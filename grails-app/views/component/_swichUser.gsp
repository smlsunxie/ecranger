        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#menu3">
            切換作業員
            <i>Switch</i>
          </a>

          <ul class="dropdown-menu">
            <g:each in="${operators}" var="operator">
              <li>
                <g:link controller="login" action="switchUser" params="[username: operator.username]" >
                    ${operator}
                </g:link>
              </li>

            </g:each>
          </ul>
        </li>