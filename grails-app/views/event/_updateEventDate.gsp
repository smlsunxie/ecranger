<div class="input-group">
  <span class="input-group-addon">維修日期</span>
  <input  type="text" value="${eventInstance?.date.format('yyyy-MM-dd')}" data-date="${eventInstance?.date.format('yyyy-MM-dd')}" data-date-format="yyyy-mm-dd" name="date" class="form-control"/>
</div> 

<r:script>
  $(function() {
    $("[name='date']").datepicker({
        format: "yyyy-mm-dd",
        language: "zh-TW"
    }).on('changeDate', function(ev){

      $.ajax({
        type:'POST',
        data:'date=' + ev.date.valueOf(), 
        url:'/event/updateDate/${eventInstance?.id}',
        success:function(data,textStatus){
          onDateSuccessFun(data);
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){

        }
      });

    });




    var onDateSuccessFun=function(data){
      if(data.success){
        bootstrap_alert.warning("維修日期已改為："+data.date)
      }else {
        bootstrap_alert.warning(data.msg)
      }
    }
  });

</r:script>
