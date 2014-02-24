                                          
<i class="icon-tags"></i>
<g:each status='i' var='tag' in='${tags}'>
  <g:if test='${i>0}'>,</g:if>
  <a href="">${tag}</a>

</g:each>