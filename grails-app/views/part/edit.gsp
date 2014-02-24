<!DOCTYPE html>
<html>

  <head>
    <meta name="layout" content="bootstrap">
    <g:set var="entityName" value="${message(code: 'part.label', default: 'part')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
  </head>

  <body>
    <g:render template="/component/formEdit" model="[domainName: 'part', domain: partInstance]"/>
  </body>

</html>
