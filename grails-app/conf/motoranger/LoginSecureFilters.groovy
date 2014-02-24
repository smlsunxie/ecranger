package motoranger
import grails.plugin.springsecurity.SpringSecurityUtils

class LoginSecureFilters {

    def userService

    def filters = {
        all(controller:'login', action:'switchUser') {
            before = {
                def switchUser = User.findByUsername(params.username)
                def currentUser = userService.currentUser()

                if((userService.isOperator() || userService.isManerger())
                    && (!switchUser?.store || switchUser.store != currentUser.store))
                {

                    flash.message = "無法切換到不屬於「${currentUser.store}」的使用者"
                    redirect(action: "redirect", controller: "home")
                    return false

                }
            }            
        }
    }
}
