import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_homeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/home/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("default.home.label")],-1)
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('img','g',16,['dir':("bizstrap/img"),'file':("slider01.png"),'class':("img-responsive")],-1)
printHtmlPart(5)
invokeTag('img','g',50,['dir':("bizstrap/img"),'file':("home_grid.png"),'class':("img-responsive")],-1)
printHtmlPart(6)
invokeTag('img','g',59,['dir':("bizstrap/img"),'file':("home_gears.png"),'class':("img-responsive")],-1)
printHtmlPart(7)
invokeTag('img','g',67,['dir':("bizstrap/img"),'file':("home_arrow.png"),'class':("img-responsive")],-1)
printHtmlPart(8)
invokeTag('img','g',75,['dir':("bizstrap/img"),'file':("home_arrows.png"),'class':("img-responsive")],-1)
printHtmlPart(9)
invokeTag('render','g',85,['template':("/component/recentPost"),'model':([recentPosts:recentPosts])],-1)
printHtmlPart(10)
invokeTag('render','g',98,['template':("/event/stickWithImage"),'model':(['stickName':'alert']),'collection':(unfinEvents),'var':("eventInstance")],-1)
printHtmlPart(11)
invokeTag('render','g',114,['template':("/event/stickWithImage"),'model':(['stickName':'success']),'collection':(endEvents),'var':("eventInstance")],-1)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',125,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392115807000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
