import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_post_mainImg_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/_mainImg.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (post.mainImage)) {
printHtmlPart(0)
invokeTag('img','g',2,['uri':("/attachment/show?name=${post.name}&file=${post.mainImage}"),'class':("img-responsive")],-1)
printHtmlPart(1)
}
else if(true && (post?.product?.mainImage)) {
printHtmlPart(0)
invokeTag('img','g',5,['uri':("/attachment/show?name=${post.product.name}&file=${post.product.mainImage}"),'class':("img-responsive")],-1)
printHtmlPart(1)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1390804579000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
