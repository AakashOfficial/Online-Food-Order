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
    <%@include file="HeaderUser.jsp" %>
    <div align="center">
     <sql:setDataSource var = "myDS" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/online_food_order"
         user = "root"  password = ""/>
      <sql:query dataSource="${myDS}" sql="select * from cart" var="cartlist" >
    </sql:query>
    <div align="center">
        <table border="1" cellpadding="5" cellspacing="5" style="border-collapse:collapse;">
            <caption><h1>List of Food In Cart</h1></caption>
            <tr>
                <th>&nbsp;&nbsp;&nbsp;User ID&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Food ID&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Name&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Category&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Type&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Description&nbsp;&nbsp;&nbsp;</th>
                <th>&nbsp;&nbsp;&nbsp;Image&nbsp;&nbsp;&nbsp;</th>
                <th></th>
            </tr>
            <c:forEach var="cart" items="${cartlist.rows}">
                <tr><form action="cartConfirmOrRemove" method="POST">
                    <input type="hidden" value="${cart.food_id}" name="food_ids" >
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.user_id}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.food_id}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.food_name}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.food_category}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.food_price}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.food_type}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<c:out value="${cart.food_desc}" />&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/resources/${cart.food_image_path}" alt="Product Image" height="213" width="320"> </td>
                    <td><input type="submit" name="submitbtn" value="Order Confirm">
                        <input type="submit" name="submitbtn" value="Remove From Cart">                        
                    </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
   </div>
   <div>
   <%@include file="FooterUser.jsp" %>
   </div> 
</body>
</html>