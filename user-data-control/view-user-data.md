---
description: Предоставляет пользователю его данные
---

# Просмотр данных пользователя

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



