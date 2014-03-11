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

          <g:link elementId="event-delete" class="btn btn-success"
            action="delete" controller="event" id="${eventInstance.id}" >
            結帳
          </g:link> 

          <g:link elementId="event-delete" class="btn btn-danger"
            action="delete" controller="event" id="${eventInstance.id}" >
            清空購物車
          </g:link> 
          

        </div>
      </sec:ifAnyGranted>

    </div>            



  <div class="contact-info" >
    <h2>購物車內容</h2>
    <g:render template="contentWithDetails" />
  </div>
            
</body>
</html>
