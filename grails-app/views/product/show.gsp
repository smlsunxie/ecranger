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

  <g:if test="${similarProductIntanceList}">
    <div class="contact-info" >
      <h2>類似產品</h2>

      <g:each in="${similarProductIntanceList}" var="similarProductIntance" >
        <div class="col-sm-4 col-md-4">

          <sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER">
            <div id="actionbar" class="text-center">
              <g:link  class="btn btn-primary" action="moveEvent" params="['fromProduct.id': similarProductIntance.id, 'toProduct.id': productInstance.id]">搬移維修事件</g:link>
            </div>
          </sec:ifAnyGranted>
          
          <g:render template="content" model="[productInstance: similarProductIntance]"  />

        </div>
      </g:each>    
    </div>

  </g:if>

  <br />

  <div class="contact-info" >
    <h2>維修記錄</h2>

    <sec:ifAnyGranted roles="ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER">

      <g:if test="${statusEnd}">
        <div id="actionbar" class="text-center">
          <g:link elementId="event-create" class="btn btn-primary" controller="event" action="create" params="['product.id':productInstance?.id]">
            新增維修記錄
          </g:link>
        </div>
      </g:if>

    </sec:ifAnyGranted>

    <g:render template="/event/contentWithDetails" collection="${productInstance?.events}" var="eventInstance" />
  </div>


</body>
</html>
