<div class="row" id="actionbar">

  <div class="col-sm-12 col-md-12">


            <g:if test="${actionName=='create' ||actionName=='save' ||actionName=='edit' }" >
              

              <g:submitButton name="${nextActionName}"  class="btn btn-primary btn-large" value="${message(code: 'default.button.${nextActionName}.label', default: nextActionName)}" />
              <g:link action='list' class="btn">${message(code: 'default.button.cancel.label', default: 'Cancel')}</g:link>
            

            </g:if >  


  </div>


</div>

