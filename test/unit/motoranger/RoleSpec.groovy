package motoranger

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Role)
class RoleSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "測試建立 Role"() {
    	when: "建立 ROLE_MANERGER"
    		def ruleAdmin = Role.findOrSaveByAuthority('ROLE_ADMIN')
    	then: "查詢要有 ROLE_ADMIN"
    		assert Role.findByAuthority("ROLE_ADMIN")

    }
}
