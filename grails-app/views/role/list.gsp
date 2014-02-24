
<%@ page import="motoranger.Role" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>

		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		<div id="list-role" class="container" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <div class="row">
				<table  class="table">
					<thead>
						<tr>
						
							<g:sortableColumn property="authority" title="${message(code: 'role.authority.label', default: 'Authority')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${roleInstanceList}" status="i" var="roleInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${roleInstance.id}">${fieldValue(bean: roleInstance, field: "authority")}</g:link></td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${roleInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
