import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_eventDetail_contentWithDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventDetail/_contentWithDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("eventDetail.name.label")],-1)
printHtmlPart(1)
invokeTag('message','g',5,['code':("part.label")],-1)
printHtmlPart(1)
invokeTag('message','g',6,['code':("part.price.label")],-1)
printHtmlPart(2)
loop:{
int j = 0
for( eventDetailInstance in (eventInstance.details) ) {
printHtmlPart(3)
invokeTag('message','g',16,['code':("eventDetail.name.label")],-1)
printHtmlPart(4)
createTagBody(2, {->
expressionOut.print(eventDetailInstance?.id)
})
invokeTag('link','g',17,['controller':("eventDetail"),'action':("show"),'id':(eventDetailInstance?.id)],2)
printHtmlPart(5)
invokeTag('message','g',19,['code':("part.label")],-1)
printHtmlPart(4)
createTagBody(2, {->
expressionOut.print(eventDetailInstance?.part?.title)
printHtmlPart(6)
})
invokeTag('link','g',20,['controller':("part"),'action':("show"),'id':(eventDetailInstance?.part.id)],2)
printHtmlPart(7)
invokeTag('message','g',23,['code':("part.price.label")],-1)
printHtmlPart(4)
expressionOut.print(eventDetailTotalPrice[eventDetailInstance.id])
printHtmlPart(8)
if(true && (currentUserIsEventOwner[eventInstance.id])) {
printHtmlPart(9)
createTagBody(3, {->
invokeTag('message','g',29,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',29,['elementId':("eventDetail-edit-${eventDetailInstance.name}"),'class':("btn btn-primary btn-xs"),'controller':("eventDetail"),'action':("edit"),'id':(eventDetailInstance.id)],3)
printHtmlPart(9)
createTagBody(3, {->
invokeTag('message','g',30,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',30,['elementId':("eventDetail-delete-${eventDetailInstance.name}"),'class':("btn btn-danger btn-xs"),'controller':("eventDetail"),'action':("delete"),'id':(eventDetailInstance.id)],3)
printHtmlPart(10)
}
printHtmlPart(11)
j++
}
}
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1391753623000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
