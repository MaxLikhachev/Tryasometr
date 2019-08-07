# Просмотр автомобилей пользователя

{% api-method method="get" host="https://192.168.0.40:8080" path="/user/cars" %}
{% api-method-summary %}
Get All User Cars
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
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Найдены автомобили пользователя
{% endapi-method-response-example-description %}

```javascript
{
    "brand": "Brand",
    "model": "Model",
    "year": 2000,
    "max": 0,
    "min": 0,
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=204 %}
{% api-method-response-example-description %}
Не найдены автомобили пользователя
{% endapi-method-response-example-description %}

```

```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



