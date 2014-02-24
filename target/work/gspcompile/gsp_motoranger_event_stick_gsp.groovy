import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_event_stick_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_stick.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(stickName)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(eventInstance?.name)
printHtmlPart(3)
})
invokeTag('link','g',8,['elementId':("event-show-${eventInstance.name}"),'controller':("event"),'action':("show"),'id':(eventInstance?.id)],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(eventInstance.product.name)
printHtmlPart(3)
})
invokeTag('link','g',16,['controller':("product"),'action':("show"),'id':(eventInstance?.product?.id)],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(eventInstance?.user)
printHtmlPart(2)
})
invokeTag('link','g',26,['controller':("user"),'action':("show"),'id':(eventInstance?.user.id)],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(eventInstance?.product?.user)
printHtmlPart(2)
})
invokeTag('link','g',35,['controller':("user"),'action':("show"),'id':(eventInstance?.product?.user?.id)],1)
printHtmlPart(8)
if(true && (currentUserIsEventOwner[eventInstance.id])) {
printHtmlPart(9)
expressionOut.print(eventInstance.totalPrice)
printHtmlPart(10)
if(true && (actionName != 'pickPartAddDetail')) {
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',48,['class':("btn btn-primary"),'controller':("event"),'action':("pickPartAddDetail"),'id':(eventInstance?.id)],3)
printHtmlPart(13)
}
printHtmlPart(13)
invokeTag('render','g',52,['template':("/event/statusChangeBtn")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
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
