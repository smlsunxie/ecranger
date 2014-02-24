import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_store_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/_form.gsp" }
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
invokeTag('eachError','g',5,['bean':(storeInstance),'var':("error")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',7,['bean':(storeInstance)],1)
printHtmlPart(7)
invokeTag('message','g',12,['code':("store.name.label"),'default':("Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',15,['name':("name"),'value':(storeInstance?.name),'class':("form-control")],-1)
printHtmlPart(9)
invokeTag('message','g',23,['code':("store.title.label"),'default':("Title")],-1)
printHtmlPart(8)
invokeTag('textField','g',26,['name':("title"),'value':(storeInstance?.title),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',34,['code':("store.address.label"),'default':("Address")],-1)
printHtmlPart(8)
invokeTag('textField','g',37,['name':("address"),'value':(storeInstance?.address),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',45,['code':("store.email.label"),'default':("email")],-1)
printHtmlPart(8)
invokeTag('textField','g',48,['name':("email"),'value':(storeInstance?.email),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',56,['code':("store.mobile.label"),'default':("Mobile")],-1)
printHtmlPart(8)
invokeTag('textField','g',59,['name':("mobile"),'value':(storeInstance?.mobile),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('message','g',70,['code':("store.telphone.label"),'default':("Telphone")],-1)
printHtmlPart(8)
invokeTag('textField','g',73,['name':("telphone"),'value':(storeInstance?.telphone),'class':("form-control")],-1)
printHtmlPart(12)
invokeTag('message','g',80,['code':("store.fax.label"),'default':("fax")],-1)
printHtmlPart(8)
invokeTag('textField','g',83,['name':("fax"),'value':(storeInstance?.fax),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('message','g',95,['code':("store.users.label"),'default':("Users"),'class':("form-control")],-1)
printHtmlPart(14)
for( u in (storeInstance?.users) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(u?.encodeAsHTML())
})
invokeTag('link','g',101,['controller':("user"),'action':("show"),'id':(u.id)],2)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'user.label', default: 'User')]))
})
invokeTag('link','g',105,['controller':("user"),'action':("create"),'params':(['store.id': storeInstance?.id])],1)
printHtmlPart(18)
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
