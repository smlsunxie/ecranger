package ecranger

class User {
	static searchable = true

	transient springSecurityService

	String username
	String password

	String title
	String telphone

	String mobile
	String address
	String email
	String description

	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Store store
	TourStep tourStep = ecranger.TourStep.STEP1_START

	static hasMany = [events:Event]

	
	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true, matches: "[a-zA-Z0-9]+"
		password blank: false
		store nullable: true
		title blank: false
		telphone nullable: true, matches: "[0-9-]+"
		mobile nullable: true, matches: "[0-9-]+"
		address nullable: true
		email nullable: true, email: true, unique: true
		description nullable: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}

	public String toString(){
		return title
	}


}
