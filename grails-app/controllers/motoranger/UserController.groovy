package motoranger

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.transaction.annotation.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {


    static layout = 'bootstrap'
    def userService


    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def create() {
        
        def user = new User(params)
        
        if(params?.product?.id){
            def product = Product.findById(params?.product?.id)
            user.username = product?.name
            user.title = product?.name
            user.password = product?.name 
        }


        if(userService.isLoggedIn() && (userService.isOperator() || userService.isManerger()))
            user.enabled = false
        else user.enabled = true


        respond user, model:[roles: Role.list(),storeList:storeList()]
    }

    @Transactional
    def save(User userInstance){
   
        if(userService.isOperator() || userService.isManerger()){
            def existUser = User.findByUsername(params.username)
            if(existUser)
                userInstance = existUser
        }
    

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create', model: [roles: Role.list()]
            return
        }

        if(!userService.isLoggedIn() && !userInstance?.email ){
            flash.message = "請輸入 email"
            respond userInstance, view:'create', model: [roles: Role.list()]
            return            
        }

        if(userInstance.store){

            Store store = userInstance.store

            store.addToUsers(userInstance).save()
        }


        userInstance.save flush: true

        // 登入使用者若屬於 ROLE_MANERGER 則進行  userRoles UserRole Update
        if(userService.isAdmin()){
            userService.modifyUserRole(userInstance, params)

        }else if(userInstance){
            def cusRole = Role.findByAuthority('ROLE_CUSTOMER')

            if(!UserRole.get(userInstance.id, cusRole.id))
                UserRole.create(userInstance,cusRole,true)
        }


        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance])


        if(params?.product?.id){
            def product = userService.addProduct(userInstance, params)
            redirect product
            return
        }else if(userInstance?.store){
            if(userService.isAdmin() || userService.isManerger()){
                redirect(action: "addToStore", id: userInstance.id, params:['store.id': userInstance.store.id])
                return
            }else {
                flash.message+= "：沒有權限將使用者加入店家"
            }
        }

        if(userService.isLoggedIn()){
            redirect userInstance 
        }else {
            flash.message = flash.message + ":可以開始登入使用！"
            redirect(action: "auth", controller:"login")
        }
    }
    
    def show(User userInstance){
        if (userInstance == null) {
            notFound()
            return
        }

        if(params?.tour){
            session.tourStep=TourStep.STEP1_START
        }


        respond userInstance, model: [productInstanceList: Product.findAllByUser(userInstance)]
    }

    def edit(User userInstance){
        if (userInstance == null) {
            notFound()
            return
        }

        respond userInstance, model: [roles: Role.list()
                                    ,userRoles:UserRole.findAllByUser(userInstance)
                                    ,storeList:storeList()]
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }


        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush: true
        // 登入使用者若屬於 ROLE_MANERGER 則進行  userRoles UserRole Update
        if(userService.isAdmin()){
            userService.modifyUserRole(userInstance, params)

        }

        if(params?.product?.id){
            def product = userService.addProduct(userInstance, params)
            redirect product
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance])
        redirect userInstance
    }



    @Transactional
    def delete(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }


        def userRoleInstances=UserRole.findAllByUser(userInstance)

        userRoleInstances?.each(){
            it.delete()
        }

        def products = Product.findAllByUser(userInstance)

        products?.each(){ product ->
            product.user = null
            product.save()
        }

        def parts = Part.findAllByUser(userInstance)

        parts.each(){ part ->
            if(EventDetail.findByPart(part)){
                part.user = null
                part.save()
            }else {
                part.delete(flush: true,failOnError:true)
            }

        }

        userInstance.delete flush: true,failOnError:true
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), userInstance])
        
        def currentUser = userService.currentUser()

        if(!currentUser){
            redirect(url: '/j_spring_security_logout')
            return 
        }else {
            redirect controller: "home", action: "redirect"
        }
            

    }
    @Secured(['ROLE_MANERGER', 'ROLE_ADMIN'])
    @Transactional
    def addToStore(){
        def currentUser = userService.currentUser()
        def user = User.get(params.id)
        def store = Store.get(currentUser.store.id)

        if(user?.store && user.store != store){
            flash.message = "此使用者已屬於「user.store」"
            redirect user
            return
        }


        def admRole = Role.findByAuthority('ROLE_ADMIN')
        def mngRole = Role.findByAuthority('ROLE_MANERGER')

        if(UserRole.get(user.id, admRole.id) || UserRole.get(user.id, mngRole.id)){
            flash.message = "不可指派「${admRole}」或「${mngRole}」為作業員"
            redirect user
            return    
        }

        store.addToUsers(user).save()

        def opRole = Role.findByAuthority('ROLE_OPERATOR')
        if(!UserRole.get(user?.id, opRole.id))
                UserRole.create(user,opRole,true)

        def cusRole = Role.findByAuthority('ROLE_CUSTOMER')
        if(UserRole.get(user?.id, cusRole.id))
            UserRole.remove(user,cusRole)             

        user.enabled=true

        user.save()

        flash.message="${flash?.message ? flash.message: ''}:指定「${user}」為「${store}」作業員"

        redirect user
    }

    private def storeList(){
        def storeList=[]
        if(userService.isAdmin()){
            storeList=Store.list()
        }else if(userService.isManerger() 
            && userService.currentUser()?.store){  
            
            storeList << userService.currentUser().store
        
        }
        return storeList
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
