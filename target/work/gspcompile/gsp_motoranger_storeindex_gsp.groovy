import motoranger.Store
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_storeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'store.label', default: 'Store'))],-1)
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
createClosureForHtmlPart(5, 2)
invokeTag('link','g',17,['class':("btn btn-primary"),'controller':("store"),'action':("create")],2)
printHtmlPart(6)
invokeTag('sortableColumn','g',31,['property':("title"),'title':(message(code: 'store.title.label', default: 'Title'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',33,['property':("address"),'title':(message(code: 'store.address.label', default: 'Address'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',35,['property':("mobile"),'title':(message(code: 'store.mobile.label', default: 'Mobile'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',37,['property':("telphone"),'title':(message(code: 'store.telphone.label', default: 'Telphone'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',39,['property':("description"),'title':(message(code: 'store.description.label', default: 'description'))],-1)
printHtmlPart(10)
loop:{
int i = 0
for( storeInstance in (storeInstanceList) ) {
printHtmlPart(11)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(12)
expressionOut.print(message(code: 'store.title.label', default: 'title'))
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: storeInstance, field: "title"))
})
invokeTag('link','g',47,['action':("show"),'id':(storeInstance.id)],3)
printHtmlPart(14)
expressionOut.print(message(code: 'store.address.label', default: 'address'))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: storeInstance, field: "address"))
printHtmlPart(15)
expressionOut.print(message(code: 'store.mobile.label', default: 'mobile'))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: storeInstance, field: "mobile"))
printHtmlPart(16)
expressionOut.print(message(code: 'store.telphone.label', default: 'telphone'))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: storeInstance, field: "telphone"))
printHtmlPart(17)
expressionOut.print(message(code: 'store.description.label', default: 'description'))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: storeInstance, field: "description"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',62,['total':(storeInstanceCount)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(21)
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
