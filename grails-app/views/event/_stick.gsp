

<div class="alert-stick stick event">

  <p>
    <g:link elementId="event-show-${eventInstance.name}" controller="event" action="show" id="${eventInstance?.id}">
    ${eventInstance?.name}
  </g:link> 
  </p>

  <p>
    <i class="icon-user"></i>
    客戶名稱：
    <g:link controller="user" action="show" id="${eventInstance?.user?.id}" > 
      ${eventInstance?.user}
    </g:link>
  </p>



  <p class="date">
    <i class="icon-calendar"></i>
    建立日期： <g:formatDate date="${eventInstance.date}" type="date" style="SHOROT" />
  </p>

  <p class="date">
    <i class="icon-calendar"></i>
    購物總額： ${eventInstance.totalPrice}
  </p>

  <g:if test="${actionName != 'pickPartAddDetail'}" >
    <g:link class="btn btn-primary" controller="event" action="pickPartAddDetail" id="${eventInstance?.id}">新增維修</g:link>

  </g:if>


</div>

