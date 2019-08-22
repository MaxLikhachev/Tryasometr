---
description: Обновляет данные о ямах в данной секции
---

# Обновление информации о ямах

{% api-method method="put" host="https://192.168.0.40:8080" path="/sections/:id/holes" %}
{% api-method-summary %}
Add All Holes By Id
{% endapi-method-summary %}

{% api-method-description %}
Принимает в качестве тела запроса список объектов ям \(List&lt;Hole&gt;\)
{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-path-parameters %}
{% api-method-parameter name="id" type="string" required=true %}

{% endapi-method-parameter %}
{% endapi-method-path-parameters %}

{% api-method-body-parameters %}
{% api-method-parameter name="distance" type="number" required=true %}
Расстояние ямы от начала секции
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Ямы успешно добавлены в буфер и ожидают дальнейшего анализа
{% endapi-method-response-example-description %}

```javascript
   
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

