<table class="table">
  <tbody>

  <tr>
    <td class="small"><g:message code="event.name.label" /></td>
    <td class="bold">
      <g:link controller="event" action="show" id="${eventDetailInstance.head.id}">${eventDetailInstance.head.name}</g:link>
    </td>
  </tr>


  <tr>
    <td class="small"><g:message code="eventDetail.name.label" /></td>
    <td class="bold">
      <g:link controller="eventDetail" action="show" id="${eventDetailInstance.id}">${eventDetailInstance.name}</g:link>
    </td>
  </tr>



  <tr>
    <td class="small"><g:message code="eventDetail.price.label" /></td>
    <td class="bold">${eventDetailInstance.price}</td>
  </tr>

  <tr>
    <td class="small"><g:message code="eventDetail.cost.label" /></td>
    <td class="bold">${(eventDetailInstance.cost == -1 ?'****':eventDetailInstance.cost)}</td>
  </tr>
    


  <tr>
    <td class="small"><g:message code="eventDetail.qty.label" /></td>
    <td class="bold">${eventDetailInstance.qty}</td>
  </tr>
  <tr>
    <td class="small"><g:message code="default.description.label" /></td>
    <td class="bold">${eventDetailInstance.description}</td>
  </tr>



  </tbody>
</table>