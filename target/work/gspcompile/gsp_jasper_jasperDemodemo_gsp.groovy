import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='jasper', version='1.7.0')
class gsp_jasper_jasperDemodemo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/jasper-1.7.0/grails-app/views/jasperDemo/demo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('jasperReport','g',81,['jasper':("sample-jasper-plugin"),'format':("PDF,HTML,XML,CSV,XLS,RTF,TEXT,ODT,ODS,DOCX,XLSX,PPTX"),'name':("Parameter Example"),'buttonPosition':("bottom"),'bodyBefore':(" "),'delimiter':(" ")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('jasperReport','g',101,['jasper':("sample-jasper-plugin"),'format':("PDF,HTML,XML,CSV,XLS,RTF,TEXT,ODT,ODS,DOCX,XLSX,PPTX"),'name':("Parameter Example")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('jasperReport','g',134,['jasper':("sample-jasper-plugin"),'format':("pdf, html, xls, rtf, text,odt,ods,docx,xlsx,pptx"),'name':("Report Name for Jasper Only]"),'inline':("true"),'buttonPosition':("bottom"),'description':(" "),'delimiter':("*"),'delimiterBefore':("((("),'delimiterAfter':(")))")],2)
printHtmlPart(10)
for( person in (people) ) {
printHtmlPart(11)
expressionOut.print(person.name)
printHtmlPart(12)
expressionOut.print(person.email)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('jasperReport','g',174,['jasper':("sample-list-domain-classes"),'controller':("jasperDemo"),'action':("exampleWithData"),'format':("pdf, html, xml, csv, xls, rtf, text,odt,ods,docx,xlsx,pptx"),'name':("GORM Example"),'description':(" "),'delimiter':(" ")],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
for( person in (people) ) {
printHtmlPart(17)
expressionOut.print(person.name)
printHtmlPart(12)
expressionOut.print(person.email)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('jasperButton','g',200,['format':("pdf"),'text':("PDF")],-1)
printHtmlPart(20)
})
invokeTag('jasperForm','g',203,['controller':("jasperDemo"),'action':("exampleWithData"),'id':("1498"),'name':("GORM Example2"),'jasper':("w_iReport")],2)
printHtmlPart(21)
createClosureForHtmlPart(22, 2)
invokeTag('jasperReport','g',232,['controller':("jasperDemo"),'jasper':("sample-list-domain-classes-2"),'action':("exampleWithData"),'format':("pdf, html, xml, csv, xls, rtf, text,odt,ods,docx,xlsx,pptx"),'name':("GORM Example"),'description':(" "),'delimiter':(" ")],2)
printHtmlPart(23)
invokeTag('jasperReport','g',244,['controller':("jasperDemo"),'jasper':("sample-list-domain-classes-3-chart"),'action':("exampleWithDataChart"),'format':("pdf, html, xml, csv, xls, rtf, text,odt,ods,docx,xlsx,pptx"),'name':("GORM chart Example"),'description':(" "),'delimiter':(" ")],-1)
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('jasperReport','g',272,['jasper':("sample-jasper-plugin"),'format':("html"),'inline':("true"),'buttonPosition':("bottom")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',478,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390292102000L
public static final String EXPRESSION_CODEC = 'none'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
