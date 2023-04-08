<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 30.03.2023
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Sign-in Failed Page</title>
</head>
<body>
<%
    String data2 = (String) session.getAttribute("session-uid");
    String result = "Hi " + data2 + ". Id or Password are wrong. Please try Again.";
    out.println(result);
%>
<h3><a href="home">return to home</a></h3>
</body>
</html>
