<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 30.03.2023
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp Page</title>
</head>
<body>
<form action="authServer.jsp">
    <h3>Please, signUp!</h3>
    User: <input type="text" name="id"/> <br><br>
    Password: <input type="password" name="pass"/> <br><br>
    <input type="submit" value="Sign In!!"/>
    <h3><a href="home">back</a></h3>
</form>
</body>
</html>
