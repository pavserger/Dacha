# Dacha

## Что это?
Это платформа для небольшого дачого кооператива, которая поможет систематизировать сведения о дачных уччастках
в том числе о платежах и необходимых работах. Возможен просмотр изображений участка и строений на нем.
При развитии проекта возможно взаимодействие с Росреестром (поле для этого предусмотрено) и наращивание 
функциональности  в плане заказа и контроля выполнения работ и возможно товаров и услуг.
При разработке использовались:
* технология "слабо связанных модулей" для упрощения внесения изменений
* ролевая модель (для определения функций пользователей системы).

Платформа пока находится в разработке, но основные идеи доступны для просмотра.

## Зависимости
- [spring boot](https://spring.io/projects/spring-boot) (web, jpa, security) как основной фреймворк проекта, отвечающий за управление контекстом приложения, развёртывание и обработку запросов
- [Lombok](https://projectlombok.org) чтобы меньше писать

## Как его запустить?
Для сборки понадобятся:
- **JDK 17**
- **Maven 3**

Для работы:
- **JRE 17**
- **MySQQL 8**

`

Перед сборкой следует отредактировать файл настроек `application.yaml` или скопировать его и положить рядом с исполняемым .jar файлом, что позволит менять настройки динамически, без пересборки приложения.


#### Настройка подключения к БД
Настройки подключения к базе данных задаются следующим образом:
```properties
spring.datasource.url = jdbc:mysql://localhost : 3306/dacha?serverTimezone=Europe/Moscow
spring.datasource.username = root
spring.datasource.password = pass
spring.jpa.hibernate.ddl-auto = update```


Для обычной работы рекомендуется использовать флаги `none` или `update`, как альтернативный вариант, можно вообще не использовать этот тег.


### Описание интерфейса

Начальная страница показывает список участков и роли пользователей:
* Председатель;
* Бухгалтер;
* Собственники участков .

Рнгистрация пользователей осуществляется по номеру телефона и паролю, которые задаются председателем.
Вся информация доступна всем, но сохранение редактирование может осуществлять председатель (таблицы участков, собственников,
 обслуживающего персонала) и бухгалтер (таблицы ежегодных плптежей, платежей за электричество ...).
 Собственники могут проверить своевременную оплату выставленных платежей и заказать необходимые работы (в разработке).
 Сведения о платежах доступны только зарегистрированному пользователю, владельцу участка. 




