<g:set var="stickName" value="${eventInstance.status == motoranger.ProductStatus.UNFIN? 'alert' : 'success'}" />

<div class="row">
  <div id="eventStick" class="contact-info col-sm-3 col-md-3"> 

  	<g:render template="/event/stick" model="['stickName': stickName]" /> 
  
  </div>
  <div id="eventContentTable" class="contact-info col-sm-3 col-md-3"> 
  	<h2>&nbsp;</h2>
    <g:render template="/event/content" />
  </div>

  <div class="contact-info col-sm-6 col-md-6">  
    <g:render template="/eventDetail/contentWithDetails" />
  </div>
</div>