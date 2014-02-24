import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_eventshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(eventInstance)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (currentUserIsEventOwner[eventInstance.id])) {
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(7)
expressionOut.print(eventInstance.id)
printHtmlPart(8)
})
invokeTag('jasperReport','g',24,['jasper':("event"),'format':("HTML"),'name':("列印"),'delimiter':(" ")],4)
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
invokeTag('message','g',30,['code':("default.button.edit.label")],-1)
printHtmlPart(10)
})
invokeTag('link','g',31,['elementId':("event-edit"),'class':("btn btn-primary btn-large "),'action':("edit"),'controller':("event"),'id':(eventInstance.id)],4)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
invokeTag('message','g',37,['code':("default.button.delete.label")],-1)
printHtmlPart(10)
})
invokeTag('link','g',38,['elementId':("event-delete"),'class':("btn btn-danger"),'action':("delete"),'controller':("event"),'id':(eventInstance.id)],4)
printHtmlPart(13)
})
invokeTag('ifAnyGranted','sec',44,['roles':("ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER")],3)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('render','g',48,['template':("/event/updateReceivedMoney")],-1)
printHtmlPart(16)
invokeTag('render','g',53,['template':("/event/updateUnreceiveMoney")],-1)
printHtmlPart(17)
invokeTag('render','g',57,['template':("/event/updateEventDate")],-1)
printHtmlPart(18)
})
invokeTag('ifAnyGranted','sec',59,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],3)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('render','g',69,['template':("contentWithDetails")],-1)
printHtmlPart(21)
invokeTag('render','g',72,['template':("/product/contentWithDetails"),'model':([productInstance: eventInstance.product])],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392369290000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
