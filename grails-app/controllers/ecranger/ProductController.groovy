package ecranger

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductController {
	static layout="bootstrap"
    def userService
    def tagQueryService

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def create(){ 

    	def product = new Product(params)

        if(product?.name)
            product.title=product.name

        respond product
    }


    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def save(Product productInstance){

        productInstance.creator = userService.currentUser().username

        def user = User.findByUsername(params.name)

        if(user){
            productInstance.user = user
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'create'
            return
        }

        productInstance.save flush:true, failOnError: true



        if(params?.tags)
            partInstance.tags = params.list("tags")
        else partInstance.tags=["未分類"]

        request.withFormat {
            '*' { 
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance])
                redirect productInstance
            }
        }
    }


    def show(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }


        respond productInstance
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def edit(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }        
        if(params?.user?.id){
            productInstance?.user = User.findByUsername(params?.user?.id)
        }
        
        if(!productInstance?.user && productInstance?.name){
            productInstance.user=User.findByUsername(productInstance.name)
        }        
        respond productInstance
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def update(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if(!productInstance.mainImage)productInstance.mainImage="";


        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'edit'
            return
        }

        productInstance.save flush:true

        request.withFormat {
            '*' {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
        }
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def delete(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        try{
            productInstance.delete flush:true

            request.withFormat {
                '*' { 
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance])
                    redirect controller: "home", action: "redirect"
                }
            }
        }catch(e){
            flash.message = "無法刪除，請確認維修事件是否已刪除"
            redirect productInstance
        }

        
    }

    def addToCart(Product productInstance){
        if (productInstance == null) {
            notFound()
            return
        }

        def currentUser = userService.currentUser()

        if(!currentUser){
            flash.message = "請先登入帳號，還沒有帳號？請先進行註冊"
            redirect controller: "login", action: "auth"
            return      
        }

        def newstEvent = Event.findByUserAndStatus(currentUser, EventStatus.START)

        if(!newstEvent){
            newstEvent = new Event(user: currentUser)
            newstEvent.name = "event-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"
            newstEvent.save(failOnError: true)
        }

        def eventDetail = new EventDetail(head: newstEvent, product: productInstance)
        eventDetail.name = "eventDetail-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"
        eventDetail.save(failOnError: true)

        request.withFormat {
            '*' {
                flash.message = "$productInstance 已加入購物車"
                redirect productInstance
            }
        }

    }

    def portfolio(){
        
        def type = params.type as ecranger.ProductType
        def allProducts = Product.findAllByType(type)

        def tags = tagQueryService.getUniTag(allProducts)
        def products = tagQueryService.getProductsWithTag(params)

        if(!products){
            products = allProducts
        }


        [products: products, tags: tags]
    }

    protected void notFound() {
        request.withFormat {
            '*'{                 
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productInstance.label', default: 'Product'), params.id])
                redirect controller: "home", action: "redirect"
            }
        }        
    }


}
