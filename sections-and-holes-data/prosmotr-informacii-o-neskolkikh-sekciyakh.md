---
description: Позволяет вывести информацию о нескольких секциях
---

# Просмотр информации о нескольких секциях

{% api-method method="get" host="https://192.168.0.40:8080" path="/sections/some" %}
{% api-method-summary %}
Get Some Sections
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="ids" type="object" required=false %}
Iterable&lt;Long&gt; список ID секций
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Секции успешно найдены
{% endapi-method-response-example-description %}

```javascript
[
    {
        "id": 12345678,
        "factor": 0.5,
    }
    ...
]
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}



