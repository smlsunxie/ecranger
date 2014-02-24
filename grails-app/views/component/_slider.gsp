

<g:if test="${files.size()>0}">
  <div id="carousel-generic" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">

      <g:each in="${files}" var="file" status="i">
        <li data-target="#carousel-generic" data-slide-to="${i}" class="${i == 0 ? 'active' : ''}"></li>
      </g:each>  

    </ol>
    <div class="carousel-inner">

      <g:each in="${files}" var="file" status="i">
        <div class="item ${i == 0 ? 'active' : ''}">
          <img alt="" src="/attachment/show?name=${name}&file=${file.name}" />
        </div>
      </g:each>  

    </div>
    <a class="left carousel-control" href="#carousel-generic" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-generic" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
  </div>




</g:if>

