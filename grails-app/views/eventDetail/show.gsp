
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<g:set var="entityName" value="${message(code: 'part.label', default: '文章')}" />
<title>${eventDetailInstance}</title>


</head>
<body>

  <g:if test="${currentUserIsEventOwner[eventDetailInstance.head.id]}">

      <div class="row" id="actionbar">

        <div class="col-sm-4 col-md-4">

          <g:link elementId="eventDetail-edit" class="btn btn-primary btn-large "
            action="edit" controller="eventDetail" id="${eventDetailInstance.id}" >
          <g:message code="default.button.edit.label" />
          </g:link>


          <g:link elementId="eventDetail-delete" class="btn btn-danger"
            action="delete" controller="eventDetail" id="${eventDetailInstance.id}" >
            <g:message code="default.button.delete.label" />
          </g:link> 
        </div>

      </div>  

  </g:if>


  <div class="row">
    <div class="contact-info col-sm-4 col-md-4">
      <h2>維修細項</h2>
      <g:render template="content" />
    </div>
    <div class="contact-info col-sm-4 col-md-4">
      <h2>耗材資料</h2>
      <g:render template="/part/content" model="[partInstance: eventDetailInstance.part]" />
    </div>
    <div class="contact-info col-sm-4 col-md-4">
      <h2>維修機車資料</h2>
      <g:render template="/product/content" model="[productInstance: eventDetailInstance.head.product]" />
    </div>
  </div>

            
</body>
</html>
