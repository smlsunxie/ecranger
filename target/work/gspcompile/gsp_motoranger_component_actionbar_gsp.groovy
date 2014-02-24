import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_component_actionbar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/component/_actionbar.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (actionName=='create' ||actionName=='save' ||actionName=='edit')) {
printHtmlPart(1)
invokeTag('submitButton','g',9,['name':(nextActionName),'class':("btn btn-primary btn-large"),'value':(message(code: 'default.button.${nextActionName}.label', default: nextActionName))],-1)
printHtmlPart(2)
createTagBody(2, {->
expressionOut.print(message(code: 'default.button.cancel.label', default: 'Cancel'))
})
invokeTag('link','g',10,['action':("list"),'class':("btn")],2)
printHtmlPart(3)
}
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1386657611000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
