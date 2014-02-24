package motoranger



import spock.lang.*

/**
 *
 */
class ProductControllerSpec extends Specification {

    def setup() {

    	def user = new User(username: "user", title: "user", password: "user").save(flush: true, failOnError: true)
    	def product = new Product(name: "QQQ123", title: "QQQ123", user: user).save(flush: true, failOnError: true)
    	def similarProduct = new Product(name: "qqq123", title: "qqq123").save(flush: true, failOnError: true)

    }

    def cleanup() {
    }
    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["name"] = 'QQQ123'
        params["title"] = 'QQQ123'

    }
    void "Test that the show action 若有類似的 product 要能正確查出"() {
    	setup: "建立 controller"
    		def productController = new ProductController()
    		def product = Product.findByName("QQQ123")

        when: "新增一筆車號相同，屬於不同使用者的 product，在執行 show"
            def result = productController.searchSimilarProduct(product)

        then:"similarProduct 會帶出相同車牌但不同 product 的實體"
            result.size() == 1
            // model.similarProduct.get(1).name == "qqq123"
    }
}
