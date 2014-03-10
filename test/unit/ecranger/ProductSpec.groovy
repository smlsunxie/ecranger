package ecranger

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(Product)
@Mock([User])
class ProductSpec extends Specification {

    def setup() {
    	User.metaClass.encodePassword = {
            password = 'password'
        }
    }

    def cleanup() {
    }

    void "product.name unique with user"() {
    	setup: "建立兩個使用者"
    		def user1 = new User(username: 'user1', password: 'user1', title: 'user1').save(failOnError: true)
    		def user2 = new User(username: 'user2', password: 'user2', title: 'user2').save(failOnError: true)
    	when: "product name 一樣，但屬於不同的 user"
    		def product1 = new Product(name: 'product', title: 'product', user: user1).save(failOnError: true)
    		def product2 = new Product(name: 'product', title: 'product', user: user2).save(failOnError: true)

    	then: "資料庫裡要有兩筆 product"
    		assert Product.list().size() == 2
    }
}
