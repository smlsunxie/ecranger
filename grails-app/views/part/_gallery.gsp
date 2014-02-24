<g:each var="partInstance" in="${partInstanceList}" >
  <li class="col-md-3 col-sm-3 small hp-wrapper ${partInstance.tags.join(' ')}">  

    <div id="${partInstance.name}" class="thumbnail">
%{--                           <g:img alt="" uri="/attachment/show?name=${partInstance.name}&file=${partInstance.mainImage}" style='height:100px' />  --}%

        <div class="caption">

          <h3><g:link elementId="part-show-${partInstance.name}" controller="part" action="show" id="${partInstance.id}">${partInstance.title}</g:link></h3>
          <p>${partInstance.description}</p>

          <g:if test="${eventInstance}">

            <g:form name="eventDetail-save-${partInstance.name}" action="save" controller="eventDetail" class="form-thumbnail" params="['part.id':partInstance.id, 'part.name':partInstance.name, 'head.id':event.id]"> 
              <p>


                <div class="input-group">
                  <span class="input-group-addon">售價</span>
                  <g:textField value="${partInstance.price}" name="price" class="form-control" />
                </div>

                <div class="input-group">
                  <span class="input-group-addon">數量</span>
                  <g:textField value="1"  name="qty" class="form-control" />
                  <g:textField hidden value=""  name="name" />
                </div>                          
              </p>

              <p>

                  <g:submitButton controller="eventDetail" action="create" class="btn btn-primary" value="快速新增" name="create" />

                  <g:link controller="eventDetail" action="create" params="['part.id':partInstance.id, 'head.id':event.id]" class="btn btn-primary">照相新增</g:link> 
                

              </p>
            </g:form>
          </g:if>

          <g:else>
            <p>售價：${partInstance.price}</p>
            <g:link controller="part" action="show" id="${partInstance.id}" class="btn">檢視項目</g:link>
          </g:else>
        </div>

    </div>
  </li>
</g:each>