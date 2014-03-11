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


<li class="${controllerName=='product' && params.type=="BOOK" ? 'active':''} single">
  <g:link controller="product" action="portfolio" params="[type: 'BOOK']">
    書籍
    <i>BOOK</i>
  </g:link>
</li>

<li class="${controllerName=='product' && params.type=="MUSIC" ? 'active':''} single">
  <g:link controller="product" action="portfolio" params="[type: 'MUSIC']">
    音樂
    <i>MUSIC</i>
  </g:link>
</li>


