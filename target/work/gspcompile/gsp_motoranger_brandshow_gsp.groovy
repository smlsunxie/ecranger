import motoranger.Brand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_brandshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/brand/show.gsp" }
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
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("list")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (brandInstance?.name)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("brand.name.label"),'default':("Name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(brandInstance),'field':("name")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (brandInstance?.description)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("brand.description.label"),'default':("Description")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',37,['bean':(brandInstance),'field':("description")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (brandInstance?.homepage)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("brand.homepage.label"),'default':("Homepage")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',46,['bean':(brandInstance),'field':("homepage")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (brandInstance?.title)) {
printHtmlPart(19)
invokeTag('message','g',53,['code':("brand.title.label"),'default':("Title")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',55,['bean':(brandInstance),'field':("title")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (brandInstance?.type)) {
printHtmlPart(21)
invokeTag('message','g',62,['code':("brand.type.label"),'default':("Type")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',64,['bean':(brandInstance),'field':("type")],-1)
printHtmlPart(13)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',72,['name':("id"),'value':(brandInstance?.id)],-1)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',73,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',73,['class':("btn btn-primary"),'action':("edit"),'id':(brandInstance?.id)],3)
printHtmlPart(25)
invokeTag('actionSubmit','g',74,['class':("btn btn-danger"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(26)
})
invokeTag('form','g',76,[:],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(28)
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
