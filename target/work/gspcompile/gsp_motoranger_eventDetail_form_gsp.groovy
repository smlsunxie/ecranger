import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_eventDetail_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventDetail/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
createTagBody(2, {->
printHtmlPart(1)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(2)
expressionOut.print(error.field)
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('message','g',4,['error':(error)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',5,['bean':(eventDetailInstance),'var':("error")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',7,['bean':(eventDetailInstance)],1)
printHtmlPart(7)
invokeTag('message','g',12,['code':("eventDetail.name.label")],-1)
printHtmlPart(8)
invokeTag('textField','g',15,['name':("name"),'readonly value':(eventDetailInstance?.name),'class':("form-control")],-1)
printHtmlPart(9)
invokeTag('message','g',24,['code':("event.name.label")],-1)
printHtmlPart(8)
invokeTag('select','g',27,['class':("form-control"),'name':("head.id"),'from':(eventDetailInstance?.head ?: motoranger.Event.list()),'noSelection':([null:'Select One...']),'optionKey':("id"),'value':(eventDetailInstance?.head?.id)],-1)
printHtmlPart(10)
invokeTag('message','g',36,['code':("part.name.label")],-1)
printHtmlPart(8)
invokeTag('select','g',39,['class':("form-control"),'name':("part.id"),'from':(eventDetailInstance?.part ? eventDetailInstance?.part : motoranger.Part.list()),'noSelection':([null:'Select One...']),'optionKey':("id"),'value':(eventDetailInstance?.part?.id)],-1)
printHtmlPart(10)
invokeTag('message','g',48,['code':("eventDetail.price.label")],-1)
printHtmlPart(8)
invokeTag('field','g',51,['type':("number"),'name':("price"),'value':(eventDetailInstance?.price),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('message','g',59,['code':("eventDetail.cost.label")],-1)
printHtmlPart(8)
invokeTag('field','g',62,['type':("number"),'name':("cost"),'value':(eventDetailInstance?.cost),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',71,['code':("eventDetail.qty.label")],-1)
printHtmlPart(8)
invokeTag('field','g',74,['type':("number"),'name':("qty"),'value':(eventDetailInstance?.qty),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('message','g',82,['code':("default.description.label")],-1)
printHtmlPart(8)
invokeTag('textField','g',85,['name':("description"),'value':(eventDetailInstance?.description),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',94,['code':("default.imageUpload.label")],-1)
printHtmlPart(8)
invokeTag('render','g',97,['template':("/attachment/uploadBtn"),'model':([name:eventDetailInstance?.name,mainImage:eventDetailInstance?.mainImage])],-1)
printHtmlPart(12)
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
