# SkyEngTestTask

### Реализация тестового задания для SkyWay
### Оглавление:
1) [Условия задачи](#условия-задачи)
2) [Реализация](#реализация)
3) [Функционал](#функционал)
4) [Собранное приложение](#ссылка-на-собранный-war)
5) [Скрин покрытия тестами](#скрин-покрытия-кода-тестами)

#### Условия задачи
Необходимо реализовать REST API, который позволяет отслеживать почтовые отправления.
В системе должны регистрировать почтовые отправления — письма, посылки — их передвижение между почтовыми отделениями, а также должна быть реализована возможность получения информации и всей истории передвижения конкретного почтового отправления.

1) Операции, которые должны быть реализованы:
* регистрации почтового отправления, его прибытие в промежуточное почтовое отделение,
его убытие из почтового отделения, его получение адресатом, просмотр статуса и полной истории движения почтового отправления.
2) Почтовое отправление определяется следующими свойствами:
* идентификатор, тип (письмо, посылка, бандероль, открытка), индекс получателя,адрес получателя,имя получателя.
3) Почтовое отделение характеризуется следующими свойствами : индекс, название, адрес получателя.

* Сервис может быть реализован в видео JSON либо XML-сервиса на выбор. Сервис может быть реализован при помощи стека Java EE или Spring.
* СУБД для хранения данных может использоваться любая.
* Работа с данными должна быть выполнена с помощью ORM, библиотека может использоваться любая.
* Приложение должно быть собрано при помощи Maven или Gradle.
* Результатом работы должен быть war или ear-архив, который может быть размещен на сервер приложений. Для отладки и демонстрации может использоваться любой сервер приложений.
* К приложению должно прилагаться описание его API — структура запросов и ответов, список допустимых операций, можно это реализовать в виде проекта SoapUI.
* Код должен быть покрыт тестами минимум на 70% (приложить скрин покрытия)


#### Реализация:
> Использован стек: Java 17 (corretto), Spring 2.7.14, Gradle, Hibernate, Swagger, Junit, FlyWay, H2
* Созданы сущности: 
1) MailItemEntity - Хранит: Тип посылки, Адрес, Имя и индекс получателя
2) PostalOfficeEntity - Хранит: Индекс, Название и Адрес  офиса
3) MailItemHistoryEntity - Хранит: Состояние отправления (находится в пути или офисе), Тип и Время взаимодействия 
с отправлением, id отправления, Объекты офисов - текущий и финальный.

* Созданы ENUM для типов отправления и типов взаимодействия с отправлением
 
* Созданы Repository, Service и Controller
 
* Подключена H2 с включенной консолью, адрес БД: jdbc:h2:mem:skyeng, user: sa, password:

> http://localhost:9000/h2-console

* Подключен Swagger в качестве документации по API
> http://localhost:9000/swagger-ui/index.html
 
#### Функционал:
1) Почтовые офисы:
* Создание офиса
* Поиск офиса по id
* Поиск офиса по индексу
2) Отправление:
* Создание отправления
* Пересылка отправления в другой офис
* Получение отправленной посылки
* Передача посылки конченому адресату
* Получение текущего состояния отправления и ее данных (история отправления)
3) Написаны тесты для всех сервисов и контроллеров проекта
4) Добавлена возможность перейти с автогенерации таблиц на миграцию через FlyWay (изменить настройки)

#### Ссылка на собранный war
> [War файл](https://drive.google.com/file/d/1shAVoE8anakOEUSVyT5AN7O70-67D_WW/view?usp=sharing)

#### Скрин покрытия кода тестами:
   ![screen](https://github.com/WMHillock/SkyEngTask/blob/main/src/main/resources/image/img.png?raw=true)

[Наверх](#skyengtesttask)

