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
      <td class="small"><g:message code="user.title.label" /></td>
      <td class="bold"><g:link action="show" controller="user" id="${productInstance?.user?.id}">${productInstance?.user?.title}</g:link> ${productInstance?.user?.enabled ? "(已啟用)" : ""}</td>
    </tr>
    <tr>
      <td class="small"><g:message code="product.brand.label" /></td>
      <td class="bold">${productInstance.brand}</td>
    </tr>    

    <tr>
      <td class="small"><g:message code="product.cc.label" /></td>
      <td class="bold">${productInstance.cc}</td>
    </tr>      
    <tr>
      <td class="small"><g:message code="product.mileage.label" /></td>
      <td class="bold">${productInstance.mileage}</td>
    </tr>
    <tr>
      <td class="small"><g:message code="product.years.label" /></td>
      <td class="bold"><g:formatDate format="yyyy" date="${productInstance.years}"/></td>
    </tr>

    <tr>
      <td class="small"><g:message code="product.totalUnreceiveMoney.label" /></td>
      <td class="bold">${productInstance?.events ? productInstance?.events?.totalPrice?.sum()-productInstance?.events?.receivedMoney?.sum():"0"}</td>
    </tr>


    <tr>
      <td class="small"><g:message code="default.description.label" /></td>
      <td class="bold">${productInstance.description}</td>
    </tr>

    </tbody>

  </table>




  


