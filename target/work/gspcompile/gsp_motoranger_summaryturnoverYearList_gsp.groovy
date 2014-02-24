import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_summaryturnoverYearList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/summary/turnoverYearList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'post.label', default: '文章'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
loop:{
int i = 0
for( result in (resultList) ) {
printHtmlPart(5)
createTagBody(3, {->
expressionOut.print(result.year)
})
invokeTag('link','g',34,['controller':("summary"),'action':("turnoverMonthList"),'params':([year:result.year])],3)
printHtmlPart(6)
expressionOut.print(result.totalMoney)
printHtmlPart(7)
expressionOut.print(result.totalCost)
printHtmlPart(8)
expressionOut.print(result.totalStoreCost)
printHtmlPart(7)
expressionOut.print(result.totalMoney-result.totalCost-result.totalStoreCost)
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(11)
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