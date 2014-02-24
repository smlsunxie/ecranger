// 常用字串處理函式
var $ = jQuery;

var trim  = function(s) { return typeof(s)=='string'?s.replace(/^\s+|\s+$/g,""):s; };
var ltrim = function(s) { return typeof(s)=='string'?s.replace(/^\s+/,""):s;       };
var rtrim = function(s) { return typeof(s)=='string'?s.replace(/\s+$/,""):s;       };

var showConfirm=function(){
  return confirm("${message(code: 'default.button.delete.confirm.message')}");
}

// 全螢幕模式切換 Request FullScreen Mode
var requestNativeFullScreen = function(element) {
  if (!element) {
    element = document.documentElement;
  }
    var result = null;
    if (element.requestFullscreen) {
        element.requestFullscreen();
        result = document.fullscreenElement;
    } else if (element.mozRequestFullScreen) {
        element.mozRequestFullScreen();
        result = document.mozFullScreenElement;
    } else if (element.webkitRequestFullscreen) {
        element.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
        result = document.webkitFullscreenElement;
    }
    return result;
};

// 全螢幕模式切換 Cancel FullScreen Mode
var cancelNativeFullScreen = function(element) {
  if (!element) {
    element = document.documentElement;
  }
    var result = null;
    if (document.cancelFullScreen) {
        result = document.fullscreenElement;
        document.cancelFullScreen();
    } else if (document.mozCancelFullScreen) {
        result = document.mozFullScreenElement;
        document.mozCancelFullScreen();
    } else if (document.webkitCancelFullScreen) {
        result = document.webkitFullscreenElement;
        document.webkitCancelFullScreen();
    }
    return result;
};

// CodeMirror 編輯器保存於全域變數
var editors = {};

// CodeMirror 編輯器的全螢幕模式
function setFullScreen(cm, full) {
    var wrap = cm.getWrapperElement();
    if (full) {
        wrap.className += " CodeMirror-fullscreen";
        wrap.style.height = winHeight() + "px";
        document.documentElement.style.overflow = "hidden";
        } else {
        wrap.className = wrap.className.replace(" CodeMirror-fullscreen", "");
        wrap.style.height = "";
        document.documentElement.style.overflow = "";
    }
    cm.refresh();
}

function isFullScreen(cm) {
    return /\bCodeMirror-fullscreen\b/.test(cm.getWrapperElement().className);
}

function winHeight() {
    return window.innerHeight || (document.documentElement || document.body).clientHeight;
}

function recivedAllMoney(id){

  var receivedMoneyElm=$("[id='"+id+"'][name='receivedMoney']");  
  var unreciveMoneyElm=$("[id='"+id+"'][name='unreceiveMoney']");

  var unreciveMoney = parseInt(unreciveMoneyElm.val(), 10);
  var receivedMoney = parseInt(receivedMoneyElm.val(), 10);


  if(unreciveMoney>0){

    receivedMoneyElm.val(unreciveMoney + receivedMoney);
    receivedMoneyElm.keyup();
  
  }

}

function discountAllMoney(id){
  
  var unreciveMoneyElm=$("[id='"+id+"'][name='unreceiveMoney']");

  unreciveMoneyElm.val(0);
  unreciveMoneyElm.keyup();


}


function onUpdateUnreciveMoneySuccess(data){
  
  var unreciveMoneyElm=$("[id='"+data.event.id+"'][name='unreceiveMoney']");

  var unreciveMoney = data.event.totalPrice-data.event.receivedMoney-data.event.discountMoney


  if(data.success){
    bootstrap_alert.warning("未收金額已更新為："+unreciveMoney)
  }else {
    bootstrap_alert.warning(data.msg)

    unreciveMoneyElm.val(unreciveMoney);
  }
}

function onUpdateReceivedMoneySuccess(data){
      var unreciveMoneyElm=$("[id='"+data.event.id+"'][name='unreceiveMoney']");
      var receivedMoney=data.event.receivedMoney;
      var totalPrice=unreciveMoneyElm.attr("data-totalPrice");
      var unreciveMoney=totalPrice-receivedMoney-data.event.discountMoney;

      if(data.success){
       

        if(unreciveMoney<0)unreciveMoney=0;

        unreciveMoneyElm.val(unreciveMoney);

        bootstrap_alert.warning("已收金額已更新為："+data.event.receivedMoney)
      }else {

        var receivedMoneyElm=$("[id='"+data.event.id+"'][name='receivedMoney']");
        receivedMoneyElm.val(data.event.receivedMoney)

        bootstrap_alert.warning(data.msg)
        unreciveMoneyElm.val(unreciveMoney);
      }
}

var bootstrap_alert = function() {};
bootstrap_alert.warning = function(message) {
  // $('#alert_placeholder').html(
  //   '<div class="alert alert-info">'+
  //     '<button data-dismiss="alert" class="close" data-dismiss="alert">&times;</button>'+
  //     '<h2>message</h2>'+
  //     '<span>'+message+'</span>'+
  //   '</div>')
  $('#alert_placeholder').html(
      '<span class="bold" >'+message+'</span>'+
    '</div>')

};


