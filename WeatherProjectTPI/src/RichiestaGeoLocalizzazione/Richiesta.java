/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RichiestaGeoLocalizzazione;


import LocationAndMeteo.Localita;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author Yami
 */
//ANDREA MILESI 5AI TPI PROGETTO GEOLOCALIZZAZIONE
public class Richiesta {
   
    public Richiesta (){ 
    }
    /*
        Questo metodo rende la richiesta HTTP e converte la risposta in un file XML.
    */
    public  static void get (Localita location) throws IOException
    {
        
       //inizia connessione
        URL url = new URL (location.toURL()); 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        
        //legge e scrive , bufferedReader PrintWriter
        String line;
        BufferedReader reader = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        PrintWriter printer = new PrintWriter (new FileOutputStream ("XMLGeoLocalizzazione.xml"));
        while ((line = reader.readLine()) != null)
        {
            printer.println(line);
        }
        
        
        printer.close();
        reader.close();
    }
}
