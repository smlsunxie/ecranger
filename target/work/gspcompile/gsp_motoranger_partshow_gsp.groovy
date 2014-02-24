import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_partshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/part/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('set','g',1,['var':("s3Service"),'bean':("s3Service")],-1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(partInstance.title)
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
if(true && (currentUserIsPartOwner)) {
printHtmlPart(3)
createTagBody(3, {->
invokeTag('message','g',14,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',14,['elementId':("part-edit"),'class':("btn btn-primary"),'action':("edit"),'id':(partInstance.id)],3)
printHtmlPart(4)
createTagBody(3, {->
invokeTag('message','g',16,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',16,['elementId':("part-delete"),'class':("btn btn-danger"),'action':("delete"),'id':(partInstance.id)],3)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('img','g',27,['uri':("/attachment/show?name=${partInstance.name}&file=${partInstance.mainImage}"),'class':("img-thumbnail")],-1)
printHtmlPart(7)
invokeTag('render','g',32,['template':("content")],-1)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',36,[:],1)
printHtmlPart(9)
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
