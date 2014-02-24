
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="bootstrap">

<g:set var="entityName" value="${message(code: 'product.label', default: '文章')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>


</head>
<body>

  <div class="row show-grid">
      <div class="col-sm-12 col-md-12">                        
          %{-- <div class="row show-grid clear-both"> --}%


              %{-- <div class="span9 main-column two-columns-left "> --}%


								<!-- 如果沒有文章，顯示空白 -->
								<g:if test="${!products}">
									<g:render template="/component/emptyList"/>
								</g:if>

								<g:each in="${products}" var="product" status="i">
									<g:render template="record" model="[product:product]"/>
								</g:each>

								<g:render template="/component/pagination"/>


					  	%{-- </div> --}%

			  	%{-- </div> --}%
	  	</div>

  </div>

</body>
</html>
