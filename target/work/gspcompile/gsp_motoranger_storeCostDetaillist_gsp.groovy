import motoranger.StoreCostDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_storeCostDetaillist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/storeCostDetail/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'storeCostDetail.label', default: 'StoreCostDetail'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',15,['class':("create"),'params':([currentMonth:(new Date()).month+1]),'action':("copyPreviousMonthCostDetail")],2)
printHtmlPart(7)
invokeTag('message','g',20,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',26,['property':("title"),'title':(message(code: 'storeCostDetail.title.label', default: 'Title'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',28,['property':("cost"),'title':(message(code: 'storeCostDetail.cost.label', default: 'Cost'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',30,['property':("date"),'title':(message(code: 'storeCostDetail.date.label', default: 'Date'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',32,['property':("description"),'title':(message(code: 'storeCostDetail.description.label', default: 'Description'))],-1)
printHtmlPart(10)
invokeTag('message','g',34,['code':("storeCostDetail.store.label"),'default':("Store")],-1)
printHtmlPart(11)
loop:{
int i = 0
for( storeCostDetailInstance in (storeCostDetailInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: storeCostDetailInstance, field: "title"))
})
invokeTag('link','g',42,['action':("show"),'id':(storeCostDetailInstance.id)],3)
printHtmlPart(14)
expressionOut.print(fieldValue(bean: storeCostDetailInstance, field: "cost"))
printHtmlPart(14)
invokeTag('formatDate','g',46,['date':(storeCostDetailInstance.date)],-1)
printHtmlPart(14)
expressionOut.print(fieldValue(bean: storeCostDetailInstance, field: "description"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: storeCostDetailInstance, field: "store"))
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',57,['total':(storeCostDetailInstanceTotal)],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1386657611000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
