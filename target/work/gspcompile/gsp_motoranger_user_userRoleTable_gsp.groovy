import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_user_userRoleTable_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_userRoleTable.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hidden)
printHtmlPart(1)
invokeTag('checkBox','g',5,['name':("enabled"),'value':(userInstance?.enabled)],-1)
printHtmlPart(2)
invokeTag('message','g',6,['code':("user.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(3)
expressionOut.print(hidden)
printHtmlPart(4)
invokeTag('checkBox','g',18,['name':("passwordExpired"),'value':(userInstance?.passwordExpired)],-1)
printHtmlPart(5)
invokeTag('message','g',19,['code':("user.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(6)
expressionOut.print(hidden)
printHtmlPart(1)
invokeTag('checkBox','g',32,['name':("accountExpired"),'value':(userInstance?.accountExpired)],-1)
printHtmlPart(2)
invokeTag('message','g',33,['code':("user.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(7)
expressionOut.print(hidden)
printHtmlPart(1)
invokeTag('checkBox','g',43,['name':("accountLocked"),'value':(userInstance?.accountLocked)],-1)
printHtmlPart(2)
invokeTag('message','g',44,['code':("user.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(8)
expressionOut.print(hidden)
printHtmlPart(9)
invokeTag('message','g',54,['code':("role.authority.label"),'default':("authority")],-1)
printHtmlPart(10)
loop:{
int i = 0
for( role in (roles) ) {
printHtmlPart(11)
invokeTag('checkBox','g',64,['name':("userRoles"),'value':(role.authority),'checked':(userRoles && userRoles.role.authority.contains(role.authority))],-1)
printHtmlPart(12)
expressionOut.print(role.authority)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390804579000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
