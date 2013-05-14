package ru.weather;
import ru.read.weather.*;
import ru.write.weather.WriteDB;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WriteDB wr = new WriteDB();
        ReadXML readXML = new ReadXML();
        wr.write(1,readXML.read());
        ReadJson json = new ReadJson();
        wr.write(2,json.getJson());
        ForecasIO forecasIO = new ForecasIO();
        wr.write(3,forecasIO.getForecastIO());
    }
}
