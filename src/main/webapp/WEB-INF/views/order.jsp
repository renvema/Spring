<%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 17.07.2019
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Your order</title>
</head>
<body>
<center>
    <h2> Order </h2>
    <form:form action="/user/order" method="post" modelAttribute="order">
        Surname:<br>
        <form:input path="surname"/>
        <br>
        Name:<br>
        <form:input path="name"/>
        <br>
        City:<br>
        <form:input path="city"/>
        <br>
        Address:<br>
        <form:input path="address"/>
        <br>
        Phone:<br>
        <form:input path="phone" />
        <input type="submit" value="Confirm"/>
        <button><a href="/sign"> Log Out </a></button>
    </form:form>
</center>
</body>
</html>
