var id;
var table = document.createElement("table");
table.setAttribute("border", "5px");
table.setAttribute("bgcolor","#82718B");
table.setAttribute("bordercolor","#4b0082");
table.setAttribute("style","font-size: 120%")
var getWeather = function(idSite){
    $.ajax( 'weather/site/'+idSite, {

        dataType:'json',
        type:'GET',
        success:function ( data1 ) {

            var result = '<tr><th>Город</th><th>Время</th><th>Температура</th><th>Что за окном</th><th>Ветер</th>' +
                '<th>Направление ветра</th><th>Давление</th><th>Влажность</th>';
            if (idSite == 3){
                result = result + '<th>Облачность</th><th>Видимость</th><th>Интенсивность осадков</th><th>Точка росы</th><th>Уровень озона</th>'
            }
            for( var i=0; i<data1.weather.length; i++){
            result = result + '</tr><tr><td>'+data1.weather[i].city+'</td><td>'+data1.weather[i].date+'</td>'+
                '<td>'+data1.weather[i].temper+'</td>'+
                '<td>'+data1.weather[i].typeWeather+'</td>'+
                '<td>'+data1.weather[i].speedWing+'</td>'+
                '<td>'+data1.weather[i].degWing+'</td>'+
                '<td>'+data1.weather[i].pressure+'</td>'+
                '<td>'+data1.weather[i].humidity+'</td>'
            if(idSite == 3){
                result = result +
                    '<td>'+data1.weather[i].cloudCover+'</td>'+
                    '<td>'+data1.weather[i].visibility+'</td>'+
                    '<td>'+data1.weather[i].precipIntensity+'</td>'+
                    '<td>'+data1.weather[i].dewPoint+'</td>'+
                    '<td>'+data1.weather[i].ozone+'</td>';
            }
            result.concat('</tr>');}
            table.innerHTML = result;

            document.body.appendChild(table);
            return result;

        }
    }).error( function()  {
            console.log("error");
        });};

getWeather(1);

var refresh = function(){
    $.ajax("weather/refresh", {
        dataType:'json',
        type:'GET',
        success:function () {
            alert("Данные обновленны!");
        }});
};
var refreshPeriod = function(){
    var period = document.getElementById("periodId").value;
    console.log(period);
    $.ajax("weather/refreshPeriod/"+period, {
        dataType:'json',
        type:'GET',
        success:function () {
            alert("Период считывания задан!");
        }});
};