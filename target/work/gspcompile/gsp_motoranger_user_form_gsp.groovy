import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_user_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_form.gsp" }
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
invokeTag('eachError','g',6,['bean':(userInstance),'var':("error")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',8,['bean':(userInstance)],1)
printHtmlPart(8)
invokeTag('hiddenField','g',11,['name':("product.id"),'value':(params?.product?.id)],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userInstance, field: 'username', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',17,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(11)
invokeTag('textField','g',21,['name':("username"),'required':(""),'value':(userInstance?.username),'class':("form-control")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: userInstance, field: 'password', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',30,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(11)
invokeTag('passwordField','g',34,['name':("password"),'required':(""),'value':(userInstance?.password),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: userInstance, field: 'title', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',42,['code':("user.title.label"),'default':("Title")],-1)
printHtmlPart(11)
invokeTag('textField','g',46,['name':("title"),'required':(""),'value':(userInstance?.title),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: userInstance, field: 'address', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',54,['code':("user.address.label"),'default':("Address")],-1)
printHtmlPart(17)
invokeTag('textField','g',57,['name':("address"),'value':(userInstance?.address),'class':("form-control")],-1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: userInstance, field: 'email', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',67,['code':("user.email.label"),'default':("Email")],-1)
printHtmlPart(17)
invokeTag('textField','g',70,['name':("email"),'value':(userInstance?.email),'class':("form-control")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: userInstance, field: 'mobile', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',79,['code':("user.mobile.label"),'default':("Mobile")],-1)
printHtmlPart(17)
invokeTag('textField','g',82,['name':("mobile"),'value':(userInstance?.mobile),'class':("form-control")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: userInstance, field: 'telphone', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',91,['code':("user.telphone.label"),'default':("Telphone")],-1)
printHtmlPart(17)
invokeTag('textField','g',94,['name':("telphone"),'value':(userInstance?.telphone),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: userInstance, field: 'description', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',102,['code':("user.description.label"),'default':("Description")],-1)
printHtmlPart(17)
invokeTag('textField','g',105,['name':("description"),'value':(userInstance?.description),'class':("form-control")],-1)
printHtmlPart(23)
createTagBody(1, {->
printHtmlPart(24)
invokeTag('message','g',114,['code':("user.store.label"),'default':("Store")],-1)
printHtmlPart(25)
invokeTag('select','g',117,['id':("store"),'name':("store.id"),'from':(storeList),'optionKey':("id"),'value':(userInstance?.store?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(26)
})
invokeTag('ifAnyGranted','sec',121,['roles':("ROLE_MANERGER, ROLE_ADMIN")],1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
invokeTag('message','g',127,['code':("user.store.label"),'default':("Store")],-1)
printHtmlPart(25)
invokeTag('select','g',130,['id':("store"),'name':("store.id"),'from':(storeList),'optionKey':("id"),'value':(userInstance?.store?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(26)
})
invokeTag('ifNotGranted','sec',134,['roles':("ROLE_MANERGER, ROLE_ADMIN")],1)
printHtmlPart(29)
createTagBody(1, {->
printHtmlPart(30)
invokeTag('render','g',140,['template':("userRoleTable"),'model':([hidden: ''])],-1)
printHtmlPart(27)
})
invokeTag('ifAnyGranted','sec',142,['roles':("ROLE_ADMIN")],1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(30)
invokeTag('render','g',146,['template':("userRoleTable"),'model':([hidden: 'hidden'])],-1)
printHtmlPart(27)
})
invokeTag('ifNotGranted','sec',148,['roles':("ROLE_ADMIN")],1)
printHtmlPart(8)
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
