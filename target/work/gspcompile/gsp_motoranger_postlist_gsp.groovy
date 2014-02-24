import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_postlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'post.label', default: '文章'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',23,['code':("post.title.label")],-1)
printHtmlPart(5)
invokeTag('message','g',24,['code':("post.dateCreated.label")],-1)
printHtmlPart(6)
invokeTag('message','g',25,['code':("post.hits.label")],-1)
printHtmlPart(7)
if(true && (!posts)) {
printHtmlPart(8)
invokeTag('message','g',32,['code':("default.empty.description")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
loop:{
int i = 0
for( post in (posts) ) {
printHtmlPart(11)
expressionOut.print(i+1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(post.title)
})
invokeTag('link','g',38,['controller':("post"),'action':("show"),'id':(post?.id)],3)
printHtmlPart(12)
invokeTag('formatDate','g',39,['date':(post.lastUpdated),'type':("date"),'style':("SHOROT")],-1)
printHtmlPart(13)
expressionOut.print(post.hits)
printHtmlPart(14)
i++
}
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',48,[:],1)
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
