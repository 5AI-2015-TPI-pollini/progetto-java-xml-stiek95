/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RichiestaMeteo;

import LocationAndMeteo.Località;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 *
 * @author Yami
 */
//ANDREA MILESI 5AI TPI PROGETTO GEOLOCALIZZAZIONE
public class Richiesta1 {
    public Richiesta1 () {
    }
    
    public static void get (Località location) throws IOException
    {
        //Inizio Connessione
        URL url = new URL (location.toMeteoURL()); 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        
        String line;
        BufferedReader reader = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        PrintWriter printer = new PrintWriter (new FileOutputStream ("meteo.xml"));
        while ((line = reader.readLine()) != null)
        {
            printer.println(line);
        }
        
        
        printer.close();
        reader.close();
    }
}
