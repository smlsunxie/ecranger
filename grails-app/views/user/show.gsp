<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">
<title>${product?.title}</title>
</head>
<body>
  <!-- 手機畫面 action button -->

  <div class="visible-xs">
    <div class="btn-group" id="actionbar">
      <button class="btn btn-default btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
        維護使用者<span class="caret"></span>
      </button>
      <ul class="dropdown-menu">
        <li><g:link  action="edit" id="${userInstance.id}"><g:message code="default.button.edit.label" /></g:link></li>
        <li><g:link  action="delete" id="${userInstance.id}"><g:message code="default.button.delete.label" /></g:link></li>
      </ul>
    </div>

    <div class="btn-group" id="actionbar">
      <button class="btn btn-default btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
        新增其他<span class="caret"></span>
      </button>
      <ul class="dropdown-menu">
        <sec:ifAnyGranted roles="ROLE_ADMIN">  
          <li><g:link controller="store" action="create" params="['user.id': userInstance.id]">新增店家</g:link></li>
        </sec:ifAnyGranted>

        <sec:ifAnyGranted roles="ROLE_CUSTOMER">  
          <li><g:link elementId="product-create" controller="product" action="create" params="['user.id': userInstance.id]">新增產品</g:link></li>
         
          <li><g:link elementId="part-create" controller="part" action="create" params="['user.id': userInstance.id]">新維修項目</g:link></li>
        </sec:ifAnyGranted>

      </ul>
    </div>
  </div>


  <!-- PC 畫面 action button -->

  <div class="hidden-xs">
    <div class="btn-group" id="actionbar">
           

      <g:link elementId="user-edit" class="btn btn-primary"  action="edit" id="${userInstance.id}"><g:message code="default.button.edit.label" /></g:link>

      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <g:link class="btn btn-primary" controller="login" action="switchUser" params="[username: userInstance.username]" >切換使用者</g:link>
        <g:link class="btn btn-primary" controller="store" action="create" params="['user.id': userInstance.id]">新增店家</g:link>
      </sec:ifAnyGranted>

      <sec:ifAnyGranted roles="ROLE_MANERGER">
        <g:if test="${!user?.store}">
          <g:link  class="btn btn-primary" controller="user" action="addToStore" id="${userInstance.id}" >指定為作業員</g:link>
        </g:if>
      </sec:ifAnyGranted>

      <sec:ifAnyGranted roles="ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER">  
        <g:link elementId="product-create" class="btn btn-primary" controller="product" action="create" params="['user.id': userInstance.id]">新增產品</g:link>
      </sec:ifAnyGranted>


      <sec:ifAnyGranted roles="ROLE_CUSTOMER">          
        <g:link elementId="part-create" class="btn btn-primary" controller="part" action="create" params="['user.id': userInstance.id]">新增維修項目</g:link>
      </sec:ifAnyGranted>


      <g:link elementId="user-delete" class="btn btn-danger" action="delete" id="${userInstance.id}"><g:message code="default.button.delete.label" /></g:link>


    </div>
  </div>




  <div class="row show-grid features-block mini-blocks">
    <div class="contact-info col-sm-12 col-md-12">
      <h2>車主資料</h2>
      <g:render template="/user/content" model="[user: userInstance]" />
    </div>

  </div>

  <div class="row show-grid features-block mini-blocks">
    <div class="contact-info col-sm-12 col-md-12">
      <h2>擁有機車</h2>
    </div>

    <g:each in="${productInstanceList}" var="productInstance" status="i" >



      <div class="contact-info col-sm-4 col-md-4 block2">
        <div class="mini-wrapper">

          <g:render template="/product/content" model="[productInstance: productInstance]" />

        </div>
      </div>


    </g:each>
  </div>




</body>
</html>