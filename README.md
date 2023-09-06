# Clients

- Java 17
- PostgreSQL 15.4

## Запуск
- В конфигурационном файле **clients.yaml** перед запуском приложения задаются логин и пароль для базы данных.
- java -jar clients.jar
- После запуска сайт будет доступен по адресу [http://localhost:8888](http://localhost:8888)


## Endpoints

### GET /api/v1/clients
- Получение списка клиентов

### POST /api/v1/clients
- Добавление нового клиента

### GET /api/v1/clients/{id}/email
- Получение списка email
- {id} - id клиента

### POST /api/v1/clients/{id}/email
- Добавление email
- {id} - id клиента

### GET /api/v1/clients/{id}/phone
- Получение списка телефонов
- {id} - id клиента

### POST /api/v1/clients/{id}/phone
- Добавление телефона
- {id} - id клиента

### GET /api/v1/clients/{id}/info
- Получение информации по заданному клиенту (по id)
- {id} - id клиента

### GET /api/v1/clients/{id}/contacts
- Получение списка контактов заданного клиента
- {id} - id клиента