---
description: >-
  Добавляется новый автомобиль на основе выбранной марки и года выпуска, а также
  создается связь автомобиля с пользователем
---

# Добавление нового автомобиля

{% api-method method="post" host="https://192.168.0.40:8080" path="/cars/" %}
{% api-method-summary %}
Add New Car
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-headers %}
{% api-method-parameter name="Authorization" type="string" required=true %}
JWT
{% endapi-method-parameter %}
{% endapi-method-headers %}

{% api-method-body-parameters %}
{% api-method-parameter name="id" type="string" required=false %}
ID модели
{% endapi-method-parameter %}

{% api-method-parameter name="year" type="string" required=false %}
Год выпуска
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Возвращает данные о новом автомобиле
{% endapi-method-response-example-description %}

```javascript
{
    "brand": "Audi",
    "model": "80",
    "year": 2019,
    "min": 0.0,
    "max": 0.0
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=204 %}
{% api-method-response-example-description %}
Выбранная модель автомобиля не найдена
{% endapi-method-response-example-description %}

```

```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}
Отсутствуют необходимые параметры
{% endapi-method-response-example-description %}

```javascript
{
    "message": "Required int parameter 'year' is not present",
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

