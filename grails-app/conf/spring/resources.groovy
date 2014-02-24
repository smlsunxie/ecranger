import motoranger.*

beans = {
	userService(UserService){
		springSecurityService = ref("springSecurityService")
	}

	tagQueryService(TagQueryService){
		userService = ref("userService")
	}
}
