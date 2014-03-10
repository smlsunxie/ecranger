<div id="productStick" class="col-sm-6 col-md-3">

  <a class="block-stick-img">

      <g:img uri="/attachment/show?name=${productInstance.name}&file=${productInstance.mainImage}"  class="img-thumbnail" />

  </a>

  <g:render template="/product/stick" model="['stickName': stickName]" />
  

</div>
