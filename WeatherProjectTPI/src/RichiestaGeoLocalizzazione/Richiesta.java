/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RichiestaGeoLocalizzazione;


import LocationAndMeteo.Località;
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
public class Richiesta {
    //Attributi per la richiesta
    private HttpURLConnection connection;
    private URL url;
    //Classe Località
    private Località location;
    
    PrintWriter printer;
   
   
    public Richiesta (Località location) throws MalformedURLException, FileNotFoundException
    {
        
        this.location = location;
        //Prender l URL della location
        url = new URL (location.toURL());
        //Crea Il File XML
        printer = new PrintWriter (new FileOutputStream ("GeolocalizzazioneXMLFile.xml"));
    }
   
    /*
        Questo metodo rende la richiesta HTTP e converte la risposta in un file XML.
    */
    public void get () throws IOException
    {
        //Si apre una connessione
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        //il Buffered Reader legge e scrive
        BufferedReader read = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        
        String line;
        do {
            line = read.readLine ();
            printer.println(line);
            line = read.readLine();
        } while (line != null);
        
        printer.close();
   
    }
}
