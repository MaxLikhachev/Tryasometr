---
description: Предоставляет пользователю его данные
---

# Просмотр данных пользователя

{% api-method method="get" host="https://192.168.0.40:8080" path="/user" %}
{% api-method-summary %}
Get User
{% endapi-method-summary %}

{% api-method-description %}
Возвращает объект пользователя с информацией о нем.
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-headers %}
{% api-method-parameter name="Authorization" type="string" required=true %}
JWT
{% endapi-method-parameter %}
{% endapi-method-headers %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Возвращается запрашиваемая информация
{% endapi-method-response-example-description %}

```javascript
{
    "username": "user",
    "name": "Name",
    "surname": "Surname",
    "email": "email@.www.com",
    "phone": "88001234567",
    "secondName": "Second Name"
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="get" host="https://192.168.0.40:8080" path="/user/info" %}
{% api-method-summary %}
Get User Info
{% endapi-method-summary %}

{% api-method-description %}
Возвращает объект пользователя с информацией о его личности и автомобилями.
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-headers %}
{% api-method-parameter name="Authorization" type="string" required=true %}
JWT
{% endapi-method-parameter %}
{% endapi-method-headers %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Возвращается запрашиваемая информация
{% endapi-method-response-example-description %}

```javascript
{
    "username";: "user",
    "password";: "$2a$10$gKWLYljp69tjVTjC/sespevjfeYn8S/ojuCDKIIDP4nM1H3eJdona",
    "name";: null,
    "surname";: null,
    "email";: null,
    "phone";: null,
    "cars";: [],
    "secondName";: null
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

