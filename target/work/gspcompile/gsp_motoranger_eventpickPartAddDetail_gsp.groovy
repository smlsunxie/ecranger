import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_eventpickPartAddDetail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/pickPartAddDetail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('set','g',1,['var':("tagQueryService"),'bean':("tagQueryService")],-1)
printHtmlPart(0)
invokeTag('set','g',2,['var':("nowTag"),'value':(params.tag)],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("event.pickPartAddDetail.label"),'defualt':("pickPartAddDetail"),'args':([eventInstance])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 3)
invokeTag('link','g',22,['class':("btn btn-primary"),'controller':("part"),'action':("create"),'params':(['event.id': eventInstance.id])],3)
printHtmlPart(6)
})
invokeTag('ifAnyGranted','sec',26,['roles':("ROLE_OPERATOR, ROLE_CUSTOMER, ROLE_MANERGER")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('render','g',31,['template':("/event/updateReceivedMoney")],-1)
printHtmlPart(9)
invokeTag('render','g',35,['template':("/event/updateUnreceiveMoney")],-1)
printHtmlPart(9)
invokeTag('render','g',39,['template':("/event/updateEventDate")],-1)
printHtmlPart(10)
})
invokeTag('ifAnyGranted','sec',41,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(11)
invokeTag('render','g',48,['template':("contentWithDetails"),'model':([event: eventInstance])],-1)
printHtmlPart(12)
invokeTag('render','g',50,['template':("/part/portfolio"),'model':(['event': eventInstance])],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390902276000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
