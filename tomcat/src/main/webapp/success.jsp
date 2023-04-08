<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 30.03.2023
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Success Page</title></head>
<body>
    <%
        String data = (String) session.getAttribute("session-uid");
        String result = "Welcome " + data + " to our Maxima club!";
        out.println(result);
    %>
    <h3><a href="home">return to home</a></h3>
</body>
</html>