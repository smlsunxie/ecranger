`
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<title>${eventInstance}</title>


</head>
<body>



    <div class="row" id="actionbar">

      <sec:ifAnyGranted roles="ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER">
        <div class="col-sm-3 col-md-3">          

          <g:link elementId="event-edit" class="btn btn-primary btn-large "
            action="edit" controller="event" id="${eventInstance.id}" >
          <g:message code="default.button.edit.label" />
          </g:link>  



          <g:link elementId="event-delete" class="btn btn-danger"
            action="delete" controller="event" id="${eventInstance.id}" >
            <g:message code="default.button.delete.label" />
          </g:link> 
        </div>
      </sec:ifAnyGranted>

    </div>            



  <div class="contact-info" >
    <h2>維修記錄</h2>
    <g:render template="contentWithDetails" />
  </div>
            
</body>
</html>
