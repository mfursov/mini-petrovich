![Petrovich](petrovich.png) mini-petrovich
==========================================

__mini-petrovich__ is a Java library which inflects Russian names to given grammatical case. It supports first names, last names and patronymic names inflections.

__mini_petrovich__  - это Java библиотека для склонения по пажежам русских имен, фамилий и отчеств.

## Building

```
mvn -DskipTests=true clean package install
```

## Usage

```java
Petrovich p = new Petrovich();
p.say("Александр", NameType.FirstName, Gender.Male, Case.Genitive) ➟ "Александра"
p.say("Сергеевич", NameType.PatronymicName, Gender.Male, Case.Dative) ➟ "Сергеевичу"
p.say("Пушкин", NameType.LastName, Gender.Male, Case.Prepositional) ➟  "Пушкине"
```

### Конфигурация

Все используемые правила перечисленны в классе *Library* и занимают порядка 100 строк кода. 
Меняйте их при необходимости прямо в коде или используйте конструктор класса *Petrovich*, который в качестве параметра принимает набор внешних правил. 

### Точность

Подробно о точности от оригинальных разработчиков: [petrovich-ruby](https://github.com/petrovich/petrovich-ruby#Оценка-аккуратности).

Если коротко: благодаря тому, что в библиотеке используется знание о роде имени (мужское или женское) и его типе (имя, фамилия, отчество) результат оказывается более точным,
чем выдаваемый сервисом [Yandex Inflect](https://export.yandex.ru/inflect.xml?name=%D0%9F%D0%B5%D1%82%D1%80%D0%BE%D0%B2%D0%B8%D1%87). 

Кроме этого, Yandex Inflect имеет проблемы с буквой 'ё' и, в ряде случаев, проглатывает букву 'н' в суффиксе женских имен в родительском роде.


### История

Оригинальный алгоритм был разработан на языке Ruby [petrovich-ruby](https://github.com/petrovich/petrovich-ruby) Андреем Козловым и Дмитрием Усталовым.

На Java алгоритм был портирован Ринатом Мулюковым: [petrovich-java](https://github.com/petrovich/petrovich-java).
 
Java версия *petrovich-mini* убирает все зависимости от сторонних библиотек, добавляет несколько сотен тестов и исправляет ряд найденных ошибок.

Итого: размер библиотеки составляет 10 килобайт, из которых 90% занимают правила. 
  

### License

This project available under MIT license