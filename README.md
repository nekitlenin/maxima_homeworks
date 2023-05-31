В рамках задания необходимо разработать веб-приложение на Java с использованием технологий Spring Framework (не Spring Boot), которое будет предоставлять функциональность для управления библиотекой. В основе приложения будет использоваться база данных для хранения информации о книгах, авторах и жанрах.

Требования к приложению:

Использовать Spring Framework (не Spring Boot) для создания веб-приложения.
Использовать Hibernate для работы с базой данных.
Реализовать CRUD-операции для книг, авторов и жанров.
Применить EntityGraph и NamedEntityGraph для оптимизации запросов к базе данных.
Небольшие подсказки и шаги для выполнения

Создайте сущности : Book, Author, Genre.

Для них необходимо создать репозитории и сервисынй слой.

Для примера можно написать граф для выборки списка книг с авторами и жанрами.

Вот самый простой пример такого графа:

@EntityGraph(attributePaths = {"author", "genre"})
List<Book> findAll();

Напишите аналогичный, но NamedEntityGraph

Подумайте и реализуйте ещё 1 метод, который стоило бы оптимизировать через графы
