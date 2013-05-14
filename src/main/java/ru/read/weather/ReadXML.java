package ru.read.weather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 13.05.13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class ReadXML {
    public List<String> read(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<String> res = new ArrayList<String>();
        try {
            builder = factory.newDocumentBuilder();
            url = new URL("http://export.yandex.ru/weather-ng/forecasts/28642.xml");
            doc = builder.parse(String.valueOf(url));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("fact");
            for (int i=0; i<nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                /*    System.out.println("Температура: "+element.getElementsByTagName("temperature").item(0).getTextContent());
                    System.out.println("Текущая погода: "+element.getElementsByTagName("weather_type").item(0).getTextContent());
                    System.out.println("Ветер: "+element.getElementsByTagName("wind_direction").item(0).getTextContent());
                    System.out.println("Скорость ветра: "+element.getElementsByTagName("wind_speed").item(0).getTextContent());
                    System.out.println("Влажность: "+element.getElementsByTagName("humidity").item(0).getTextContent());
                    System.out.println("Давление в мм: "+element.getElementsByTagName("pressure").item(0).getTextContent());
                    System.out.println("Время: "+element.getElementsByTagName("observation_time").item(0).getTextContent()); */
                    res.add(element.getElementsByTagName("observation_time").item(0).getTextContent());
                    res.add(element.getElementsByTagName("temperature").item(0).getTextContent());
                    res.add(element.getElementsByTagName("weather_type").item(0).getTextContent());
                    res.add(element.getElementsByTagName("wind_speed").item(0).getTextContent());
                    res.add(element.getElementsByTagName("wind_direction").item(0).getTextContent());
                    res.add(element.getElementsByTagName("mslp_pressure").item(0).getTextContent());
                    res.add(element.getElementsByTagName("humidity").item(0).getTextContent());
                }
            }
        }catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //System.out.println(res);
        return res;
    }
    private URL url;
    private DocumentBuilder builder;
    private Document doc;
}
