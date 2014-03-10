package ecranger




class Store {
    static searchable = true
	String name
	String title
	String address
	String telphone
    String mobile
    
    String fax
    String description
    String email


	static hasMany=[users:User]

    static constraints = {
    	name unique:true, matches: "[a-zA-Z0-9]+"
    	mobile nullable:true, matches: "[0-9-]+"
    	telphone nullable:true, matches: "[0-9-]+" 
    	address nullable:true

        fax nullable:true, matches: "[0-9-]+"
        description nullable:true
        email nullable:true, email: true

    }
    public String toString() {

	    return title;
  	}
}
