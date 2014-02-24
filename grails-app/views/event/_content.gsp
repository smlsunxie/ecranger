<table class="table">
  <tbody>


    <tr>
        <td class="small"><g:message code="event.mileage.label" /></td>
        <td class="bold">${eventInstance.mileage}</td>
    </tr> 

    <sec:ifAnyGranted roles="ROLE_OPERATOR, ROLE_MANERGER">
      <g:if test = "${currentUserIsEventOwner[eventInstance.id]}">

        <tr>
            <td class="small">已收</td>
            <td class="bold">${eventInstance?.receivedMoney.toString()}</td>
        </tr> 
        <tr>
            <td class="small">未收</td>
            <td class="bold">${eventInstance?.totalPrice-eventInstance?.receivedMoney}</td>
        </tr> 
        
      </g:if>
    </sec:ifAnyGranted>


    <g:if test="${currentUserIsEventOwner[eventInstance.id]}">

      <tr>
        <td class="small"><g:message code="event.totalPrice.label" /></td>
        <td class="bold">${eventInstance?.totalPrice}</td>
      </tr>

    </g:if>

    <tr>
        <td class="small"><g:message code="event.store.label" /></td>
        <td class="bold">
          <g:link controller="store" action="show" id="${eventInstance?.store?.id}">${eventInstance?.store}</g:link>

        </td>
    </tr>

    
    <tr>
        <td class="small"><g:message code="default.dateCreated.label" /></td>
        <td class="bold">
          <g:formatDate date="${eventInstance.date}" type="date" style="SHOROT" />
        </td>
    </tr> 



  </tbody>
</table>