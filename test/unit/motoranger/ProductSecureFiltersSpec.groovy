package motoranger

import grails.test.mixin.Mock
import spock.lang.Specification

@TestFor(ProductController)
@Mock([User, Store, Product, UserService, ProductSecureFilters])
class ProductSecureFiltersSpec extends Specification {

    def setup() {

		User.metaClass.encodePassword = {
			password = 'password'
		}        

		def storeA = new Store(name: "storeA", title: "storeA").save(failOnError: true)
		def userA = new User(username: 'userA', title: 'userA', password:'pass'
			, enabled: true, store: storeA).save(failOnError: true)
		def userB = new User(username: 'userB', title: 'userB', password:'pass'
			, enabled: true).save(failOnError: true)

		def userC = new User(username: 'userC', title: 'userC', password:'pass'
			, enabled: false).save(failOnError: true)

		def productA = new Product(name: "productA", title: "productA", user: userA).save(failOnError: true)
		def productB = new Product(name: "productB", title: "productB", user: userB).save(failOnError: true)
		def productC = new Product(name: "productC", title: "productC", user: userC).save(failOnError: true)

	    UserService.metaClass.currentUser = {
        	userA
        }
    }

    def cleanup() {
    }

    void "使用者為 ROLE_OPERATOR 只可維護未 enabled 的 user"(){
    	setup: "取得相關 domain 實體，並且設定 params.id"
		    UserService.metaClass.isOperator = {
	        	true
	        }
		    UserService.metaClass.isCustomer = {
	        	false
	        }


    		def productA = Product.findByName('productA')
			def productB = Product.findByName('productB')
			def productC = Product.findByName('productC')
			
		when: "userA 想要進行 edit 已 enabled 的 userB 擁有的 product，經過 filters"
			params.id = productB.id.toString()
			response.reset()
	    	withFilters(controller:"product",action:"*") {
			    controller.edit(Product.get(params.id))
			}
		then: "將不允許進行維護，並且被 reditect 到所屬首頁，告知不可編輯"
			assert flash.message == "已啟用使用者之產品不可維護"
			

		when: "userA 想要進行 edit 自己擁有的 product，經過 filters"
			params.id = productA.id.toString()
			response.reset()
	    	withFilters(controller:"product",action:"*") {
			    controller.edit(Product.get(params.id))
			}
		then: "可以進行編輯"
			assert model.productInstance

		when: "userA 想要進行 edit 未 enabled user 的 product，經過 filters"
			params.id = productC.id.toString()
			response.reset()
	    	withFilters(controller:"product",action:"*") {
			    controller.edit(Product.get(params.id))
			}
		then: "可以進行編輯"
			assert model.productInstance			
			
    }
  //   void "使用者為 ROLE_CUSTOMRE 只可維護自己"(){
  //   	setup: "取得相關 domain 實體，並且設定 params.id"
		//     UserService.metaClass.isCustomer = {
	 //        	true
	 //        }
		//     UserService.metaClass.isOperator = {
	 //        	false
	 //        }

  //   		def userA = User.findByUsername('userA')
		// 	def userB = User.findByUsername('userB')
		// 	def userC = User.findByUsername('userC')
			
		// when: "userA 想要進行 edit 已 enabled 的 userB 擁有的 product，經過 filters"
		// 	params.id = userB.id.toString()
		// 	response.reset()
	 //    	withFilters(controller:"product",action:"*") {
		// 	    controller.edit()
		// 	}
		// then: "將不允許進行維護，並且被 reditect 到所屬首頁，告知不可編輯"
		// 	assert flash.message == "不屬於自己的摩托不可維護"
			

		// when: "userA 想要進行 edit 自己擁有的 product，經過 filters"
		// 	params.id = userA.id.toString()
		// 	response.reset()
	 //    	withFilters(controller:"product",action:"*") {
		// 	    controller.edit()
		// 	}
		// then: "允許進行維護"
		// 	assert model.product

	
			
  //   }


}
