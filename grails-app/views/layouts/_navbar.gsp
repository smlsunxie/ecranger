

<div class="row show-frid">
    <div class="col-sm-12 col-md-12">
        <div id="breadcrumb">
              <ul >
                  <li class="home"><g:message code="default.${actionName}.label" args="[message(code:controllerName+'.label', default: controllerName )]" /></li>

                  <li id="alert_placeholder"></li>
              </ul>
              
              <g:form action="query" controller="search" class="form-inline pull-right"> 
                <input type="text" name="q" class="form-control" placeholder="全文檢索" value="${params.q}">
              </g:form>
        </div>

    </div>

</div>

