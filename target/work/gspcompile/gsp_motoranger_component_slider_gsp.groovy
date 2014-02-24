import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_component_slider_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/component/_slider.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (files.size()>0)) {
printHtmlPart(1)
loop:{
int i = 0
for( file in (files) ) {
printHtmlPart(2)
expressionOut.print(i)
printHtmlPart(3)
expressionOut.print(i == 0 ? 'active' : '')
printHtmlPart(4)
i++
}
}
printHtmlPart(5)
loop:{
int i = 0
for( file in (files) ) {
printHtmlPart(6)
expressionOut.print(i == 0 ? 'active' : '')
printHtmlPart(7)
expressionOut.print(name)
printHtmlPart(8)
expressionOut.print(file.name)
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
}
printHtmlPart(0)
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
