package WeatherProjectTPI;

import RichiestaGeoLocalizzazione.Richiesta;
import LocationAndMeteo.Località;
import RichiestaGeoLocalizzazione.Estrattore;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import javax.xml.parsers.ParserConfigurationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yami
 */

//ANDREA MILESI 5AI TPI PROGETTO GEOLOCALIZZAZIONE
public class WheaterProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, FileNotFoundException, ParserConfigurationException{
        Località location = new Località ("new york");
        
        Richiesta.get(location);
        location = Estrattore.drawLocation (location);
    }
    
}
