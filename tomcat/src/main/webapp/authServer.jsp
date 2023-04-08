<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 30.03.2023
  Time: 02:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Authentication</title>
</head>
<body>
<%
    String uid = request.getParameter("id");
    String password = request.getParameter("pass");
    session.setAttribute("session-uid", uid);
    if (uid.equals("Nikita") && password.equals("1234")) {
        response.sendRedirect("success.jsp");
    } else {
        response.sendRedirect("failed.jsp");
    }
%>
</body>
</html>
