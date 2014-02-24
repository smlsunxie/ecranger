import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_postportfolio_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/portfolio.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',3,['code':("post.edit.title"),'defualt':("修改文章")],-1)
})
invokeTag('captureTitle','sitemesh',3,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',3,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
for( tag in (tags) ) {
printHtmlPart(5)
expressionOut.print(tag)
printHtmlPart(6)
expressionOut.print(tag)
printHtmlPart(7)
}
printHtmlPart(8)
for( post in (posts) ) {
printHtmlPart(9)
expressionOut.print(post.tags.join(' '))
printHtmlPart(10)
createTagBody(3, {->
invokeTag('img','g',33,['alt':(""),'dir':("bizstrap/img"),'file':("460_arrow_2_hover.png"),'class':("hover-shade")],-1)
printHtmlPart(11)
})
invokeTag('link','g',34,['controller':("post"),'action':("show"),'id':(post.id)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('render','g',37,['template':("mainImg"),'model':([post:post])],-1)
printHtmlPart(11)
})
invokeTag('link','g',38,['controller':("post"),'action':("show"),'id':(post.id),'class':("top-link")],3)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(post.title)
})
invokeTag('link','g',41,['controller':("post"),'action':("show"),'id':(post.id)],3)
printHtmlPart(15)
expressionOut.print(post.description)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(18)
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
