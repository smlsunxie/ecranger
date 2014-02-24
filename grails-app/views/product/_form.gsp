<%@ page import="motoranger.Product" %>


<g:hasErrors bean="${productInstance}">
  <ul class="errors" role="alert">
    <g:eachError bean="${productInstance}" var="error">
      <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>

<div class="form-group ${hasErrors(bean: productInstance, field: 'name', 'has-error')}">
  
  <label for="name" class="col-sm-2 control-label">
    <g:message code="product.name.label" /><span class="required-mark">*</span>
  </label>
  <div class="col-sm-10">
%{--     <g:textField name="name" value="${productInstance?.name}" class="form-control" placeholder="請輸入你的車牌號嗎(不需要 '-' 符號)" maxlength="10" pattern="${productInstance.constraints.name.matches}" /> --}%

    <g:remoteField action="checkNameExist" update="alert_placeholder" name="name" value="${productInstance?.name}" class="form-control" placeholder="請輸入你的車牌號嗎(不需要 '-' 符號)" maxlength="10" pattern="${productInstance.constraints.name.matches}" />    
  </div>

</div>


<div class="form-group ${hasErrors(bean: productInstance, field: 'title', 'has-error')}">
  
  <label for="title" class="col-sm-2 control-label">
    <g:message code="product.title.label" /><span class="required-mark">*</span>
  </label>
  <div class="col-sm-10">
    <g:textField name="title" value="${productInstance?.title}" class="form-control"  placeholder="請隨意輸入" />
  </div>

</div>



<div class="form-group ${hasErrors(bean: productInstance, field: 'description', 'has-error')}">
  
  <label for="description" class="col-sm-2 control-label">
    <g:message code="default.description.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="description" value="${productInstance?.description}" class="form-control" />
  </div>

</div>


<div class="form-group ${hasErrors(bean: productInstance, field: 'mileage', 'has-error')}">
  
  <label for="mileage" class="col-sm-2 control-label">
    <g:message code="product.mileage.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="mileage" type="number" value="${productInstance?.mileage}" class="form-control" />
  </div>

</div>


<div class="form-group ${hasErrors(bean: productInstance, field: 'brand', 'has-error')}">
  
  <label for="brand.id" class="col-sm-2 control-label">
    <g:message code="product.brand.label" />
  </label>
  <div class="col-sm-10">
    <g:select class="form-control" name="brand.id" from="${motoranger.Brand.list()}" 
          noSelection="${['null':'請選擇...']}" optionKey="id" value="${productInstance?.brand?.id}" />
  </div>

</div>



<div hidden class="form-group ${hasErrors(bean: productInstance, field: 'user', 'has-error')}">
  
  <label for="user.id" class="col-sm-2 control-label">
    <g:message code="product.user.label" />
  </label>
  <div class="col-sm-10">
    <g:select id="user" name="user.id" from="${motoranger.User.findById(productInstance?.user?.id)}" optionKey="id" value="${productInstance?.user?.id}" class="many-to-one" noSelection="['null': '']" class="form-control" />
  </div>

</div>

<div class="form-group ${hasErrors(bean: productInstance, field: 'years', 'has-error')}">
  
  <label for="years" class="col-sm-2 control-label">
    <g:message code="product.years.label" />
  </label>
  <div class="col-sm-10">
    <g:datePicker name="years" value="${productInstance.years}"
        noSelection="['':'-Choose-']" precision="month" years="${1980..(new Date().getAt(Calendar.YEAR))}" />
  </div>

</div>


<div class="form-group ${hasErrors(bean: productInstance, field: 'cc', 'has-error')}">
  
  <label for="cc" class="col-sm-2 control-label">
    <g:message code="product.cc.label" />  
  </label>
  <div class="col-sm-10">
    <g:field class="form-control" type="number" name="cc" value="${productInstance?.cc}"/>
  </div>

</div>



<sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER">

  <div class="form-group ${hasErrors(bean: productInstance, field: 'cost', 'has-error')}">
    
    <label for="cost" class="col-sm-2 control-label">
      <g:message code="product.cost.label" />
    </label>
    <div class="col-sm-10">
      <g:field class="form-control" type="number" name="cost" value="${productInstance?.cost}" />
    </div>

  </div>


  <div class="form-group ${hasErrors(bean: productInstance, field: 'price', 'has-error')}">
    
    <label for="price" class="col-sm-2 control-label">
      <g:message code="product.price.label" />
    </label>
    <div class="col-sm-10">
      <g:field class="form-control" type="number" name="price" value="${productInstance?.price}" />
    </div>

  </div>


</sec:ifAnyGranted>

<p></p>
<div class="form-group">
  
  <label class="col-sm-2 control-label">
    <g:message code="default.imageUpload.label" />
  </label>
  <div class="col-sm-10">
    <g:render template="/attachment/uploadBtn" model="[name:productInstance.name,mainImage: productInstance?.mainImage]" />
  </div>

</div>

