package ru.write.weather;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 14.05.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class WriteDB {
      public void write(Integer idCity, Integer idSite, List<String> astring){

          try {
              PreparedStatement state = getConnection().prepareStatement("INSERT INTO Weather(city_idcity,site_idsite,day,temper,typeWeather,speedWing,degWing,pressure,humidity,cloudCover,visibility,precipIntensity,dewPoint,ozone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
              try {
                  state.setInt(1,idCity);
                  state.setInt(2,idSite);System.out.println(astring+" "+ idSite);
                  if (idSite == 3){
                      state.setTimestamp(3, new Timestamp(1000*Long.valueOf(astring.get(0))));
                      if (astring.size()>8){
                      state.setBigDecimal(10,BigDecimal.valueOf(Double.valueOf(astring.get(7))));
                      state.setBigDecimal(11,BigDecimal.valueOf(Double.valueOf(astring.get(8))));
                      state.setBigDecimal(12,BigDecimal.valueOf(Double.valueOf(astring.get(9))));
                      state.setBigDecimal(13,BigDecimal.valueOf(Double.valueOf(astring.get(10))));
                      state.setBigDecimal(14,BigDecimal.valueOf(Double.valueOf(astring.get(11))));
                  }}

                  else {state.setTimestamp(3, Timestamp.valueOf(astring.get(0)));
                        state.setNull(10,Types.NULL);
                      state.setNull(11,Types.NULL);
                      state.setNull(12,Types.NULL);
                      state.setNull(13,Types.NULL);
                      state.setNull(14,Types.NULL);
                  }
                  state.setBigDecimal(4, BigDecimal.valueOf(Double.valueOf(astring.get(1))));
                  state.setString(5,astring.get(2));
                  state.setBigDecimal(6,BigDecimal.valueOf(Double.valueOf(astring.get(3))));
                  state.setString(7,astring.get(4));
                  state.setBigDecimal(8,BigDecimal.valueOf(Double.valueOf(astring.get(5))));
                  state.setBigDecimal(9,BigDecimal.valueOf(Double.valueOf(astring.get(6))));

                  state.execute();
              }finally {
                  state.close();
                  //System.out.println(id);
              }
          } catch (SQLException e) {
              e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
          }
      }


    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/weather?useUnicode=true&characterEncoding=utf8";
        String username = "pogoda";
        String password = "pogoda";
        return DriverManager.getConnection(url, username, password);
    }

}

/*

 */

