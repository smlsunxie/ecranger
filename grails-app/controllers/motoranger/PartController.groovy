package motoranger

import grails.plugin.springsecurity.annotation.Secured
import org.jsoup.Jsoup
import org.jsoup.nodes.*
import org.jsoup.select.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PartController {
	static layout="bootstrap"
    def tagQueryService
    def userService

    def index(){

        if(!params?.group)params.group = motoranger.TagGroup.CUSTOMIZED
        
        if(params?.group.toString() == motoranger.TagGroup.RECENT.toString() && !params?.tag){

            session.recentPartIds = tagQueryService.getRecentPartIds()
        } 

        params.recentPartIds = session.recentPartIds

        def tags = tagQueryService.getUniTag(params)
        def parts = tagQueryService.getCurrentUserPartsWithTag(params)

 
        [partInstanceList: parts, tags: tags]
        

    }

	@Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def create(){
    	def part = new Part(params)
        def currentUser = userService.currentUser()


        if(currentUser?.store){
            part.store=currentUser.store
            part.user=null
        }else if(!part?.user){
            part.user = currentUser
        }

        if(!params?.name)
    	   part.name = "part-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"



        respond part

    }
    @Secured(['ROLE_OPERATOR', 'ROLE_MANERGER'])
    def query(){

        def part = Part.findByName(params.name)
        if(part){
            redirect part
        }else {
            redirect(action:'create', params:params)
        }


    }
    
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def addEvent(){

        def part = Part.findByName(params.name)
        if(part){
            redirect(controller:'event', action:'create', params:[partId:part.id])
        }else {
            redirect(action:'create', params:params)
        }


    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def save(Part partInstance){

        //set current user as creator
        partInstance.creator = userService.currentUser().username


        if (partInstance.hasErrors()) {
            respond partInstance.errors, view:'create'
            return
        }


        
        partInstance.save(flush: true, failOnError: true)

        if(params.tags instanceof String)
            partInstance.tags=[params.tags];
        else if(params?.tags)
            partInstance.tags = params.tags
        else partInstance.tags=["未分類"]

        if(params?.event?.id){
            def newParams=[:]
            newParams.qty=1
            newParams.price = partInstance.price
            newParams.cost = partInstance.cost
            newParams["part.id"] = partInstance.id
            newParams["head.id"] = params.event.id
            redirect(controller:"eventDetail", action: "save", params: newParams)
            return 
        }

        flash.message = message(code: 'default.created.message'
            , args: [message(code: 'part.label', default: 'part'), partInstance])
        redirect partInstance
    }


    def show(Part partInstance){ 
        if (partInstance == null) {
            notFound()
            return
        }        
        respond partInstance
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    def edit(Part partInstance){ 
        if (partInstance == null) {
            notFound()
            return
        } 
        def eventDetails= EventDetail.findAllByPart(partInstance)

        respond partInstance, model:[ 
            historyCost: eventDetails*.cost.unique().sort(),
            historyPrice: eventDetails*.price.unique().sort()
        ]
    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def update(Part partInstance){
        if (partInstance == null) {
            notFound()
            return
        }
        if(params.tags instanceof String)
            partInstance.tags=[params.tags];
        else partInstance.tags = params.tags



        if(!params.mainImage)params.mainImage="";

        if (partInstance.hasErrors()) {
            respond partInstance.errors, view:'edit'
            return
        }

        partInstance.save flush: true

        flash.message = message(code: 'default.updated.message'
            , args: [message(code: 'user.label', default: 'User'), partInstance])
        redirect partInstance
    }
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER'])
    @Transactional
    def delete(Part partInstance){ 
        if (partInstance == null) {
            notFound()
            return
        }
        
        try{
            partInstance.delete flush: true, failOnError:true
            flash.message = message(code: 'default.deleted.message'
                , args: [message(code: 'part.label', default: 'part'), partInstance])
            redirect(action: "index")
        }catch(Exception e){
            flash.message = "維修記錄使用到該維修項目：${partInstance.title}，無法刪除。請修正標籤，例如：不使用"
            redirect partInstance
        }



    }

    protected void notFound() {
        request.withFormat {
            '*'{                 
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), params.id])
                redirect controller: "home", action: "redirect"
            }
        }        
    }

}
