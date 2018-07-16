<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Food Remove</title>

<style type="text/css">
</style>

</head>

<body>
	<%@include file="HeaderUser.jsp"%>

	<form id="form1" name="form1" method="post" action="removeFood">
		<table width="358" border="1" align="center" cellpadding="5" cellspacing="0">
			<caption>Remove Food</caption>
			<tr>
			   <input type="hidden" name="secretInput" value="notID" >
			   <td>Food ID</td>
			   <td><input type="text" name="food_id" placeholder="Enter Food ID"></td>
			</tr>
			<tr>
				<td width="169"><div align="center">Name Of Food</div></td>
				<td width="163"><input name="food_name" type="text" /></td>
			</tr>
			<tr>
				<td><div align="center">Food Category</div></td>
				<td><input type="text" name="food_category" /></td>
			</tr>
			<tr>
				<td><div align="center">Food Type</div></td>
				<td><input type="text" name="food_type" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div>
					    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;
						<input type="submit" name="Submit" value="Submit" /> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" name="Submit2" value="Reset" />
					</div>
				</td>
			</tr>
		</table>
		<div align="center"></div>
		<div align="right"></div>
	</form>
    
    
    <form id="form1" name="form1" method="post" action="removeFood">
		<table width="358" border="1" align="center" cellpadding="5" cellspacing="0">
			<caption>Remove Food  By Food ID</caption>
			<tr>
			   <input type="hidden" name="secretInput" value="useID" >
			   <td>Food ID</td>
			   <td><input type="text" name="food_id" placeholder="Enter Food ID"></td>
			</tr>

			<tr>
				<td colspan="2">
					<div>
					    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;
						<input type="submit" name="Submit" value="Submit" /> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" name="Submit2" value="Reset" />
					</div>
				</td>
			</tr>
		</table>
		<div align="center"></div>
		<div align="right"></div>
	</form>	
	

</body>
</html>
