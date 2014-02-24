import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_post_tabs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/_tabs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: post, field: 'name', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',15,['code':("post.name.label")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("name"),'value':(post?.name),'class':("form-control")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: post, field: 'title', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',26,['code':("post.title.label")],-1)
printHtmlPart(2)
invokeTag('textField','g',30,['name':("title"),'value':(post?.title),'class':("form-control")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: post, field: 'type', 'has-error'))
printHtmlPart(6)
invokeTag('message','g',37,['code':("post.type.label")],-1)
printHtmlPart(2)
invokeTag('select','g',41,['name':("type"),'from':(motoranger.PostType?.values()),'keys':(motoranger.PostType.values()*.name()),'required':(""),'value':(post?.type?.name()),'valueMessagePrefix':("PostType"),'class':("form-control")],-1)
printHtmlPart(7)
invokeTag('message','g',48,['code':("default.tags.label")],-1)
printHtmlPart(8)
for( _it1657519343 in (post.tags) ) {
changeItVariable(_it1657519343)
printHtmlPart(9)
expressionOut.print(it)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(hasErrors(bean: post, field: 'description', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',63,['code':("post.description.label")],-1)
printHtmlPart(2)
invokeTag('textField','g',67,['name':("description"),'value':(post?.description),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('textArea','g',81,['name':("content"),'cols':("40"),'rows':("20"),'value':(post?.content),'class':("wmd-input enable-tabkey"),'id':("wmd-input")],-1)
printHtmlPart(14)
invokeTag('render','g',106,['template':("/attachment/uploadBtn"),'model':([name:post.name ,mainImage: post?.mainImage, domainName: 'post'])],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
expressionOut.print(g.createLink(controller:'tag',action: 'listAsJson'))
printHtmlPart(17)
})
invokeTag('script','r',117,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390902276000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
