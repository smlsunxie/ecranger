<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title><g:layoutTitle default="ecranger"/> - 線上 Moto 維修記錄</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon" />
<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}" />
<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}" />

<r:require modules="jquery, jquery-ui, modernizr, common, font-awesome, pagedown, compass, tagit, fileuploader, bootstrap-ext, ie6"/>

<g:layoutHead/>
<r:layoutResources />
<ga:trackPageview />
%{-- <g:justfont /> --}%
%{-- <google:analytics /> --}%
</head>
<body>

  <div id="load" style="position:fixed; top:0; left:0; right:0; bottom:0; background:#fff; z-index:999999;"><span></span></div>
  

  
  <div class="container"></div>
  
  <div id="over">
    <div id="out_container">
      <div class="top_line"></div>
      
      <header>
        <g:applyLayout name="inc_header" />
      </header>


      <div class="main-content">
        <%--GoogleChromeFrame--%>
        <g:render template="/layouts/alert_chromeframe" />

      	<%--主畫面內容--%>
        <div class="container">
          <g:render template="/layouts/navbar" />


          <g:layoutBody/>

        </div>
      </div>
      
      <footer id="footer">
        
        <g:footer /> 
        

        <div class="footer-bottom">
          <div class="container">
            <div class="row show-grid">
              <div class="col-sm-12 col-md-12">
                <p>Template by bizstrap power by <a href="http://ccws.co">ccws</a></p>

              </div>
            </div>
          </div>
        </div>
      </footer>



    </div>

  </div>



  <r:script>
  (function () {
    if('${flash.message}'!=='') {
      bootstrap_alert.warning('${flash.message}');
    }
  })();
  </r:script>

  <r:layoutResources />



</body>
</html>
