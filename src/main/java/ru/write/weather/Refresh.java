package ru.write.weather;

import ru.read.weather.ForecasIO;
import ru.read.weather.ReadJson;
import ru.read.weather.ReadXML;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 17.05.13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
public class Refresh {
    public void refresh(final Long period){

        final Timer timer = new Timer();
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                WriteDB wr = new WriteDB();
                ReadXML readXML = new ReadXML();
                ReadJson json = new ReadJson();
                ForecasIO forecasIO = new ForecasIO();
                for (int i=1; i<4; i++){
                    wr.write(i,1,readXML.read(i));
                    wr.write(i,2,json.getJson(i));
                    wr.write(i,3,forecasIO.getForecastIO(i));}
                System.out.println("OOOOKKKK!!!!!!");
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    timer.schedule(task,period);
                }

            }
        }).start();

    }
}
