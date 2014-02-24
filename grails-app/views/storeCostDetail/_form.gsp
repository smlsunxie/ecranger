<%@ page import="motoranger.StoreCostDetail" %>



<div class="fieldcontain ${hasErrors(bean: storeCostDetailInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="storeCostDetail.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${storeCostDetailInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storeCostDetailInstance, field: 'cost', 'error')} required">
	<label for="cost">
		<g:message code="storeCostDetail.cost.label" default="Cost" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cost" type="number" value="${storeCostDetailInstance.cost}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: storeCostDetailInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="storeCostDetail.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="month"  value="${storeCostDetailInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: storeCostDetailInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="storeCostDetail.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${storeCostDetailInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storeCostDetailInstance, field: 'store', 'error')} required">
	<label for="store">
		<g:message code="storeCostDetail.store.label" default="Store" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="store" name="store.id" from="${motoranger.Store.list()}" optionKey="id" required="" value="${storeCostDetailInstance?.store?.id}" class="many-to-one"/>
</div>

