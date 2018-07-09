<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User Here</title>
</head>
<body>

<%@include file="HeaderDefault.jsp" %>
	<center>
		<h1>Registration For User Only</h1>

		<form action="registerUser" method="POST">
			User ID : <input type="text" name="user_id" placeholder="Enter User Id"> 
			<br>
			Password : <input type="password" name="passwoord" placeholder="Enter Password">
			<br>
			Name : <input type="text" name="name" placeholder="Enter Your Name Here">
			<br>
			Address : <input type="text" name="address" placeholder="Enter Address">
			<br>
			Mobile No. : <input type="text" name="mobile_no" placeholder="Enter Mobile No">
			<br>
			Email Id : <input type="text" name="email_id" placeholder="Enter Email ID">
			<br>
			<input type="submit" value="register" > 
		</form>

	</center>
	
<%-- <%@include file="FooterDefault.jsp" %> --%>
</body>
</html>