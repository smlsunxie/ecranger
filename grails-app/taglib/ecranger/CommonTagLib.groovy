package ecranger

class CommonTagLib {
    def justfont = { attr, body ->
        if (attr.force) {
            out << render(template: '/taglib/justfont_force')
        }
        else {
            out << render(template: '/taglib/justfont')
        }
    }
    

	def compact = { attr, body ->
		def c = body()?.trim()

		if (c) {
			c = (c =~ /\n+/).replaceAll('\n')
		}

		out << c
	}
}
