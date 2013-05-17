package ru.weather;

import ru.read.weather.ForecasIO;
import ru.read.weather.ReadJson;
import ru.read.weather.ReadXML;
import ru.write.weather.Refresh;
import ru.write.weather.WriteDB;

import javax.ws.rs.*;

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
    @Path("site/{idSite}")
    @Produces("application/json")
    public String getWeather(@PathParam(value = "idSite") Integer idSite) {
        connectDB = new ConnectDB();
        String s = connectDB.getWeather(idSite).toString();
        return s;
    }

    @GET
    @Path("refresh")
    @Produces("application/json")
    public String refresh(){
        WriteDB wr = new WriteDB();
        ReadXML readXML = new ReadXML();
        ReadJson json = new ReadJson();
        ForecasIO forecasIO = new ForecasIO();
        for (int i=1; i<4; i++){
        wr.write(i,1,readXML.read(i));
        wr.write(i,2,json.getJson(i));
        wr.write(i,3,forecasIO.getForecastIO(i));}
        return "true";
    }
    @GET
    @Path("refreshPeriod/{period}")
    @Produces("application/json")
    public boolean refreshPeriod(@PathParam(value = "period") Long period){
        Refresh refresh = new Refresh();
        refresh.refresh(period*60);
        return true;
    }
}

