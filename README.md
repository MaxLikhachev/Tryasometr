---
description: >-
  Здесь описаны комментарии, пояснения и инструкции по эксплуатации.
  Рекомендуется прочитать их перед дальнейшим просмотром документации.
---

# Начало работы

## Авторизация

Авторизация осуществляется с использованием JWT. 

В `POST` запросах JWT должен передаваться в качестве `header`-параметра `"Authorization"` и начинаться с подстроки `"JWT "`Пример:

```javascript
JWT eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY0NDE2NDM3LCJpYXQiOjE1NjQzOTg0Mzd9.qW30s-tJku4uJ_gUPWReqhtDWWehLk4e4HL3P2gk7xjxYrpXWsF1no21kkfCbcdSzP4s9UJ-9T5Rsvqf8chteg
```

## Регистрация и аутентификация пользователей

Основными параметрами для аутентификации и регистрации пользователя являются логин и пароль. Они вводятся пользователем. В качестве логина используется номер телефона пользователя. Пример:

```javascript
{
    "username":"user", 
    "password":"password"
}
```

## Набор реализованных и необходимых функций

{% tabs %}
{% tab title="User" %}
| create | update | view |
| :--- | :--- | :--- |
|  |  |  |
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

|  |  |
| :--- | :--- |
|  |  |