// var isMobile = function(){
//   if (useragent.indexOf("iPhone") != -1 
//     || useragent.indexOf("Android") != -1 
//     || useragent.indexOf("Blackberry") != -1 
//     || useragent.indexOf("Mobile") != -1 && useragent.indexOf("iPad") == -1) {
//     return true;
//   }else {
//     return false;
//   }

// }

(function () {

    //tags 處理



    //Markdown 顯示處理
    if (Markdown) {
        var converter = new Markdown.Converter();
        $('.markdown-source').each(function(index) {
            var _this = $(this);
            _this.html(converter.makeHtml(_this.text()));
            _this.show();

            $(".markdown-source img").each(function(){
              $(this).addClass('img-responsive');
            });
        });
        
        //Markdown 編輯處理
        
        converter = Markdown.getSanitizingConverter();

        converter.hooks.chain("preConversion", function (text) {
            return text.replace(/\b(a\w*)/gi, "*$1*");
        });

        converter.hooks.chain("plainLinkText", function (url) {
            return "This is a link to " + url.replace(/^https?:\/\//, "");
        });

        var help = function () { alert("Do you need help?"); }


        $('.wmd-editor').each(function(index) {
            var editor = new Markdown.Editor(converter, $(this).data('suffix'));
            editor.run();
        });



            
        
        
        // var editor = new Markdown.Editor(converter, '.wmd-editor', { handler: help });
        
        // editor.run();



    }

    var $window = $(window);
    
    var __codecanaan_fullscreen = null;
    
    //實作全螢幕機制
    var isDocumentFullScreen = function() {
        if ( document.fullscreenElement ||    // alternative standard method
             document.mozFullScreenElement ||
             document.webkitFullscreenElement ||
             __codecanaan_fullscreen) {  // current working methods
             return true;
         }
         return false;
    }

    if (!window.opener) {
        $('.document-request-fullscreen').click(function() {
        
            if (!isDocumentFullScreen()) {
                if (requestNativeFullScreen) {
                    if (!requestNativeFullScreen()) {
                        //open window
                        if ($(this).is('a')) {
                            __codecanaan_fullscreen = window.open($(this).attr('href'),'__codecanaan_fullscreen','fullscreen=yes,top=0,left=0,width='+screen.width+',height='+screen.height+',location=no,menubar=no,resizable=no,scrollbars=no,titlebar=no,toolbar=no,status=no',false);
                            __codecanaan_fullscreen.moveTo(0, 0);
                            __codecanaan_fullscreen.focus();
                        }

                    }
                }
            
            }
            else {
                if (cancelNativeFullScreen) {
                    if (!cancelNativeFullScreen()) {
                        if (__codecanaan_fullscreen) {
                            __codecanaan_fullscreen.close();
                            __codecanaan_fullscreen = null;
                        }
                    }
                }
            }
        });
    }
    else {
        $('.document-request-fullscreen').click(function() {
            window.opener.$('.document-request-fullscreen').trigger('click');
        });
    }

  //部份內容全螢幕
  $('.element-request-fullscreen').click(function() {
    if (requestNativeFullScreen) {
      var elementId = $(this).data('element');
      var element = document.getElementById(elementId);
      if (element) {
        if (requestNativeFullScreen(element)) {
          return false;
        }
      }
    }
  });

    // Enable loadmask
    $('a.auto-loadmask, .auto-loadmask a').click(function() {
        //$('body').append('<div class="modal-backdrop"></div>');
        $('<div class="modal"><div class="modal-body"><i class="icon-spinner icon-spin"></i> Loading...</p></div></div>').modal();
    });
    
    // Fix for textarea "TAB" keydown
    $('textarea.enable-tabkey').tabby({tabString:'    '});

    // Tooltips
    $('[rel=tooltip]').tooltip();
 
    // 字型調整按鈕，允許變更 justfont 區域的字型大小
    // $('#jfontsize-m').click(function() {
    //     $('.justfont').addClass('smaller-font').removeClass('larger-font');
    // });
    // $('#jfontsize-d').click(function() {
    //     $('.justfont').removeClass('smaller-font').removeClass('larger-font');
    // });
    // $('#jfontsize-p').click(function() {
    //     $('.justfont').removeClass('smaller-font').addClass('larger-font');
    // });

  // Hightlight.js only support MSIE 9+ and other modern browsers
  // if (!$.browser.msie || ($.browser.msie && $.browser.version.slice(0,1)>8)) {
  //  //Pretty Code with Highlight.js
 //        if (hljs) {
 //            hljs.tabReplace = '    '; //4 spaces
 //            hljs.initHighlightingOnLoad();
 //        }
  // }

    //Affix Sidebar
    $('.bs-docs-sidenav').affix({
        offset: {
            top: function () { return $window.width() <= 980 ? 100 : 20 },
            bottom: 270
        }
    });


})();
