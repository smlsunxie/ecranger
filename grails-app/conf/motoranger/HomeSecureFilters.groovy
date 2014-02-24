package motoranger
import grails.plugin.springsecurity.SpringSecurityUtils

class HomeSecureFilters {

    def userService
    def secureFiltersService

    def filters = {

        all(controller:'home', action:'index') {


            after = { Map model ->

                if(model ){
                    model.currentUserIsEventOwner=[:]
                    model.eventDetailTotalPrice=[:]                 
                    
                    if(model?.unfinEvents){
                        secureFiltersService.setModelEventExtraCondiction(model.unfinEvents, model)
                        model.unfinEvents.each(){ event ->
                            event.discard()
                        }                          
                    }
                    if(model?.endEvents){
                        secureFiltersService.setModelEventExtraCondiction(model.endEvents, model)

                        model.endEvents.each(){ event ->
                            event.discard()
                        }   
                    }
                }
            }

        }        


    }




}
