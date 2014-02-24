package motoranger

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.transaction.annotation.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StoreController {

    static layout = 'bootstrap'
    
    def show(Store storeInstance) {
        if (storeInstance == null) {
            notFound()
            return
        }
        
        def unfinEvents= Event.findAllByStatusAndStore(motoranger.ProductStatus.UNFIN
            , storeInstance,[max:4, order:"desc", sort:"lastUpdated"])
        def endEvents= Event.findAllByStatusAndStore(motoranger.ProductStatus.END
            , storeInstance,[max:4, order:"desc", sort:"lastUpdated"])


        respond storeInstance, model:[
            unfinEvents: unfinEvents,
            endEvents: endEvents
        ]


    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Store.list(params), model: [storeInstanceCount: Store.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Store(params)
    }

    @Secured(['ROLE_ADMIN'])
    @Transactional
    def save(Store storeInstance) {
        if (storeInstance.hasErrors()) {
            respond storeInstance.errors, view:'create'
            return
        }
        
        storeInstance.save(flush: true)

        flash.message = message(code: 'default.created.message', args: [message(code: 'store.label', default: 'Store'), storeInstance])
        redirect storeInstance
    }

    @Secured(['ROLE_MANERGER', 'ROLE_ADMIN'])
    def edit(Store storeInstance) {
        if (storeInstance == null) {
            notFound()
            return
        }

        respond storeInstance
    }

    @Transactional
    @Secured(['ROLE_MANERGER', 'ROLE_ADMIN'])
    def update(Store storeInstance) {
        if (storeInstance == null) {
            notFound()
            return
        }

        if (storeInstance.hasErrors()) {
            respond storeInstance.errors, view:'edit'
            return
        }

        storeInstance.save flush: true

        flash.message = message(code: 'default.updated.message', args: [message(code: 'store.label', default: 'Store'), storeInstance])
        redirect storeInstance
    }


    @Transactional
    @Secured(['ROLE_ADMIN'])
    def delete(Store storeInstance) {
        if (storeInstance == null) {
            notFound()
            return
        }


        try {
            storeInstance.delete flush: true,failOnError:true
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'store.label', default: 'Store'), storeInstance])
            redirect controller: "home", action: "redirect"
        }
        catch (Exception e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'store.label', default: 'Store'), storeInstance])
            redirect storeInstance
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
