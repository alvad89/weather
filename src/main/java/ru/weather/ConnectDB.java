package ru.weather;

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
    public JSONObject getWeather(Integer id){
        JSONObject jsonObject = new JSONObject();
        try{
            PreparedStatement state = getConnection().prepareStatement("SELECT day,temper,typeWeather,speedWing,degWing,pressure,humidity,cloudCover,visibility,precipIntensity,dewPoint,ozone from Weather where City_idCity=1 and Site_idSite=? ");
            try{
                state.setInt(1,id);
                ResultSet rst = state.executeQuery();
                while (rst.next()){
                    jsonObject.put("date",rst.getString(1));
                    jsonObject.put("temper",rst.getString(2));
                    jsonObject.put("typeWeather",rst.getString(3));
                    jsonObject.put("speedWing",rst.getString(4));
                    jsonObject.put("degWing",rst.getString(5));
                    jsonObject.put("pressure",rst.getString(6));
                    jsonObject.put("humidity",rst.getString(7));
                    if (id == 3){
                        jsonObject.put("cloudCover",rst.getString(8));
                        jsonObject.put("visibility",rst.getString(9));
                        jsonObject.put("precipIntensity",rst.getString(10));
                        jsonObject.put("dewPoint",rst.getString(11));
                        jsonObject.put("ozone",rst.getString(12));
                    }
                }
            }
            finally {
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return jsonObject;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/weather?useUnicode=true&characterEncoding=utf8";
        String username = "pogoda";
        String password = "pogoda";
        return DriverManager.getConnection(url, username, password);
    }
}
