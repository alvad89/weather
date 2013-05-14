package ru.write.weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 14.05.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class WriteDB {
      public void write(Integer id, List<String> astring){


      }
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/weather?useUnicode=true&characterEncoding=utf8";
        String username = "pogoda";
        String password = "pogoda";
        return DriverManager.getConnection(url, username, password);
    }

}
