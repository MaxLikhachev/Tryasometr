---
description: 'Отправка сигнала о том, что в данном месте, скорее всего, находится яма'
---

# Добавление подозреваемой ямы

{% api-method method="post" host="https://192.168.0.40:8080" path="/vibration" %}
{% api-method-summary %}
Add Vibration
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-headers %}
{% api-method-parameter name="Authentication" type="string" required=true %}
Authentication token to track down who is emptying our stocks.
{% endapi-method-parameter %}
{% endapi-method-headers %}

{% api-method-body-parameters %}
{% api-method-parameter name="longitude" type="string" required=true %}
Долгота
{% endapi-method-parameter %}

{% api-method-parameter name="latitude" type="string" required=true %}
Широта
{% endapi-method-parameter %}

{% api-method-parameter name="factor" type="string" required=true %}
Коэффициент \(показания акселерометра\)
{% endapi-method-parameter %}

{% api-method-parameter name="section\_id" type="string" required=true %}
ID секции
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Cake successfully retrieved.
{% endapi-method-response-example-description %}

```javascript
{
    "name";: "Cake's name",
    "recipe";: "Cake's recipe name",
    "cake";: "Binary cake"
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=404 %}
{% api-method-response-example-description %}
Could not find a cake matching this query.
{% endapi-method-response-example-description %}

```javascript
{
    "message";: "Ain't no cake like that."
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



