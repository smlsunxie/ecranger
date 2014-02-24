package motoranger

class StoreSecureFilters {

    def userService
    def secureFiltersService

    def filters = {

        all(controller:'store', action:'*') {
            before = {
                def currentUser = userService.currentUser()

                if(userService.isManerger() 
                    && (actionName == "edit" || actionName == "update" || actionName == "delete" || actionName == "*"))
                {

                    if(params.id.toLong() != currentUser.store.id){

                        flash.message = "只可維護自己的店家"
                        redirect(action: "redirect", controller: "home")
                        return false

                    }
                }


            }
            after = { Map model ->
                def currentUser = userService.currentUser()

                if(actionName == 'show'){

                    model.currentUserIsStoreOwnerOrAdmin = 
                        (currentUser?.store?.id == params.id.toLong() || userService.isAdmin())

                    if(model?.unfinEvents || model?.endEvents){

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
}
