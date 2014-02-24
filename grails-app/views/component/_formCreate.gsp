
  <g:form name="${domainName}-save" url="[resource: domain, action:'save']" class="form-horizontal">

    <div id="actionbar" class="btn-group">
      <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />

      <g:link controller='home' class="btn btn-default">${message(code: 'default.button.cancel.label', default: 'Cancel')}</g:link>
    </div>



    <g:render template="/${domainName}/form"/>



    <div id="actionbar" class="btn-group">
      <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />

      <g:link controller='home' class="btn btn-default">${message(code: 'default.button.cancel.label', default: 'Cancel')}</g:link>
    </div>

  </g:form>

