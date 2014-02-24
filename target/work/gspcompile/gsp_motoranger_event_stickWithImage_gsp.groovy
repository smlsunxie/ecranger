import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_event_stickWithImage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_stickWithImage.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('img','g',5,['uri':("/attachment/show?name=${eventInstance.product.name}&file=${eventInstance.product.mainImage}"),'class':("img-thumbnail")],-1)
printHtmlPart(1)
invokeTag('render','g',9,['template':("/event/stick"),'model':(['stickName': stickName])],-1)
printHtmlPart(2)
if(true && (currentUserIsEventOwner[eventInstance.id])) {
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('render','g',17,['template':("/event/updateReceivedMoney")],-1)
printHtmlPart(5)
invokeTag('render','g',18,['template':("/event/updateUnreceiveMoney")],-1)
printHtmlPart(6)
})
invokeTag('ifAnyGranted','sec',22,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(7)
}
printHtmlPart(8)
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
