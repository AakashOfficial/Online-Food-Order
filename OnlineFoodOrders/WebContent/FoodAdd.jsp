<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Food</title>
</head>
<body>

	<%@include file="HeaderAdmin.jsp"%>
	
	<form action="foodAdd" method="post">
		<table align="center" border="2px">
		    <tr>
			   <td>Food ID</td>
			   <td><input type="text" name="food_id" placeholder="Enter Food ID"></td>
			</tr>
			<tr>
				<td>Food Name</td>
				<td><input type="text" name="food_name"	placeholder="Enter Food Name" size="35"></td>
			</tr>
			<tr>
				<td>Food Category</td>
				<td><input type="text" name="food_category"	placeholder="Enter Food Category" size="35"></td>
			</tr>
			<tr>
				<td>Food Price</td>
				<td><input type="text" name="food_price" placeholder="Enter Food Price" size="35"></td>
			</tr>
			<tr>
				<td>Food Type</td>
				<td><input type="text" name="food_type" placeholder="Enter Food Type" size="35"></td>
			</tr>
			<tr>
				<td>Food Description</td>
				<td><input type="text" name="food_desc" placeholder="Enter Food Description" size="35"></td>
			</tr>
			<tr>
				<td>Food Image</td>
				<td><input type="text" name="path" placeholder="Enter Image Path"></td>
			</tr>
			<tr>
				<td clospan="2"><input type="submit" value="Add Food Items To"></td>
			</tr>
		</table>
	</form>
</body>
</html>