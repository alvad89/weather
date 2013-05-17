package ru.read.weather;

import org.json.simple.JSONArray;
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
 * Date: 13.05.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class ReadJson {
    public List<String> getJson(Integer id){
        List<String> info = new ArrayList<String>();
        String adress = "http://api.openweathermap.org/data/2.1/weather/city/";
        if (id == 1) adress=adress.concat(CEK);
        else if (id == 2) adress = adress.concat(MOW);
        else if (id ==3) adress = adress.concat(IEV);
        adress = adress.concat("?units=metric");
        System.out.print(adress);
        json="";
        try {
            try{
            url = new URL(adress);
            in = url.openStream();
            scanner = new Scanner(in);
            while (scanner.hasNext()){
                json=json+scanner.next();
            }
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(json);
                JSONObject jsonObject = (JSONObject) obj;
                String s = jsonObject.get("date").toString();
                s = s.substring(0,10)+" "+s.substring(10);
                //info.add(jsonObject.get("date").toString());
                info.add(s);
                JSONObject jsonMain = (JSONObject) jsonObject.get("main");
                info.add(jsonMain.get("temp").toString());
                JSONArray jsonWeather = (JSONArray) jsonObject.get("weather");
                JSONObject weather = (JSONObject) jsonWeather.get(0);
                info.add(weather.get("main").toString());


          //  info.add(jsonMain.get("temp_max").toString());
          //  info.add(jsonMain.get("temp_min").toString());
            JSONObject jsonWind = (JSONObject) jsonObject.get("wind");
            info.add(jsonWind.get("speed").toString());
            info.add(jsonWind.get("deg").toString());
                info.add(jsonMain.get("pressure").toString());
                info.add(jsonMain.get("humidity").toString());


           // info.add(weather.get("description").toString());
        }finally {
               in.close();
               scanner.close();
            }}
        catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassCastException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return info;
    }
    private URL url;
    private String json;
    private InputStream in;
    private Scanner scanner;
    private final String CEK = "1508291";
    private final String MOW = "524901";
    private final String IEV = "703448";
}
