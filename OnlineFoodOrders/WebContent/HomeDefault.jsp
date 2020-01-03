<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>                   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Default Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<div>

<%@include file="HeaderDefault.jsp" %>

</div>

<sql:setDataSource var = "myDS" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/online_food_order"
         user = "root"  password = ""/>
      <sql:query dataSource="${myDS}" sql="select * from food" var="foodlist" >
    </sql:query>
    <div align="center">
        <table border="1" cellpadding="5" cell-spacing="5" style="border-collapse:collapse;">
            <caption><h1>List of Food</h1></caption>
            <tr>
                <th>&nbsp; &nbsp; &nbsp;ID&nbsp; &nbsp; &nbsp;</th>
                <th>&nbsp; &nbsp; &nbsp;Name&nbsp; &nbsp; &nbsp;</th>
                <th>&nbsp; &nbsp; &nbsp;Category&nbsp; &nbsp; &nbsp;</th>
                <th>&nbsp; &nbsp; &nbsp;Price&nbsp; &nbsp; &nbsp;</th>
                <th>&nbsp; &nbsp; &nbsp;Type&nbsp; &nbsp; &nbsp;</th>
                <th>&nbsp; &nbsp; &nbsp;Description&nbsp; &nbsp; &nbsp;</th>
                <th>&nbsp; &nbsp; &nbsp;Image&nbsp; &nbsp; &nbsp;</th>
                <th></th>
            </tr>
            <c:forEach var="food" items="${foodlist.rows}">
                <tr><form action="Login.jsp" method="POST">
                    <input type="hidden" value="${food.food_id}" name="food_ids" >
                    <td>&nbsp; &nbsp; &nbsp;<c:out value="${food.food_id}" /> &nbsp; &nbsp; &nbsp;</td>
                    <td>&nbsp; &nbsp; &nbsp;<c:out value="${food.food_name}" />&nbsp; &nbsp; &nbsp;</td>
                    <td>&nbsp; &nbsp; &nbsp;<c:out value="${food.food_category}" />&nbsp; &nbsp; &nbsp;</td>
                    <td>&nbsp; &nbsp; &nbsp;<c:out value="${food.food_price}" />&nbsp; &nbsp; &nbsp;</td>
                    <td>&nbsp; &nbsp; &nbsp;<c:out value="${food.food_type}" />&nbsp; &nbsp; &nbsp;</td>
                    <td>&nbsp; &nbsp; &nbsp;<c:out value="${food.food_desc}" />&nbsp; &nbsp; &nbsp;</td> 
                    <td>&nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; &nbsp;<a href="Login.jsp"><img src="${pageContext.request.contextPath}/resources/${food.food_image_path}" alt="Product Image" height="213" width="320"> </a> &nbsp; &nbsp; &nbsp;<br>&nbsp;</td>
                    <td>&nbsp;&nbsp; &nbsp;<input type="submit" name="submitbtn" value="Add To Cart">&nbsp;&nbsp;&nbsp;</td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div>
        <%@include file="FooterDefault.jsp" %>
    </div>

</body>
</html>
