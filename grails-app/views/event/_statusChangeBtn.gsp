        <g:if test="${eventInstance.status == ecranger.ProductStatus.UNFIN}">
          <g:link elementId="event-update-statusEnd-${eventInstance.name}"
            class="btn btn-success" action="update" controller="event" id="${eventInstance.id}" params="[status:ecranger.ProductStatus.END.name()]" >
            <g:message code="ProductStatus.END" />
          </g:link>
        </g:if>
        <g:elseif test="${eventInstance.status == ecranger.ProductStatus.END}">
          <g:link
            class="btn btn-danger" action="update" controller="event" id="${eventInstance.id}" params="[status:ecranger.ProductStatus.UNFIN.name()]" >
            <g:message code="ProductStatus.UNFIN" />
          </g:link>
        </g:elseif>