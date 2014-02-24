import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_event_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(3)
expressionOut.print(error.field)
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('message','g',5,['error':(error)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',6,['bean':(eventInstance),'var':("error")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',8,['bean':(eventInstance)],1)
printHtmlPart(8)
invokeTag('message','g',13,['code':("event.name.label")],-1)
printHtmlPart(9)
invokeTag('textField','g',16,['name':("name"),'value':(eventInstance?.name),'readonly class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',24,['code':("user.username.label")],-1)
printHtmlPart(9)
invokeTag('select','g',27,['class':("form-control"),'name':("user.id"),'from':(eventInstance?.user ?: motoranger.UserRole.findAllByRole(motoranger.Role.findByAuthority('ROLE_OPERATOR'))*.user),'noSelection':([null:'Select One...']),'optionKey':("id"),'value':(eventInstance?.user?.id)],-1)
printHtmlPart(10)
invokeTag('message','g',35,['code':("event.product.label")],-1)
printHtmlPart(9)
invokeTag('select','g',38,['class':("form-control"),'name':("product.id"),'from':(eventInstance?.product?:motoranger.Product.list()),'noSelection':([null:'Select One...']),'optionKey':("id"),'value':(eventInstance?.product?.id)],-1)
printHtmlPart(11)
invokeTag('message','g',47,['code':("event.mileage.label")],-1)
printHtmlPart(9)
invokeTag('textField','g',50,['type':("number"),'name':("mileage"),'value':(eventInstance.mileage),'class':("form-control")],-1)
printHtmlPart(12)
invokeTag('message','g',58,['code':("event.date.label")],-1)
printHtmlPart(9)
invokeTag('datePicker','g',62,['name':("date"),'value':(eventInstance.date),'noSelection':(['':'-Choose-']),'precision':("day"),'years':((new Date().getAt(Calendar.YEAR)-1)..(new Date().getAt(Calendar.YEAR)))],-1)
printHtmlPart(12)
invokeTag('message','g',70,['code':("default.description.label")],-1)
printHtmlPart(9)
invokeTag('textField','g',73,['name':("description"),'value':(eventInstance?.description),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('message','g',82,['code':("user.store.label"),'default':("Store")],-1)
printHtmlPart(14)
invokeTag('select','g',85,['class':("form-control"),'id':("store"),'name':("store.id"),'from':(motoranger.Store.list()),'optionKey':("id"),'value':(eventInstance?.store?.id),'noSelection':(['null': ''])],-1)
printHtmlPart(15)
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
