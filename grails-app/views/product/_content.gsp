  <table class="table">
    <tbody>
    <tr>
      <td class="small"><g:message code="product.name.label" /></td>

      <td class="bold"><g:link elementId="product-show-${productInstance.name}" action="show" controller="product" id="${productInstance.id}">
        ${productInstance.name}
      </g:link></td>

    </tr>

    <tr>
      <td class="small"><g:message code="product.title.label" /></td>
      <td class="bold">${productInstance.title}</td>
    </tr>


    <tr>
      <td class="small"><g:message code="default.description.label" /></td>
      <td class="bold">${productInstance.description}</td>
    </tr>

    </tbody>

  </table>




  


