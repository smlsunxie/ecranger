package ecranger

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(Part)
@Mock([User, Store])
class PartSpec extends Specification {

    def setup() {
    	User.metaClass.encodePassword = {
            password = 'password'
        }
    }

    def cleanup() {
    }

    void "Part.name unque with user and store"() {
    	setup: "建立 user、store 以及 part"
    		def user = new User(username: 'user', password: 'user', title: "user").save(failOnError: true)
    		def store =new Store(name: 'store', title: 'store').save(failOnError: true)
    	when: "part 名稱一樣，但屬於不同的 user、store"
    		def part1 = new Part(name: 'part', title: 'part', store: store).save(failOnError: true)
    		def part2 = new Part(name: 'part', title: 'part', user: user).save(failOnError: true)
    	then: "資料庫裡要有兩筆 part"
    		assert Part.list().size() == 2


    }
}
