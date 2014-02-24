<!DOCTYPE html>
<html>
  <head>
    <title><g:message code="default.home.label"/></title>

  </head>
  <body>
<!-- MAIN CONTENT AREA: SLIDER BANNER (REVOLUTION SLIDER) -->
  <div class="bannercontainer">
    <div class="banner">
      <ul>
        <!-- MAIN CONTENT AREA: SLIDER BANNER (REVOLUTION SLIDER) - SLIDE 1 [SLIDE
        STYLE=BOXFADE] -->
        <li class="slide1 slide" data-transition="boxfade" data-slotamount="5"
          data-masterspeed="300">
          <g:img dir="bizstrap/img" file="slider01.png" class="img-responsive" />
          <div class="caption sft carousel-caption visible-md visible-lg" data-x="-60" data-y="70" data-speed="1000"
             data-start="1000" data-easing="easeInBack" style="background: none;">
            <p class="middle">立即註冊試用！</p>
          </div>
          <div class="caption sfl carousel-caption" data-x="98" data-y="101" data-speed="1000"
             data-start="1000" data-easing="easeOutBack" style="background: none;">
            <p class="big">Moto Ranger</p>
          </div>                    
          <div class="caption sfl carousel-caption" data-x="98" data-y="151" data-speed="1000"
             data-start="1000" data-easing="easeOutBack" style="background: none;">
            <p class="big">線上摩托維修記錄</p>
          </div>
          <div class="caption sfl carousel-caption" data-x="98" data-y="201" data-speed="1000"
             data-start="1000" data-easing="easeOutBack" style="background: none;">
            <p class="big">不再忘記何時加機油！</p>
          </div>
          <div class="caption sfb carousel-caption visible-md visible-lg" data-x="110" data-y="255" data-speed="1000"
             data-start="1000" data-easing="easeInBack" style="background: none; width: 436px;">
            <p class="middle">自定維修項目，打造屬於你的線上維修車庫</p>
          </div>
        </li>

      </ul>
      <div class="tp-bannertimer"></div>
    </div>
  </div>

  <div class="row main-block">
    <div class="col-sm-12 col-md-12">
      <!-- MAIN CONTENT AREA: REDESIGN CUSTOM - HERO LIST -->
      <div class="row show-grid hero-list features-list">
        <div class="col-sm-3 col-md-3">
          <div class="image-wrapper">
            <g:img dir="bizstrap/img" file="home_grid.png" class="img-responsive" />
          </div>
          <h2>支援眾多瀏覽器</h2>
          <p>建議使用 google chrome，也支援 firefox，若是使用 IE，建議使用 IE 10+ 有較佳的使用體驗
          <a href="http://www.google.com/intl/zh-TW/chrome/browser/">Google Chrome 下載</a>
          </p>
        </div>
        <div class="col-sm-3 col-md-3">
          <div class="image-wrapper">
            <g:img dir="bizstrap/img" file="home_gears.png" class="img-responsive" />
          </div>
          <h2>自定維修記錄</h2>
          <p>每個人常用的維修項目皆不一樣，您可以依你的喜好建立維修項目，並且打上標籤進行分類
          </p>
        </div>
        <div class="col-sm-3 col-md-3">
          <div class="image-wrapper">
            <g:img dir="bizstrap/img" file="home_arrow.png" class="img-responsive" />
          </div>
          <h2>除了個人也可用於店家</h2>
          <p>每次客人都說沒多久前才維修過？使用 Moto Ranger 替你的客戶記錄，最真實的維修歷程
          </p>
        </div>
        <div class="col-sm-3 col-md-3">
          <div class="image-wrapper">
            <g:img dir="bizstrap/img" file="home_arrows.png" class="img-responsive" />
          </div>
          <h2>適用於各種不同裝置</h2>
          <p>無論是桌上型電腦、平板或是手機，皆可使用；讓您隨時隨地拿起身邊的設備就可進行記錄維修項目
          </p>
        </div>
      </div>
    </div>
  </div>

  <g:render template="/component/recentPost" model="[recentPosts:recentPosts]"   />



  <div class="main-block block-posts">
    <div class="title-wrapper">
      <h1><i class="icon-signin"></i> 維修中</h1>
    </div>
    <div class="row show-grid clear-both">
      <div class="col-sm-12 col-md-12">
        <div class="row show-grid">
        
        <g:render template="/event/stickWithImage" model="['stickName':'alert']"
          collection="${unfinEvents}" var="eventInstance"  />
        
        </div>
      </div>
    </div>
  </div>
  
  <hr>
  <div class="main-block block-posts">
    <div class="title-wrapper">
      <h1><i class="icon-ok "></i> 維修完成</h1>
    </div>
    <div class="row show-grid clear-both">
    <div class="col-sm-12 col-md-12">
      <div class="row show-grid">
      <g:render template="/event/stickWithImage" model="['stickName':'success']"
        collection="${endEvents}" var="eventInstance"  />
    </div>
    </div>
  </div>


  <hr>




  </body>
</html>
