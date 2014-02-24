<g:hasErrors bean="${eventDetailInstance}">
  <ul class="errors" role="alert">
    <g:eachError bean="${eventDetailInstance}" var="error">
      <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>

<div hidden class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="eventDetail.name.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="name" readonly value="${eventDetailInstance?.name}" class="form-control" />
  </div>

</div>


<div hidden class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="event.name.label" />
  </label>
  <div class="col-sm-10">
    <g:select class="form-control" name="head.id" from="${eventDetailInstance?.head ?: motoranger.Event.list()}" noSelection="${[null:'Select One...']}" optionKey="id" value="${eventDetailInstance?.head?.id}" />
  </div>

</div>


<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="part.name.label" />
  </label>
  <div class="col-sm-10">
    <g:select class="form-control" name="part.id" from="${eventDetailInstance?.part ? eventDetailInstance?.part : motoranger.Part.list()}" noSelection="${[null:'Select One...']}" optionKey="id" value="${eventDetailInstance?.part?.id}" />
  </div>

</div>


<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="eventDetail.price.label" />
  </label>
  <div class="col-sm-10">
    <g:field  type="number" name="price" value="${eventDetailInstance?.price}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="eventDetail.cost.label" />
  </label>
  <div class="col-sm-10">
    <g:field  type="number" name="cost" value="${eventDetailInstance?.cost}" class="form-control" />
  </div>

</div>


<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="eventDetail.qty.label" />
  </label>
  <div class="col-sm-10">
    <g:field  type="number" name="qty" value="${eventDetailInstance?.qty}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="default.description.label" />
  </label>
  <div class="col-sm-10">
    <g:textField  name="description" value="${eventDetailInstance?.description}" class="form-control" />
  </div>

</div>


<div class="form-group">
  
  <label for="" class="col-sm-2 control-label">
   <g:message code="default.imageUpload.label" />
  </label>
  <div class="col-sm-10">
    <g:render template="/attachment/uploadBtn" model="[name:eventDetailInstance?.name,mainImage:eventDetailInstance?.mainImage]" />
  </div>

</div>