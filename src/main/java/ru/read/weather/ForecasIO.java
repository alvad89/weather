package ru.read.weather;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 14.05.13
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
public class ForecasIO {
    public List<String> getForecastIO(){
        List<String> res = new ArrayList<String>();
        json = "";
        try{
            try{
                url = new URL("https://api.forecast.io/forecast/096facb7680d91c266c4597089403f4f/55.1777,61.3006?units=si");
                io = url.openStream();
                in = new Scanner(io);
                while (in.hasNext()){
                    json = json+in.next();
                }
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(json);
                JSONObject jsonObject = (JSONObject) obj;
                JSONObject jsonCurrently = (JSONObject) jsonObject.get("currently");
                res.add(jsonCurrently.get("time").toString());
                res.add(jsonCurrently.get("temperature").toString());
                res.add(jsonCurrently.get("summary").toString());
                res.add(jsonCurrently.get("windSpeed").toString());
                res.add(jsonCurrently.get("windBearing").toString());
                res.add(jsonCurrently.get("pressure").toString());
                res.add(jsonCurrently.get("humidity").toString());
                res.add(jsonCurrently.get("cloudCover").toString());
                res.add(jsonCurrently.get("visibility").toString());
                res.add(jsonCurrently.get("precipIntensity").toString());
                res.add(jsonCurrently.get("dewPoint").toString());
                res.add(jsonCurrently.get("ozone").toString());
        }finally {
                in.close();
                io.close();
            }
            }catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //System.out.println(res);
        return res;
    }
    private URL url;
    private String json;
    private Scanner in;
    private InputStream io;
}
