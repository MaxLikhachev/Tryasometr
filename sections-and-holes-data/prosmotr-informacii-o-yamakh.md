---
description: Просмотр информации о местоположении ям в данной секции
---

# Просмотр информации о ямах

{% api-method method="get" host="https://192.168.0.40:8080" path="/sections/:id/holes" %}
{% api-method-summary %}
Get All Holes By Id
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-path-parameters %}
{% api-method-parameter name="id" type="string" required=true %}
ID секции
{% endapi-method-parameter %}
{% endapi-method-path-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Возвращает отрезки местоположения ям
{% endapi-method-response-example-description %}

```javascript
[
    {
        "begin": 0.7,
        "end": 0.9
    },
    ...
] 
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



