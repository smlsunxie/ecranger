import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_productportfolio_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/portfolio.gsp" }
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
for( part in (parts) ) {
printHtmlPart(9)
expressionOut.print(part.tags.join(' '))
printHtmlPart(10)
invokeTag('img','g',42,['uri':("/attachment/show?name=${part.name}&file=${part.mainImage}"),'style':("height:200px")],-1)
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(part.title)
})
invokeTag('link','g',47,['controller':("part"),'action':("show"),'id':(part.id)],3)
printHtmlPart(12)
expressionOut.print(part.description)
printHtmlPart(13)
expressionOut.print(part.price)
printHtmlPart(14)
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(16)
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
