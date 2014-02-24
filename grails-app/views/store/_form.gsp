<g:hasErrors bean="${storeInstance}">
  <ul class="errors" role="alert">
    <g:eachError bean="${storeInstance}" var="error">
      <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="store.name.label" default="Name" />
  </label>
  <div class="col-sm-10">
    <g:textField name="name" value="${storeInstance?.name}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
   <g:message code="store.title.label" default="Title" />
  </label>
  <div class="col-sm-10">
    <g:textField name="title" value="${storeInstance?.title}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="store.address.label" default="Address" />
  </label>
  <div class="col-sm-10">
    <g:textField name="address" value="${storeInstance?.address}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="store.email.label" default="email" />
  </label>
  <div class="col-sm-10">
    <g:textField name="email" value="${storeInstance?.email}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="store.mobile.label" default="Mobile" />
  </label>
  <div class="col-sm-10">
    <g:textField name="mobile" value="${storeInstance?.mobile}" class="form-control" />
  </div>

</div>




<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="store.telphone.label" default="Telphone" />
  </label>
  <div class="col-sm-10">
    <g:textField name="telphone" value="${storeInstance?.telphone}" class="form-control" />
  </div>

</div>
<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="store.fax.label" default="fax" />
  </label>
  <div class="col-sm-10">
    <g:textField name="fax" value="${storeInstance?.fax}" class="form-control" />
  </div>

</div>





<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
   <g:message code="store.users.label" default="Users" class="form-control" />
  </label>
  <div class="col-sm-10 portfolio-nav">

    <ul class="nav nav-pills nav-pills-portfolio" >
      <g:each in="${storeInstance?.users}" var="u">
        <li><g:link controller="user" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
      </g:each>

      <li class="add">
        <g:link controller="user" action="create" params="['store.id': storeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'user.label', default: 'User')])}</g:link>
      </li>
    </ul>
  </div>
</div>



