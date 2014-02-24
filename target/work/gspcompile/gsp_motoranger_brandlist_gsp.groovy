import motoranger.Brand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_brandlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/brand/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'brand.label', default: 'Brand'))],-1)
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
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(6)
invokeTag('sortableColumn','g',25,['property':("name"),'title':(message(code: 'brand.name.label', default: 'Name'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',27,['property':("description"),'title':(message(code: 'brand.description.label', default: 'Description'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',29,['property':("homepage"),'title':(message(code: 'brand.homepage.label', default: 'Homepage'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',31,['property':("title"),'title':(message(code: 'brand.title.label', default: 'Title'))],-1)
printHtmlPart(7)
invokeTag('sortableColumn','g',33,['property':("type"),'title':(message(code: 'brand.type.label', default: 'Type'))],-1)
printHtmlPart(8)
loop:{
int i = 0
for( brandInstance in (brandInstanceList) ) {
printHtmlPart(9)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(10)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: brandInstance, field: "name"))
})
invokeTag('link','g',41,['action':("show"),'id':(brandInstance.id)],3)
printHtmlPart(11)
expressionOut.print(fieldValue(bean: brandInstance, field: "description"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: brandInstance, field: "homepage"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: brandInstance, field: "title"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: brandInstance, field: "type"))
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
invokeTag('paginate','g',56,['total':(brandInstanceTotal)],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',60,[:],1)
printHtmlPart(15)
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
