package ecranger


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


class EventDetail {
	// static searchable = true
	static belongsTo=[head:Event]

	String mainImage
	String name

	Integer qty=1
	String description
	String creator
	Date dateCreated
	Date lastUpdated
	Long price=0
	Long cost=0

	Product product

	static constraints={
		name unique:true
		creator nullable: true
		mainImage nullable:true
		description nullable:true
		price min: 0L
		cost min: 0L
	}

	def beforeInsert() {
		updateHeadTotalPrice()
	}

	def beforeUpdate() {
		if (isDirty('qty') || isDirty('price')) {
			updateHeadTotalPrice()
		}
	}


	protected void updateHeadTotalPrice() {
		def event = Event.findById(head.id);
		// 先計算已在資料庫的維修記錄
		head.totalPrice=0

		head.details.each(){ detail ->
			//若是 update 需將更新對象的自己排除在外
			if(detail.id!=id){
				head.totalPrice += detail.qty * detail.price
        	}
        }

        // 在加上此次更新的維修記錄
        head.totalPrice += qty * price
	}

	public String toString(){
		"購買產品 $product"
	}


}