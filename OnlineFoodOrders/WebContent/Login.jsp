<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%@include file="HeaderDefault.jsp"%>
	<h1>Login Here</h1>
	<table border="2">
		<form action="login" method="POST">
			<tr>
				<td>&nbsp; &nbsp; User ID &nbsp; &nbsp;</td>
				<td><input type="text" name="user_id" placeholder="Enter You User Name" /></td>
			</tr>
			<tr>
				<td>&nbsp; &nbsp; Password &nbsp; &nbsp;</td>
				<td><input type="text" name="password" placeholder="Enter You Password" /></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input type="submit" name="Login"></td>
			</tr>

		</form>
	</table>
</body>
</html>
