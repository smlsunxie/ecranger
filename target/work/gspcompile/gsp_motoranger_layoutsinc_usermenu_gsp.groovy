import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_layoutsinc_usermenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/inc_usermenu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(controllerName=='user' && actionName=='create' ?'active':'')
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.register.text")],-1)
printHtmlPart(4)
})
invokeTag('link','g',10,['controller':("user"),'action':("create")],2)
printHtmlPart(5)
expressionOut.print(controllerName=='login' && actionName=='auth' ?'active':'')
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('message','g',15,['code':("default.login.text")],-1)
printHtmlPart(6)
})
invokeTag('link','g',16,['controller':("login"),'action':("auth")],2)
printHtmlPart(7)
})
invokeTag('ifNotLoggedIn','sec',18,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('switchUser','g',28,[:],-1)
printHtmlPart(10)
})
invokeTag('ifAnyGranted','sec',28,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',40,['controller':("user"),'action':("show"),'params':([tour: true])],2)
printHtmlPart(13)
invokeTag('displayUserName','g',48,[:],-1)
printHtmlPart(14)
invokeTag('userMenu','g',54,[:],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',61,['controller':("post"),'action':("create")],3)
printHtmlPart(18)
})
invokeTag('ifAnyGranted','sec',63,['roles':("ROLE_ADMIN")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',70,['url':("${request.contextPath}/j_spring_security_exit_user")],3)
printHtmlPart(18)
})
invokeTag('ifSwitched','sec',72,[:],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',80,['code':("default.logout.text")],-1)
printHtmlPart(23)
})
invokeTag('link','g',80,['uri':("/j_spring_security_logout")],3)
printHtmlPart(18)
})
invokeTag('ifNotSwitched','sec',82,[:],2)
printHtmlPart(24)
})
invokeTag('ifLoggedIn','sec',85,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390805510000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
