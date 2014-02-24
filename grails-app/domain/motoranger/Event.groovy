package motoranger


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

class Event {
	// static searchable = true
	String name
	String description
	Product product
	Long mileage=0

	static hasMany = [details:EventDetail]


	ProductStatus status=motoranger.ProductStatus.UNFIN

	User user
 	
 	Date date
 	
 	String creator

 	Long receivedMoney=0
 	Long totalPrice=0
 	Long discountMoney=0

	Date dateCreated
	Date lastUpdated

	Store store

	static constraints = {
	    name blank: false, unique: true
	    description nullable: true, empty: true
	    store nullable:true
	    creator nullable:true
    	// user nullable: true, empty: true		user 不允許 null

  }

  static mapping = {
       sort date: "desc"
  }

  public String toString(){
  	"摩托 "+product+ " 維修記錄"
  }




}