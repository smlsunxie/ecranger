import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_eventDetailshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventDetail/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'part.label', default: '文章'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(eventDetailInstance)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (currentUserIsEventOwner[eventDetailInstance.head.id])) {
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',22,['code':("default.button.edit.label")],-1)
printHtmlPart(6)
})
invokeTag('link','g',23,['elementId':("eventDetail-edit"),'class':("btn btn-primary btn-large "),'action':("edit"),'controller':("eventDetail"),'id':(eventDetailInstance.id)],3)
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('message','g',28,['code':("default.button.delete.label")],-1)
printHtmlPart(6)
})
invokeTag('link','g',29,['elementId':("eventDetail-delete"),'class':("btn btn-danger"),'action':("delete"),'controller':("eventDetail"),'id':(eventDetailInstance.id)],3)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('render','g',40,['template':("content")],-1)
printHtmlPart(11)
invokeTag('render','g',44,['template':("/part/content"),'model':([partInstance: eventDetailInstance.part])],-1)
printHtmlPart(12)
invokeTag('render','g',48,['template':("/product/content"),'model':([productInstance: eventDetailInstance.head.product])],-1)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(14)
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
