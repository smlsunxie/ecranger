import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_postshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(post?.title)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
createTagBody(3, {->
invokeTag('message','g',15,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',15,['class':("btn btn-primary"),'action':("edit"),'id':(post?.id)],3)
printHtmlPart(4)
createTagBody(3, {->
invokeTag('message','g',18,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',18,['class':("btn btn-danger"),'action':("delete"),'id':(post?.id)],3)
printHtmlPart(5)
})
invokeTag('ifAnyGranted','sec',23,['roles':("ROLE_ADMIN")],2)
printHtmlPart(6)
expressionOut.print(post?.title)
printHtmlPart(7)
if(true && (productShow)) {
printHtmlPart(8)
invokeTag('render','g',31,['template':("/product/content"),'model':(['product':productShow.product,'files':productShow.files])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(post?.content?.encodeAsHTML())
printHtmlPart(11)
invokeTag('formatDate','g',40,['date':(post?.lastUpdated),'type':("datetime"),'style':("MEDIUM")],-1)
printHtmlPart(12)
expressionOut.print(post.creator)
printHtmlPart(13)
invokeTag('render','g',48,['template':("/component/recentPost"),'model':([recentPosts:recentPosts])],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',48,[:],1)
printHtmlPart(15)
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
