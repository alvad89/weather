package ru.weather;

import ru.read.weather.ForecasIO;
import ru.read.weather.ReadJson;
import ru.read.weather.ReadXML;
import ru.write.weather.WriteDB;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 14.05.13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
public class RestWeather {
    private ConnectDB connectDB;
    public RestWeather(){
        connectDB = new ConnectDB();
    }
    public RestWeather(ConnectDB db){
        this.connectDB = db;
    }

    @GET
    @Path("site/{id}")
    @Produces("application/json")
    public String getWeather(@PathParam(value = "id") Integer id) {
        connectDB = new ConnectDB();
        String s = connectDB.getWeather(id).toString();
        return s;
    }

    @GET
    @Path("refresh")
    @Produces("application/json")
    public String refresh(){
        WriteDB wr = new WriteDB();
        ReadXML readXML = new ReadXML();
        wr.write(1,readXML.read());
        ReadJson json = new ReadJson();
        wr.write(2,json.getJson());
        ForecasIO forecasIO = new ForecasIO();
        wr.write(3,forecasIO.getForecastIO());
        return "true";
    }
}

