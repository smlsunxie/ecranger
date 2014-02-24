import org.springframework.util.ClassUtils
import grails.plugin.searchable.internal.lucene.LuceneUtils
import grails.plugin.searchable.internal.util.StringQueryUtils
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='searchable', version='0.6.6')
class gsp_searchable_searchableindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/searchable-0.6.6/grails-app/views/searchable/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("content-type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
if(true && (params.q && params.q?.trim() != '')) {
expressionOut.print(params.q)
printHtmlPart(3)
}
printHtmlPart(4)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',91,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('textField','g',96,['name':("q"),'value':(params.q),'size':("50")],-1)
printHtmlPart(9)
})
invokeTag('form','g',97,['url':([controller: "searchable", action: "index"]),'id':("searchableForm"),'name':("searchableForm"),'method':("get")],2)
printHtmlPart(10)
invokeTag('set','g',101,['var':("haveQuery"),'value':(params.q?.trim())],-1)
printHtmlPart(2)
invokeTag('set','g',102,['var':("haveResults"),'value':(searchResult?.results)],-1)
printHtmlPart(11)
if(true && (haveQuery && haveResults)) {
printHtmlPart(12)
expressionOut.print(searchResult.offset + 1)
printHtmlPart(13)
expressionOut.print(searchResult.results.size() + searchResult.offset)
printHtmlPart(14)
expressionOut.print(searchResult.total)
printHtmlPart(15)
expressionOut.print(params.q)
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (haveQuery && !haveResults && !parseException)) {
printHtmlPart(19)
expressionOut.print(params.q)
printHtmlPart(20)
if(true && (!searchResult?.suggestedQuery)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',120,['controller':("searchable"),'action':("index"),'params':([q: params.q, suggestQuery: true])],4)
printHtmlPart(23)
}
printHtmlPart(2)
}
printHtmlPart(24)
if(true && (searchResult?.suggestedQuery)) {
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(StringQueryUtils.highlightTermDiffs(params.q.trim(), searchResult.suggestedQuery))
})
invokeTag('link','g',130,['controller':("searchable"),'action':("index"),'params':([q: searchResult.suggestedQuery])],3)
printHtmlPart(26)
}
printHtmlPart(24)
if(true && (parseException)) {
printHtmlPart(27)
expressionOut.print(params.q)
printHtmlPart(28)
if(true && (LuceneUtils.queryHasSpecialCharacters(params.q))) {
printHtmlPart(29)
expressionOut.print(LuceneUtils.cleanQuery(params.q))
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',140,['controller':("searchable"),'action':("index"),'params':([q: LuceneUtils.cleanQuery(params.q)])],4)
printHtmlPart(32)
expressionOut.print(LuceneUtils.escapeQuery(params.q))
printHtmlPart(33)
createClosureForHtmlPart(34, 4)
invokeTag('link','g',143,['controller':("searchable"),'action':("index"),'params':([q: LuceneUtils.escapeQuery(params.q)])],4)
printHtmlPart(35)
createClosureForHtmlPart(36, 4)
invokeTag('link','g',144,['controller':("searchable"),'action':("index"),'params':([q: params.q, escape: true])],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(24)
if(true && (haveResults)) {
printHtmlPart(39)
loop:{
int index = 0
for( result in (searchResult.results) ) {
printHtmlPart(40)
invokeTag('set','g',154,['var':("className"),'value':(ClassUtils.getShortName(result.getClass()))],-1)
printHtmlPart(41)
invokeTag('set','g',155,['var':("link"),'value':(createLink(controller: className[0].toLowerCase() + className[1..-1], action: 'show', id: result.id))],-1)
printHtmlPart(42)
expressionOut.print(link)
printHtmlPart(43)
expressionOut.print(className)
printHtmlPart(44)
expressionOut.print(result.id)
printHtmlPart(45)
invokeTag('set','g',157,['var':("desc"),'value':(result.toString())],-1)
printHtmlPart(41)
if(true && (desc.size() > 120)) {
invokeTag('set','g',158,['var':("desc"),'value':(desc[0..120] + '...')],-1)
}
printHtmlPart(46)
expressionOut.print(desc.encodeAsHTML())
printHtmlPart(47)
expressionOut.print(link)
printHtmlPart(48)
index++
}
}
printHtmlPart(49)
if(true && (haveResults)) {
printHtmlPart(50)
invokeTag('set','g',169,['var':("totalPages"),'value':(Math.ceil(searchResult.total / searchResult.max))],-1)
printHtmlPart(51)
if(true && (totalPages == 1)) {
printHtmlPart(52)
}
else {
invokeTag('paginate','g',171,['controller':("searchable"),'action':("index"),'params':([q: params.q]),'total':(searchResult.total),'prev':("&lt; previous"),'next':("next &gt;")],-1)
}
printHtmlPart(53)
}
printHtmlPart(54)
}
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',177,['onload':("focusQueryInput();")],1)
printHtmlPart(56)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1379464480000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
