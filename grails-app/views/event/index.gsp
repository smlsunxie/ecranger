
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<g:set var="entityName" value="${message(code: 'part.label', default: '文章')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>


</head>
<body>

  <div class="contact-info" >
    <h2>${title}</h2>
    <g:render template="/event/contentWithDetails" collection="${eventInstanceList}" var="eventInstance" />
  </div>

	<div class="row text-center">
	  <ul class="pagination">
	    <g:paginate total="${eventInstanceCount}" />
	  <ul>   
	</div>

</body>
</html>
