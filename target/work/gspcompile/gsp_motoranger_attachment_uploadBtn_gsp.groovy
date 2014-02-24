import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_attachment_uploadBtn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/attachment/_uploadBtn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',8,['action':("show"),'controller':("post"),'id':("10")],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('onComplete','uploader',29,[:],2)
printHtmlPart(5)
})
invokeTag('uploader','uploader',30,['multiple':("false"),'debug':("true"),'id':("fileupload"),'url':([controller:'attachment', action:'save']),'params':([name:name, domainName: domainName])],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(name)
printHtmlPart(8)
invokeTag('remoteFunction','g',120,['controller':("attachment"),'action':("list"),'params':([name:name, mainImage: mainImage, domainName: domainName]),'onSuccess':("checkDefaultRadioSelected()"),'update':("images")],-1)
printHtmlPart(9)
})
invokeTag('script','r',142,[:],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1391753623000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
