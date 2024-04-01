<%--
  Created by IntelliJ IDEA.
  User: 31036
  Date: 2024/3/13
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label>Gender:</label>
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label><br><br>

   Date of Birth :<input type ="text name=" name ="birthDate"><br/>

    <input type="submit" value="Register">
</form>
<%@include file="footer.jsp"%>

