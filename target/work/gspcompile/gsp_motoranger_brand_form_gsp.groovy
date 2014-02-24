import motoranger.Brand
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_brand_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/brand/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: brandInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("brand.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'value':(brandInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: brandInstance, field: 'description', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("brand.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("description"),'value':(brandInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: brandInstance, field: 'homepage', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("brand.homepage.label"),'default':("Homepage")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("homepage"),'value':(brandInstance?.homepage)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: brandInstance, field: 'title', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("brand.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',34,['name':("title"),'value':(brandInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: brandInstance, field: 'type', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("brand.type.label"),'default':("Type")],-1)
printHtmlPart(8)
invokeTag('select','g',42,['name':("type"),'from':(motoranger.BrandType?.values()),'keys':(motoranger.BrandType.values()*.name()),'required':(""),'value':(brandInstance?.type?.name())],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389430506000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
