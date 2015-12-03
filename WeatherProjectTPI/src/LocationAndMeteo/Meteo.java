/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationAndMeteo;

/**
 *
 * @author Yami
 */
//ANDREA MILESI 5AI TPI PROGETTO GEOLOCALIZZAZIONE
public class Meteo {
    private String Tempo;
    private float Temperatura;
    private float Umidita; //%
    private float Pressione; //hPa
    
    //Località
    private Località location;
    
   
    public Meteo (Località location)
    {
        this.location = location;
    }
    
    //questo metodo permette di salvare la risposta di openweather
    public void setResults (String climateCondition, float temperatura)
    {
        this.Temperatura = temperatura;
    }
        
    
    public void setMeteo (String w)
    {
        Tempo = w;
    }
    
    
    public void setTemperatura (float temperatura)
    {
        Temperatura = temperatura;
    }
    
    
    public void setUmidita (float umidita)
    {
       Umidita = umidita;
    }
    
    
    public void setPressione (float pressione)
    {
        Pressione = pressione;
    }
    
    
    public String toString ()
    {
        return location.getAddress() + " "+ Tempo + " " + Temperatura + "°C " + Umidita + "% " + Pressione + "hPa.";
    }
}
