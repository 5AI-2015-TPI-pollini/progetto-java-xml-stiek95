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
    //Connection attributes
    private HttpURLConnection connection;
    private URL url;
    //Location
    private Località location;
    //XML Printer
    PrintWriter printer;
   
    //Constructor
    public Richiesta (Località location) throws MalformedURLException, FileNotFoundException
    {
        //It saves the location
        this.location = location;
        //It gets the url from the location
        url = new URL (location.toURL());
        //It initializes the printer and then it creates the XML file with the answer
        printer = new PrintWriter (new FileOutputStream ("google_answer.xml"));
    }
   
    /*
        This method makes the Http request and converts the answer in a XML file.
        First it opens the connection with the Google's Service, then it reads the answer line by line.
        Lastly it create a XML file with the answer.
    */
    public void get () throws IOException
    {
        //It opens a connection through the URL builded in the Constructor
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        //Thanks to the BufferedReader it reads line by line saving them in a XML file
        BufferedReader read = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        //It creates a line and then scans all the others till there aren't more lines
        String line;
        do {
            line = read.readLine ();
            printer.println(line);
            line = read.readLine();
        } while (line != null);
        //It closes the XML printer
        printer.close();
   
    }
}
