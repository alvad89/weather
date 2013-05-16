var id;
var table = document.createElement("table");
table.setAttribute("border", "5px");
table.setAttribute("bgcolor","#82718B");
table.setAttribute("bordercolor","#4b0082");
table.setAttribute("style","font-size: 120%")
var getWeather = function(id){
    $.ajax( 'weather/site/'+id, {
        dataType:'json',
        type:'GET',
        success:function ( data1 ) {

            var result = '<tr><th>Время</th><th>Температура</th><th>Что за окном</th><th>Ветер</th>' +
                '<th>Направление ветра</th><th>Давление</th><th>Влажность</th>';
            if (id == 3){
                result = result + '<th>Облачность</th><th>Видимость</th><th>Интенсивность осадков</th><th>Точка росы</th><th>Уровень озона</th>'
            }
            result = result + '</tr><tr><td>'+data1.date+'</td>'+
                '<td>'+data1.temper+'</td>'+
                '<td>'+data1.typeWeather+'</td>'+
                '<td>'+data1.speedWing+'</td>'+
                '<td>'+data1.degWing+'</td>'+
                '<td>'+data1.pressure+'</td>'+
                '<td>'+data1.humidity+'</td>'
            if(id == 3){
                result = result +
                    '<td>'+data1.cloudCover+'</td>'+
                    '<td>'+data1.visibility+'</td>'+
                    '<td>'+data1.precipIntensity+'</td>'+
                    '<td>'+data1.dewPoint+'</td>'+
                    '<td>'+data1.ozone+'</td>';
            }

            result.concat('</tr>');
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
}