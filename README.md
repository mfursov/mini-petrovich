![Petrovich](petrovich.png) mini-petrovich
==========================================

__mini-petrovich__ is Java library which inflects Russian names to given grammatical case. It supports first names, last names and patronymic names inflections.

__mini_petrovich__  это Java библиотека склонения по пажежам русских имен, фамилий и отчеств

## Building

```
mvn -DskipTests=true clean package install
```

## Usage

```java
Petrovich p = new Petrovich();
p.say("Иван", LastName, Male, Case.Genitive), "Иван"
p.say("Иван", LastName, Male, Case.Dative), "Ивану")
```

### Алгоритм

Все используемые правила перечисленны в классе Library и занимают порядка 100 строк кода. Меняйте их при необходимости прямо в коде или используйте конструктор класса Petrovich, 
который в качестве аргумента принимает наибор внешних правил. 

### Точность

Подробно о точности от оригинальных разработчиков [petrovich-ruby](https://github.com/petrovich/petrovich-ruby#Оценка-аккуратности) project front page

Если коротко: благодаря тому, что в библиотеке используется знание о роде (мужской, женский) и типе (имя, фамилия, отчество) результат оказывается более точным,
чем выдаваемый сервисом [Yandex Inflect](https://export.yandex.ru/inflect.xml?name=%D0%9F%D0%B5%D1%82%D1%80%D0%BE%D0%B2%D0%B8%D1%87). 

Кроме этого, Yandex Inflect имеет проблемы с буквой 'ё' и, в ряде случаев проглатывает букву 'н' в женских именах в родительском роде.


### История

Оригинально алгоритм разработан на языке Ruby [petrovich-ruby](https://github.com/petrovich/petrovich-ruby) Андрей Козловым и Дмитрием Усталовым.

Оригинальная Java версия была разработана Ринатом Мулюковым: [petrovich-java](https://github.com/petrovich/petrovich-java)
 
Этот форк Java версии убирает все зависимости от сторонних библиотек, добавляет несколько сотен тестов и исправляет ряд ошибок оригинального алгоритма.
  

### License

This project available under MIT license