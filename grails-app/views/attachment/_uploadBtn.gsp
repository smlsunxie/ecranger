  <div class="controls">
    <div  class="row" >
      <ul>
        <li>
          如果您是使用手機操作，你可以照相之後點選下方「上傳檔案」。
        </li>
        <li>
          如果您是使用手機操作，並且使用 iOS7+ 以及 android 4.1+ 手機版 chrome，也可以點選「上傳檔案」直接拍照後上傳，注意：拍攝時請將手機橫置拍攝，使用說明請參考:<g:link action="show" controller="post" id="10">手機拍照上傳照片說明</g:link>。
        </li>        
        <li>
          如果你是用電腦操作，你可點選「上傳檔案」選取照片，也可以拖拉多筆到「上傳檔案」按鈕上新增。
        </li>
        <li id="webcamCtrlDiv">
          如果你有 Web Cam (電腦用攝影機)，點選瀏覽器上方允許使用相機後，按「攝影照相」會擷取影像， 確定沒問題在點選 「照片上傳」。
        </li>
        <li>
          最後，你可以挑選你上傳的其中之一個照片作為主要顯示。
        </li>        
      </ul>
    </div>
    <div  class="row" >
      

      <div  class="col-sm-4 col-md-4" >

        <uploader:uploader multiple="false" debug="true" id="fileupload" url="${[controller:'attachment', action:'save']}" params='[name:name, domainName: domainName]' >
          <uploader:onComplete>
            displayList();
          </uploader:onComplete>
        </uploader:uploader>

      </div>

      <div id="webcamCtrlDiv"  class="hidden-xs hidden-sm"  >
        <div  class="col-sm-2 col-md-2" >
          <input type="button" style="height: 35px;" id="shapshot" name="shapshot" value="攝影照像">
        </div>
        <div  class="col-sm-2 col-md-2" >
          <input type="button" style="height: 35px;" id="uploadShapshot" name="uploadShapshot" value="照片上傳">
        </div>
      </div>
    </div>

  </div>  
  <hr/>

  <div id="webcamViewDiv" class="row hidden-xs hidden-sm" >
    <video id='video' class="col-sm-6 col-md-6 thumbnail" autoplay></video>
    <canvas id='canvas' class="col-sm-6 col-md-6 thumbnail" height = '225'></canvas>    
  </div>




  <div  class="row">
    <div id="images" class="col-sm-12 col-md-12">
    </div>
  </div>


    <r:script>

      var video = document.getElementById('video');
      var canvas = document.getElementById('canvas');
      
      var localMediaStream = null;

      function snapshot() {
        var ctx = canvas.getContext('2d');
        if (localMediaStream) {
          ctx.drawImage(video, 0, 0, canvas.width, canvas.height);
        }

      }

      function uploadShapshot(){
          var image    = canvas.toDataURL("image/jpeg").replace('data:image/jpeg;base64,', '');

          var fd = new FormData();
          fd.append('image', image);
          fd.append('name', "${name}");
          $.ajax({
              type: 'POST',
              url: '/attachment/SaveBlob',
              data: fd,
              processData: false,
              contentType: false
          }).done(function(data) {
              // print the output from the upload.php script
              displayList();
          }); 
      }

      $("#shapshot").on('click', snapshot);
      $("#uploadShapshot").on('click', uploadShapshot);

      // Not showing vendor prefixes or code that works cross-browser.


      if(navigator && navigator.webkitGetUserMedia){
        navigator.webkitGetUserMedia({video: true}, function(stream) {
          video.src = window.URL.createObjectURL(stream);
          localMediaStream = stream;
        },function(){ // success
          $("#webcamCtrlDiv").css( "display", "none" );
          $("#webcamViewDiv").css( "display", "none" );

        },
        function(){
          $("#webcamCtrlDiv").css( "display", "block" );
          $("#webcamViewDiv").css( "display", "block" );
        });
      }


      var displayList=function(){
        // console.log("displayList function");
        // console.log("isMobile = "+ isMobile());

        <g:remoteFunction controller='attachment' action="list" params="[name:name, mainImage: mainImage, domainName: domainName]" onSuccess="checkDefaultRadioSelected()" update="images" />
      }


      var checkDefaultRadioSelected=function(){
        var hasChecked=false;
        $("#mainImage").each(function() {
          console.log($(this).val());
          if ($(this).is(':checked')) {
            hasChecked = true;
          }
        });
        if(!hasChecked && $("#mainImage").size() > 0){
          $("#mainImage")[0].checked = true;
        }

        console.log("hasChecked ="+ hasChecked);
      }

      $(function() {
        displayList();
      });
    </r:script>
