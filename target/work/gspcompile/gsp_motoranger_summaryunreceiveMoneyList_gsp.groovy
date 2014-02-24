import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_summaryunreceiveMoneyList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/summary/unreceiveMoneyList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'post.label', default: '文章'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',20,['code':("event.name.label")],-1)
printHtmlPart(5)
invokeTag('message','g',21,['code':("default.dateCreated.label")],-1)
printHtmlPart(5)
invokeTag('message','g',22,['code':("product.name.label")],-1)
printHtmlPart(5)
invokeTag('message','g',23,['code':("user.title.label")],-1)
printHtmlPart(5)
invokeTag('message','g',24,['code':("user.telphone.label")],-1)
printHtmlPart(5)
invokeTag('message','g',25,['code':("user.mobile.label")],-1)
printHtmlPart(5)
invokeTag('message','g',26,['code':("summary.unreceiveMoney.label")],-1)
printHtmlPart(6)
loop:{
int i = 0
for( event in (events) ) {
printHtmlPart(7)
createTagBody(3, {->
expressionOut.print(event.id)
})
invokeTag('link','g',35,['action':("show"),'controller':("event"),'id':(event.id)],3)
printHtmlPart(8)
invokeTag('formatDate','g',36,['date':(event.date),'type':("date"),'style':("SHOROT")],-1)
printHtmlPart(8)
createTagBody(3, {->
expressionOut.print(event.product.name)
})
invokeTag('link','g',37,['action':("show"),'controller':("product"),'id':(event.product.id)],3)
printHtmlPart(8)
expressionOut.print(event.product?.user?.title)
printHtmlPart(8)
expressionOut.print(event.product?.user?.telphone)
printHtmlPart(8)
expressionOut.print(event.product?.user?.mobile)
printHtmlPart(9)
expressionOut.print(event.totalPrice-event.receivedMoney-event.discountMoney)
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540487000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
