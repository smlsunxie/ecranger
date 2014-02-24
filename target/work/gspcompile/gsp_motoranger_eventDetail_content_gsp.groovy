import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_eventDetail_content_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventDetail/_content.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',5,['code':("event.name.label")],-1)
printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(eventDetailInstance.head.name)
})
invokeTag('link','g',7,['controller':("event"),'action':("show"),'id':(eventDetailInstance.head.id)],1)
printHtmlPart(2)
invokeTag('message','g',13,['code':("eventDetail.name.label")],-1)
printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(eventDetailInstance.name)
})
invokeTag('link','g',15,['controller':("eventDetail"),'action':("show"),'id':(eventDetailInstance.id)],1)
printHtmlPart(3)
invokeTag('message','g',22,['code':("eventDetail.price.label")],-1)
printHtmlPart(4)
expressionOut.print(eventDetailInstance.price)
printHtmlPart(5)
invokeTag('message','g',27,['code':("eventDetail.cost.label")],-1)
printHtmlPart(4)
expressionOut.print((eventDetailInstance.cost == -1 ?'****':eventDetailInstance.cost))
printHtmlPart(6)
invokeTag('message','g',34,['code':("eventDetail.qty.label")],-1)
printHtmlPart(4)
expressionOut.print(eventDetailInstance.qty)
printHtmlPart(7)
invokeTag('message','g',38,['code':("default.description.label")],-1)
printHtmlPart(4)
expressionOut.print(eventDetailInstance.description)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1391501665000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
