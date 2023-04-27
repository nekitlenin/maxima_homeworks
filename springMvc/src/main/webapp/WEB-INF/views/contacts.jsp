<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 23.04.2023
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<h2>Список контактов:</h2>
<table>
    <c:forEach var="contact" items="${contactList}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.firstName}</td>
            <td>${contact.lastName}</td>
            <td>${contact.email}</td>
            <td>${contact.phoneNumber}</td>
            <td><a href="<c:url value='/contact/edit/${contact.id}'/>">
                <input type="submit" value="Изменить 🔄">
            </a></td>
            <td><a href="<c:url value='/contact/delete/${contact.id}'/>" method="GET">
                <input type="submit" value="Удалить ❌">
            </a></td>
        </tr>
    </c:forEach>
    <td><a href="<c:url value='/'/>">
        <input type="submit" value="Добавить контакт ➕">
    </a>
</table>
</body>
</html>
