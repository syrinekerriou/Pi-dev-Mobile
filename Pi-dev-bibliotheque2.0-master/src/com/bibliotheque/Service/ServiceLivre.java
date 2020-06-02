/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;


import com.bibliotheque.Entite.Livre;
import com.bibliotheque.Entite.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;

import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;


/**
 *
 * @author Mohamedhabib - pc
 */
public class ServiceLivre 
{
    ArrayList<Livre> listlivre = new ArrayList<>();
   ArrayList<Livre> listlivreone = new ArrayList<>(); 
    public ArrayList<Livre> LivreParseJson(String json) throws ParseException {

        ArrayList<Livre> listLivre1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Livre e = new Livre();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
                float id = Float.parseFloat(obj.get("idlivre").toString());
                float prix = Float.parseFloat(obj.get("prixlivre").toString());
                float quantite = Float.parseFloat(obj.get("quantitelivre").toString());
                 e.setIdlivre((int) id);
                //e.set((int) id);
                e.setNom(obj.get("nomlivre").toString());
                e.setAuteurlivre(obj.get("auteurlivre").toString());
                e.setContenu(obj.get("contenu").toString());
                e.setDatelivre(obj.get("datelivre").toString());
                e.setPrixlivre((int)prix);
                e.setQuantitelivre((int)quantite);
                 e.setImage_name(obj.get("imageName").toString());
                 
                listLivre1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listLivre1;
    }
     
     public ArrayList<Livre> getListLivre() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showlivre");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre sl = new ServiceLivre();
                try {
                    listlivre = sl.LivreParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listlivre;
    
    }
     public ArrayList<Livre> LivreParseoneJson(String json) throws ParseException {

        ArrayList<Livre> listLivre1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Livre e = new Livre();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
                float id = Float.parseFloat(obj.get("idlivre").toString());
                float prix = Float.parseFloat(obj.get("prixlivre").toString());
                float quantite = Float.parseFloat(obj.get("quantitelivre").toString());
                 e.setIdlivre((int) id);
                //e.set((int) id);
                e.setNom(obj.get("nomlivre").toString());
                e.setAuteurlivre(obj.get("auteurlivre").toString());
                e.setContenu(obj.get("contenu").toString());
                e.setDatelivre(obj.get("datelivre").toString());
                e.setPrixlivre((int)prix);
                e.setQuantitelivre((int)quantite);
                 e.setImage_name(obj.get("imageName").toString());
                 
                listLivre1.add(e);

            }

        } catch (IOException ex) {
        }
        // System.out.println(listLivre1);
        return listLivre1;
    }
         public ArrayList<Livre> getListLivred(String q) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/searchLivre?"+"idlivre="+q+"nomlivre"+q);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre sl = new ServiceLivre();
                try {
                    listlivre = sl.LivreParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listlivre;
    
    }
     public void addbook(Livre e,String img) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/addbook?" + "nomlivre=" + e.getNomlivre()+ "&auteur=" + e.getAuteur() + "&prix=" + e.getPrixlivre() + "&contenu=" + e.getContenu() + "&quantite=" + e.getQuantitelivre()+ "&img=" + img ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
          
        con.addResponseListener((ee) -> {
            
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

}
