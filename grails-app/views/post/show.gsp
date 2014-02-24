
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">
<title>${post?.title}</title>
</head>
<body>

  <sec:ifAnyGranted roles="ROLE_ADMIN">
    <div class="row" id="actionbar">

      <div class="col-sm-12 col-md-12">           

          <g:link  class="btn btn-primary"  action="edit" id="${post?.id}"><g:message code="default.button.edit.label" /></g:link>


          <g:link  class="btn btn-danger" action="delete" id="${post?.id}"><g:message code="default.button.delete.label" /></g:link>

      </div>

    </div>
  </sec:ifAnyGranted>


  <div class="row show-grid">
      <div class="col-sm-12 col-md-12">                        
        <h1>${post?.title}</h1>

        <g:if test="${productShow}">
          <g:render template="/product/content"  model="['product':productShow.product,'files':productShow.files]" />
        </g:if>

        <div class="markdown-source">${post?.content?.encodeAsHTML()}</div>

%{--                   <disqus:comments bean="${post}" url="${request.scheme}://${request.serverName}${request.forwardURI}" /> --}%
        
        <div class="post-item-panel">
            <ul>
                <li class="date">
                  <p><i class="icon-calendar"></i><g:formatDate date="${post?.lastUpdated}" type="datetime" style="MEDIUM" /></p>
                </li>
                <li>
                  <p><i class="icon-user"></i>by ${post.creator}</p>
                </li>
%{--                 <li>
                  <p>
                    <g:render template="/tag/links" model="['tags':post.tags]" />
                  </p>
                </li> --}%
            </ul>
        </div>
    </div>

                                        
  </div>
  <hr>
  <g:render template="/component/recentPost" model="[recentPosts:recentPosts]"   />     
</body>
</html>
