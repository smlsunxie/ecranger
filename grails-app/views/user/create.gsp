<!DOCTYPE html>
<html>
  
  <head>
    <meta name="layout" content="bootstrap">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'user')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
  </head>

  <body>
    <g:render template="/component/formCreate" model="[domainName: 'user', , domain: userInstance]"/>
  </body>

</html>
