<%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 03.07.2019
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<center>
    <form:form action="/admin/product/add"
               method="post" modelAttribute="product">
        Title <form:input path="title"/> <br>
        Description <form:input path="description"/> <br>
        Price <form:input path="price" type="number" step="0.01"/> <br>
        <input type="submit" value="Register"/>
    </form:form>
</center>
</body>
</html>
