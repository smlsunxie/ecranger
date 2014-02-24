package motoranger

import org.springframework.dao.DataIntegrityViolationException

class StoreCostDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [storeCostDetailInstanceList: StoreCostDetail.list(params), storeCostDetailInstanceTotal: StoreCostDetail.count()]
    }

    def create() {
        [storeCostDetailInstance: new StoreCostDetail(params)]
    }

    def save() {
        def storeCostDetailInstance = new StoreCostDetail(params)
        if (!storeCostDetailInstance.save(flush: true)) {
            render(view: "create", model: [storeCostDetailInstance: storeCostDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), storeCostDetailInstance.id])
        redirect(action: "show", id: storeCostDetailInstance.id)
    }

    def show(Long id) {
        def storeCostDetailInstance = StoreCostDetail.get(id)
        if (!storeCostDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), id])
            redirect(action: "list")
            return
        }

        [storeCostDetailInstance: storeCostDetailInstance]
    }

    def edit(Long id) {
        def storeCostDetailInstance = StoreCostDetail.get(id)
        if (!storeCostDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), id])
            redirect(action: "list")
            return
        }

        [storeCostDetailInstance: storeCostDetailInstance]
    }

    def update(Long id, Long version) {
        def storeCostDetailInstance = StoreCostDetail.get(id)
        if (!storeCostDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (storeCostDetailInstance.version > version) {
                storeCostDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'storeCostDetail.label', default: 'StoreCostDetail')] as Object[],
                          "Another user has updated this StoreCostDetail while you were editing")
                render(view: "edit", model: [storeCostDetailInstance: storeCostDetailInstance])
                return
            }
        }

        storeCostDetailInstance.properties = params

        if (!storeCostDetailInstance.save(flush: true)) {
            render(view: "edit", model: [storeCostDetailInstance: storeCostDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), storeCostDetailInstance.id])
        redirect(action: "show", id: storeCostDetailInstance.id)
    }

    def delete(Long id) {
        def storeCostDetailInstance = StoreCostDetail.get(id)
        if (!storeCostDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            storeCostDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'storeCostDetail.label', default: 'StoreCostDetail'), id])
            redirect(action: "show", id: id)
        }
    }

    def copyPreviousMonthCostDetail(){
        def nowDate = new Date()
        params.year = nowDate.year+1900
        params.currentMonth=  params.currentMonth.toInteger()


        def query=StoreCostDetail.where{
            year(date) == params.year
            month(date) == params.currentMonth
        }


        if(query.list().size() == 0){
            query=StoreCostDetail.where{
                year(date) == params.year
                month(date) == params.currentMonth-1
            }

            def results = query.list()
            results.each { previousMonthCostDetail ->
                def currentMonthCostDetail=new StoreCostDetail()
                currentMonthCostDetail.properties = previousMonthCostDetail.properties
                def newDate=new Date()
                newDate.clearTime()
                newDate.month=params.currentMonth-1

                currentMonthCostDetail.date=newDate
                currentMonthCostDetail.save()

            }
        }else {
            flash.message="本月份已有複製店家固定成本"
        }


        
         redirect(action: "list")


    }
}
