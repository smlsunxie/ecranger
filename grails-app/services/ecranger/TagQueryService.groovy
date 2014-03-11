package ecranger

import org.grails.taggable.*

class TagQueryService {

    def userService


    def getlikeTag = { query ->
        return Tag.findAllByNameIlike("%${query}%").name
    }

    def getUniTag ={def allProducts ->



        String domainTagsHQL= """
           SELECT distinct tagLink.tag.id
           FROM TagLink tagLink 
           where tagLink.type=:domainName
           and tagLink.tagRef in (:productIds)
        """

        def productIds = allProducts*.id

        def allTagIds = TagLink.executeQuery(domainTagsHQL,
                    [domainName: 'product', productIds: productIds])

        def allTags=Tag.withCriteria{
            if(allTagIds)
    		  "in" ("id", allTagIds)
            else eq("id",-1L)
    	}


		return allTags?.name
    }
    def getProductsWithTag = { params ->

        def products = Product.findAllByTagWithCriteria(params.tag) {
                
                eq('type', params.type as ecranger.ProductType)
            }  
        
        return products
    }

    def getUniTagByList ={ domainList ->

        def tags=[]
        if(domainList){
            

            domainList.tags.each{ //i ->
                tags.addAll(it) 
            }
            
        }

        return tags.unique()

        
    }

    def getRecentPartIds(){

        def partIds =[]
        def params= [:]
        params.max = 400
        params.sort = "date"
        params.order = "desc"

        def currentUser = userService.currentUser()
        def recentEvents 

        if(userService.isOperator() || userService.isManerger()){
            recentEvents =Event.findAllByStore(currentUser.store, params)
        }else {
            recentEvents =Event.findAllByUser(currentUser, params)
        }

        recentEvents.each(){ recentEvent ->
            recentEvent.details.each(){ detail ->
                partIds << detail.part.id
            }
            
        }

        return partIds
    }
}