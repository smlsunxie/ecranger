<table class="table">
  <tbody>
    <tr>
      <td class="small"><g:message code="part.title.label" /></td>
      <td class="bold">
        <g:link controller="part" action="show" id="${partInstance.id}">${partInstance.title}</g:link>
      </td>
    </tr>


    <tr>
      <td class="small"><g:message code="part.price.label" /></td>
      <td class="bold">${partInstance.price}</td>
    </tr> 

    <tr>
      <td class="small"><g:message code="part.cost.label" /></td>
      <td class="bold">${(partInstance.cost == -1 ?'****':partInstance.cost)}</td>
    </tr>

    <tr>
      <td class="small"><g:message code="default.description.label" /></td>
      <td class="bold">${partInstance.description}</td>
    </tr>

    <tr>
      <td class="small"><g:message code="part.user.label" /></td>
      <td class="bold">${partInstance.user}</td>
    </tr>
    <tr>
      <td class="small"><g:message code="part.store.label" /></td>
      <td class="bold">${partInstance.store}</td>
    </tr>

  </tbody>
</table>