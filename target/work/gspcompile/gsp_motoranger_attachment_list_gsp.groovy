import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_attachment_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/attachment/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("attachment.mainImage.label")],-1)
printHtmlPart(1)
invokeTag('message','g',5,['code':("attachment.file.name")],-1)
printHtmlPart(2)
if(true && (params.domainName == 'post')) {
printHtmlPart(3)
invokeTag('message','g',7,['code':("attachment.file.link")],-1)
printHtmlPart(2)
}
printHtmlPart(4)
loop:{
int i = 0
for( file in (files) ) {
printHtmlPart(5)
expressionOut.print(message(code: 'attachment.mainImage.label', default: 'mainImage'))
printHtmlPart(6)
invokeTag('radio','g',19,['name':("mainImage"),'value':(file.name),'checked':(mainImage==file.name  ?'true':'')],-1)
printHtmlPart(7)
expressionOut.print(message(code: 'ttachment.file.name"', default: 'name'))
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(file.name)
})
invokeTag('link','g',23,['action':("show"),'params':([file: file.name, name:name]),'target':("_blank")],2)
printHtmlPart(8)
if(true && (params.domainName == 'post')) {
printHtmlPart(9)
expressionOut.print(message(code: 'attachment.file.link"', default: 'link'))
printHtmlPart(10)
if(true && (['.jpg','.jpeg','.JPG','.JPEG','.gif','.GIF','.png','.PNG'].any{file.name.endsWith(it)})) {
printHtmlPart(11)
expressionOut.print(file.name)
printHtmlPart(12)
expressionOut.print(createLink(action:'show', params: [file: file.name, name:name]))
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(message(code: 'default.button.delete.label', default: '刪除'))
})
invokeTag('remoteLink','g',35,['onSuccess':("displayList()"),'action':("delete"),'params':([name:name, file:file.path]),'update':("success"),'class':("btn btn-danger btn-xs")],2)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1391753623000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
