<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DefaultFooter</title>
<style type="text/css">
footer {
	background-color: #eee;
	padding: 25px;
}

ul, li {
	list-style-type: none;
}

.list {
	margin-top: 15px;
}
</style>
</head>
<body>

	<!-- Put this on the header -->
	<footer>
	<div class="container">
		<div class="row">

			<div class="col-md-3 list">
				<h2>&nbsp; &nbsp;Settings</h2>
				<ul>
					<li><a href="Login.jsp">Login</a></li>
					<li><a href="RegisterUser.jsp">Register</a></li>
					<li><a href="FoodShow.jsp">Show Foods</a></li>
					<li><a href="Login.jsp">Show Cart</a></li>
				</ul>

			</div>
			<div class="col-md-3 list">
				<h2>&nbsp; &nbsp;Services</h2>
				<ul>
					<li><a href="ContactUs.jsp">About Us</a></li>
					<li><a href="AboutUs.jsp">Contact Us</a></li>
					<li><a href="Feedback.jsp">Feedback</a></li>
					<li><a href="Complaints.jsp">Complaints</a></li>
				</ul>

			</div>
			<div class="col-md-3 list">
			   <h2>&nbsp; &nbsp;Services</h2>
				<ul>
					<li><a href="#">Lorem Ipsum</a></li>
					<li><a href="#">Lorem Ipsum</a></li>
					<li><a href="#">Lorem Ipsum</a></li>
					<li><a href="#">Lorem Ipsum</a></li>
				</ul>

			</div>

			<div class="col-md-3">
				<h5>
					<strong>Contact Info</strong>
				</h5>
				<p>
					<strong>Adress:</strong>

				</p>
				<p>
					<strong>Email:</strong> 19aakash33@gmail.com
				</p>
				<p>
					<strong>Tel.:</strong> (+91) 9711216829
				</p>
			</div>

		</div>
		<div class="container">
			<div class="row">
				<div class="col-md text-center">

					© 2010-
					<script language="JavaScript" type="text/javascript">
						now = new Date
						theYear = now.getYear()
						if (theYear < 1900)
							theYear = theYear + 1900
						document.write(theYear)
					</script>
				</div>
	</footer>
</body>
</html>
