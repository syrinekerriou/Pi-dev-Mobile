/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.util.Base64;
import java.util.Calendar;
import java.util.Map;



/**
 *
 * @author Mohamedhabib - pc
 */
public class ServiceLivraison {
  
 public void Livrer(int id) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/livrer?" + "idcommande=" + id;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            

        });
             String accountSID = "ACdf2a4fd51f2b0e7f5e0e0d402cf408b0";
            String authToken = "afe219d29522d340d8a0eaae2a4221bd";
            String fromPhone = "+15103191798";
            String destinationPhone = "+21650431288";

            Response<Map> SMS = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                    queryParam("To", destinationPhone).
                    queryParam("From", fromPhone).
                    queryParam("Body", "Votre Commande va etre livrer ").
                    header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                    getAsJsonMap();
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
  
}
