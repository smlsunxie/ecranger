import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_layoutsbootstrap_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/bootstrap.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',6,['default':("motoranger")],-1)
printHtmlPart(2)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(6)
invokeTag('require','r',12,['modules':("jquery, jquery-ui, modernizr, common, font-awesome, pagedown, compass, tagit, fileuploader, bootstrap-ext, ie6")],-1)
printHtmlPart(7)
invokeTag('layoutHead','g',14,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',15,[:],-1)
printHtmlPart(1)
invokeTag('trackPageview','ga',16,[:],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('applyLayout','g',32,['name':("inc_header")],-1)
printHtmlPart(10)
invokeTag('render','g',38,['template':("/layouts/alert_chromeframe")],-1)
printHtmlPart(11)
invokeTag('render','g',41,['template':("/layouts/navbar")],-1)
printHtmlPart(12)
invokeTag('layoutBody','g',42,[:],-1)
printHtmlPart(13)
invokeTag('footer','g',46,[:],-1)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
})
invokeTag('script','r',78,[:],2)
printHtmlPart(18)
invokeTag('layoutResources','r',79,[:],-1)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(20)
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
