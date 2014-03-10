
<%@ page import="ecranger.User" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="bootstrap">
  <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
  <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>

  <div class="row" id="actionbar">

    <div class="col-sm-12 col-md-12">           


        <g:link  class="btn btn-primary" controller="user" action="create" >新增使用者</g:link>


    </div>

  </div>

  
  <div class="contact-info" >
    <h2><g:message code="default.list.label" args="[entityName]" /></h2>


    <div class="row">
      <div class="col-sm-12 col-md-12">   
      <table  class="table" id="no-more-tables">
        <thead>
          <tr>
          
            <g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}" />

            <g:sortableColumn property="store" title="${message(code: 'user.store.label', default: 'Store')}" />            
          
            <g:sortableColumn property="address" title="${message(code: 'user.address.label', default: 'Address')}" />

            <g:sortableColumn property="telphone" title="${message(code: 'user.telphone.label', default: 'telphone')}" />
            
            <g:sortableColumn property="mobile" title="${message(code: 'user.mobile.label', default: 'mobile')}" />             
            
            <g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'email')}" />

            <th>切換使用者</th>
          </tr>
        </thead>
        <tbody>
        <g:each in="${userInstanceList}" status="i" var="userInstance">
          <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
          
            <td data-title="${message(code: 'user.username.label', default: 'Username')}"><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link>&nbsp</td>
            
            <td data-title="${message(code: 'user.store.label', default: 'Username')}"><g:link action="show" url="/store/show/${userInstance?.store?.id}">${fieldValue(bean: userInstance, field: "store")}</g:link>&nbsp</td>
          
            <td data-title="${message(code: 'user.address.label', default: 'Username')}">${fieldValue(bean: userInstance, field: "address")}&nbsp</td>

            <td data-title="${message(code: 'user.telphone.label', default: 'Username')}">${fieldValue(bean: userInstance, field: "telphone")}&nbsp</td>

            <td data-title="${message(code: 'user.mobile.label', default: 'Username')}">${fieldValue(bean: userInstance, field: "mobile")}&nbsp</td>

            <td data-title="${message(code: 'user.email.label', default: 'Username')}">${fieldValue(bean: userInstance, field: "email")}&nbsp</td>



              <sec:ifAnyGranted roles="ROLE_ADMIN">
                <td data-title="">
                  <g:if test="${userInstance.enabled}">
                    <g:link controller="login" action="switchUser" params="[username: userInstance.username]" >
                            切換使用者
                    </g:link>
                  </g:if>&nbsp
                </td>
              </sec:ifAnyGranted>

            

          
          </tr>
        </g:each>
        </tbody>
      </table>
      </div>
    </div>

    <div class="row text-center">
      <ul class="pagination">
        <g:paginate total="${userInstanceCount}" />
      <ul>   
    </div>

  </div>

</body>
</html>
