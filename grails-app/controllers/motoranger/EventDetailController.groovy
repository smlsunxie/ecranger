package motoranger

import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON
class EventDetailController {
    static layout="bootstrap"

    def userService


    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def create(EventDetail eventDetailInstance){


        eventDetailInstance.name = "eventDetail-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"

        eventDetailInstance.price=eventDetailInstance.part.price

        respond eventDetailInstance


    }

    def show(EventDetail eventDetailInstance){
        if (eventDetailInstance == null) {
            notFound()
            return
        }
        respond eventDetailInstance

    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def save(EventDetail eventDetailInstance){
        

        if(!eventDetailInstance?.qty)
            eventDetailInstance?.qty=1


        def creator = userService.currentUser().username
        eventDetailInstance.creator = creator
        def refererUrl = request.getHeader('referer')


       if (eventDetailInstance.hasErrors()) {
            flash.message = "無法新增維修項目"

            if(refererUrl && refererUrl.indexOf("pickPartAddDetail")!=-1){
                redirect(uri: refererUrl )
                return
            }
            else {
                respond eventDetailInstance.errors, view: "create"
                return
            }
            
        }

        if(eventDetailInstance.cost == 0){
            eventDetailInstance.cost = eventDetailInstance.part.cost 
        }

        eventDetailInstance.save(flush: true, failOnError: true)


        
        flash.message = message(code: 'default.created.message', 
            args: [message(code: 'eventDetail.label', default: 'eventDetail'), eventDetailInstance])

        

        if(refererUrl && refererUrl.indexOf("part/create?event.id")!=-1){
            redirect(controller:"event", action:"pickPartAddDetail", id:eventDetailInstance.head.id)
        }else if(refererUrl && refererUrl.indexOf("pickPartAddDetail")!=-1)
            redirect(uri: request.getHeader('referer') )
        else redirect eventDetailInstance


    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def edit(EventDetail eventDetailInstance){ 
        if (eventDetailInstance == null) {
            notFound()
            return
        }        
        respond eventDetailInstance
    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def update(EventDetail eventDetailInstance){
        if (eventDetailInstance == null) {
            notFound()
            return
        }

        if (eventDetailInstance.hasErrors()) {
            respond eventDetailInstance.errors, view:'edit'
            return
        }



        eventDetailInstance.save flush: true




        flash.message = message(code: 'default.updated.message'
            , args: [message(code: 'eventDetail.label', default: 'EventDetail'), eventDetailInstance])
        redirect eventDetailInstance.head


    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def delete(EventDetail eventDetailInstance){ 
        if (eventDetailInstance == null) {
            notFound()
            return
        }

        def headId=eventDetailInstance.head.id

        def event = Event.findById(headId)
        event.totalPrice -=  eventDetailInstance.price * eventDetailInstance.qty
        event.save(flush:true, failOnError: true)

        eventDetailInstance.delete(flush:true, failOnError: true)


        flash.message = message(code: 'default.deleted.message', args: [message(code: 'eventDetail.label', default: 'eventDetail'), eventDetailInstance])

        def refererUrl = request.getHeader('referer')
        if(refererUrl && refererUrl.indexOf("/eventDetail/show") != -1){
            redirect event
        }else redirect(uri: request.getHeader('referer') )

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
