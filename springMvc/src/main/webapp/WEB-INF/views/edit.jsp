<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 27.04.2023
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit contact</title>
</head>
<body>
<h2>Редактирование контакта:</h2>
<form action="http://localhost:8080/contact/edit" method="post">
    <label>
        <input type="text" name="id" value="${editContact.id}">
    </label>Идентификатор<br>
    <label>
        <input type="text" , name="firstName" value="${editContact.firstName}">
    </label>Имя<br>
    <label>
        <input type="text" , name="lastName" value="${editContact.lastName}">
    </label>Фамилия<br>
    <label>
        <input type="email" , name="email" value="${editContact.email}">
    </label>Email<br>
    <label>
        <input type="number" , name="phoneNumber" value="${editContact.phoneNumber}">
    </label>Номер телефона<br>
    <input type="submit" value="Редактировать ✅">
    <a href="<c:url value='/contacts'/>">
        <input type="submit" value="Отмена ❌">
    </a>
</form>

</body>
</html>
