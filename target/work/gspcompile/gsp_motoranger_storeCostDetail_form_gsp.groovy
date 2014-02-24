import motoranger.StoreCostDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_storeCostDetail_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/storeCostDetail/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: storeCostDetailInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("storeCostDetail.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'value':(storeCostDetailInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: storeCostDetailInstance, field: 'cost', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("storeCostDetail.cost.label"),'default':("Cost")],-1)
printHtmlPart(5)
invokeTag('field','g',18,['name':("cost"),'type':("number"),'value':(storeCostDetailInstance.cost),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: storeCostDetailInstance, field: 'date', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("storeCostDetail.date.label"),'default':("Date")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',26,['name':("date"),'precision':("month"),'value':(storeCostDetailInstance?.date)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: storeCostDetailInstance, field: 'description', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("storeCostDetail.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',34,['name':("description"),'value':(storeCostDetailInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: storeCostDetailInstance, field: 'store', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("storeCostDetail.store.label"),'default':("Store")],-1)
printHtmlPart(5)
invokeTag('select','g',42,['id':("store"),'name':("store.id"),'from':(motoranger.Store.list()),'optionKey':("id"),'required':(""),'value':(storeCostDetailInstance?.store?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
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
