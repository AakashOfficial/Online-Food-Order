<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login To Account</title>
</head>
<body>
	<h5>Login Here</h5>
				<form id="login-form" action="perform_login"	method="post" role="form" style="display: block;">



					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span> 
								<input type="text" class="form-control"	name="username" id="username" placeholder="Enter your Username" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> 
									<input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" />
							</div>
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button" value="Login" />
					</div>

				</form>
</body>
</html>