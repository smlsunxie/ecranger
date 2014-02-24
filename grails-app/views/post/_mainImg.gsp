<g:if test="${post.mainImage}">
  <g:img uri="/attachment/show?name=${post.name}&file=${post.mainImage}" class="img-responsive"/>
</g:if>
<g:elseif test="${post?.product?.mainImage}">
  <g:img uri="/attachment/show?name=${post.product.name}&file=${post.product.mainImage}" class="img-responsive" />
</g:elseif>