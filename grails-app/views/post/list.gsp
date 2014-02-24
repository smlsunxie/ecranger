
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<g:set var="entityName" value="${message(code: 'post.label', default: '文章')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>


</head>
<body>

<div class="container">

    <div class="row">

        <div class="col-sm-12 col-md-12">
            <table class="table">
                <thead>
                    <tr>
                        <th width="40">#</th>
                        <th><g:message code="post.title.label" /></th>
                        <th width="100"><g:message code="post.dateCreated.label" /></th>
                        <th width="60"><g:message code="post.hits.label" /></th>
                    </tr>
                </thead>
                <tbody>
                		<!-- 如果沒有文章，顯示空白 -->
                    <g:if test="${!posts}">
                        <tr>
                            <td colspan="4"><div style="text-align:center"><g:message code="default.empty.description" /></div></td>
                        </tr>
                    </g:if>
                    <g:each in="${posts}" var="post" status="i">
                        <tr>
                            <td>${i+1}</td>
                            <td><g:link controller="post" action="show" id="${post?.id}">${post.title}</g:link></td>
                            <td><g:formatDate date="${post.lastUpdated}" type="date" style="SHOROT" /></td>
                            <td><span class="muted">${post.hits}</span></td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
