<%@ page import="motoranger.Brand" %>



<div class="fieldcontain ${hasErrors(bean: brandInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="brand.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${brandInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: brandInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="brand.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${brandInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: brandInstance, field: 'homepage', 'error')} ">
	<label for="homepage">
		<g:message code="brand.homepage.label" default="Homepage" />
		
	</label>
	<g:textField name="homepage" value="${brandInstance?.homepage}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: brandInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="brand.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${brandInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: brandInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="brand.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${motoranger.BrandType?.values()}" keys="${motoranger.BrandType.values()*.name()}" required="" value="${brandInstance?.type?.name()}"/>
</div>

