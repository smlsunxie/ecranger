<g:set var="s3Service" bean="s3Service"/>
<div class="row">

  <div class="contact-info col-sm-4 col-md-4">
    <h2>外觀</h2>
    <g:img uri="/attachment/show?name=${productInstance.name}&file=${productInstance.mainImage}"  class="img-thumbnail" />
  </div>
  <div class="contact-info col-sm-4 col-md-4">
    <h2>產品資料</h2>
    <g:render template="/product/content" />
  </div>

</div>

