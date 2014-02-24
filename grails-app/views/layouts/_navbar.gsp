

<div class="row show-frid">
    <div class="col-sm-12 col-md-12">
        <div id="breadcrumb">
              <ul >
                  <li class="home"><g:message code="default.${actionName}.label" args="[message(code:controllerName+'.label', default: controllerName )]" /></li>

                  <li id="alert_placeholder"></li>
              </ul>
              
              <sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER, ROLE_ADMIN">

                <g:form action="query" controller="search" class="form-inline pull-right"> 
                  <input type="text" name="q" class="form-control" placeholder="車牌或使用者" value="${params.q}">
                </g:form>
              </sec:ifAnyGranted>





        </div>

    </div>

</div>

