package ru.weather;
import ru.read.weather.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ReadXML readXML = new ReadXML();
        readXML.read();
        ReadJson json = new ReadJson();
        json.getJson();
    }
}
