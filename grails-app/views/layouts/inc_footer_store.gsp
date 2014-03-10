


<div class="footer-top"></div>
<div class="footer-wrapper">
  <div class="container">
    <div class="row show-grid">
      <div class="col-sm-12 col-md-12">
        <div class="row show-grid">
          <div class="col-sm-4 col-md-4">

            <address hidden class="address">
              <p>
                <i class="icon-map-marker icon-large"></i>
                ${store?.address}
              </p>
            </address>

            <div class="footer-center">
              <h4 class="center-title">聯絡我們</h4>
              <p>對系統有任何建議歡迎來信</p>
              <p><i class="icon-envelope"></i>
                Mail:<a class="btn btn-inverse btn-xs" href="mailto:smlsun@gmail.com?subject=ecranger-意見回饋"> smlsun@gmail.com</a></p>
            </div>
          </div>

          <div class="col-sm-4 col-md-4 footer-center">
            <h4 class="center-title">聯絡店家</h4>
            <p><i class="icon-map-marker"></i>地址：${store?.address}</p>
            <p><i class="icon-phone"></i>電話：${store?.telphone}</p>
            <p><i class="icon-mobile-phone icon-large"></i>行動：${store?.mobile}</p>
            <p><i class="icon-print"></i>傳真：${store?.fax}</p>
            <p><i class="icon-envelope"></i>
              Email:<a class="btn btn-inverse btn-xs" href="${store?.email}"> ${store?.email}</a></p>
          </div>

          <div class="col-sm-4 col-md-4 footer-right">
            <h4 class="center-title">連結</h4>
            <ul class="footer-navigate">
              <g:applyLayout name="inc_sysmenu" />
            </ul> 
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


