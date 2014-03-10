package ecranger

import com.grailsrocks.functionaltest.*

class CustomerFunctionalTests extends BrowserTestCase {
    void testOverallFlow() {
        // Here call get(uri) or post(uri) to start the session
        // and then use the custom assertXXXX calls etc to check the response
        //
        redirectEnabled = false
        javaScriptEnabled = false

		get('/login/auth')

		form('login-check') {
			j_username = "customer"
			j_password = "customer"
			click "submit"
	    }

	    followRedirect()

	    // assertRedirectUrlContains "/login/success"

	    followRedirect()

	    // assertRedirectUrlContains "/home/redirect"

	    followRedirect()

	    // assertRedirectUrlContains "/user/show"


	    click "part-create"

	    form('part-save') {
			name = "testPart"
			title = "testPart"
			click "create"
	    }

	    followRedirect()


	    // assertRedirectUrlContains "/part/show"



	    click 'user-show'

	    click "product-create"

	    form('product-save') {
			name = "testMoto"
			title = "testMoto"
			click "create"
	    }

	    followRedirect()

	    // assertRedirectUrlContains "/product/show"

	    click 'product-edit'
	    form('product-update') {
			click "update"
	    }	    

	    followRedirect()

	    // assertRedirectUrlContains "/prdouct/show"


	    click "event-create"

	    form('event-save') {
	    	name = "testEvent"
			click "create"
	    }
	    followRedirect()

	    // assertRedirectUrlContains "/evnet/pickPartAddDetail"

	    click 'tag-show-0'


	    form('eventDetail-save-testPart') {
	    	name = "testEventDetail"
			click "create"
	    }
	    followRedirect()

	    // assertRedirectUrlContains "/evnet/pickPartAddDetail"

	    click 'event-update-statusEnd-testEvent'

	    followRedirect()

	    // assertRedirectUrlContains "/home/redirect"

	    followRedirect()

	    // assertRedirectUrlContains "/user/show"


	    click 'product-show-testMoto'

	    click 'event-show-testEvent'


	    click "event-edit"

	    form('event-update') {
			click "update"
	    }
	    followRedirect()


	    click "eventDetail-edit-testEventDetail"

	    form('eventDetail-update') {
			click "update"
	    }
	    followRedirect()


	    click 'eventDetail-delete-testEventDetail'

	    followRedirect()

	    // assertRedirectUrlContains "/event/show"

	    click 'event-delete'

	    followRedirect()

	    // assertRedirectUrlContains "/product/show"

	    //回到 product show，刪除產品


	    click "product-edit"

	    form('product-update') {
			click "update"
	    }
	    followRedirect()


	    click "product-delete"

	    followRedirect()

		// assertRedirectUrlContains "/home/redirect"

	    followRedirect()

	    // assertRedirectUrlContains "/user/show"

		click "part-index"

		click 'tag-show-0'

		click 'part-show-testPart'

		click 'part-delete'

		followRedirect()

		// assertRedirectUrlContains "/part/index"

		click 'user-show'
  
    } 

}
