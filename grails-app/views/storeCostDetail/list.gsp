
<%@ page import="ecranger.StoreCostDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'storeCostDetail.label', default: 'StoreCostDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>

		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" params="[currentMonth:(new Date()).month+1]" action="copyPreviousMonthCostDetail">複製前一個月店家固定成本</g:link></li>
			</ul>
		</div>
		
		<div id="list-storeCostDetail" class="container" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <div class="row">
				<table  class="table">
					<thead>
						<tr>
						
							<g:sortableColumn property="title" title="${message(code: 'storeCostDetail.title.label', default: 'Title')}" />
						
							<g:sortableColumn property="cost" title="${message(code: 'storeCostDetail.cost.label', default: 'Cost')}" />
						
							<g:sortableColumn property="date" title="${message(code: 'storeCostDetail.date.label', default: 'Date')}" />
						
							<g:sortableColumn property="description" title="${message(code: 'storeCostDetail.description.label', default: 'Description')}" />
						
							<th><g:message code="storeCostDetail.store.label" default="Store" /></th>
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${storeCostDetailInstanceList}" status="i" var="storeCostDetailInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${storeCostDetailInstance.id}">${fieldValue(bean: storeCostDetailInstance, field: "title")}</g:link></td>
						
							<td>${fieldValue(bean: storeCostDetailInstance, field: "cost")}</td>
						
							<td><g:formatDate date="${storeCostDetailInstance.date}" /></td>
						
							<td>${fieldValue(bean: storeCostDetailInstance, field: "description")}</td>
						
							<td>${fieldValue(bean: storeCostDetailInstance, field: "store")}</td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${storeCostDetailInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
