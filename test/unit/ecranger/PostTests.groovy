package ecranger



import grails.test.mixin.*
import org.junit.*
/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostTests {

    void testAddPost() {

       new Post(name:'news', title:'newes',type:PostType.DEMO).save(flush:true,failOnError:true)
       new Post(name:'demo', title:'demo',type:PostType.DEMO).save(flush:true)

       assert Post.list().size()==2
    }
}
