import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_part_gallery_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/part/_gallery.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
for( partInstance in (partInstanceList) ) {
printHtmlPart(0)
expressionOut.print(partInstance.tags.join(' '))
printHtmlPart(1)
expressionOut.print(partInstance.name)
printHtmlPart(2)
createTagBody(2, {->
expressionOut.print(partInstance.title)
})
invokeTag('link','g',7,['elementId':("part-show-${partInstance.name}"),'controller':("part"),'action':("show"),'id':(partInstance.id)],2)
printHtmlPart(3)
expressionOut.print(partInstance.description)
printHtmlPart(4)
if(true && (eventInstance)) {
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('textField','g',19,['value':(partInstance.price),'name':("price"),'class':("form-control")],-1)
printHtmlPart(7)
invokeTag('textField','g',23,['value':("1"),'name':("qty"),'class':("form-control")],-1)
printHtmlPart(8)
invokeTag('textField','g',24,['hidden value':(""),'name':("name")],-1)
printHtmlPart(9)
invokeTag('submitButton','g',28,['controller':("eventDetail"),'action':("create"),'class':("btn btn-primary"),'value':("快速新增"),'name':("create")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',34,['controller':("eventDetail"),'action':("create"),'params':(['part.id':partInstance.id, 'head.id':event.id]),'class':("btn btn-primary")],4)
printHtmlPart(12)
})
invokeTag('form','g',34,['name':("eventDetail-save-${partInstance.name}"),'action':("save"),'controller':("eventDetail"),'class':("form-thumbnail"),'params':(['part.id':partInstance.id, 'part.name':partInstance.name, 'head.id':event.id])],3)
printHtmlPart(13)
}
else {
printHtmlPart(14)
expressionOut.print(partInstance.price)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',41,['controller':("part"),'action':("show"),'id':(partInstance.id),'class':("btn")],3)
printHtmlPart(13)
}
printHtmlPart(17)
}
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
