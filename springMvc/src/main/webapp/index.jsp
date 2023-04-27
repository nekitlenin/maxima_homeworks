<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 23.04.2023
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New contact</title>
</head>
<body>
<h2>Добавить новый контакт</h2>
<form action="/contact/save" , method="post">
    <label>
        <input type="text" name="id">
    </label>Идентификатор<br>
    <label>
        <input type="text" , name="firstName">
    </label>Имя<br>
    <label>
        <input type="text" , name="lastName">
    </label>Фамилия<br>
    <label>
        <input type="email" , name="email">
    </label>Email<br>
    <label>
        <input type="number" , name="phoneNumber">
    </label>Номер телефона<br>
    <input type="submit" value="Добавить ✅">
</form>
<a href="<c:url value='/contacts'/>">
    <input type="submit" value="Список контактов 👥"></a>
</body>
</html>
