package motoranger

class ProductSecureFilters {

    def userService
    def secureFiltersService

    def filters = {


        all(controller:'product', action:'*') {
            before = {
                def currentUser = userService.currentUser()

                if(actionName == "edit" || actionName == "update" || actionName == "delete" || actionName == "*"){

                    if(currentUser && userService.isCustomer()){

                        def product = Product.findById(params.id)

                        if(!product?.user || product.user.id !=  currentUser.id){
                            flash.message = "不屬於自己的摩托不可維護"
                            redirect(action: "redirect", controller: "home")
                        }

                    }else if(currentUser && (userService.isOperator() || userService.isManerger())){

                        def product = Product.findById(params.id)

                        if(product?.user && product.user.enabled && product.user!=currentUser){
                            flash.message = "已啟用使用者之產品不可維護"
                            redirect(action: "redirect", controller: "home")
                        }

                    }
                }

            }

            after = { Map model ->

                if(actionName=="show" && model?.productInstance){

                    model.currentUserIsEventOwner=[:]
                    model.eventDetailTotalPrice=[:]                     
                    secureFiltersService.setModelProductNameExtraCondiction(model.productInstance)
                    if(model.productInstance?.user)
                        secureFiltersService.setModelUserExtraCondiction(model.productInstance.user)
                    secureFiltersService.setModelEventExtraCondiction(model.productInstance?.events, model, true)

                    model.productInstance.discard()
                }

            }

        }
    }
}
