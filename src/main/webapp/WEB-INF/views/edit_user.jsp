<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 08.07.2019
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<center>

    ${valid}
    <h4>Edit user data</h4>
        <form:form action="/admin/user/edit"
                   method="post" modelAttribute="user">
            <form:hidden path="id"/>
            Email <form:input path="email"/> <br>
            Password <form:password path="password"/><br>
            <form:radiobutton path="role" value="ROLE_ADMIN"/> admin
            <form:radiobutton path="role" value="ROLE_USER"/>user
            <input type="submit" value="Save">
        </form:form>
</center>
</body>
</html>
