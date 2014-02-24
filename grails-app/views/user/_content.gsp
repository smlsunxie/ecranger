

<table class="table">
  <tbody>
	<tr>
		<td class="small"><g:message code="user.username.label" /></td>
		<td class="bold"><g:link controller="user" action="show" id="${userInstance.id}" >${userInstance.username}</g:link></td>

	</tr> 
	<tr>
		<td class="small"><g:message code="user.title.label" /></td>
		<td class="bold">${userInstance.title}</td>
	</tr> 
	<tr>
		<td class="small"><g:message code="user.email.label" /></td>
		<td class="bold">${userInstance.email}</td>
	</tr> 	
	<tr>
		<td class="small"><g:message code="user.telphone.label" /></td>
		<td class="bold">${userInstance.telphone}</td>
	</tr> 
	<tr>
		<td class="small"><g:message code="user.mobile.label" /></td>
		<td class="bold">${userInstance.mobile}</td>
	</tr>
    <tr>
      <td class="small"><g:message code="user.enable.label" /></td>
      <td class="bold">${productInstance?.user?.enabled ? "是" : "否"}</td>
    </tr>	    
	<tr>
		<td class="small"><g:message code="user.description.label" /></td>
		<td class="bold">${userInstance.description}</td>
	</tr>



  </tbody>

</table>

