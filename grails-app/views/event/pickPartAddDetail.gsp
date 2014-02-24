<g:set var="tagQueryService" bean="tagQueryService"/>
<g:set var="nowTag" value="${params.tag}" />

<html>
<head>
<title><g:message code="event.pickPartAddDetail.label" defualt="pickPartAddDetail" args="[eventInstance]"/></title>


</head>
<body>





  <div class="row">

    <sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_CUSTOMER, ROLE_MANERGER">

      <div class="col-sm-3 col-md-3">
        <div class="btn-group" id="actionbar">
          <g:link  class="btn btn-primary" controller="part" action="create" params="['event.id': eventInstance.id]">新增並加入自定維修項目</g:link>
        </div>
      </div>

    </sec:ifAnyGranted>


    <sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER">
      <div class="col-sm-3 col-md-3">
        <g:render template="/event/updateReceivedMoney" />
      </div>

      <div class="col-sm-3 col-md-3">
        <g:render template="/event/updateUnreceiveMoney" />
      </div>

      <div class="col-sm-3 col-md-3">
        <g:render template="/event/updateEventDate" /> 
      </div>
    </sec:ifAnyGranted>


  </div>



<g:render template="contentWithDetails"  model="[event: eventInstance]" />

<g:render template="/part/portfolio" model="['event': eventInstance]" />
               
  </body>
</html>
