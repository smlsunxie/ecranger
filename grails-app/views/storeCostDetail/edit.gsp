<!DOCTYPE html>
<html>

  <head>
    <meta name="layout" content="bootstrap">
    <g:set var="entityName" value="${message(code: 'storeCostDetail.label', default: 'storeCostDetail')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
  </head>

  <body>
    <g:render template="/component/formEdit" model="[domainName: 'storeCostDetail', domain: storeCostDetailInstance]"/>
  </body>

</html>
