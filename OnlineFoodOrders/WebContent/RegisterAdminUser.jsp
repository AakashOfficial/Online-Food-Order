<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Admin Here</title>
</head>
<body>

<%@include file="HeaderAdmin.jsp" %>
	<center>
		<h1>Registration For Admin Only</h1>

		<form action="registerAdmin" method="POST">
			User ID : <input type="text" name="user_id" placeholder="Enter User Id"> 
			<br>
			Password : <input type="password" name="password" placeholder="Enter Password">
			<br>
			<input type="submit" value="register" > 
		</form>

	</center>
<%-- <%@include file="FooterAdmin.jsp" %> --%>
</body>
</html>