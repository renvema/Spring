<%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 03.07.2019
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<center>

    ${error}
<%--@elvariable id="user" type=""--%>
<form:form action="/admin/user/add"
           method="post" modelAttribute="user">
        Email <form:input path="email"/> <br>
        Password <form:password  path="password"/> <br>
        Repeat password <input type="password" name="repeatPassword"/> <br>
        <form:radiobutton path="role" value="ROLE_ADMIN"/> admin <br>
        <form:radiobutton path="role" value="ROLE_USER"/> user <br>
        <input type="submit" value="Register"/>
</form:form>

</center>

</body>
</html>
