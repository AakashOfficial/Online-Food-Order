<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Food List</title>
</head>
<body>
    <%@include file="HeaderDefault.jsp" %>
     <sql:setDataSource var = "myDS" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/online_food_order"
         user = "root"  password = ""/>
      <sql:query dataSource="${myDS}" sql="select * from food" var="foodlist" >
    </sql:query>
    <div align="center">
        <table border="1" cellpadding="5" cell-spacing="5" style="border-collapse:collapse;">
            <caption><h1>List of Food</h1></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Type</th>
                <th>Description</th>
                <th>Image</th>
                <th></th>
            </tr>
            <c:forEach var="food" items="${foodlist.rows}">
                <tr><form action="Login.jsp" method="POST">
                    <input type="hidden" value="${food.food_id}" name="food_ids" >
                    <td><c:out value="${food.food_id}" /></td>
                    <td><c:out value="${food.food_name}" /></td>
                    <td><c:out value="${food.food_category}" /></td>
                    <td><c:out value="${food.food_price}" /></td>
                    <td><c:out value="${food.food_type}" /></td>
                    <td><c:out value="${food.food_desc}" /></td> 
                    <td><a href="Login.jsp"><img src="${pageContext.request.contextPath}/resources/${food.food_image_path}" alt="Product Image" height="213" width="320"> </a> </td>
                    <td><input type="submit" name="submitbtn" value="Add To Cart"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>