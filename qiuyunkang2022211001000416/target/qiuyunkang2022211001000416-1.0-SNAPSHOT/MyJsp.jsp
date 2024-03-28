<%--
  Created by IntelliJ IDEA.
  User: 31036
  Date: 2024/3/11
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="https://www.ecjtu.edu.cn/">go to ecjtu</a><!-- method is Get-->
<form method="Post"><!--what is method when we use form?--><!-- its Get ,why? default is Get-->
    <!--its better to use POST in frorm-->
    Nmae :<input type="text" name="name"><br/>
    ID :<input type="text" name="id"><br/>
    <input type="submit"value="Send data to server">
</form>
</body>
</html>
