
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
    <table class="table">
      <thead>
        <tr>
        <th><g:message code="event.name.label" /></th>
        <th><g:message code="default.dateCreated.label" /></th>
        <th><g:message code="product.name.label" /></th>
        <th><g:message code="user.title.label" /></th>
        <th><g:message code="user.telphone.label" /></th>
        <th><g:message code="user.mobile.label" /></th>
        <th><g:message code="summary.unreceiveMoney.label" /></th>


        </tr>
      </thead>
      <tbody>
        <g:each in="${events}" var="event" status="i">

          <tr>
            <td><g:link action="show" controller="event" id='${event.id}'>${event.id}</g:link></td>
            <td><g:formatDate date="${event.date}" type="date" style="SHOROT" /></td>
            <td><g:link action="show" controller="product" id='${event.product.id}'>${event.product.name}</g:link></td>
            <td>${event.product?.user?.title}</td>
            <td>${event.product?.user?.telphone}</td>
            <td>${event.product?.user?.mobile}</td>

            <td>${event.totalPrice-event.receivedMoney-event.discountMoney}</td> 
            </tr>

        </g:each>

      </tbody>
    </table>                    
  </div>



</div>
</body>
</html>
