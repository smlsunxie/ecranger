
  <g:form name="${domainName}-update" url="[resource: domain, action:'update']" class="form-horizontal">

    <div id="actionbar" class="btn-group">
      <g:submitButton name="update" class="btn btn-primary" value="${message(code: 'default.button.update.label', default: 'update')}" />

      <g:link action='show' id="${domain.id}" class="btn btn-default">${message(code: 'default.button.cancel.label', default: 'Cancel')}</g:link>
    </div>



    <g:render template="/${domainName}/form"/>



    <div id="actionbar" class="btn-group">
      <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.update.label', default: 'update')}" />

      <g:link action='show' id="${domainId}" class="btn btn-default">${message(code: 'default.button.cancel.label', default: 'Cancel')}</g:link>
    </div>

  </g:form>

