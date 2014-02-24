import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_searchresult_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/result.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("bootstrap")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(params.q)
printHtmlPart(5)
})
invokeTag('link','g',13,['class':("btn btn-primary"),'controller':("product"),'action':("create"),'params':([name: params.q])],2)
printHtmlPart(6)
loop:{
int i = 0
for( productInstance in (searchResult?.results) ) {
printHtmlPart(7)
invokeTag('render','g',26,['template':("/product/content"),'model':([productInstance: productInstance])],-1)
printHtmlPart(8)
i++
}
}
printHtmlPart(9)
if(true && (searchResult?.results)) {
printHtmlPart(10)
expressionOut.print(searchResult?.results)
printHtmlPart(11)
invokeTag('paginate','g',41,['action':("query"),'params':([q: params.q]),'total':(searchResult.total),'prev':("&lt; previous"),'next':("next &gt;")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(15)
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
