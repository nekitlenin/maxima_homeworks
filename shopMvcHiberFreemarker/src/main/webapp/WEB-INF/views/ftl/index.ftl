<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товары</title>
    <style>
        <#include "style.css" />
    </style>
</head>
<body>
<div id="header">
    <h1>Товары</h1>
</div>
<div id="content">
    <table class="datatable">
        <tr>
            <td>Идентификатор</td>
            <td>Название</td>
            <td>Цена</td>
            <td>Количество</td>
            <td>Действие</td>
        </tr>
        <h3>Список товаров:</h3>
        <#list productList as product>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.count}</td>
                <td>
                    <a href="/products/update/${product.id}">
                        <button>Изменить 🔄</button>
                    </a>
                    <a href="/products/delete/${product.id}">
                        <button>Удалить ❌</button>
                    </a>
                </td>
            </tr>
        </#list>
    </table>
</div>

<fieldset>
    <legend>Добавить товары</legend>
    <form name="product" action="/products" method="post">
        Название: <input type="text" name="name"/><br/>
        Цена: <input type="number" name="price"/><br/>
        Количество: <input type="number" name="count"/><br/>
        <input type="submit" value="Добавить✅"/>
    </form>
</fieldset>

</body>
</html>
