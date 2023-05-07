<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Изменить</title>
</head>
<body>
<br>
<fieldset>
    <legend>Редактировать товары</legend>
    <form name="product" action="/products/update" method="post">
        Идентификатор: <input type="number" name="id" value="${product.id}" readonly/><br/>
        Название: <input type="text" name="name" value="${product.name}"/><br/>
        Цена: <input type="number" name="price" value="${product.price}"/><br/>
        Количество: <input type="number" name="count" value="${product.count}"/><br/>
        <input type="submit" value="Изменить 🔄"/>
        <a href="/products">
            <input type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
<br/>
</body>
</html>