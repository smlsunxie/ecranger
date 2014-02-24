<div ${hidden} class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <div class="checkbox">
      <label>
        <g:checkBox name="enabled" value="${userInstance?.enabled}" /> 
        <g:message code="user.enabled.label" default="Enabled" />
      </label>
    </div>
  </div>
</div>



<div ${hidden} class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <div  class="checkbox">
      <label>
        <g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />
        <g:message code="user.passwordExpired.label" default="Password Expired" />
      </label>
    </div>
  </div>
</div>




<div ${hidden} class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <div class="checkbox">
      <label>
        <g:checkBox name="accountExpired" value="${userInstance?.accountExpired}"  /> 
        <g:message code="user.accountExpired.label" default="Account Expired" />
      </label>
    </div>
  </div>
</div>

<div ${hidden} class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <div class="checkbox">
      <label>
        <g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" /> 
        <g:message code="user.accountLocked.label" default="Account Locked" />
      </label>
    </div>
  </div>
</div>


<div ${hidden} class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="role.authority.label" default="authority" />
  </label>
  <div class="col-sm-10">
    <table class="table">

      <tbody>
        <g:each in="${roles}" var="role" status="i">

          <tr>

            <td><g:checkBox name="userRoles" value="${role.authority}" checked="${userRoles && userRoles.role.authority.contains(role.authority)}" /></td>
            <td>${role.authority}</td>

            </tr>

        </g:each>

      </tbody>
    </table> 
  </div>

</div>
