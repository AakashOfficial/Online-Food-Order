<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User Here</title>
</head>
<body>

<%@include file="HeaderUser.jsp" %>
	<center>
		<h1>Update Information For User Only</h1>
<pre>
		<form action="updateUser" method="POST">
		    Old User ID : <input type="text" name="user_id_old" placeholder="Enter Old User Id" >
		    
			User ID : <input type="text" name="user_id" placeholder="Enter User Id"> 
			
			Password : <input type="password" name="password" placeholder="Enter Password">
			
			Name : <input type="text" name="name" placeholder="Enter Your Name Here">
			
			Address : <input type="text" name="address" placeholder="Enter Address">
			
			Mobile No. : <input type="text" name="mobile_no" placeholder="Enter Mobile No">
			
			Email Id : <input type="text" name="email_id" placeholder="Enter Email ID">
			
			<input type="submit" value="Update Information" > 
		</form>
</pre>
	</center>
	
<%-- <%@include file="FooterDefault.jsp" %> --%>
</body>
</html>