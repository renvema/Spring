<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 05.07.2019
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список продуктов</title>
</head>
<body>
<center>
    <h2> All products </h2>

    <button><a href="/admin/product/add"> Add product </a></button>
    <table border=1 bgcolor="#dda0dd">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="element" items="${allProducts}">
        <tr>
            <td>${element.title}</td>
            <td>${element.description}</td>
            <td>${element.price}</td>
            <td>
                <button><a href="/admin/product/edit/${element.id}">Edit</a></button>
            </td>
            <td>
                <button><a href="/admin/product/delete/${element.id}">Delete</a></button>
            </td>
        </tr>
        </c:forEach>
        <button><a href="/login"> Started page </a></button>
</center>
</table>
</body>
</html>
