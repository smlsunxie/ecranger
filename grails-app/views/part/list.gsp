
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<g:set var="entityName" value="${message(code: 'part.label', default: '文章')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>


</head>
<body>

    <div class="row">

        <div class="col-sm-12 col-md-12">
            <table class="table">
                <thead>
                    <tr>
                        <th width="40">#</th>
                        <th><g:message code="part.title.label" /></th>
                        <th width="100"><g:message code="part.dateCreated.label" /></th>
                    </tr>
                </thead>
                <tbody>
                		<!-- 如果沒有文章，顯示空白 -->
                    <g:if test="${!parts}">
                        <tr>
                            <td colspan="4"><div style="text-align:center"><g:message code="default.empty.description" /></div></td>
                        </tr>
                    </g:if>
                    <g:each in="${parts}" var="part" status="i">
                        <tr>
                            <td>${i+1}</td>
                            <td><g:link controller="part" action="show" id="${part?.id}">${part.title}</g:link></td>
                            <td><g:formatDate date="${part.lastUpdated}" type="date" style="SHOROT" /></td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
