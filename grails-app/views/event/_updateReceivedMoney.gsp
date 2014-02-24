

<div class="input-group">

<span class="input-group-addon"><a onclick="recivedAllMoney(${eventInstance.id})" >已付清</a></span>
  <span class="input-group-addon">已收</span>
  <g:remoteField action="updateReceivedMoney" controller="event" id="${eventInstance.id}" name="receivedMoney" onSuccess="onUpdateReceivedMoneySuccess(data)" value="${eventInstance?.receivedMoney.toString()}" class="form-control" data-totalPrice="${eventInstance?.totalPrice}"  type="number" /> 

</div>

