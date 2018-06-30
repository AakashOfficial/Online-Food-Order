<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<h5>Register Here</h5>
	<form action="InsertUserRegister" method="post">


		<div class="form-group">
			<label for="address" class="cols-sm-2 control-label">Address</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"	aria-hidden="true"></i></span> <input type="text" class="form-control" name="address" id="address" placeholder="Enter Address" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="customername" class="cols-sm-2 control-label">Enter	Customer Name</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"
						aria-hidden="true"></i></span> <input type="text" class="form-control" name="customername" id="customername" placeholder="Enter Customer Name" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="cols-sm-2 control-label">Your Email</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span> <input type="text" class="form-control" name="email" id="email" placeholder="Enter your Email" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="enabled" class="cols-sm-2 control-label">User Enabled</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"	aria-hidden="true"></i></span> <input type="text" class="form-control" name="enabled" id="enabled" placeholder="Enter Status" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="gender" class="cols-sm-2 control-label">Enter Your Gender</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"	aria-hidden="true"></i></span> <input type="text" class="form-control" name="gender" id="gender" placeholder="Enter Your Gender" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="mobile" class="cols-sm-2 control-label">Mobile No.</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input type="password" class="form-control" name="mobile" id="mobile" placeholder="Enter Mobile Number" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="cols-sm-2 control-label">Password</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"	aria-hidden="true"></i></span> <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="role" class="cols-sm-2 control-label">User Role</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-lg"	aria-hidden="true"></i></span> <input type="text" class="form-control" name="role" id="role" placeholder="Enter User Role" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="username" class="cols-sm-2 control-label">Username</label>
			<div class="cols-sm-10">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span> <input type="text" class="form-control" name="username" id="username" placeholder="Enter your Username" />
				</div>
			</div>
		</div>

		<div class="form-group ">
			<input type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button" value="Register" />
		</div>
	</form>

</body>
</html>