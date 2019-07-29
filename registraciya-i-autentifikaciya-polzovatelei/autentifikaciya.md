---
description: Генерация JWT для доступа
---

# Аутентификация

{% api-method method="post" host="https://192.168.0.40:8080" path="/login" %}
{% api-method-summary %}
Login
{% endapi-method-summary %}

{% api-method-description %}
Проверка данных пользователя и предоставление ему доступа через JWT.
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
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
Пользователь успешно вошел в систему. Сгенерирован JWT.
{% endapi-method-response-example-description %}

```javascript
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY0NDE2NDM3LCJpYXQiOjE1NjQzOTg0Mzd9.qW30s-tJku4uJ_gUPWReqhtDWWehLk4e4HL3P2gk7xjxYrpXWsF1no21kkfCbcdSzP4s9UJ-9T5Rsvqf8chteg"
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=401 %}
{% api-method-response-example-description %}
Пользователь не существует в системе или неверно указаны данные
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



