<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Maryana
  Date: 03.07.2019
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Hello</title>
</head>
<body>
Welcome! You can register if you want :-P
<center>
	<h2>Sign In</h2>
	<form method="post" action='<spring:url value="/signin"/>'>
		Email:<br>
		<input type="email" name="email" value="">
		<br>
		Password:<br>
		<input type="password" name="password" value="">
		<br><br>
		<button><a type="submit">Sign In</a></button>
	</form>
</center>
</body>

</html>
