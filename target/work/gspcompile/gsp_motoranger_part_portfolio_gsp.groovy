import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_part_portfolio_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/part/_portfolio.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',7,['code':("TagGroup.${params.group}")],-1)
printHtmlPart(1)
for( group in (motoranger.TagGroup.values()) ) {
printHtmlPart(2)
if(true && (params.group.toString() != group.toString())) {
printHtmlPart(3)
createTagBody(3, {->
invokeTag('message','g',14,['code':("TagGroup.${group}")],-1)
})
invokeTag('link','g',14,['action':(actionName),'id':(eventInstance?.id),'params':([group: group])],3)
printHtmlPart(4)
}
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(params.tag ? params.tag : '選擇標籤')
printHtmlPart(1)
loop:{
int i = 0
for( tag in (tags) ) {
printHtmlPart(7)
if(true && (params.tag != tag)) {
printHtmlPart(8)
createTagBody(3, {->
expressionOut.print(tag)
})
invokeTag('link','g',31,['elementId':("tag-show-${i}"),'action':(actionName),'id':(eventInstance?.id),'params':([tag: tag, group: params.group])],3)
printHtmlPart(9)
}
printHtmlPart(5)
i++
}
}
printHtmlPart(10)
for( group in (motoranger.TagGroup.values()) ) {
printHtmlPart(11)
expressionOut.print(params.group.toString() == group.toString() ? 'active' : '')
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',49,['code':("TagGroup.${group}")],-1)
})
invokeTag('link','g',49,['action':(actionName),'id':(eventInstance?.id),'params':([group: group])],2)
printHtmlPart(13)
}
printHtmlPart(14)
loop:{
int i = 0
for( tag in (tags) ) {
printHtmlPart(11)
expressionOut.print(params.tag == tag.toString() ? 'active' : '')
printHtmlPart(12)
createTagBody(2, {->
expressionOut.print(tag)
})
invokeTag('link','g',62,['elementId':("tag-show-${i}"),'action':(actionName),'id':(eventInstance?.id),'params':([tag: tag, group: params.group])],2)
printHtmlPart(13)
i++
}
}
printHtmlPart(15)
invokeTag('render','g',73,['template':("/part/gallery")],-1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392369290000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
