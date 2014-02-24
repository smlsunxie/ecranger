package motoranger

import grails.plugin.springsecurity.SpringSecurityUtils
class UserService {
	def springSecurityService

    def addProduct(userInstance, params){
    	def product = Product.findById(params?.product?.id)

        product.user=userInstance
        product.save(failOnError: true)

        return product

    }

    def modifyUserRole(userInstance, params){
	    def defRoles = Role.list()*.authority;
        def userRoleParams = params.list('userRoles');

        defRoles.each(){ defRole ->
        
            def addRoule =false;
            userRoleParams.each(){ userRole ->
                if(userRole == defRole){
                    addRoule = true;
                }
            }

            def roleInstance = Role.findByAuthority(defRole)
            def userRoleInstance = UserRole.get(userInstance?.id,roleInstance?.id)

            if(addRoule && !userRoleInstance){
                UserRole.create(userInstance,roleInstance,true)
            }else if(!addRoule && userRoleInstance) {
                UserRole.remove(userInstance,roleInstance)
            }
        }
    }

    def currentUser(){
        return springSecurityService?.currentUser
    }
    def isLoggedIn(){
        return springSecurityService.isLoggedIn()
    }

    def isCustomer(){
        return SpringSecurityUtils.ifAnyGranted("ROLE_CUSTOMER")
    }
    def isOperator(){
        return SpringSecurityUtils.ifAnyGranted("ROLE_OPERATOR")
    }    

    def isManerger(){
        return SpringSecurityUtils.ifAnyGranted("ROLE_MANERGER")
    }
    def isAdmin(){
        return SpringSecurityUtils.ifAnyGranted("ROLE_ADMIN")

    }
}
