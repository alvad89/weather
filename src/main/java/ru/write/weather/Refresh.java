package ru.write.weather;
import ru.read.weather.ForecasIO;
import ru.read.weather.ReadJson;
import ru.read.weather.ReadXML;


/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 17.05.13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
public class Refresh {
    public void refresh(Long period){
        per = period;
        start();
    }

    public void stop(){
        potok = null;
    }
    public void start(){
        Thread thisThread = Thread.currentThread();
        while (potok == Thread.currentThread()){
            try {
                Thread.sleep(per);
            } catch (InterruptedException e) {
            }
            write();
        }
    }
    public void write(){
        WriteDB wr = new WriteDB();
        ReadXML readXML = new ReadXML();
        ReadJson json = new ReadJson();
        ForecasIO forecasIO = new ForecasIO();
        for (int i=1; i<4; i++){
            wr.write(i,1,readXML.read(i));
            wr.write(i,2,json.getJson(i));
            wr.write(i,3,forecasIO.getForecastIO(i));}
        System.out.println("OK!");
    }
    private volatile Thread potok;
    private Long per;
}
