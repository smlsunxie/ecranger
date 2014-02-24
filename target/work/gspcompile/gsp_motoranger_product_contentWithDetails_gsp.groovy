import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_product_contentWithDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/_contentWithDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('set','g',1,['var':("s3Service"),'bean':("s3Service")],-1)
printHtmlPart(0)
invokeTag('img','g',6,['uri':("/attachment/show?name=${productInstance.name}&file=${productInstance.mainImage}"),'class':("img-thumbnail")],-1)
printHtmlPart(1)
invokeTag('render','g',10,['template':("/product/content")],-1)
printHtmlPart(2)
if(true && (!productInstance.user)) {
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',20,['code':("search.createOrLinkProductOwner.label")],-1)
printHtmlPart(5)
})
invokeTag('link','g',21,['class':("btn btn-primary"),'controller':("search"),'action':("createOrLinkProductOwner"),'params':(['product.id':productInstance?.id])],2)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('render','g',25,['template':("/user/content"),'model':([userInstance: productInstance.user])],-1)
printHtmlPart(8)
}
printHtmlPart(9)
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
