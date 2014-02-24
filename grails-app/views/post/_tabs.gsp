            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#setup" data-toggle="tab">設置</a></li>
              <li class=""><a href="#imagesTab" data-toggle="tab">圖片</a></li>
              <li class=""><a href="#content" data-toggle="tab">編輯</a></li>
              <li class=""><a href="#preview" data-toggle="tab">預覽</a></li>

            </ul>
            <div id="myTabContent" class="tab-content">
              
              <div class="tab-pane fade in active" id="setup">

              %{-- form --}%
                <div class="form-group ${hasErrors(bean: post, field: 'name', 'has-error')}">
                  <label for="name" class="col-sm-2 control-label">
                    <g:message code="post.name.label" />
                    <span class="required-indicator">*</span>
                  </label>
                  <div class="col-sm-10">
                    <g:textField name="name" value="${post?.name}" class="form-control" />
                  </div>
                </div>


                <div class="form-group ${hasErrors(bean: post, field: 'title', 'has-error')}">
                  <label for="title" class="col-sm-2 control-label">
                    <g:message code="post.title.label" />
                    <span class="required-indicator">*</span>
                  </label>
                  <div class="col-sm-10">
                    <g:textField name="title" value="${post?.title}" class="form-control" />
                  </div>
                </div>


                <div hidden class="form-group ${hasErrors(bean: post, field: 'type', 'has-error')}">
                  <label for="type" class="col-sm-2 control-label">
                    <g:message code="post.type.label" />
                    <span class="required-indicator">*</span>
                  </label>
                  <div class="col-sm-10">
                    <g:select name="type" from="${motoranger.PostType?.values()}" keys="${motoranger.PostType.values()*.name()}" required="" value="${post?.type?.name()}"  valueMessagePrefix="PostType" class="form-control"  />
                  </div>
                </div>

                <div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">
                    <g:message code="default.tags.label" />
                  </label>
                  <div class="col-sm-10">
                    <ul name="tags" id='tag-field' >
                      <g:each in="${post.tags}">
                        <li>${it}</li>
                      </g:each>
                    </ul>
                  </div>

                </div>


                <div class="form-group ${hasErrors(bean: post, field: 'description', 'has-error')}">
                  <label for="description" class="col-sm-2 control-label">
                    <g:message code="post.description.label" />
                    <span class="required-indicator">*</span>
                  </label>
                  <div class="col-sm-10">
                    <g:textField name="description" value="${post?.description}" class="form-control" />
                  </div>
                </div>
                

              </div>

              %{-- 編輯區域 tab --}%
              <div class="tab-pane fade" id="content">

                <div class="row">
                  <div class="col-sm-12 col-md-12">
                    <div class="wmd-panel wmd-editor">
                        <div id="wmd-button-bar"></div>
                        <g:textArea name="content" cols="40" rows="20" value="${post?.content}" class="wmd-input enable-tabkey" id="wmd-input" />
                    </div>                    
                  </div>

                </div>






              </div>

              %{-- preview tab --}%
              <div class="tab-pane fade" id="preview">
                <div id="wmd-preview" class="wmd-panel wmd-preview"></div>


              </div>

              %{-- 圖片 tab --}%
              <div class="tab-pane fade" id="imagesTab">

                <div class="row">

                    <g:render template="/attachment/uploadBtn" model="[name:post.name ,mainImage: post?.mainImage, domainName: 'post']" />  
                </div>

              </div>

            </div>

    <r:script>


      $(function() {
        $("ul[name='tags']").tagit({select:true, tagSource: "${g.createLink(controller:'tag',action: 'listAsJson')}"});

      });


    </r:script>
