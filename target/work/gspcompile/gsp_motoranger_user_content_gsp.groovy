import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_user_content_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_content.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',6,['code':("user.username.label")],-1)
printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(userInstance.username)
})
invokeTag('link','g',7,['controller':("user"),'action':("show"),'id':(userInstance.id)],1)
printHtmlPart(2)
invokeTag('message','g',11,['code':("user.title.label")],-1)
printHtmlPart(1)
expressionOut.print(userInstance.title)
printHtmlPart(3)
invokeTag('message','g',15,['code':("user.email.label")],-1)
printHtmlPart(1)
expressionOut.print(userInstance.email)
printHtmlPart(4)
invokeTag('message','g',19,['code':("user.telphone.label")],-1)
printHtmlPart(1)
expressionOut.print(userInstance.telphone)
printHtmlPart(3)
invokeTag('message','g',23,['code':("user.mobile.label")],-1)
printHtmlPart(1)
expressionOut.print(userInstance.mobile)
printHtmlPart(5)
invokeTag('message','g',27,['code':("user.enable.label")],-1)
printHtmlPart(6)
expressionOut.print(productInstance?.user?.enabled ? "是" : "否")
printHtmlPart(7)
invokeTag('message','g',31,['code':("user.description.label")],-1)
printHtmlPart(1)
expressionOut.print(userInstance.description)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390926202000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
