/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RichiestaMeteo;

import LocationAndMeteo.Località;
import LocationAndMeteo.Meteo;
import java.io.FileInputStream;
import static java.util.stream.DoubleStream.builder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
/**
 *
 * @author Yami
 */
//ANDREA MILESI 5AI TPI PROGETTO GEOLOCALIZZAZIONE
public class Estrattore1 {
    public Estrattore1 () {
    }
    
    public static Meteo EstrattoreTempo (Località location) throws ParserConfigurationException
    {
        //attributi per l xpath
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document documentoMeteo;
        
        Meteo meteo = new Meteo (location);
        try {
            documentoMeteo = builder.parse(new FileInputStream("meteo.xml"));
            
            String Meteo = "/current/clouds/@name";
            String Temperatura = "/current/temperature/@value"; 
            String Umidita = "/current/humidity/@value"; 
            String Pressione = "/current/pressure/@value"; 
            XPath xPath =  XPathFactory.newInstance().newXPath();
            
            
            meteo.setMeteo(xPath.compile(Meteo).evaluate(documentoMeteo));
            meteo.setTemperatura(Float.parseFloat(xPath.compile(Temperatura).evaluate(documentoMeteo)));
            meteo.setUmidita(Float.parseFloat(xPath.compile(Umidita).evaluate(documentoMeteo)));
            meteo.setPressione(Float.parseFloat(xPath.compile(Pressione).evaluate(documentoMeteo)));

        }
        catch(Exception ex) { }
        return meteo;
    }
}
