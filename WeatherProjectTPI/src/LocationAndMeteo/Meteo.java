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
    private Localita location;
    
   
    public Meteo (Localita location)
    {
        this.location = location;
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
