/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;


import com.bibliotheque.Entite.Evenement;


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

/**
 *
 * @author farouk
 */
public class ServiceEvent {
     ArrayList<Evenement> listEvent = new ArrayList<>();
  
    public ArrayList<Evenement> EventParseJson(String json) throws ParseException {

        ArrayList<Evenement> listEvent1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Evenement e = new Evenement();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
                float id = Float.parseFloat(obj.get("id").toString());
               // float ide = Float.parseFloat(obj.get("idEnseignant").toString());
               // float quantite = Float.parseFloat(obj.get("quantitelivre").toString());
               //e.setIdenseignant((int)ide);
               e.setIdevenement((int)id);
               e.setDescription(obj.get("description").toString());
               e.setNomevent(obj.get("nomevent").toString());
        
                 
                listEvent1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listEvent1;
    }
     
     public ArrayList<Evenement> getListEvent() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showevent");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvent sl = new ServiceEvent();
                try {
                    listEvent = sl.EventParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvent;
    
    }
    
}
