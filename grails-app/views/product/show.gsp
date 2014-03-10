<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">
<title>${product?.title}</title>
</head>
<body>

  <sec:ifAnyGranted roles="ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER">
    <div class="row" id="actionbar">

      <div class="col-sm-12 col-md-12">           

          <g:link elementId="product-edit" class="btn btn-primary" action="edit" id="${productInstance?.id}"><g:message code="default.button.edit.label" /></g:link>


          <g:link elementId="product-delete" class="btn btn-danger" action="delete" id="${productInstance?.id}"><g:message code="default.button.delete.label" /></g:link>

      </div>

    </div>
  </sec:ifAnyGranted>

  <g:render template="contentWithDetails" />


  <hr />

  <div class="row" id="actionbar">

    <div class="col-sm-12 col-md-12">           

        <g:link elementId="product-addToCart" class="btn btn-primary" action="addToCart" id="${productInstance?.id}">放入購物車</g:link>
        <g:link elementId="product-edit" class="btn btn-primary" action="edit" id="${productInstance?.id}">直接購買</g:link>

    </div>

  </div>


</body>
</html>
