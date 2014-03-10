package ecranger

import org.grails.taggable.Taggable
import groovy.transform.EqualsAndHashCode

import groovy.transform.ToString



@ToString
public enum PostType {
    SALE,
    DEMO,
    NEWS;
}

@EqualsAndHashCode
class Post implements Taggable {

	String name
	String title
	String content
    String description
	PostType type = ecranger.PostType.SALE
	
	String creator		//建立者

    Date dateCreated    //建立日期
    Date lastUpdated    //修改日期
    
    int hits = 0        //點擊次數
    String mainImage

    static constraints = {
    	name blank: false, unique: true
	    title blank: false
    	content nullable: true, empty: true, maxSize: 128*1024
        description nullable: true, empty: true
        mainImage nullable: true, empty: true
        creator nullable: true

    }
    String toString(){
      "${title}"
    }
}
