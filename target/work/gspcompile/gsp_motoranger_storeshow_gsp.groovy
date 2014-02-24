import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_motoranger_storeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("default.home.label")],-1)
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(storeInstance.title)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (currentUserIsStoreOwnerOrAdmin)) {
printHtmlPart(7)
createTagBody(4, {->
invokeTag('message','g',27,['code':("store.edit.label")],-1)
})
invokeTag('link','g',27,['controller':("store"),'action':("edit"),'id':(storeInstance.id)],4)
printHtmlPart(8)
createTagBody(4, {->
invokeTag('message','g',29,['code':("part.create.label")],-1)
})
invokeTag('link','g',29,['controller':("part"),'action':("create"),'params':(['store.id': storeInstance.id])],4)
printHtmlPart(8)
createTagBody(4, {->
invokeTag('message','g',31,['code':("product.create.label")],-1)
})
invokeTag('link','g',31,['controller':("product"),'action':("create"),'params':(['store.id': storeInstance.id])],4)
printHtmlPart(9)
}
printHtmlPart(10)
})
invokeTag('ifAnyGranted','sec',36,['roles':("ROLE_OPERATOR, ROLE_MANERGER")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',46,['controller':("event"),'action':("unfinListOfStore"),'params':(['store.id': storeInstance.id])],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',47,['controller':("event"),'action':("endListOfStore"),'params':(['store.id': storeInstance.id])],2)
printHtmlPart(15)
if(true && (currentUserIsStoreOwnerOrAdmin)) {
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',59,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',59,['class':("btn btn-primary"),'action':("edit"),'id':(storeInstance?.id)],4)
printHtmlPart(18)
createTagBody(4, {->
invokeTag('message','g',62,['code':("default.button.delete.label")],-1)
})
invokeTag('link','g',62,['class':("btn btn-danger"),'action':("delete"),'id':(storeInstance?.id)],4)
printHtmlPart(19)
})
invokeTag('ifAnyGranted','sec',63,['roles':("ROLE_ADMIN")],3)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (currentUserIsStoreOwnerOrAdmin)) {
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',72,['class':("btn btn-primary"),'controller':("user"),'action':("create"),'params':(['store.id': storeInstance.id])],4)
printHtmlPart(17)
})
invokeTag('ifAnyGranted','sec',73,['roles':("ROLE_MANERGER")],3)
printHtmlPart(25)
createTagBody(3, {->
printHtmlPart(23)
createTagBody(4, {->
invokeTag('message','g',76,['code':("product.create.label")],-1)
})
invokeTag('link','g',76,['class':("btn btn-primary"),'controller':("product"),'action':("create"),'params':(['store.id': storeInstance.id])],4)
printHtmlPart(26)
createTagBody(4, {->
invokeTag('message','g',78,['code':("part.create.label")],-1)
})
invokeTag('link','g',78,['class':("btn btn-primary"),'controller':("part"),'action':("create"),'params':(['store.id': storeInstance.id])],4)
printHtmlPart(17)
})
invokeTag('ifAnyGranted','sec',79,['roles':("ROLE_MANERGER, ROLE_OPERATOR")],3)
printHtmlPart(27)
}
printHtmlPart(28)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',88,['class':("btn btn-danger"),'controller':("event"),'action':("unfinListOfStore"),'params':(['store.id': storeInstance.id])],2)
printHtmlPart(29)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',90,['class':("btn btn-success"),'controller':("event"),'action':("endListOfStore"),'params':(['store.id': storeInstance.id])],2)
printHtmlPart(30)
invokeTag('render','g',107,['template':("/event/stickWithImage"),'model':(['stickName':'alert']),'collection':(unfinEvents),'var':("eventInstance")],-1)
printHtmlPart(31)
invokeTag('render','g',123,['template':("/event/stickWithImage"),'model':(['stickName':'success']),'collection':(endEvents),'var':("eventInstance")],-1)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(33)
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
