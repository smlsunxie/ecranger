<div class="input-group">

  %{-- <span class="input-group-addon"><a onclick="discountAllMoney(${event.id})" >全優惠</a></span> --}%
  <span class="input-group-addon">未收</span>
  <g:remoteField action="updateDiscountMoney" controller="event" id="${eventInstance.id}" name="unreceiveMoney" onSuccess="onUpdateUnreciveMoneySuccess(data)" value="${(eventInstance?.totalPrice-eventInstance?.receivedMoney-eventInstance?.discountMoney).toString()}" class="form-control" type="number" data-totalPrice="${eventInstance?.totalPrice}"  />
</div>
