import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_event_statusChangeBtn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_statusChangeBtn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (eventInstance.status == motoranger.ProductStatus.UNFIN)) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('message','g',4,['code':("ProductStatus.END")],-1)
printHtmlPart(1)
})
invokeTag('link','g',5,['elementId':("event-update-statusEnd-${eventInstance.name}"),'class':("btn btn-success"),'action':("update"),'controller':("event"),'id':(eventInstance.id),'params':([status:motoranger.ProductStatus.END.name()])],2)
printHtmlPart(3)
}
else if(true && (eventInstance.status == motoranger.ProductStatus.END)) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('message','g',10,['code':("ProductStatus.UNFIN")],-1)
printHtmlPart(1)
})
invokeTag('link','g',11,['class':("btn btn-danger"),'action':("update"),'controller':("event"),'id':(eventInstance.id),'params':([status:motoranger.ProductStatus.UNFIN.name()])],2)
printHtmlPart(3)
}
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
