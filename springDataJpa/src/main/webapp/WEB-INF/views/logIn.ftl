<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Войти</title>
    <style>
        <#include "style.css" />
    </style>
</head>
<body>
<div class="container">
    <h1>Вход</h1>
    <fieldset>
        <form name="user" action="/login" method="post">
            Email: <input type="email" name="email"/><br/>
            Пароль: <input type="password" name="password"/><br/>
            <input type="submit" value="Войти✅"/>
        </form>
    </fieldset>
    <a class="top-right-button" href="/registration">
        <input type="submit" value="Зарегистрироваться">
    </a>
</div>
</body>
</html>