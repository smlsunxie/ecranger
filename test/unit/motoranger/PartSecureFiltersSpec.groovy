package motoranger

import grails.test.mixin.Mock
import spock.lang.Specification

@TestFor(PartController)
@Mock([User, Store, Part, EventDetail, UserService, PartSecureFilters])
class PartSecureFiltersSpec extends Specification {

    def setup() {

		User.metaClass.encodePassword = {
			password = 'password'
		}        

		def storeA = new Store(name: "storeA", title: "storeA").save(failOnError: true)
		def storeB = new Store(name: "storeB", title: "storeB").save(failOnError: true)


		def userA = new User(username: 'userA', title: 'userA', password:'pass'
			, enabled: true, store: storeA).save(failOnError: true)
		def userB = new User(username: 'userB', title: 'userB', password:'pass'
			, enabled: true, store: storeB).save(failOnError: true)

		def userC = new User(username: 'userC', title: 'userC', password:'pass'
			, enabled: false, store: storeA).save(failOnError: true)

		def partA = new Part(name: "partA", title: "partA", user: userA, store: storeA).save(failOnError: true)
		def partB = new Part(name: "partB", title: "partB", user: userB, store: storeB).save(failOnError: true)
		def partC = new Part(name: "partC", title: "partC", user: userC, store: storeA).save(failOnError: true)

	    UserService.metaClass.currentUser = {
        	userA
        }
    }

    def cleanup() {
    }

    void "使用者為 ROLE_OPERATOR 只可維護屬於同一個 store 的 part"(){
    	setup: "取得相關 domain 實體，並且設定 params.id"
		    UserService.metaClass.isOperator = {
	        	true
	        }
		    UserService.metaClass.isCustomer = {
	        	false
	        }

    		def userA = User.findByUsername('userA')
    		def partA = Part.findByName('partA')
			def partB = Part.findByName('partB')
			def partC = Part.findByName('partC')
			
		when: "userA 想要進行 edit 與 userA 不屬於同個 store 的 userB 擁有的 Part，經過 filters"
			params.id = partB.id.toString()
			response.reset()
	    	withFilters(controller:"part",action:"*") {
			    controller.edit(partB)
			}
		then: "將不允許進行維護，並且被 reditect 到所屬首頁，告知不可編輯"
			assert flash.message == "只可維護自己或所屬店家的維修項目"
			

		when: "userA 想要進行 edit 自己擁有的 Part，經過 filters"
			params.id = partA.id.toString()
			response.reset()
	    	withFilters(controller:"part",action:"*") {
			    controller.edit(partA)
			}
		then: "可以進行編輯"
			assert model.partInstance

		when: "userA 想要進行 edit 與 userA 屬於同一個 store 的 userC 擁有的 part 經過 filters"
			params.id = partC.id.toString()
			response.reset()
	    	withFilters(controller:"part",action:"*") {
			    controller.edit(partC)
			}
		then: "可以進行編輯"
			assert model.partInstance			
			
    }
    void "使用者為 ROLE_CUSTOMRE 只可維護自己的維修項目"(){
    	setup: "取得相關 domain 實體，並且設定 params.id"
		    UserService.metaClass.isCustomer = {
	        	true
	        }

    		def userA = User.findByUsername('userA')
    		def partA = Part.findByName('partA')
			def partB = Part.findByName('partB')
			def partC = Part.findByName('partC')
			
		when: "userA 想要進行 edit 與 userA 屬於同個 store 的 userC 擁有的 Part，經過 filters"
			params.id = partC.id.toString()
			response.reset()
	    	withFilters(controller:"part",action:"*") {
			    controller.edit(partC)
			}
		then: "將不允許進行維護，並且被 reditect 到所屬首頁，告知不可編輯"
			assert flash.message == "沒有權限維護不屬於自己的維修項目"
			

		when: "userA 想要進行 edit 自己擁有的 Part，經過 filters"
			params.id = partA.id.toString()
			response.reset()
	    	withFilters(controller:"part",action:"*") {
			    controller.edit(partA)
			}
		then: "可以進行編輯"
			assert model.partInstance		
			
    }


}
