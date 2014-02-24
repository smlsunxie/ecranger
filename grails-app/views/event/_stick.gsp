

<div class="${stickName}-stick stick event">

  <p>
    <g:link elementId="event-show-${eventInstance.name}" controller="event" action="show" id="${eventInstance?.id}">
    ${eventInstance?.name}
  </g:link> 
  </p>


  <p>
    <i class="icon-screenshot"></i> 
    產品編號：<g:link controller="product" action="show" id="${eventInstance?.product?.id}">
    ${eventInstance.product.name}
  </g:link> 
  </p>
  


  <p>
    <i class="icon-user"></i>
    維修人員：
    <g:link controller="user" action="show" id="${eventInstance?.user.id}" > 
      ${eventInstance?.user}
    </g:link>
  </p>


  <p>
    <i class="icon-user"></i>
    客戶名稱：
    <g:link controller="user" action="show" id="${eventInstance?.product?.user?.id}" > 
      ${eventInstance?.product?.user}
    </g:link>
  </p>


  <g:if test = "${currentUserIsEventOwner[eventInstance.id]}">


    <p class="date">
      <i class="icon-calendar"></i>
      維修總額： ${eventInstance.totalPrice}
    </p>

    <g:if test="${actionName != 'pickPartAddDetail'}" >
      <g:link class="btn btn-primary" controller="event" action="pickPartAddDetail" id="${eventInstance?.id}">新增維修</g:link>

    </g:if>

    <g:render template="/event/statusChangeBtn" />

  </g:if>

</div>

