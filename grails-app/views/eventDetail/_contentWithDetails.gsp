<table class="table" id="no-more-tables">
  <thead>
    <tr>
      <th><g:message code="product.label" /></th>
      <th><g:message code="product.price.label" /></th>
      <th>&nbsp;</th>

    </tr>
  </thead>

  <g:each in="${eventInstance.details}" var="eventDetailInstance" status="j">
    <tbody>        
      
      <tr>
        <td data-title='<g:message code="eventDetail.name.label" />'>
          <g:link controller="eventDetail" action="show" id="${eventDetailInstance?.product?.id}">${eventDetailInstance?.product}</g:link>
        </td>
        <td data-title='<g:message code="part.price.label" />'>
          ${eventDetailInstance.price}
        </td>
        
        <td>
            <g:link elementId="eventDetail-edit-${eventDetailInstance.name}" class="btn btn-primary btn-xs" controller="eventDetail" action="edit" id="${eventDetailInstance.id}"><g:message code="default.button.edit.label" /></g:link>
            <g:link elementId="eventDetail-delete-${eventDetailInstance.name}" class="btn btn-danger btn-xs" controller="eventDetail" action="delete" id="${eventDetailInstance.id}"><g:message code="default.button.delete.label" /></g:link>

          &nbsp;
        </td>
        
      </tr>
    </tbody>
  </g:each>
</table> 