        <table class="table" id="no-more-tables">
          <thead>
            <tr>
              <th ><g:message code="attachment.mainImage.label" /></th>
              <th ><g:message code="attachment.file.name" /></th>
              <g:if test="${params.domainName == 'post'}">
                <th ><g:message code="attachment.file.link" /></th>
              </g:if>
              <th ></th>
            </tr>
          </thead>
          <tbody>

            <g:each in="${files}" var="file" status="i">
              
              <tr>

                  <td data-title="${message(code: 'attachment.mainImage.label', default: 'mainImage')}">
                    <g:radio name="mainImage" value="${file.name}" checked="${mainImage==file.name  ?'true':''}" />
                  </td>

                  <td data-title="${message(code: 'ttachment.file.name"', default: 'name')}">
                    <g:link action="show" params="[file: file.name, name:name]" target="_blank">${file.name}</g:link>
                  </td>

                  <g:if test="${params.domainName == 'post'}">
                    <td data-title="${message(code: 'attachment.file.link"', default: 'link')}">
                      <g:if test="${['.jpg','.jpeg','.JPG','.JPEG','.gif','.GIF','.png','.PNG'].any{file.name.endsWith(it)}}">
                          ![${file.name}](${createLink(action:'show', params: [file: file.name, name:name])})
                      </g:if>
                    </td>
                  </g:if>

                  <td>
                    <g:remoteLink onSuccess="displayList()" action="delete" params="[name:name, file:file.path]" update="success" class="btn btn-danger btn-xs">${message(code: 'default.button.delete.label', default: '刪除')}</g:remoteLink>
                  </td>

              </tr>

            </g:each>
          </tbody>


