<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User Home</title>
    <link href="All.css" rel="stylesheet" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fixed">
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="UserHome.jsp">Online Food Order</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
       
        <li><a href="UserHome.jsp">Home</a></li>
        <li><a href="logout">Logout</a></li>
        <li><a href="ContactUsU.jsp">Contact Us</a></li>
        <li><a href="AboutUsU.jsp">About Us</a></li>
        <li><a href="Feedback.jsp">Feed Back</a></li>
        <li><a href="showFoodUser">Show Food</a></li>
        <li class="dropdown "><a href="#" id="drop1" data-toggle="dropdown" class="dropdown-toggle" role="button">Account Settings <b class="caret"></b></a>
            <ul role="menu" class="dropdown-menu" aria-labelledby="drop1">
                <li role="presentation"><a href="UpdateUser.jsp" role="menuitem">Update Information</a></li>
                <li role="presentation"><a href="CartShow.jsp" role="menuitem">Show Your Cart</a></li>
                <li role="presentation"><a href="showFoodUser" role="menuitem">Show All Food</a></li>
                <li role="presentation"><a href="RemoveUser.jsp" role="menuitem">Delete Your Account</a></li>
            </ul>
        </li>
        
          <li class="dropdown "><a href="#" id="drop1" data-toggle="dropdown" class="dropdown-toggle" role="button">services <b class="caret"></b></a>
            <ul role="menu" class="dropdown-menu" aria-labelledby="drop1">
                <li role="presentation"><a href="AboutUs.jsp" role="menuitem">About Us</a></li>
                <li role="presentation"><a href="ContactUs.jsp" role="menuitem">Contact Us</a></li>
                <li role="presentation"><a href="Feedback.jsp" role="menuitem">Feedback</a></li>
                <li role="presentation"><a href="#" role="menuitem">Complaint</a></li>
            </ul>
        </li>             
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</div>
</body>
</html> 
