package ecranger
import org.grails.taggable.Taggable


class Product implements Taggable {

    static searchable = true


	String name
	String title
	Long cost=0
	Long price=0
	String mainImage
    ProductType type=ecranger.ProductType.BOOK

    String description


    String creator
    Date dateCreated    //建立日期
    Date lastUpdated    //修改日期

    static constraints = {

        name blank: false, matches: "[a-zA-Z0-9]+"

        creator nullable: true
        title blank: false
        mainImage nullable: true, empty: true   
        description nullable: true, empty: true
        
        cost min: 0L
        price min: 0L

    }

    public String toString(){
        return title
    }

}
