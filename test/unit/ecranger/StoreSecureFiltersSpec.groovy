	package ecranger

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import org.junit.*
/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(StoreController)
@Mock([User, Store, Product, Event, UserService, StoreSecureFilters])
class StoreSecureFiltersSpec extends Specification {

    def setup() {
		User.metaClass.encodePassword = {
			password = 'password'
		}

	    UserService.metaClass.isCustomer = {
        	false
        }	
	    UserService.metaClass.isManerger = {
        	true
        }
	    UserService.metaClass.isAdmin = {
        	false
        }
		def storeA = new Store(name: "storeA", title: "storeA").save(failOnError: true)
		def userA = new User(username: 'userA', title: 'userA', password:'pass'
			, enabled: true, store: storeA).save(failOnError: true)
		def storeB = new Store(name: "storeB", title: "storeB").save(failOnError: true)

		def productA = new Product(name: "productA", title: "productA", user: userA).save(failOnError: true)
		def productB = new Product(name: "productB", title: "productB", user: userA).save(failOnError: true)

		def eventA = new Event(name: 'eventA', date: new Date(), product: productA, user: userA, store: storeA).save(failOnError: true)
		def eventB = new Event(name: 'eventB', date: new Date(), product: productB, user: userA, store: storeA
			, status: ecranger.ProductStatus.END).save(failOnError: true)

	    UserService.metaClass.currentUser = {
        	userA
        }
    	
    }

    def cleanup() {
    }

    void "使用者為 ROLE_MANERGER 不可維護不屬於自己的店家"() {
    	setup: "取得相關 domain 實體，並且設定 params.id"

			def userA = User.findByUsername('userA')
			def storeB = Store.findByName('storeB')
			params.id = storeB.id.toString()


    	when: "屬於 storeA 的 user 進行 edit storeB 時透過 filter 檢查"
    		response.reset()
	    	withFilters(controller:"store",action:"*") {
			    controller.edit(storeB)
			}
		then: "storeA 的 user 不可修改 storeB"
			assert flash.message == "只可維護自己的店家"
			

    	when: "屬於 storeA 的 user 進行 delete storeB 時透過 filter 檢查"
    		response.reset()
	    	withFilters(controller:"store",action:"*") {
			    controller.delete(storeB)
			}
		then: "storeA 的 user 不可刪除 storeB"
			assert flash.message == "只可維護自己的店家"
			


    	when: "屬於 storeA 的 user 更新 storeB 時透過 filter 檢查"
    		response.reset()
	    	withFilters(controller:"store",action:"*") {
			    controller.update(storeB)
			}
		then: "storeA 的 user 不可更新 storeB"
			assert flash.message == "只可維護自己的店家"
			

    }

    void "使用者為 ROLE_MANERGER 可以維護自己的店家"() {
    	setup: "取得相關 domain 實體，並且設定 params.id"
			def userA = User.findByUsername('userA')
			def storeA = userA.store
			params.id = storeA.id.toString()


    	when: "屬於 storeA 的 user 修改 storeA 時透過 filter 檢查"
    		response.reset()
	    	withFilters(controller:"store",action:"*") {
			    controller.edit(storeA)
			}
		then: "storeA 的 user 可修改 storeA"
			assert !response.redirectedUrl


    	when: "屬於 storeA 的 user 刪除 storeA 時透過 filter 檢查"
    		response.reset()
	    	withFilters(controller:"store",action:"*") {
			    controller.delete(storeA)
			}
		then: "storeA 的 user 可刪除 storeA"
			assert flash.message == 'default.deleted.message'
			assert response.redirectedUrl=="/home/redirect"


    	when: "屬於 storeA 的 user 更新 storeA 時透過 filter 檢查"
    		response.reset()
	    	withFilters(controller:"store",action:"*") {
			    controller.update(storeA)
			}
		then: "storeA 的 user 可更新 storeA"
			assert flash.message == 'default.updated.message'

    }

    /*
    * 此測試目前沒辦法驗證 
    * @link http://stackoverflow.com/questions/20928797/how-to-unit-test-a-grails-after-filter-that-updates-the-model
    */
    @Ignore
    void """
    	當檢視 store 進行 show 的時候，filter 要新增 currentUserIsEventOwner 以及 eventDetailTotalPrice 
    	分別標示可否編輯 event 以及是否可以看到總金額
    	""" (){

    	setup: "取得相關 domain 實體，並且設定 params.id"     
			def storeA = Store.findByName('storeA')
			params.id = storeA.id.toString()

		when: "userA 進行檢視 show storeA"
		    response.reset()
	    	withFilters(controller: "store",action: "*") {
			    controller.show(storeA)
			}
		then: """model unfinEvents, endEvents 各有一個 event, 
			並且 filter 加入另外兩個 model 分別為 currentUserIsEventOwner 以及 eventDetailTotalPrice
			"""

			assert model.unfinEvents
			assert model.endEvents
			// assert model.currentUserIsEventOwner
			// assert model.eventDetailTotalPrice


    }

    void """
    	當檢視 store 進行 show 的時候，使用 filter 要能夠成功通過
    	""" (){
    	setup: "取得相關 domain 實體，並且設定 params.id"      
			def storeA = Store.findByName('storeA')
			params.id = storeA.id.toString()

		when: "userA 進行檢視 show storeA"
		    response.reset()
	    	withFilters(controller: "store",action: "*") {
			    controller.show(storeA)
			}
		then: """
			model unfinEvents, endEvents 各有一個 event, 
			並且 filter 加入另外兩個 model 分別為 currentUserIsEventOwner 以及 eventDetailTotalPrice
			"""

			assert model.unfinEvents
			assert model.endEvents


    }

}
