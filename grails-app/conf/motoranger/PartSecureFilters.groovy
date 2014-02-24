package motoranger

class PartSecureFilters {

    def userService
    def secureFiltersService

    def filters = {

        all(controller:'part', action:'*') {
            before = {
                def currentUser = userService.currentUser()

                if(actionName == "edit" || actionName == "update" || actionName == "delete" || actionName == "*"){


                    if(currentUser && userService.isCustomer()){
                        def part = Part.findById(params.id)

                        if(part?.user && currentUser == part.user){
                            return true

                        }else {
                            flash.message = "沒有權限維護不屬於自己的維修項目"
                            redirect(action: "redirect", controller: "home")
                            return false

                        }

                    }else if(currentUser && (userService.isOperator() || userService.isManerger())){

                        def part = Part.findById(params.id)
                        if(part?.user == currentUser || (part?.store && part.store == currentUser?.store)){
                        
                            return true
                        }else {

                            flash.message = "只可維護自己或所屬店家的維修項目"
                            redirect(action: "redirect", controller: "home")
                            
                            return false                        

                        }

                    } 

                }        
            }



        }

        show(controller:'part', action:'show') {
            after = { Map model ->
                if(model?.partInstance){
                    secureFiltersService.setModelPartCostExtraCondiction(model.partInstance, model) 
                    model.partInstance.discard()                 
                }
            }            
        }
    }
}
