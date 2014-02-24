<table class="table" id="no-more-tables">
  <thead>
    <tr>
      <th><g:message code="eventDetail.name.label" /></th>
      <th><g:message code="part.label" /></th>
      <th><g:message code="part.price.label" /></th>
      <th>&nbsp;</th>

    </tr>
  </thead>

  <g:each in="${eventInstance.details}" var="eventDetailInstance" status="j">
    <tbody>        
      
      <tr>
        <td data-title='<g:message code="eventDetail.name.label" />'>
          <g:link controller="eventDetail" action="show" id="${eventDetailInstance?.id}">${eventDetailInstance?.id}</g:link>
        </td>
        <td data-title='<g:message code="part.label" />'>
          <g:link controller="part" action="show" id="${eventDetailInstance?.part.id}">${eventDetailInstance?.part?.title}&nbsp;</g:link>
        </td>
          
        <td data-title='<g:message code="part.price.label" />'>
          ${eventDetailTotalPrice[eventDetailInstance.id]}
        </td>
        
        <td>
          <g:if test="${currentUserIsEventOwner[eventInstance.id]}">
              <g:link elementId="eventDetail-edit-${eventDetailInstance.name}" class="btn btn-primary btn-xs" controller="eventDetail" action="edit" id="${eventDetailInstance.id}"><g:message code="default.button.edit.label" /></g:link>
              <g:link elementId="eventDetail-delete-${eventDetailInstance.name}" class="btn btn-danger btn-xs" controller="eventDetail" action="delete" id="${eventDetailInstance.id}"><g:message code="default.button.delete.label" /></g:link>
          </g:if>
          &nbsp;
        </td>
        
      </tr>
    </tbody>
  </g:each>
</table> 