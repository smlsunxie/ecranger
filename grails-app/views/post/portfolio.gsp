<html>
  <head>
    <title><g:message code="post.edit.title" defualt="修改文章"/></title>


  </head>
  <body>


    <div class="col-wrapper">

<!-- START PORTFOLIO NAV -->                    
        <div class="portfolio-nav">
<!-- SET PORTFOLIO NAV FILTERS HERE -->                     
            <ul id="filters" data-option-key="filter" class="nav nav-pills nav-pills-portfolio">

                <li class="active"><a href="#" data-toggle="pill" data-filter="*">All</a></li>
                <g:each var="tag" in="${tags}">
                    <li><a href="#" data-toggle="pill" data-filter=".${tag}">${tag}</a></li>
                </g:each>

            </ul>

        </div>
    <!-- END PORTFOLIO NAV -->

    <!-- START PORTFOLIO GRID -->                
        <div class="portfolio-grid-1 main-block">
            <div id="portfolio" class="row show-grid">                   

                <g:each var="post" in="${posts}">
                    <div class="col-md-3 col-sm-3 small hp-wrapper element ${post.tags.join(' ')}">        
                        <g:link controller="post" action="show" id="${post.id}"><g:img alt="" dir='bizstrap/img' file="460_arrow_2_hover.png" class="hover-shade" />
                        </g:link>
                        
                         <g:link controller="post" action="show" id="${post.id}"  class="top-link">    
                            <g:render template="mainImg" model="[post:post]" />
                        </g:link>

                        <div class="bottom-block">
                            <g:link controller="post" action="show" id="${post.id}">${post.title}</g:link>
                            <p>${post.description}</p>
                        </div>
                    </div>
                </g:each>
            </div>
        </div>
    </div>                 
  </body>
</html>
