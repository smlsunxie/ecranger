package modernizr

class ModernizrTagLib {

	static namespace = "mod"

	def modernizr = { attrs ->
		def dev = grails.util.GrailsUtil.isDevelopmentEnv()
		def modernizrVersion = ModernizrConfig.SHIPPED_VERSION
		def modernizrFile = "modernizr-${modernizrVersion}${dev?'':'.min'}.js"
		out << "<script src=\"${g.resource(plugin:'modernizr', dir:'js/modernizr', file:modernizrFile)}\" type=\"text/javascript\"></script>"
	}

}
