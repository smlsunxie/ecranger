        <g:if test="${eventInstance.status == motoranger.ProductStatus.UNFIN}">
          <g:link elementId="event-update-statusEnd-${eventInstance.name}"
            class="btn btn-success" action="update" controller="event" id="${eventInstance.id}" params="[status:motoranger.ProductStatus.END.name()]" >
            <g:message code="ProductStatus.END" />
          </g:link>
        </g:if>
        <g:elseif test="${eventInstance.status == motoranger.ProductStatus.END}">
          <g:link
            class="btn btn-danger" action="update" controller="event" id="${eventInstance.id}" params="[status:motoranger.ProductStatus.UNFIN.name()]" >
            <g:message code="ProductStatus.UNFIN" />
          </g:link>
        </g:elseif>