package ecranger

import static org.junit.Assert.*
import org.junit.*
import org.grails.taggable.Tag

class TaggablePostTests {



    @Test
    void 'test post with tag and get unique Tags'() {
        def post1=new Post(name:'news', title:'newes',type:PostType.DEMO).save(flush:true,failOnError:true)
        def post2=new Post(name:'demo', title:'demo',type:PostType.DEMO).save(flush:true)

        assert Post.list().size()==2

        post1.addTags(['a','b','c'])

        assert post1.tags==['a','b','c']

        post2.addTags(['a','b','d'])

        def allTags=[]

        Post.list().tags.each{ //i ->
            allTags.addAll(it) 
        }

        assert allTags.unique() == ['a', 'b', 'c', 'd']




    }
}




