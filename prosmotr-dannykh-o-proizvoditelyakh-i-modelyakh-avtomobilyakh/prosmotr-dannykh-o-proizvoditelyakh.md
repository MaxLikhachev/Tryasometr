---
description: Просмотр данных о производителях автомобилей
---

# Просмотр данных о производителях

{% api-method method="get" host="https://192.168.0.40:8080" path="/brands" %}
{% api-method-summary %}
Get All Brands
{% endapi-method-summary %}

{% api-method-description %}
Возвращает список объектов производителей
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Возвращен список объектов производителей
{% endapi-method-response-example-description %}

```javascript
[
        {
                "name":"Audi"
        },
        {
                "name":"BMW"
        }
]
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



