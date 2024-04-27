# Пример SpringBoot проекта на Kotlin для работы с OpenAPI и PostgreSQL

- *Для сборки и запуска проекта необходима версия Java 17 и выше*

## Ссылки
- *SwaggerUI - http://localhost:8080/swagger-ui/index.html*
- *PGAdmin - http://localhost:5050*

## Obsidian
Для работы с `Obsidian` необходимо установить приложение на компьютер и плагин Local Rest API for Obsidian. 
При работе приложение должно быть запущено. Токен для работы с API можно получить в настройках приложения в разделе плагина. 

Ссылка на документацию по плагину:
https://coddingtonbear.github.io/obsidian-local-rest-api/

## OMDb API
Для работы с `OMDb API` необходимо зарегистрироваться на сайте и получить API ключ.

Ссылка на сайт `OMDb API` с документацией: https://www.omdbapi.com/

## Примечание 
Ключи для работы с API необходимо хранить в `application.yaml` предварительно раскомментировав нужный блок кода.

## Запуск проекта
- Запуск Docker контейнеров: `docker-compose up`
- Запуск проекта: с помощью кнопки `Run` в IDEA или `./gradlew bootRun`
- Перейти по ссылке: http://localhost:8080/swagger-ui/index.html