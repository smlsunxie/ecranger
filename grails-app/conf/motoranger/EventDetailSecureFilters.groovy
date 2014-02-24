package motoranger

class EventDetailSecureFilters {

    def userService
    def secureFiltersService

    def filters = {

        create(controller:'eventDetail', action:'create') {
            before = {
                def currentUser = userService.currentUser()

                if(currentUser && userService.isCustomer())
                {

                    def product = Event.findById(params.head.id).product
                    if(!product?.user || product.user.id !=  currentUser.id){
                        flash.message = "沒有權限建立不屬於自己產品的維修事件之維修項目"
                        redirect(action: "redirect", controller: "home")
                        return false 

                    }

                }
                else if(currentUser && (userService.isOperator() || userService.isManerger()))
                {

                    def event = Event.findById(params.head.id)

                    if(!event?.store || event.store !=  currentUser.store){
                        flash.message = "沒有權限建立不屬於自己店家的維修事件之維修項目"
                        redirect(action: "redirect", controller: "home")
                        return false 
                    }
                }

            }
        }


        edit(controller:'eventDetail', action:'edit') {
            before = {
                def currentUser = userService.currentUser()
                def event = EventDetail.findById(params.id).head

                if(event?.user == currentUser || (event?.store && event.store == currentUser?.store)){
                    return true                        
                }else {
                    flash.message = "只可維護自己或所屬店家的維修事件之維修項目"
                    redirect(action: "redirect", controller: "home")
                    return false                        
                }
            }
        }
        save(controller:'eventDetail', action:'save') {
            before = {
                if(!params?.name)
                    params.name = "eventDetail-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"
            }
        }
        delete(controller:'eventDetail', action:'delete') {
            before = {

                def currentUser = userService.currentUser()
                def event = EventDetail.findById(params.id)?.head


                if(!event || event?.user == currentUser || (event?.store && event.store == currentUser?.store)){
                    return true                        
                }else {
                    flash.message = "只可維護自己或所屬店家的維修事件之維修項目"
                    redirect(action: "redirect", controller: "home")
                    return false                        
                }
            }
        }
        show(controller:'eventDetail', action:'show') {

            after = { Map model ->

                if(model?.eventDetailInstance){
                    model.currentUserIsEventOwner=[:]
                    model.eventDetailTotalPrice=[:] 
                    secureFiltersService.setModelEventExtraCondiction([model.eventDetailInstance.head], model, true)
                    secureFiltersService.setModelPartCostExtraCondiction(model.eventDetailInstance.part, model)

                    model.eventDetailInstance.discard()
                }

            }
        }
    }
}
