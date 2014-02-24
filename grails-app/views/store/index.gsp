
<%@ page import="motoranger.Store" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="bootstrap">
    <g:set var="entityName" value="${message(code: 'store.label', default: 'Store')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
  </head>
  <body>

  <div class="row" id="actionbar">

    <div class="col-sm-12 col-md-12">           


        <g:link  class="btn btn-primary" controller="store" action="create" >新增車行</g:link>


    </div>

  </div>


    <div class="row">

      <table  class="table" id="no-more-tables">
        <thead>
          <tr>
          
            <g:sortableColumn property="title" title="${message(code: 'store.title.label', default: 'Title')}" />

            <g:sortableColumn property="address" title="${message(code: 'store.address.label', default: 'Address')}" />   

            <g:sortableColumn property="mobile" title="${message(code: 'store.mobile.label', default: 'Mobile')}" />

            <g:sortableColumn property="telphone" title="${message(code: 'store.telphone.label', default: 'Telphone')}" />          

            <g:sortableColumn property="description" title="${message(code: 'store.description.label', default: 'description')}" />
          
          </tr>
        </thead>
        <tbody>
        <g:each in="${storeInstanceList}" status="i" var="storeInstance">
          <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
          
            <td data-title="${message(code: 'store.title.label', default: 'title')}"><g:link action="show" id="${storeInstance.id}">${fieldValue(bean: storeInstance, field: "title")}</g:link>&nbsp</td>
            
            <td data-title="${message(code: 'store.address.label', default: 'address')}">${fieldValue(bean: storeInstance, field: "address")}&nbsp</td>     
            
            <td data-title="${message(code: 'store.mobile.label', default: 'mobile')}">${fieldValue(bean: storeInstance, field: "mobile")}&nbsp</td>
          
            <td data-title="${message(code: 'store.telphone.label', default: 'telphone')}">${fieldValue(bean: storeInstance, field: "telphone")}&nbsp</td>

            <td data-title="${message(code: 'store.description.label', default: 'description')}">${fieldValue(bean: storeInstance, field: "description")}&nbsp</td>
          
          </tr>
        </g:each>
        </tbody>
      </table>
      <div class="pagination">
        <g:paginate total="${storeInstanceCount}" />
      </div>
    </div>
  </body>
</html>
