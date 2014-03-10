package ecranger

import com.grailsrocks.functionaltest.*

class RegisterFunctionalTests extends BrowserTestCase {
    void testSomeWebsiteFeature() {

        redirectEnabled = false
        javaScriptEnabled = false

		get('/user/create')

		form('user-save') {
			username = 'test'
			title = 'test'
			password = 'test'
			email = 'test@test.com'
			click "create"
	    }
	    followRedirect()

	    // assertRedirectUrlContains "/login/auth"

		form('login-check') {
			j_username = "test"
			j_password = "test"
			click "submit"
	    }

	    followRedirect()

	    // assertRedirectUrlContains "/login/success"

	    followRedirect()

	    // assertRedirectUrlContains "/home/redirect"

	    followRedirect()

	    // assertRedirectUrlContains "/user/show"

	    click "user-edit"
		form('user-update') {
			click "update"
	    }
		followRedirect()

	    // assertRedirectUrlContains "/user/show"	    

		click "user-delete"

		followRedirect()

		// assertRedirectUrlContains "/"

    }
}
