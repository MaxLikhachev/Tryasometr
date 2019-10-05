---
description: Возвращает информацию о качестве данной секции
---

# Просмотр информации о секции

{% api-method method="get" host="https://192.168.0.40:8080" path="/sections/:id" %}
{% api-method-summary %}
Get Section
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
Секция успешно найдена
{% endapi-method-response-example-description %}

```javascript
{
    "id": 12345678,
    "factor": 0.5,
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



