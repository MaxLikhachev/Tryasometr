---
description: Генерация JWT для нового пользователя
---

# Регистрация пользователя

{% api-method method="post" host="https://192.168.0.40:8080" path="/signup" %}
{% api-method-summary %}
Sign Up
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="email" type="string" required=false %}
E-mail
{% endapi-method-parameter %}

{% api-method-parameter name="phone" type="string" required=false %}
Номер телефона
{% endapi-method-parameter %}

{% api-method-parameter name="surname" type="string" required=false %}
Фамилия
{% endapi-method-parameter %}

{% api-method-parameter name="second\_name" type="string" required=false %}
Отчество
{% endapi-method-parameter %}

{% api-method-parameter name="name" type="string" required=false %}
Имя
{% endapi-method-parameter %}

{% api-method-parameter name="username" type="string" required=true %}
Логин пользователя
{% endapi-method-parameter %}

{% api-method-parameter name="password" type="string" required=true %}
Пароль пользователя
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Пользователь успешно зарегистрирован в системе. Сгенерирован JWT.
{% endapi-method-response-example-description %}

```javascript
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY0NDE2NDM3LCJpYXQiOjE1NjQzOTg0Mzd9.qW30s-tJku4uJ_gUPWReqhtDWWehLk4e4HL3P2gk7xjxYrpXWsF1no21kkfCbcdSzP4s9UJ-9T5Rsvqf8chteg"
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=401 %}
{% api-method-response-example-description %}
Пользователь уже существует в системе или неверно указаны данные
{% endapi-method-response-example-description %}

```javascript
{
    "message": "Unauthorized"
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="https://192.168.0.40:8080" path="/signup" %}
{% api-method-summary %}
Sign Up
{% endapi-method-summary %}

{% api-method-description %}
Предоставление доступа новому пользователю через JWT.
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="cars" type="array" required=false %}
Массив объектов автомобилей
{% endapi-method-parameter %}

{% api-method-parameter name="email" type="string" required=false %}
E-mail
{% endapi-method-parameter %}

{% api-method-parameter name="phone" type="string" required=false %}
Номер телефона
{% endapi-method-parameter %}

{% api-method-parameter name="surname" type="string" required=false %}
Фамилия
{% endapi-method-parameter %}

{% api-method-parameter name="second\_name" type="string" required=false %}
Отчество
{% endapi-method-parameter %}

{% api-method-parameter name="name" type="string" required=false %}
Имя
{% endapi-method-parameter %}

{% api-method-parameter name="username" type="string" required=true %}
Логин пользователя
{% endapi-method-parameter %}

{% api-method-parameter name="password" type="string" required=true %}
Пароль пользователя
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Пользователь успешно зарегистрирован в системе. Сгенерирован JWT.
{% endapi-method-response-example-description %}

```javascript
{
    "token";: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY0NDE2NDM3LCJpYXQiOjE1NjQzOTg0Mzd9.qW30s-tJku4uJ_gUPWReqhtDWWehLk4e4HL3P2gk7xjxYrpXWsF1no21kkfCbcdSzP4s9UJ-9T5Rsvqf8chteg"
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=401 %}
{% api-method-response-example-description %}
Пользователь уже существует в системе или неверно указаны данные
{% endapi-method-response-example-description %}

```javascript
{
    "message";: "Unauthorized"
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

