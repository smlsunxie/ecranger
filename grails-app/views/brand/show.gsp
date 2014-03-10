
<%@ page import="ecranger.Brand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'brand.label', default: 'Brand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-brand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list brand">
			
				<g:if test="${brandInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="brand.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${brandInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="brand.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${brandInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.homepage}">
				<li class="fieldcontain">
					<span id="homepage-label" class="property-label"><g:message code="brand.homepage.label" default="Homepage" /></span>
					
						<span class="property-value" aria-labelledby="homepage-label"><g:fieldValue bean="${brandInstance}" field="homepage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="brand.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${brandInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="brand.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${brandInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${brandInstance?.id}" />
					<g:link class="btn btn-primary" action="edit" id="${brandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
