
<g:hasErrors bean="${eventInstance}">
  <ul class="errors" role="alert">
    <g:eachError bean="${eventInstance}" var="error">
      <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>

<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="event.name.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="name" value="${eventInstance?.name}" readonly class="form-control" />
  </div>

</div>

<div hidden class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="user.username.label" />
  </label>
  <div class="col-sm-10">
    <g:select class="form-control" name="user.id" from="${eventInstance?.user ?: motoranger.UserRole.findAllByRole(motoranger.Role.findByAuthority('ROLE_OPERATOR'))*.user}" noSelection="${[null:'Select One...']}" optionKey="id" value="${eventInstance?.user?.id}" />
  </div>

</div>

<div hidden class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="event.product.label" />
  </label>
  <div class="col-sm-10">
    <g:select class="form-control" name="product.id" from="${eventInstance?.product?:motoranger.Product.list()}" noSelection="${[null:'Select One...']}" optionKey="id" value="${eventInstance?.product?.id}" />
  </div>

</div>


<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="event.mileage.label" />
  </label>
  <div class="col-sm-10">
    <g:textField type='number' name="mileage" value="${eventInstance.mileage}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="event.date.label" />
  </label>
  <div class="col-sm-10">
    <g:datePicker name="date" value="${eventInstance.date}"
      noSelection="['':'-Choose-']" precision="day" years="${(new Date().getAt(Calendar.YEAR)-1)..(new Date().getAt(Calendar.YEAR))}" />
  </div>

</div>

<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="default.description.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="description" value="${eventInstance?.description}" class="form-control" />
  </div>

</div>


<div hidden class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="user.store.label" default="Store" />
  </label>
  <div class="col-sm-10">
      <g:select class="form-control" id="store" name="store.id" from="${motoranger.Store.list()}" optionKey="id" value="${eventInstance?.store?.id}" noSelection="['null': '']"/>
  </div>

</div>



