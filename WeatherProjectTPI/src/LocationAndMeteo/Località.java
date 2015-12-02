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
public class Località {
    //atttributi località
    private String address;
   
    //URL uguale per tutte le localizzazioni , è quello standard
    private String url = "https://maps.googleapis.com/maps/api/geocode/xml?";
   
   
    public Località (String address)  //costruttore
    {
        this.address = address;
       
    }
   
    /*
        questo metodo converte gli attributi della località nell'url necessario per fare la
        richiesta http al servizio di georeferenziazione di google sostituisce gli spazi negli
        attributi con + e poi li aggiunge nella forma richiesta
    */
    public String toURL ()
    {
       String temp = address;
       temp.replace(" ", "+");
       return url + "address=" + temp;
    }
}