/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author farouk
 */
public class ServiceParticiper {
      public static int idu=1;
        public void participer(int id) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/participer?" + "idEvent=" + id+ "&idUser=" + ServiceUser.currentUser.getId();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
               public void OneSignal() {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/one/notifMobile" ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
