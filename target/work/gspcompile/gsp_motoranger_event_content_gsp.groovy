import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_event_content_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_content.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',6,['code':("event.mileage.label")],-1)
printHtmlPart(1)
expressionOut.print(eventInstance.mileage)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
if(true && (currentUserIsEventOwner[eventInstance.id])) {
printHtmlPart(4)
expressionOut.print(eventInstance?.receivedMoney.toString())
printHtmlPart(5)
expressionOut.print(eventInstance?.totalPrice-eventInstance?.receivedMoney)
printHtmlPart(6)
}
printHtmlPart(7)
})
invokeTag('ifAnyGranted','sec',23,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],1)
printHtmlPart(8)
if(true && (currentUserIsEventOwner[eventInstance.id])) {
printHtmlPart(9)
invokeTag('message','g',29,['code':("event.totalPrice.label")],-1)
printHtmlPart(1)
expressionOut.print(eventInstance?.totalPrice)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',36,['code':("event.store.label")],-1)
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(eventInstance?.store)
})
invokeTag('link','g',38,['controller':("store"),'action':("show"),'id':(eventInstance?.store?.id)],1)
printHtmlPart(13)
invokeTag('message','g',45,['code':("default.dateCreated.label")],-1)
printHtmlPart(12)
invokeTag('formatDate','g',47,['date':(eventInstance.date),'type':("date"),'style':("SHOROT")],-1)
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
