/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RichiestaGeoLocalizzazione;

import LocationAndMeteo.Località;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Yami
 */
//ANDREA MILESI 5AI TPI PROGETTO GEOLOCALIZZAZIONE
public class Estrattore { 
    public Estrattore () {
    }
    
    public  static Località EstrattoreLocalizzazione (Località location) throws FileNotFoundException, ParserConfigurationException
    {
        //Serve per l Xpath
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document locationDocument; // prende la latitudine e la longitudine
        
        try {
            
            locationDocument =  builder.parse(new FileInputStream("XMLGeoLocalizzazione.xml"));
            String LatitudeExpression = "/GeocodeResponse/result/geometry/location/lat/text()";
            String LongitudeExpression = "/GeocodeResponse/result/geometry/location/lng/text()";
            XPath xPath =  XPathFactory.newInstance().newXPath();
            
            float lat = Float.parseFloat(xPath.compile(LatitudeExpression).evaluate(locationDocument));//legge la latitudine e longitudine
            float lon = Float.parseFloat(xPath.compile(LongitudeExpression).evaluate(locationDocument));
           
            location.setCoordinates(lat, lon);
            System.out.println(lat + " " + lon);
        } catch (Exception ex) {}
        return location;
    }
    
   
}
