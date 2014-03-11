package ecranger
import grails.plugin.springsecurity.annotation.Secured
class SearchController {
	static layout="bootstrap"

    def query(){

        def productSearchResult
        def userSearchResult

        params.max = 12

        if(params.q && params.q != ''){
            productSearchResult = Product.search(params.q+" OR *"+params.q+"*",params)
            
            if(productSearchResult?.results.size() == 0){
                println "start reindex"
                Product.reindex()
                println "end reindex"
                productSearchResult = Product.search(params.q+" OR *"+params.q+"*",params)
            }

        }

        render (view:"result", model:[searchResult:productSearchResult])


    }

    def doReindex(){
        Product.reindex()
        render "reindex 執行完成"
    }

    def doIndex(){
        Product.index()
        render "index 執行完成"
    }




}
