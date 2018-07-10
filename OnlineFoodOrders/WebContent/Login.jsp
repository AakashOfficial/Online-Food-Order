<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%@include file="HeaderDefault.jsp" %>
<h1>Login Here</h1>
<form action="login" method="POST" >
User ID - <input type="text" name="user_id" placeholder="Enter You User Name" /><br>
Password - <input type="text" name="password" placeholder="Enter You Password" /> 
<input type="submit" name="Login" >
</form>
</body>
</html>