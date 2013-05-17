a simple program to gather information about the weather from various sites

current! Chelyabinsk

2 сайта с JSON
1 сайт с XML

http://api.openweathermap.org/data/2.1/weather/city/1508291?units=metric

https://api.forecast.io/forecast/APIKEY/55.1777,61.3006

http://export.yandex.ru/weather-ng/forecasts/28642.xml

В качестве сервера приложений используется Jboss-as-7. Между сервером и браузером данные передаются в формате JSON. 
Написана простая страница на html+javascript. Запрос на сервер отправляется по ajax. Архитектура REST. база данных MySQL. 
Для получения свежих данных необходимо нажать кнопку Обновить данные на странице index.html и дождаться ответа от сервера.
