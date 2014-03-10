<!DOCTYPE html>
<html>
  <head>
    <title><g:message code="default.home.label"/></title>

  </head>
  <body>




    <div class="portfolio-grid-1 main-block">
      <div class="title-wrapper">
        <h1>書籍</h1>
      </div>
 
      <div id="portfolio" class="row show-grid">                   
        <g:each var="product" in="${productBooks}">
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

    <div class="portfolio-grid-1 main-block">
      <div class="title-wrapper">
        <h1>音樂</h1>
      </div>
 
      <div id="portfolio" class="row show-grid">                   
        <g:each var="product" in="${productMusics}">
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



  </body>
</html>
