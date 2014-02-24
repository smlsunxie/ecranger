<html>
<head>
	<meta name='layout' content='bootstrap'/>
	<title><g:message code="springSecurity.login.title"/></title>
	<style type='text/css' media='screen'>



.form-signin {
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}

.form-signin .form-signin-heading,
.form-signin .checkbox {
    margin-bottom: 10px;
}

.form-signin .checkbox {
    font-weight: normal;
}

.form-signin .form-control {
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    z-index: 2;
}

.form-signin input[type="text"] {
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
} 
	</style>
</head>

<body>



  <form class="form-signin" role="form" action='${postUrl}' method='POST' id='login-check' autocomplete='off'>
    <h2 class="form-signin-heading"><g:message code="springSecurity.login.header" /></h2>
    <input name="j_username" type="text" class="form-control" placeholder='<g:message code="springSecurity.login.username.label" />' required autofocus />
    <input name="j_password" type="password" class="form-control" placeholder='<g:message code="springSecurity.login.password.label" />' required />
    
    <label class="checkbox">
      <input type="checkbox" name='${rememberMeParameter}' value="remember-me" id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if> /><g:message code="springSecurity.login.remember.me.label" />
    </label>

    <button class="btn btn-lg btn-primary btn-block" type='submit' id="submit">${message(code: "springSecurity.login.button")}</button>
  </form>



</body>
</html>
