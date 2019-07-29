---
description: Просмотр списка моделей выбранного производителя автомобилей
---

# Просмотр моделей выбранного производителя

{% api-method method="get" host="https://192.168.0.40:8080" path="/brands/:brand\_name/models" %}
{% api-method-summary %}
Get All Models By BrandName
{% endapi-method-summary %}

{% api-method-description %}
Возвращает список моделей выбранного производителя
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-path-parameters %}
{% api-method-parameter name="brand\_name" type="string" required=false %}
Название производителя \("Audi","BMW" и т.п.\)
{% endapi-method-parameter %}
{% endapi-method-path-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```javascript
[
    {
        "id":"1"
        "name":"model_1"
    },
    {
        "id":"2"
        "name":"model_2"
    }
]
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

