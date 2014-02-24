package motoranger

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(EventController)
@Mock([User, Store, Product, Event, UserService, EventSecureFilters])
class EventSecureFiltersSpec extends Specification {

    def setup() {
		User.metaClass.encodePassword = {
			password = 'password'
		}

	    UserService.metaClass.isCustomer = {
        	false
        }	
	    UserService.metaClass.isOperator = {
        	true
        }	        
	    UserService.metaClass.isManerger = {
        	false
        }

		def storeA = new Store(name: "storeA", title: "storeA").save(failOnError: true)
		def userA = new User(username: 'userA', title: 'userA', password:'pass'
			, enabled: true, store: storeA).save(failOnError: true)
		def storeB = new Store(name: "storeB", title: "storeB").save(failOnError: true)
		def userB = new User(username: 'userB', title: 'userB', password:'pass'
			, enabled: true, store: storeA).save(failOnError: true)

		def productA = new Product(name: "productA", title: "productA", user: userA).save(failOnError: true)
		def productB = new Product(name: "productB", title: "productB", user: userB).save(failOnError: true)

		def eventA = new Event(name: 'eventA', date: new Date(), product: productA, user: userA, store: storeA).save(failOnError: true)
		def eventB = new Event(name: 'eventB', date: new Date(), product: productB, user: userB, store: storeB
			, status: motoranger.ProductStatus.END).save(failOnError: true)


	    UserService.metaClass.currentUser = {
        	userA
        }

    	
    }

    def cleanup() {
    }


    void "使用者為 ROLE_OPERATOR 只可維護自己或所屬店家的事件"(){
    	setup: "取得相關 domain 實體"
    		def userA = User.findByUsername('userA')
			def eventB = Event.findByName('eventB')
			


		when: "userA 想要進行 edit userB 所屬 store 之 event 經過 filters，並且設定 params.id"
			params.id = eventB.id.toString()
			response.reset()
	    	withFilters(controller:"event",action:"*") {
			    controller.edit()
			}
		then: "將不允許進行維護，並且被 reditect 到所屬首頁，告知不可編輯"
			assert flash.message == "只可維護自己或所屬店家的維修事件"
			

			


    }
}
