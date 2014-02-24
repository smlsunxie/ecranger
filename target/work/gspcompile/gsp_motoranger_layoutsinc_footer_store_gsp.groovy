import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_layoutsinc_footer_store_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/inc_footer_store.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(store?.address)
printHtmlPart(1)
expressionOut.print(store?.address)
printHtmlPart(2)
expressionOut.print(store?.telphone)
printHtmlPart(3)
expressionOut.print(store?.mobile)
printHtmlPart(4)
expressionOut.print(store?.fax)
printHtmlPart(5)
expressionOut.print(store?.email)
printHtmlPart(6)
expressionOut.print(store?.email)
printHtmlPart(7)
invokeTag('applyLayout','g',40,['name':("inc_sysmenu")],-1)
printHtmlPart(8)
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
