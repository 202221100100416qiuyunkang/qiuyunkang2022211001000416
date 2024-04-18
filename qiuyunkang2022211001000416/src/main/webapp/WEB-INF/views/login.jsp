<%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2024/4/11
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> Login</h1>
<%
    if(!(request.getAttribute("message")==null)){

        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="login">
    Username : <input type="text" name="Username"><br/>
    Password : <input type="text" name="password"><br/>
    <input type="submit" value="submit"/>
</form>

<%@include file="footer.jsp"%>
