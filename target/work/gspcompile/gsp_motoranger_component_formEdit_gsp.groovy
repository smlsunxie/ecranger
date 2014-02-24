import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_component_formEdit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/component/_formEdit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('submitButton','g',5,['name':("update"),'class':("btn btn-primary"),'value':(message(code: 'default.button.update.label', default: 'update'))],-1)
printHtmlPart(2)
createTagBody(2, {->
expressionOut.print(message(code: 'default.button.cancel.label', default: 'Cancel'))
})
invokeTag('link','g',7,['action':("show"),'id':(domain.id),'class':("btn btn-default")],2)
printHtmlPart(3)
invokeTag('render','g',12,['template':("/${domainName}/form")],-1)
printHtmlPart(4)
invokeTag('submitButton','g',17,['name':("create"),'class':("btn btn-primary"),'value':(message(code: 'default.button.update.label', default: 'update'))],-1)
printHtmlPart(2)
createTagBody(2, {->
expressionOut.print(message(code: 'default.button.cancel.label', default: 'Cancel'))
})
invokeTag('link','g',19,['action':("show"),'id':(domainId),'class':("btn btn-default")],2)
printHtmlPart(5)
})
invokeTag('form','g',22,['name':("${domainName}-update"),'url':([resource: domain, action:'update']),'class':("form-horizontal")],1)
printHtmlPart(6)
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
