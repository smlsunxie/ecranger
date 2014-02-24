import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_part_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/part/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
createTagBody(2, {->
printHtmlPart(1)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(2)
expressionOut.print(error.field)
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('message','g',4,['error':(error)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',5,['bean':(partInstance),'var':("error")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',7,['bean':(partInstance)],1)
printHtmlPart(7)
invokeTag('hiddenField','g',9,['name':("event.id"),'value':(params['event.id'])],-1)
printHtmlPart(8)
invokeTag('message','g',15,['code':("part.name.label")],-1)
printHtmlPart(9)
invokeTag('textField','g',18,['name':("name"),'readonly value':(partInstance?.name),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',26,['code':("part.title.label")],-1)
printHtmlPart(11)
invokeTag('textField','g',29,['name':("title"),'value':(partInstance?.title),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('message','g',37,['code':("default.tags.label")],-1)
printHtmlPart(12)
for( _it800085428 in (partInstance.tags) ) {
changeItVariable(_it800085428)
printHtmlPart(13)
expressionOut.print(it)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',52,['code':("default.description.label")],-1)
printHtmlPart(11)
invokeTag('textField','g',55,['name':("description"),'value':(partInstance?.description),'class':("form-control")],-1)
printHtmlPart(16)
invokeTag('message','g',64,['code':("part.price.label")],-1)
printHtmlPart(11)
invokeTag('textField','g',67,['type':("number"),'name':("price"),'value':(partInstance?.price),'class':("form-control")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( it in (historyPrice) ) {
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
expressionOut.print(it)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
invokeTag('message','g',96,['code':("part.cost.label")],-1)
printHtmlPart(23)
invokeTag('textField','g',99,['type':("number"),'name':("cost"),'value':(partInstance?.cost),'class':("form-control")],-1)
printHtmlPart(24)
for( it in (historyCost) ) {
printHtmlPart(25)
expressionOut.print(it)
printHtmlPart(19)
expressionOut.print(it)
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('ifAnyGranted','sec',121,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],1)
printHtmlPart(28)
invokeTag('message','g',127,['code':("part.stockCount.label")],-1)
printHtmlPart(11)
invokeTag('textField','g',130,['type':("number"),'name':("stockCount"),'value':(partInstance?.stockCount),'class':("form-control")],-1)
printHtmlPart(29)
invokeTag('message','g',138,['code':("user.label"),'default':("user")],-1)
printHtmlPart(30)
invokeTag('select','g',142,['id':("user"),'name':("user.id"),'from':(motoranger.User.findById(partInstance?.user?.id)),'optionKey':("id"),'value':(partInstance?.user?.id),'noSelection':(['null': '']),'class':("form-control")],-1)
printHtmlPart(31)
invokeTag('message','g',149,['code':("user.store.label"),'default':("Store")],-1)
printHtmlPart(32)
invokeTag('select','g',153,['id':("user"),'name':("store.id"),'from':(motoranger.Store.findById(partInstance?.store?.id)),'optionKey':("id"),'value':(partInstance?.store?.id),'noSelection':(['null': '']),'class':("form-control")],-1)
printHtmlPart(33)
invokeTag('message','g',164,['code':("default.imageUpload.label")],-1)
printHtmlPart(34)
invokeTag('render','g',167,['template':("/attachment/uploadBtn"),'model':([name: partInstance.name ,mainImage: partInstance?.mainImage])],-1)
printHtmlPart(35)
createTagBody(1, {->
printHtmlPart(36)
expressionOut.print(g.createLink(controller:'tag',action: 'listAsJson'))
printHtmlPart(37)
})
invokeTag('script','r',1,[:],1)
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
