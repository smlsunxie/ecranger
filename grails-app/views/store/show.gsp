<!DOCTYPE html>
<html>
  <head>
    <title><g:message code="default.home.label"/></title>

  </head>
  <body>
    <div class="title-wrapper">
        <h1><i class="icon-home"></i> ${storeInstance.title}</h1>
    </div>

    <!-- 手機畫面 action button -->



    <div class="visible-xs">
      <sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER">
        <g:if test="${currentUserIsStoreOwnerOrAdmin}">
          <div class="btn-group" id="actionbar">

            <button class="btn btn-default btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
              維護其他<span class="caret"></span>
            </button>
                  
            <ul class="dropdown-menu">

              <li><g:link controller="store" action="edit" id="${storeInstance.id}" ><g:message code="store.edit.label"/></g:link></li>

              <li><g:link controller="part" action="create" params="['store.id': storeInstance.id]"><g:message code="part.create.label"/></g:link></li>

              <li><g:link controller="product" action="create" params="['store.id': storeInstance.id]"><g:message code="product.create.label"/></g:link></li>

            </ul>
          </div>
        </g:if>
      </sec:ifAnyGranted>

      <div class="btn-group" id="actionbar">

        <button class="btn btn-default btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
          店家狀況<span class="caret"></span>
        </button>    

        <ul class="dropdown-menu">

          <li><g:link controller="event" action="unfinListOfStore" params="['store.id': storeInstance.id]" >所有維修中</g:link></li>
          <li><g:link controller="event" action="endListOfStore" params="['store.id': storeInstance.id]" >最近維修完成</g:link></li>

        </ul>

      </div>
    </div>  

    <div class="hidden-xs">

        <g:if test="${currentUserIsStoreOwnerOrAdmin}">
          <div class="btn-group" id="actionbar">
            <sec:ifAnyGranted roles="ROLE_ADMIN">
              <g:link  class="btn btn-primary"  action="edit" id="${storeInstance?.id}"><g:message code="default.button.edit.label" /></g:link>


              <g:link  class="btn btn-danger" action="delete" id="${storeInstance?.id}"><g:message code="default.button.delete.label" /></g:link>
            </sec:ifAnyGranted>
          </div>
        </g:if>

        <g:if test="${currentUserIsStoreOwnerOrAdmin}">

          <div class="btn-group" id="actionbar">

              <sec:ifAnyGranted roles="ROLE_MANERGER">
                <g:link  class="btn btn-primary" controller="user" action="create" params="['store.id': storeInstance.id]" >建立作業員</g:link>
              </sec:ifAnyGranted>

              <sec:ifAnyGranted roles="ROLE_MANERGER, ROLE_OPERATOR">
                <g:link  class="btn btn-primary" controller="product" action="create" params="['store.id': storeInstance.id]"><g:message code="product.create.label"/></g:link>

                <g:link  class="btn btn-primary" controller="part" action="create" params="['store.id': storeInstance.id]"><g:message code="part.create.label"/></g:link>
              </sec:ifAnyGranted>

            
          </div>
        </g:if>

        <div class="btn-group" id="actionbar">

    
          <g:link  class="btn btn-danger" controller="event" action="unfinListOfStore" params="['store.id': storeInstance.id]" >所有維修中</g:link>

          <g:link  class="btn btn-success" controller="event" action="endListOfStore" params="['store.id': storeInstance.id]" >最近維修完成</g:link>


        </div>

    </div>


    <div class="main-block block-posts">
      <div class="title-wrapper">
          <h1><i class="icon-signin"></i> 維修中</h1>
      </div>
        <div class="row show-grid clear-both">
            <div class="col-sm-12 col-md-12">
              <div class="row show-grid">
                
                <g:render template="/event/stickWithImage" model="['stickName':'alert']"
                  collection="${unfinEvents}" var="eventInstance"  />
              
              </div>
            </div>
        </div>
    </div>
    
    <hr>
    <div class="main-block block-posts">
      <div class="title-wrapper">
          <h1><i class="icon-ok "></i> 維修完成</h1>
      </div>
      <div class="row show-grid clear-both">
        <div class="col-sm-12 col-md-12">
          <div class="row show-grid">
            <g:render template="/event/stickWithImage" model="['stickName':'success']"
              collection="${endEvents}" var="eventInstance"  />
        </div>
      </div>
    </div>


  </body>
</html>
