package WeatherProjectTPI;

import RichiestaGeoLocalizzazione.Richiesta;
import LocationAndMeteo.Localita;
import LocationAndMeteo.Meteo;
import RichiestaGeoLocalizzazione.Estrattore;
import RichiestaMeteo.Estrattore1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        System.out.println("Inserire nome della location:");
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader myInput = new BufferedReader (reader);
        String prov = new String();
        try { prov = myInput.readLine(); } catch (IOException e) {}       
        Localita location = new Localita (prov);
        Richiesta.get(location);
        location = RichiestaGeoLocalizzazione.Estrattore.EstrattoreLocalizzazione (location);
        RichiestaMeteo.Richiesta1.get(location);
        Meteo weather = Estrattore1.EstrattoreTempo(location);
        System.out.println (weather.toString());
    }
    
}
