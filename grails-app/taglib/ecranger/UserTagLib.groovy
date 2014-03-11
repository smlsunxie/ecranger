package ecranger

class UserTagLib {
    def userService
    
    def emoticon = { attrs, body ->
       out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")
    }
    
    def displayUserName = { attrs, body ->
    
        def output = ''
        
        try {
            def user = userService.currentUser()
            
            def display =  user?.title
            
            output = display
            
        }
        catch (e) {
            log.error e.message
        }
            
        out << body() << output
    }

    def actionbar= {attrs, body ->

        def nextActionName

        if(attrs.actionName=="create" || attrs.actionName=="save")
            nextActionName="save";
        else if(attrs.actionName=="edit")
            nextActionName="update"
        else if(attrs.actionName=="show")
            nextActionName="edit"



        out << body() << render(template:'/component/actionbar'
            , model:[actionName:actionName, nextActionName:nextActionName ,domain:attrs?.domain])
    }

    def switchUser={attrs, body ->

        def currentUser = userService.currentUser()
        def isManerger = false
        def isOperator = false

        if(currentUser.getAuthorities().contains(ecranger.Role.findByAuthority('ROLE_MANERGER')))
            isManerger = true
        if(currentUser.getAuthorities().contains(ecranger.Role.findByAuthority('ROLE_OPERATOR')))
            isOperator = true
        def operators=[]
        if(currentUser?.store && (isManerger || isOperator)){

            def users=User.findAllByStore(userService.currentUser()?.store)

            users.each(){
                if(it.getAuthorities().contains(ecranger.Role.findByAuthority('ROLE_OPERATOR'))
                    && it != currentUser){
                    operators << it
                }

            }
            out << body() << render(template:'/component/swichUser'
            , model:[operators:operators])
        }else {
            out << body() << ""
        }
    }
    def footer={attrs, body ->

        def store

        if(actionName == "show" && controllerName=="store" && params?.id){
            store = Store.get(params?.id)
        }else {
            store = userService.currentUser()?.store
        }

        if(store){
            out << body() << g.applyLayout(name: "inc_footer_store", 
                model:[store: store])

        }else {
            out << body() << g.applyLayout(name: "inc_footer")
        }
    }

    def homeNav={ attrs, body ->
        def currentUser = userService.currentUser()
        def store = currentUser?.store

        def nowActive = ""

        def link = link(controller:'home', action:"index"){
            "首頁<i>index</i>"
        }
        def active = (controllerName=='home' && actionName=='index' ? 'active':'')
        out << body() << 
            """
              <li class='${active} single'>
                ${link}
              </li>
              ${nowActive}
            """    

    }
    def userMenu={ attrs, body ->
        def currentUser = userService.currentUser()
        def userMenu = ""

        def userShowTitle = message(code:"user.show.label")
        def userShowLink = link(controller: "user", action: "show", id: currentUser.id){userShowTitle}
        userMenu += '<li>'+userShowLink+'</li>'


        def userEditTitle = message(code:"user.edit.label")
        def userEditLink = link(controller: "user", action: "edit", id: currentUser.id){userEditTitle}
        userMenu += '<li>'+userEditLink+'</li>'

        if(userService.isManerger()){
            def storeEditTitle = message(code:"store.edit.label")
            def storeEditLink = link(controller: "store", action: "edit", id: currentUser.store.id){storeEditTitle}
            userMenu += '<li>'+storeEditLink+'</li>'
        }

        out << body() << userMenu

    }

}
