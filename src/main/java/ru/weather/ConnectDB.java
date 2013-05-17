package ru.weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 14.05.13
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public class ConnectDB {
    public JSONObject getWeather(Integer idSite){

        JSONObject obj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{

            PreparedStatement state = null;
            try{
                for (int i=1; i<4; i++){
                state = getConnection().prepareStatement("SELECT City.City,day,temper,typeWeather,speedWing,degWing,pressure,humidity,cloudCover,visibility,precipIntensity,dewPoint,ozone from Weather LEFT JOIN City on City.idCity=Weather.City_idCity where Weather.Site_idSite=? and City_idCity=? order by day DESC limit 1");
                state.setInt(1,idSite);
                state.setInt(2,i);
                ResultSet rst = state.executeQuery();
                while (rst.next()){
                    JSONObject jsonObject = new JSONObject();
                    System.out.println(rst.getString(1));
                    jsonObject.put("city", rst.getString(1));
                    jsonObject.put("date",rst.getString(2));
                    jsonObject.put("temper",rst.getString(3));
                    jsonObject.put("typeWeather",rst.getString(4));
                    jsonObject.put("speedWing",rst.getString(5));
                    jsonObject.put("degWing", rst.getString(6));
                    jsonObject.put("pressure",rst.getString(7));
                    jsonObject.put("humidity",rst.getString(8));
                    if (idSite == 3){
                        jsonObject.put("cloudCover",rst.getString(9));
                        jsonObject.put("visibility",rst.getString(10));
                        jsonObject.put("precipIntensity",rst.getString(11));
                        jsonObject.put("dewPoint",rst.getString(12));
                        jsonObject.put("ozone",rst.getString(13));
                    }
                    jsonArray.add(jsonObject);
                }
                    rst.close();

            }

                obj.put("weather", jsonArray);

            }
            finally {
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return obj;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/weather?useUnicode=true&characterEncoding=utf8";
        String username = "pogoda";
        String password = "pogoda";
        return DriverManager.getConnection(url, username, password);
    }
}
