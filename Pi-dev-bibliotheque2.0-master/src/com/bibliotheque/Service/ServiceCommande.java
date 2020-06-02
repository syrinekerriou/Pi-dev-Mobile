/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Entite.Livre;
import com.bibliotheque.Entite.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Mohamedhabib - pc
 */
public class ServiceCommande {
    public static User currentUser=new User();
       
    // private static int idu = currentUser.getId();
     
         ArrayList<Commande> lis = new ArrayList<>();
    public void Commender(int id) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/commender?" + "idlivre=" + id+ "&idUser=" + ServiceUser.currentUser.getId();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public ArrayList<Commande> parseListComJson(String json) {

        ArrayList<Commande> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
        Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");
           // System.out.println(list);
            for (Map<String, Object> obj : list) {

                Commande e = new Commande();
                Livre l =new Livre();

                float id = Float.parseFloat(obj.get("idcommande").toString());
              float idliv = Float.parseFloat(obj.get("idlivre").toString());
              Double prix = Double.parseDouble(obj.get("prixlivre").toString());
              String nomlivre =obj.get("nomlivre").toString();
                e.setIdcommande((int) id);
              e.setIdl((int) idliv);
              e.setL(new Livre(nomlivre));
               
                e.setDatecommande(obj.get("datecommande").toString());
                e.setPrixlivre(prix);


                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        return listTasks;

    }


    public ArrayList<Commande> getCommande() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showcom?" + "idUser=" + ServiceUser.currentUser.getId());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
             public void actionPerformed(NetworkEvent evt) {
                ServiceCommande sl = new ServiceCommande();
                lis = sl.parseListComJson(new String(con.getResponseData()));

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return lis;
    }
        public void deleteCom(int idcommande) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/deletecom?" + "idcommande=" + idcommande;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
