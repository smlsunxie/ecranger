import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_productshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(product?.title)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
createTagBody(3, {->
invokeTag('message','g',14,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',14,['elementId':("product-edit"),'class':("btn btn-primary"),'action':("edit"),'id':(productInstance?.id)],3)
printHtmlPart(4)
createTagBody(3, {->
invokeTag('message','g',17,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',17,['elementId':("product-delete"),'class':("btn btn-danger"),'action':("delete"),'id':(productInstance?.id)],3)
printHtmlPart(5)
})
invokeTag('ifAnyGranted','sec',22,['roles':("ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(6)
invokeTag('render','g',27,['template':("contentWithDetails")],-1)
printHtmlPart(2)
if(true && (similarProductIntanceList)) {
printHtmlPart(7)
for( similarProductIntance in (similarProductIntanceList) ) {
printHtmlPart(8)
createTagBody(4, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 5)
invokeTag('link','g',38,['class':("btn btn-primary"),'action':("moveEvent"),'params':(['fromProduct.id': similarProductIntance.id, 'toProduct.id': productInstance.id])],5)
printHtmlPart(11)
})
invokeTag('ifAnyGranted','sec',40,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],4)
printHtmlPart(12)
invokeTag('render','g',42,['template':("content"),'model':([productInstance: similarProductIntance])],-1)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
if(true && (statusEnd)) {
printHtmlPart(17)
createClosureForHtmlPart(18, 4)
invokeTag('link','g',61,['elementId':("event-create"),'class':("btn btn-primary"),'controller':("event"),'action':("create"),'params':(['product.id':productInstance?.id])],4)
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('ifAnyGranted','sec',65,['roles':("ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(20)
invokeTag('render','g',67,['template':("/event/contentWithDetails"),'collection':(productInstance?.events),'var':("eventInstance")],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392115764000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
