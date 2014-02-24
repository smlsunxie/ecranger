package motoranger
import org.grails.taggable.Taggable

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Part implements Taggable {
    // static searchable = true
		String name
		String title
		Long cost=0
		Long price=0

		String description
		Integer stockCount=0
		String mainImage

		String creator		//建立者
    Date dateCreated    //建立日期
    Date lastUpdated    //修改日期

    Store store
    User user

    static constraints = {
    	name blank: false, unique: true
    	title blank: false
      description nullable: true, empty: true
      creator nullable: true
      mainImage nullable: true, empty: true
      store nullable: true
      user nullable: true
      cost min: 0L
      price min: 0L
      stockCount min: 0

    }

    String toString(){
      "${title}"
    }
}
