package motoranger

class StoreCostDetail {

	static belongsTo=[store: Store]

	String title
	String description
	Long cost
	Date date
	Store store


    static constraints = {
    	title unique: 'date'
    }
}
