
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 11.07.2019
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    ${valid}
    <h4>Edit product data</h4>
        <form:form action="/admin/product/edit"
                   method="post" modelAttribute="product">
            <form:hidden path="id"/>
            Email <form:input path="title"/> <br>
            Description <form:input  path="description"/><br>
            Price <form:input  path="price" type="number" step="0.01"/><br>
            <input type="submit" value="Save">
        </form:form>

</center>
</body>
</html>
