package motoranger

class UserSecureFilters {

    def userService
    def secureFiltersService

    def filters = {
        all(controller: 'user', action: "*") {
            before = {
                if(actionName == "edit" || actionName == "update" || actionName == "delete"|| actionName == "*"){
                    def currentUser = userService.currentUser()

                    if(currentUser && userService.isCustomer()){
                        if(params.id.toLong() != currentUser.id){
                            flash.message = "不可維護其他使用者的資料"
                            redirect(action: "redirect", controller: "home")
                            return false
                        }

                    }else if(currentUser && (userService.isOperator() || userService.isManerger())){
                        def user = User.get(params.id)
                        if(user.store == currentUser.store || !user.enabled ){ 
                            return true
                        }else {
                            flash.message = "已經啟用或不屬於「${currentUser.store}」的使用者不可維護"
                            redirect(action: "redirect", controller: "home")
                            return false  
                        }
                    }
                }
            }
        }
        all(controller: 'user', action: "show") {
            after = { model ->
                if(model?.userInstance){
                    secureFiltersService.setModelUserExtraCondiction(model.userInstance)
                    model.userInstance.discard()
                }
                if(model?.products){
                    model.products.each(){ product ->
                        secureFiltersService.setModelProductNameExtraCondiction(product)
                        product.discard()

                    }
                }
            }

        }        
    }
}
