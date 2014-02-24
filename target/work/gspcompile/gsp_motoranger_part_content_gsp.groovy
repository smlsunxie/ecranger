import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_part_content_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/part/_content.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("part.title.label")],-1)
printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(partInstance.title)
})
invokeTag('link','g',6,['controller':("part"),'action':("show"),'id':(partInstance.id)],1)
printHtmlPart(2)
invokeTag('message','g',12,['code':("part.price.label")],-1)
printHtmlPart(3)
expressionOut.print(partInstance.price)
printHtmlPart(4)
invokeTag('message','g',17,['code':("part.cost.label")],-1)
printHtmlPart(3)
expressionOut.print((partInstance.cost == -1 ?'****':partInstance.cost))
printHtmlPart(5)
invokeTag('message','g',22,['code':("default.description.label")],-1)
printHtmlPart(3)
expressionOut.print(partInstance.description)
printHtmlPart(5)
invokeTag('message','g',27,['code':("part.user.label")],-1)
printHtmlPart(3)
expressionOut.print(partInstance.user)
printHtmlPart(6)
invokeTag('message','g',31,['code':("part.store.label")],-1)
printHtmlPart(3)
expressionOut.print(partInstance.store)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1391501665000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
