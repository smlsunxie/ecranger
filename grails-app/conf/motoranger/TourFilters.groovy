package motoranger

class TourFilters {

    def userService

    def filters = {
        all(controller:'*', action:'*') {
            before = {

            }
            after = { Map model ->

                if(userService.isLoggedIn()){


                    if(session.tourStep.toString().contains("STEP1")){

                        if(session.tourStep == TourStep.STEP1_START && controllerName == "store" && actionName == "show" ){

                            flash.message = "${flash?.message ? flash.message: ''}:歡迎使用 MotoRanger！讓我幫你記錄客戶維修的一切，讓我們從點選下方「新增產品」建置你的第一個客戶摩托開始！"
                        
                        }else if(session.tourStep == TourStep.STEP1_START && controllerName == "user" && actionName == "show" ){

                            flash.message = "${flash?.message ? flash.message: ''}:歡迎使用 MotoRanger！讓我幫你記錄您愛車的一切，讓我們從點選下方「新增產品」建置屬於你的摩托開始！"
                        
                        }else if(session.tourStep == TourStep.STEP1_START && controllerName == "product" && actionName == "show"){
                        
                            flash.message = "${flash?.message ? flash.message: ''}:很好！我們有了第一個摩托，檢查一下資料是否正確，接著你可以點選下方的「新增維修記錄」，開始建立第一個維修記錄"
                        
                        }else if(session.tourStep == TourStep.STEP1_START && controllerName == "event" && actionName == "pickPartAddDetail"){
                            

                            if (params?.group.toString() == motoranger.TagGroup.RECENT.toString()  && !params?.tag) {
                                flash.message = "${flash?.message ? flash.message: ''}:再來我們要挑選維修項目，有使用過的項目會出現在「常用」，您也可以「新增並加入自定維修項目」，或者點選內建的「通用」項目，看看有什麼是您需要的"
                            }else if(params?.group && !params?.tag){
                                flash.message = "${flash?.message ? flash.message: ''}:接著，你可以在點點選標籤分類，將帶出分類中各個維修項目"
                            }else if(params?.group && params?.tag){
                                flash.message = "${flash?.message ? flash.message: ''}:除了標準售價之外，您也可以自定您實際維修的價格，如果想記錄更換的舊零件的照片，可以點選「照相新增」，或者直接「快速新增」"
                            }

                        }else if(controllerName == "eventDetail" && actionName == "save"){
                            session.tourStep=TourStep.STEP1_CREATED_EVENT_DETAIL
                        
                        }else if(session.tourStep == TourStep.STEP1_CREATED_EVENT_DETAIL && controllerName == "event" && actionName == "pickPartAddDetail"){
                            
                            flash.message = "${flash?.message ? flash.message: ''}:你可以在接著新增別的維修項目，或者可以現在或是稍後在透過點選「維修完成」，完成此次記錄"

                        }else if(session.tourStep == TourStep.STEP1_CREATED_EVENT_DETAIL && controllerName == "event" && actionName == "update" && params?.status == "END"){

                            session.tourStep = TourStep.STEP1_UPDATED_EVENT_STATUS_END

                        }else if(session.tourStep == TourStep.STEP1_UPDATED_EVENT_STATUS_END && (controllerName == "user" || controllerName == "store") && actionName == "show" ){

                            flash.message = "${flash?.message ? flash.message: ''}:太棒了！您完成了一筆維修記錄，可以點選下方的產品連結看看結果或「新增維修項目」，讓 MotoRanger 跟著您的摩托一起成長！"
                            session?.tourStep = TourStep.STEP2_START
                            def user = User.get(userService.currentUser().id)
                            user.tourStep = session?.tourStep
                            user.save()

                        }
                    }
                }

            }
            afterView = { Exception e ->

            }
        }
    }
}
