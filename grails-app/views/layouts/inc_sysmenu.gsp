<li class="${controllerName=='user' && actionName=='show' ? 'active':''} single">
  <g:homeNav />
</li>

<sec:ifAnyGranted roles="ROLE_CUSTOMER, ROLE_OPERATOR, ROLE_MANERGER">
  

  <li class="${controllerName=='part' ? 'active':''} single">
    <g:link elementId="part-index" controller="part" action="index">
      <g:message code="part.label" />
      <i>store</i>
    </g:link>
  </li>

</sec:ifAnyGranted>


<sec:ifAnyGranted roles="ROLE_MANERGER, ROLE_OPERATOR">
  <li class="${controllerName=='summary' ? 'active':''} dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#menu2">
      <g:message code="summary.label"/>
      <i>SUMMARY</i>
    </a>
 
    <ul class="dropdown-menu">

      <li>
        <g:link controller="summary" action="unreceiveMoneyList">
          <g:message code="summary.unreceiveMoney.label"/>
        </g:link>
      </li>

      <sec:ifAnyGranted roles="ROLE_MANERGER">
        <li>
          <g:link controller="summary" action="turnoverYearList">
            <g:message code="summary.turnover.label"/>
          </g:link>
        </li>
      </sec:ifAnyGranted>
      
    </ul>
  </li>
</sec:ifAnyGranted>


<sec:ifAnyGranted roles="ROLE_ADMIN">
  
  <li class="${controllerName=='brand' ? 'active':''} single">
    <g:link controller="brand">
      <g:message code="brand.label" />
      <i>brand</i>
    </g:link>
  </li>

  <li class="${controllerName=='user' && actionName=='index' ? 'active':''} single">
    <g:link controller="user" action="index">
      <g:message code="user.label" />
      <i>user</i>
    </g:link>
  </li>


</sec:ifAnyGranted>


<li class="${controllerName=='store' && actionName=='index' ? 'active':''} single">
  <g:link controller="store" action="index">
    車行清單
    <i>Stores</i>
  </g:link>
</li>

<li class="${controllerName=='post' ? 'active':''} single">
  <g:link controller="post" action="portfolio">
    文章
    <i>POST</i>
  </g:link>
</li>

<sec:ifNotGranted roles="ROLE_ADMIN">
  <li class="${controllerName=='home' && actionName=='question' ? 'active':''} single">
    <g:link controller="home" action="question">
      意見回饋
      <i>suggest</i>
    </g:link>
  </li>
</sec:ifNotGranted>


