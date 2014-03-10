package ecranger


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

class Event {
	// static searchable = true
	String name
	String description

	static hasMany = [details:EventDetail]

	User user
 	
 	Date date = new Date()
 	
 	String creator

 	Long receivedMoney=0
 	Long totalPrice=0
 	Long discountMoney=0

	Date dateCreated
	Date lastUpdated

	Store store

	EventStatus status = EventStatus.START

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





}