<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">
<title>search</title>
</head>
<body>

  <div class="row text-center" id="actionbar">

    <div class="col-sm-12 col-md-12">           

        <g:link  class="btn btn-primary" controller="product" action="create" params="[name: params.q]" >以 ${params.q} 建立產品</g:link>


    </div>

  </div>
  <div class="row show-grid features-block mini-blocks">
    <g:each in="${searchResult?.results}" var="productInstance" status="i" >


      <div class="contact-info col-sm-4 col-md-4 block2">
        <div class="mini-wrapper">

        <g:render template="/product/content" model="[productInstance: productInstance]" />

        </div>
      </div>


    </g:each>
  </div>


  <g:if test="${searchResult?.results}"> <!-- or you could use test="${searchResult?.results}" -->

    <div class="row text-center">
      <ul class="pagination">

        <g:paginate action="query" params="[q: params.q]" total="${searchResult.total}" prev="&lt; previous" next="next &gt;"/>
      <ul>   


    </div>

  </g:if>
  <g:else>
    <div class="row text-center">
        查無資料

    </div>  
  </g:else>


</body>
</html>