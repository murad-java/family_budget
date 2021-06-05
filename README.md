# family_budget
В этом проекте используется база данных postgres, Java 11.

Для подключения Базы данных к проекту войдите в папку resources  откройте файл application.properties  и поменяйте эти строку

spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
spring.datasource.username=postgres
spring.datasource.password=postgres

В папке resources/SQL находятся файлы для инсерта в базу с тестовыми данными.

А для проведения тестов импортируйте файл resource/Family Budget.postman_collection.json в Postman.

Для сборки проекта используется Maven.
