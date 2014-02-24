
<%@ page import="motoranger.StoreCostDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'storeCostDetail.label', default: 'StoreCostDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-storeCostDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list storeCostDetail">
			
				<g:if test="${storeCostDetailInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="storeCostDetail.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${storeCostDetailInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${storeCostDetailInstance?.cost}">
				<li class="fieldcontain">
					<span id="cost-label" class="property-label"><g:message code="storeCostDetail.cost.label" default="Cost" /></span>
					
						<span class="property-value" aria-labelledby="cost-label"><g:fieldValue bean="${storeCostDetailInstance}" field="cost"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${storeCostDetailInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="storeCostDetail.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${storeCostDetailInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${storeCostDetailInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="storeCostDetail.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${storeCostDetailInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${storeCostDetailInstance?.store}">
				<li class="fieldcontain">
					<span id="store-label" class="property-label"><g:message code="storeCostDetail.store.label" default="Store" /></span>
					
						<span class="property-value" aria-labelledby="store-label"><g:link controller="store" action="show" id="${storeCostDetailInstance?.store?.id}">${storeCostDetailInstance?.store?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${storeCostDetailInstance?.id}" />
					<g:link class="btn btn-primary" action="edit" id="${storeCostDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
