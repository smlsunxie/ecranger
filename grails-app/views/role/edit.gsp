<!DOCTYPE html>
<html>

  <head>
    <meta name="layout" content="bootstrap">
    <g:set var="entityName" value="${message(code: 'roleInstance.label', default: 'roleInstance')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
  </head>

  <body>
    <g:render template="/component/formEdit" model="[domainName: 'role', domain: roleInstance]"/>
  </body>

</html>
