import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_component_recentPost_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/component/_recentPost.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( recentPost in (recentPosts) ) {
printHtmlPart(1)
invokeTag('render','g',13,['template':("/post/mainImg"),'class':("img-rounded img-responsive"),'model':([post:recentPost])],-1)
printHtmlPart(2)
createTagBody(2, {->
expressionOut.print(recentPost?.title)
})
invokeTag('link','g',16,['controller':("post"),'action':("show"),'id':(recentPost.id),'class':("block-post-title")],2)
printHtmlPart(3)
invokeTag('formatDate','g',17,['date':(recentPost.lastUpdated),'type':("date"),'style':("MEDIUM")],-1)
printHtmlPart(4)
expressionOut.print(recentPost.description)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',19,['controller':("post"),'action':("show"),'id':(recentPost.id),'class':("block-post-more")],2)
printHtmlPart(7)
}
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
