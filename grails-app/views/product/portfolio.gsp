<html>
  <head>
    <title><g:message code="post.edit.title" defualt="修改文章"/></title>
  </head>
  <body>


<div class="visible-xs" >
  <div class="btn-group" id="actionbar">
    <button class="btn btn-default btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
      ${params.tag ? params.tag : '全部'}<span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
      <li>
        <g:link elementId="tag-show-all" action="${actionName}" params="[type: params.type]" >全部</g:link>
      </li>
      <g:each var="tag" in="${tags}" status="i">
        <li>
          <g:link elementId="tag-show-${i}" action="${actionName}" params="[tag: tag, type: params.type]" >${tag}</g:link>
        </li>
      </g:each>
    </ul>
  </div>
</div>


<div class="hidden-xs">
  <div class="portfolio-nav">
                
    <ul data-option-key="filter" class="nav nav-pills nav-pills-portfolio">
      <li class="${ !params?.tag ? 'active' : '' }">
        <g:link elementId="tag-show-all" action="${actionName}" params="[type: params.type]">全部</g:link>
      </li>    
      <g:each var="tag" in="${tags}" status="i">
        <li class="${ params.tag == tag.toString() ? 'active' : '' }">
          <g:link elementId="tag-show-${i}" action="${actionName}"  params="[tag: tag, type: params.type]" >${tag}</g:link>
        </li>
      </g:each>
    </ul>
  </div>
</div>



  <div class="portfolio-grid-1 main-block">
    <div id="portfolio" class="row show-grid">                   
      <g:each var="product" in="${products}">
        <div class="col-md-3 col-sm-3 small hp-wrapper element}">        
          <g:link controller="product" action="show" id="${product.id}"><g:img alt="" dir='bizstrap/img' file="460_arrow_2_hover.png" class="hover-shade" />
          </g:link>
          
           <g:link controller="product" action="show" id="${product.id}"  class="top-link">    
              <g:img uri="/attachment/show?name=${product.name}&file=${product.mainImage}" class="img-responsive"/>
          </g:link>

          <div class="bottom-block">
              <g:link controller="product" action="show" id="${product.id}">${product.title}</g:link>
              <p>${product.description}</p>
          </div>
        </div>
      </g:each>
    </div>
  </div>



%{--   <div class="row text-center">
    <ul class="pagination">
      <g:paginate action="query" params="[q: params.q]" total="${searchResult.total}" prev="&lt; previous" next="next &gt;"/>
    <ul>   

  </div> --}%



  </body>
</html>
