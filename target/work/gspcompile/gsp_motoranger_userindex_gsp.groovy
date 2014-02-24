import motoranger.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_userindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('link','g',17,['class':("btn btn-primary"),'controller':("user"),'action':("create")],2)
printHtmlPart(5)
invokeTag('message','g',26,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(6)
invokeTag('sortableColumn','g',35,['property':("username"),'title':(message(code: 'user.username.label', default: 'Username'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',37,['property':("store"),'title':(message(code: 'user.store.label', default: 'Store'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',39,['property':("address"),'title':(message(code: 'user.address.label', default: 'Address'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',41,['property':("telphone"),'title':(message(code: 'user.telphone.label', default: 'telphone'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',43,['property':("mobile"),'title':(message(code: 'user.mobile.label', default: 'mobile'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',45,['property':("email"),'title':(message(code: 'user.email.label', default: 'email'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( userInstance in (userInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(message(code: 'user.username.label', default: 'Username'))
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: userInstance, field: "username"))
})
invokeTag('link','g',54,['action':("show"),'id':(userInstance.id)],3)
printHtmlPart(15)
expressionOut.print(message(code: 'user.store.label', default: 'Username'))
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: userInstance, field: "store"))
})
invokeTag('link','g',56,['action':("show"),'url':("/store/show/${userInstance?.store?.id}")],3)
printHtmlPart(16)
expressionOut.print(message(code: 'user.address.label', default: 'Username'))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: userInstance, field: "address"))
printHtmlPart(17)
expressionOut.print(message(code: 'user.telphone.label', default: 'Username'))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: userInstance, field: "telphone"))
printHtmlPart(17)
expressionOut.print(message(code: 'user.mobile.label', default: 'Username'))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: userInstance, field: "mobile"))
printHtmlPart(17)
expressionOut.print(message(code: 'user.email.label', default: 'Username'))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: userInstance, field: "email"))
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
if(true && (userInstance.enabled)) {
printHtmlPart(20)
createClosureForHtmlPart(21, 5)
invokeTag('link','g',73,['controller':("login"),'action':("switchUser"),'params':([username: userInstance.username])],5)
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('ifAnyGranted','sec',76,['roles':("ROLE_ADMIN")],3)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',90,['total':(userInstanceCount)],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(27)
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
