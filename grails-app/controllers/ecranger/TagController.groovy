package ecranger
import org.grails.taggable.Tag

import grails.converters.JSON

class TagController {

	def tagQueryService

    def listAsJson = {
        render tagQueryService.getlikeTag(params.term) as JSON
    }
}
