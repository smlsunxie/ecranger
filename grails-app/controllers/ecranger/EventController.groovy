package ecranger

import grails.converters.JSON

import org.jsoup.Jsoup
import org.jsoup.nodes.*
import org.jsoup.select.*
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventController {

	static layout="bootstrap"
    def userService
    def tagQueryService

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), model:[eventInstanceCount: Event.count()]
    }


    def show(Event eventInstance) { 
        if (eventInstance == null) {
            notFound()
            return
        }
        respond eventInstance
    }

    def showStatusStart() {

        def currentUser = userService.currentUser()
        def newstEvent = Event.findByUserAndStatus(currentUser, EventStatus.START)

        println newstEvent
        if(newstEvent){
            redirect newstEvent
            return
        }
        else {
            flash.message = "尚無商品加入購物車"
            redirect url: request.getHeader('referer')
            return
        }
    }


    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def create() { 

        def unfinEvent


        if(params?.product?.id){
            params.product=Product.findById(params.product.id)

            params.mileage=params.product.mileage
            
            unfinEvent = Event.findByProductAndStatus(params.product,ecranger.ProductStatus.UNFIN)
        }

        if(unfinEvent){
            redirect(controller:"event", action:"pickPartAddDetail", id:unfinEvent.id)
        } 

        def event = new Event(params)

        def currentUser = userService.currentUser()
        
        event.user=currentUser
        if(currentUser?.store){
            event.store=currentUser.store
        }

        event.name = "event-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"


    	respond event

    }


    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def save(Event eventInstance) {
        
        
        eventInstance.creator=userService.currentUser().username


        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'create'
            return
        }

        if(eventInstance.product.mileage < eventInstance.mileage){
            eventInstance.product.mileage=eventInstance.mileage
        }

        eventInstance.product.status=ecranger.ProductStatus.UNFIN
        eventInstance.save(flush: true, failOnError: true)

        
        flash.message = message(code: 'default.created.message', 
            args: [message(code: 'event.label', default: 'event'), eventInstance])


        redirect(action:"pickPartAddDetail", id:eventInstance.id)


    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def pickPartAddDetail(){

        def event
        
        if(params?.id){
            event=Event.findById(params.id)
        }

        if(!params?.group)params.group = ecranger.TagGroup.CUSTOMIZED
        
        if(params?.group.toString() == ecranger.TagGroup.RECENT.toString() && !params?.tag){

            session.recentPartIds = tagQueryService.getRecentPartIds()
        } 

        params.recentPartIds = session.recentPartIds

        def tags = tagQueryService.getUniTag(params)
        def parts = tagQueryService.getCurrentUserPartsWithTag(params)

        [
            eventInstance: event,
            tags: tags, 
            partInstanceList: parts
        ]

    }


    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def delete(Event eventInstance) { 
        if (eventInstance == null) {
            notFound()
            return
        }


        def details=EventDetail.findAllByHead(eventInstance)

        eventInstance?.details?.each(){
            it.delete()
        }
        eventInstance.delete(flush:true)


        flash.message = message(code: 'default.deleted.message'
            , args: [message(code: 'event.label', default: 'event'), eventInstance])


        redirect controller: "home", action: "index"

    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def edit(Event eventInstance) { 
        if (eventInstance == null) {
            notFound()
            return
        }

        respond eventInstance

    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def update(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }
         
        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'edit'
            return
        }


        if(params.mileage && eventInstance.product.mileage.toLong() < params.mileage.toLong()){
            eventInstance.product.mileage=params.mileage.toLong()
        }

        if(params?.status){
            eventInstance.status = params.status
        }

        eventInstance.save flush: true, failOnError: true



        flash.message = message(code: 'default.updated.message', args: [message(code: 'event.label', default: 'event'), eventInstance])
        
        def refererUrl= request.getHeader('referer')
        def refererUrlMatch = (refererUrl 
            && (refererUrl.indexOf("pickPartAddDetail") != -1|| refererUrl.indexOf("/store/") != -1))

        if(params?.status == 'END'){
            redirect(action: "redirect", controller: "home")
        }
        else if(refererUrlMatch){
             redirect(uri: request.getHeader('referer')) 
             return
        }else {
            redirect eventInstance
            return
        }
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
