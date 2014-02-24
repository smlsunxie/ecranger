import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_product_content_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/_content.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("product.name.label")],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(productInstance.name)
printHtmlPart(3)
})
invokeTag('link','g',8,['elementId':("product-show-${productInstance.name}"),'action':("show"),'controller':("product"),'id':(productInstance.id)],1)
printHtmlPart(4)
invokeTag('message','g',13,['code':("product.title.label")],-1)
printHtmlPart(5)
expressionOut.print(productInstance.title)
printHtmlPart(6)
invokeTag('message','g',18,['code':("user.title.label")],-1)
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(productInstance?.user?.title)
})
invokeTag('link','g',19,['action':("show"),'controller':("user"),'id':(productInstance?.user?.id)],1)
printHtmlPart(7)
expressionOut.print(productInstance?.user?.enabled ? "(已啟用)" : "")
printHtmlPart(8)
invokeTag('message','g',22,['code':("product.brand.label")],-1)
printHtmlPart(5)
expressionOut.print(productInstance.brand)
printHtmlPart(9)
invokeTag('message','g',27,['code':("product.cc.label")],-1)
printHtmlPart(5)
expressionOut.print(productInstance.cc)
printHtmlPart(10)
invokeTag('message','g',31,['code':("product.mileage.label")],-1)
printHtmlPart(5)
expressionOut.print(productInstance.mileage)
printHtmlPart(8)
invokeTag('message','g',35,['code':("product.years.label")],-1)
printHtmlPart(5)
invokeTag('formatDate','g',36,['format':("yyyy"),'date':(productInstance.years)],-1)
printHtmlPart(6)
invokeTag('message','g',40,['code':("product.totalUnreceiveMoney.label")],-1)
printHtmlPart(5)
expressionOut.print(productInstance?.events ? productInstance?.events?.totalPrice?.sum()-productInstance?.events?.receivedMoney?.sum():"0")
printHtmlPart(11)
invokeTag('message','g',46,['code':("default.description.label")],-1)
printHtmlPart(5)
expressionOut.print(productInstance.description)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390992630000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
