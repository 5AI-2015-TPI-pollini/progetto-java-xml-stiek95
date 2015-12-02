package WeatherProjectTPI;

import RichiestaGeoLocalizzazione.Richiesta;
import LocationAndMeteo.Località;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 70056583
 */
public class WheaterProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException{
        Località location = new Località ("gussago");
        Richiesta r = new Richiesta (location);
        r.get();
    }
    
}
