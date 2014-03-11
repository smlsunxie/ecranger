<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">
<title>${product?.title}</title>
</head>
<body>




  <div class="btn-group" id="actionbar">
         

    <g:link elementId="user-edit" class="btn btn-primary"  action="edit" id="${userInstance.id}"><g:message code="default.button.edit.label" /></g:link>


    <g:link elementId="user-delete" class="btn btn-danger" action="delete" id="${userInstance.id}"><g:message code="default.button.delete.label" /></g:link>


  </div>




  <div class="row show-grid features-block mini-blocks">
    <div class="contact-info col-sm-12 col-md-12">
      <h2>客戶資料</h2>
      <g:render template="/user/content" model="[user: userInstance]" />
    </div>

  </div>

  <div class="row">
    <div class="contact-info col-sm-12 col-md-12">
      <h2>購物歷程</h2>
    </div>

    <g:each in="${userInstance.events}" var="eventInstance" status="i" >

      <div class="contact-info  col-sm-4 col-md-4">

          <g:render template="/event/stick" model="[eventInstance: eventInstance]" />

      </div>

    </g:each>
  </div>




</body>
</html>