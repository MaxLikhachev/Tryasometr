---
description: Позволяет обновить показатель качества секции
---

# Обновлении информации о секции

{% api-method method="put" host="https://192.168.0.40:8080" path="/sections/:id" %}
{% api-method-summary %}
Put Section
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

{% api-method-body-parameters %}
{% api-method-parameter name="factor" type="number" required=true %}
Показатель качества секции
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Обновленный показатель качества секции успешно сохранен в буфер и ожидает дальнейшего анализа
{% endapi-method-response-example-description %}

```javascript

```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}





