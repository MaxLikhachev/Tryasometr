---
description: Предоставляет пользователю возможность изменить его данные
---

# Редактирование данных пользователя

{% api-method method="put" host="https://192.168.0.40:8080" path="/user" %}
{% api-method-summary %}
Edit User
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-headers %}
{% api-method-parameter name="Authentication" type="string" required=true %}
JWT
{% endapi-method-parameter %}
{% endapi-method-headers %}

{% api-method-body-parameters %}
{% api-method-parameter name="phone" type="string" required=false %}
Новый номер телефона
{% endapi-method-parameter %}

{% api-method-parameter name="email" type="string" required=false %}
Новый e-mail
{% endapi-method-parameter %}

{% api-method-parameter name="secondName" type="string" required=false %}
Новое отчество
{% endapi-method-parameter %}

{% api-method-parameter name="surname" type="string" required=false %}
Новая фамилия
{% endapi-method-parameter %}

{% api-method-parameter name="name" type="string" required=false %}
Новое имя
{% endapi-method-parameter %}

{% api-method-parameter name="password" type="string" required=false %}
Новый пароль
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Информация о пользователе успешно изменена
{% endapi-method-response-example-description %}

```javascript
{
    "username": "88001234568",
    "name": "name",
    "surname": "surname",
    "secondName": "secondName",
    "email": "email",
    "phone": "phone"
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



