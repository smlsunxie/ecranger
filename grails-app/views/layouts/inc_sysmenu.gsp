<li class="${controllerName=='user' && actionName=='show' ? 'active':''} single">
  <g:homeNav />
</li>


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


<li class="${controllerName=='post' ? 'active':''} single">
  <g:link controller="post" action="portfolio">
    書籍
    <i>POST</i>
  </g:link>
</li>


<li class="${controllerName=='post' ? 'active':''} single">
  <g:link controller="post" action="portfolio">
    聖經
    <i>POST</i>
  </g:link>
</li>


