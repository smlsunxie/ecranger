<html>
  <head>
    <title><g:message code="post.edit.title" defualt="修改文章"/></title>


  </head>
  <body>

    <div class="container">
%{--         <div class="row show-frid">
            <div class="col-sm-12 col-md-12">
                <div id="breadcrumb">
                    <ul>
                        <li class="home"><a href="#">${type}</a></li>
                    </ul>
                </div>
            </div>
        </div> --}%


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
                <ul id="portfolio" class="row thumbnails">                  

                    <g:each var="part" in="${parts}">
                        <li class="col-sm-4 col-md-4 large hp-wrapper element ${part.tags.join(' ')}">        
     


                <div class="thumbnail">
                    
                  <g:img uri="/attachment/show?name=${part.name}&file=${part.mainImage}" style='height:200px' /></a>

                  <div class="caption">
                    <h3><g:link controller="part" action="show" id="${part.id}">${part.title}</g:link></h3>
                    <p>${part.description}</p>
                    <p>售價：${part.price}</p>
                    <p>
                        <a href="#" class="btn btn-primary">加入維修</a> 
                        <a href="#" class="btn">售出</a>
                    </p>
                  </div>
                </div>




      
          
                        </li>
                    </g:each>
                </ul>
            </div>
        </div>                
    </div> 
  </body>
</html>
