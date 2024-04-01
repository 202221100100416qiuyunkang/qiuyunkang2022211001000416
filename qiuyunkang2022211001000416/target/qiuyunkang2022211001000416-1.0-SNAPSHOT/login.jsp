<%--
  Created by IntelliJ IDEA.
  User: 31036
  Date: 2024/4/1
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1>Welcome to the Login Page</h1>
<!-- Add your login form here -->

<%@ include file="footer.jsp" %>
<form action="LoginServlet" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>

</body>
</html>

