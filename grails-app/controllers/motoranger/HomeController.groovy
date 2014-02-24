package motoranger

import grails.plugin.springsecurity.annotation.Secured
import org.grails.plugins.csv.CSVMapReader

class HomeController {
	static layout = 'bootstrap'
	def userService


    def index= {


        def recentPosts = Post.list(max: 4, sort: 'dateCreated', order: 'desc')

        def unfinEvents= Event.findAllByStatus(motoranger.ProductStatus.UNFIN
            ,[max:4, order:"desc", sort:"lastUpdated"])
        def endEvents= Event.findAllByStatus(motoranger.ProductStatus.END
            ,[max:4, order:"desc", sort:"lastUpdated"])


        [ 
            recentPosts:recentPosts,
            unfinEvents:unfinEvents,
            endEvents:endEvents
        ]


    }
    def question={

        flash.message = "留下您的建議，或者您也可以點選下方「意見回饋」按鈕寄送 mail"
        
    }


    def redirect= {
        def currentUser = userService.currentUser()
        
        
        if(currentUser){
            
            if(flash?.message){
                flash.message = flash.message
            }

            if(userService.isManerger() || userService.isOperator()){
                redirect action: 'show', controller:'store', id: currentUser.store.id
                return 
            }else {
                redirect action: 'show', controller:'user', id: currentUser.id
                return
            }
        }else {
            redirect action: 'index'
            return
        }
    }

    
}
