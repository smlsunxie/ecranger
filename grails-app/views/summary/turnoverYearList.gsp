
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<g:set var="entityName" value="${message(code: 'post.label', default: '文章')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>


</head>
<body>

<div class="container">

                  <div class="row">
                    <table class="table">
                        <thead>
                          <tr>
                            <th>年度</th>
                            <th>總金營業額</th>
                            <th>總成本</th>
                            <th>總固定成本</th>
                            <th>總利潤</th>


                          </tr>
                        </thead>
                        <tbody>
                            <g:each in="${resultList}" var="result" status="i">

                                <tr>

                                    <td><g:link controller="summary" action="turnoverMonthList" params="[year:result.year]">${result.year}</g:link></td>
                                    <td>${result.totalMoney}</td>  
                                    <td>${result.totalCost}</td> 
                                    <td>${result.totalStoreCost}</td>  
                                    <td>${result.totalMoney-result.totalCost-result.totalStoreCost}</td>  

                                  </tr>

                            </g:each>

                        </tbody>
                    </table>                    
                  </div>



</div>
</body>
</html>
