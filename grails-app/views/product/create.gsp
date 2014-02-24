<!DOCTYPE html>
<html>
  
  <head>
    <meta name="layout" content="bootstrap">
    <g:set var="entityName" value="${message(code: 'product.label', default: 'product')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
  </head>

  <body>
    <g:render template="/component/formCreate" model="[domainName: 'product', domain: productInstance]"/>
  </body>

</html>
