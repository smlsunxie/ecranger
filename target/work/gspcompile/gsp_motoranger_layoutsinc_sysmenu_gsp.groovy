import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_layoutsinc_sysmenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/inc_sysmenu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(controllerName=='user' && actionName=='show' ? 'active':'')
printHtmlPart(1)
invokeTag('homeNav','g',2,[:],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(controllerName=='part' ? 'active':'')
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',10,['code':("part.label")],-1)
printHtmlPart(6)
})
invokeTag('link','g',12,['elementId':("part-index"),'controller':("part"),'action':("index")],2)
printHtmlPart(7)
})
invokeTag('ifAnyGranted','sec',15,['roles':("ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER")],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(controllerName=='summary' ? 'active':'')
printHtmlPart(10)
invokeTag('message','g',21,['code':("summary.label")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',29,['code':("summary.unreceiveMoney.label")],-1)
printHtmlPart(13)
})
invokeTag('link','g',30,['controller':("summary"),'action':("unreceiveMoneyList")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('message','g',36,['code':("summary.turnover.label")],-1)
printHtmlPart(12)
})
invokeTag('link','g',37,['controller':("summary"),'action':("turnoverYearList")],3)
printHtmlPart(17)
})
invokeTag('ifAnyGranted','sec',39,['roles':("ROLE_MANERGER")],2)
printHtmlPart(18)
})
invokeTag('ifAnyGranted','sec',43,['roles':("ROLE_MANERGER, ROLE_OPERATOR")],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(19)
expressionOut.print(controllerName=='brand' ? 'active':'')
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',50,['code':("brand.label")],-1)
printHtmlPart(20)
})
invokeTag('link','g',52,['controller':("brand")],2)
printHtmlPart(21)
expressionOut.print(controllerName=='user' && actionName=='index' ? 'active':'')
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['code':("user.label")],-1)
printHtmlPart(22)
})
invokeTag('link','g',59,['controller':("user"),'action':("index")],2)
printHtmlPart(23)
})
invokeTag('ifAnyGranted','sec',63,['roles':("ROLE_ADMIN")],1)
printHtmlPart(24)
expressionOut.print(controllerName=='store' && actionName=='index' ? 'active':'')
printHtmlPart(1)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',70,['controller':("store"),'action':("index")],1)
printHtmlPart(26)
expressionOut.print(controllerName=='post' ? 'active':'')
printHtmlPart(1)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',77,['controller':("post"),'action':("portfolio")],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(controllerName=='home' && actionName=='question' ? 'active':'')
printHtmlPart(4)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',85,['controller':("home"),'action':("question")],2)
printHtmlPart(29)
})
invokeTag('ifNotGranted','sec',87,['roles':("ROLE_ADMIN")],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390992630000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
