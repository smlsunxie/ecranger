import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_usershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(product?.title)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',16,['action':("edit"),'id':(userInstance.id)],2)
printHtmlPart(3)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',17,['action':("delete"),'id':(userInstance.id)],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',27,['controller':("store"),'action':("create"),'params':(['user.id': userInstance.id])],3)
printHtmlPart(7)
})
invokeTag('ifAnyGranted','sec',28,['roles':("ROLE_ADMIN")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(5)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',31,['elementId':("product-create"),'controller':("product"),'action':("create"),'params':(['user.id': userInstance.id])],3)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',33,['elementId':("part-create"),'controller':("part"),'action':("create"),'params':(['user.id': userInstance.id])],3)
printHtmlPart(7)
})
invokeTag('ifAnyGranted','sec',34,['roles':("ROLE_CUSTOMER")],2)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',47,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',47,['elementId':("user-edit"),'class':("btn btn-primary"),'action':("edit"),'id':(userInstance.id)],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',50,['class':("btn btn-primary"),'controller':("login"),'action':("switchUser"),'params':([username: userInstance.username])],3)
printHtmlPart(14)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',51,['class':("btn btn-primary"),'controller':("store"),'action':("create"),'params':(['user.id': userInstance.id])],3)
printHtmlPart(16)
})
invokeTag('ifAnyGranted','sec',52,['roles':("ROLE_ADMIN")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
if(true && (!user?.store)) {
printHtmlPart(17)
createClosureForHtmlPart(18, 4)
invokeTag('link','g',56,['class':("btn btn-primary"),'controller':("user"),'action':("addToStore"),'id':(userInstance.id)],4)
printHtmlPart(14)
}
printHtmlPart(16)
})
invokeTag('ifAnyGranted','sec',58,['roles':("ROLE_MANERGER")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',61,['elementId':("product-create"),'class':("btn btn-primary"),'controller':("product"),'action':("create"),'params':(['user.id': userInstance.id])],3)
printHtmlPart(16)
})
invokeTag('ifAnyGranted','sec',62,['roles':("ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',66,['elementId':("part-create"),'class':("btn btn-primary"),'controller':("part"),'action':("create"),'params':(['user.id': userInstance.id])],3)
printHtmlPart(16)
})
invokeTag('ifAnyGranted','sec',67,['roles':("ROLE_CUSTOMER")],2)
printHtmlPart(20)
createTagBody(2, {->
invokeTag('message','g',70,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',70,['elementId':("user-delete"),'class':("btn btn-danger"),'action':("delete"),'id':(userInstance.id)],2)
printHtmlPart(23)
invokeTag('render','g',82,['template':("/user/content"),'model':([user: userInstance])],-1)
printHtmlPart(24)
loop:{
int i = 0
for( productInstance in (productInstanceList) ) {
printHtmlPart(25)
invokeTag('render','g',99,['template':("/product/content"),'model':([productInstance: productInstance])],-1)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',111,[:],1)
printHtmlPart(28)
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
