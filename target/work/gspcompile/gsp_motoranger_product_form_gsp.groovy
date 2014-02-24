import motoranger.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_product_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(3)
expressionOut.print(error.field)
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('message','g',7,['error':(error)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',8,['bean':(productInstance),'var':("error")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',10,['bean':(productInstance)],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: productInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',15,['code':("product.name.label")],-1)
printHtmlPart(10)
invokeTag('remoteField','g',20,['action':("checkNameExist"),'update':("alert_placeholder"),'name':("name"),'value':(productInstance?.name),'class':("form-control"),'placeholder':("請輸入你的車牌號嗎(不需要 '-' 符號)"),'maxlength':("10"),'pattern':(productInstance.constraints.name.matches)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: productInstance, field: 'title', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',21,['code':("product.title.label")],-1)
printHtmlPart(13)
invokeTag('textField','g',29,['name':("title"),'value':(productInstance?.title),'class':("form-control"),'placeholder':("請隨意輸入")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: productInstance, field: 'description', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',39,['code':("default.description.label")],-1)
printHtmlPart(16)
invokeTag('textField','g',41,['name':("description"),'value':(productInstance?.description),'class':("form-control")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: productInstance, field: 'mileage', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',48,['code':("product.mileage.label")],-1)
printHtmlPart(16)
invokeTag('textField','g',53,['name':("mileage"),'type':("number"),'value':(productInstance?.mileage),'class':("form-control")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: productInstance, field: 'brand', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',60,['code':("product.brand.label")],-1)
printHtmlPart(16)
invokeTag('select','g',68,['class':("form-control"),'name':("brand.id"),'from':(motoranger.Brand.list()),'noSelection':(['null':'請選擇...']),'optionKey':("id"),'value':(productInstance?.brand?.id)],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: productInstance, field: 'user', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',73,['code':("product.user.label")],-1)
printHtmlPart(16)
invokeTag('select','g',83,['id':("user"),'name':("user.id"),'from':(motoranger.User.findById(productInstance?.user?.id)),'optionKey':("id"),'value':(productInstance?.user?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: productInstance, field: 'years', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',84,['code':("product.years.label")],-1)
printHtmlPart(16)
invokeTag('datePicker','g',92,['name':("years"),'value':(productInstance.years),'noSelection':(['':'-Choose-']),'precision':("month"),'years':(1980..(new Date().getAt(Calendar.YEAR)))],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: productInstance, field: 'cc', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',95,['code':("product.cc.label")],-1)
printHtmlPart(25)
invokeTag('field','g',103,['class':("form-control"),'type':("number"),'name':("cc"),'value':(productInstance?.cc)],-1)
printHtmlPart(26)
createTagBody(1, {->
printHtmlPart(27)
expressionOut.print(hasErrors(bean: productInstance, field: 'cost', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',114,['code':("product.cost.label")],-1)
printHtmlPart(29)
invokeTag('field','g',118,['class':("form-control"),'type':("number"),'name':("cost"),'value':(productInstance?.cost)],-1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: productInstance, field: 'price', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',125,['code':("product.price.label")],-1)
printHtmlPart(29)
invokeTag('field','g',130,['class':("form-control"),'type':("number"),'name':("price"),'value':(productInstance?.price)],-1)
printHtmlPart(32)
})
invokeTag('ifAnyGranted','sec',131,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],1)
printHtmlPart(33)
invokeTag('message','g',134,['code':("default.imageUpload.label")],-1)
printHtmlPart(16)
invokeTag('render','g',146,['template':("/attachment/uploadBtn"),'model':([name:productInstance.name,mainImage: productInstance?.mainImage])],-1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1392369290000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
