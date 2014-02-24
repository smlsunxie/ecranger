<g:hasErrors bean="${partInstance}">
  <ul class="errors" role="alert">
    <g:eachError bean="${partInstance}" var="error">
      <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>

<g:hiddenField name="event.id" value="${params['event.id']}" />


<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="part.name.label" /><span class="required-mark">*</span>
  </label>
  <div class="col-sm-10">
    <g:textField name="name" readonly value="${partInstance?.name}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="part.title.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="title" value="${partInstance?.title}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="default.tags.label" />
  </label>
  <div class="col-sm-10">
    <ul name="tags" id='tag-field' >
      <g:each in="${partInstance.tags}">
        <li>${it}</li>
      </g:each>
    </ul>
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="default.description.label" />
  </label>
  <div class="col-sm-10">
    <g:textField name="description" value="${partInstance?.description}" class="form-control" />
  </div>

</div>


<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="part.price.label" />
  </label>
  <div class="col-sm-10">
    <g:textField type="number" name="price" value="${partInstance?.price}" class="form-control" />
  </div>

</div>

<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    歷史售價
  </label>
  <div class="col-sm-10">
    <h4>
      <g:each var="it" status="i" in="${historyPrice}">

        <li class="btn btn-link" id='historyPrice' data-historyPrice='${it}' >${it}</li>

      </g:each>
    </h4>
  </div>

</div>

<sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER">



  <div class="form-group">
    
    <label for="inputEmail3" class="col-sm-2 control-label">
      <g:message code="part.cost.label" />
    </label>
    <div class="col-sm-10">
      <g:textField type="number" name="cost" value="${partInstance?.cost}" class="form-control" />
    </div>

  </div>

  <div class="form-group">
    
    <label for="inputEmail3" class="col-sm-2 control-label">
      歷史成本
    </label>
    <div class="col-sm-10">
      <h4>
        <g:each var="it" in="${historyCost}">

          <li class="btn btn-link" id='historyCost' data-historyCost='${it}' >${it}</li>

        </g:each>
      </h4>
    </div>

  </div>

</sec:ifAnyGranted>


<div hidden class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="part.stockCount.label" />
  </label>
  <div class="col-sm-10">
    <g:textField type="number" name="stockCount" value="${partInstance?.stockCount}" class="form-control" />
  </div>

</div>

 <div hidden class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="user.label" default="user" />
  </label>
  
  <div class="col-sm-10">
    <g:select id="user" name="user.id" from="${motoranger.User.findById(partInstance?.user?.id)}" optionKey="id" value="${partInstance?.user?.id}" noSelection="['null': '']" class="form-control" />
  </div>  

</div> 
<div hidden class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
    <g:message code="user.store.label" default="Store" />
  </label>

  <div class="col-sm-10">
    <g:select id="user" name="store.id" from="${motoranger.Store.findById(partInstance?.store?.id)}" optionKey="id" value="${partInstance?.store?.id}" noSelection="['null': '']" class="form-control" />
  </div>  


</div>       



<div class="form-group">
  
  <label for="inputEmail3" class="col-sm-2 control-label">
  <g:message code="default.imageUpload.label" />
  </label>
  <div class="col-sm-10">
  <g:render template="/attachment/uploadBtn" model="[name: partInstance.name ,mainImage: partInstance?.mainImage]" />
  </div>

</div>


<r:script>


  $(function() {

  $("ul[name='tags']").tagit({select:true, tagSource: "${g.createLink(controller:'tag',action: 'listAsJson')}"});

  $("li[id ='historyCost']").on('click',function(eventObject){
    var historyCost = $(this).attr("data-historyCost");
    $("#cost").val(historyCost)
  });

  $("li[id ='historyPrice']").on('click',function(eventObject){
    var historyCost = $(this).attr("data-historyPrice");
    $("#price").val(historyCost)
  });

  });


</r:script>