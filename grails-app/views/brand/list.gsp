
<%@ page import="motoranger.Brand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'brand.label', default: 'Brand')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>

		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		<div id="list-brand" class="container" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <div class="row">
				<table  class="table">
					<thead>
						<tr>
						
							<g:sortableColumn property="name" title="${message(code: 'brand.name.label', default: 'Name')}" />
						
							<g:sortableColumn property="description" title="${message(code: 'brand.description.label', default: 'Description')}" />
						
							<g:sortableColumn property="homepage" title="${message(code: 'brand.homepage.label', default: 'Homepage')}" />
						
							<g:sortableColumn property="title" title="${message(code: 'brand.title.label', default: 'Title')}" />
						
							<g:sortableColumn property="type" title="${message(code: 'brand.type.label', default: 'Type')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${brandInstanceList}" status="i" var="brandInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${brandInstance.id}">${fieldValue(bean: brandInstance, field: "name")}</g:link></td>
						
							<td>${fieldValue(bean: brandInstance, field: "description")}</td>
						
							<td>${fieldValue(bean: brandInstance, field: "homepage")}</td>
						
							<td>${fieldValue(bean: brandInstance, field: "title")}</td>
						
							<td>${fieldValue(bean: brandInstance, field: "type")}</td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${brandInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
