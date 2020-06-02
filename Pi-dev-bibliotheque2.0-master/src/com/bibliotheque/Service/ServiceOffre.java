/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.bibliotheque.Entite.Offre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author farouk
 */
public class ServiceOffre {
        ArrayList<Offre> listOffre = new ArrayList<>();
  
    public ArrayList<Offre> OffreParseJson(String json) throws ParseException {

        ArrayList<Offre> listEvent1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Offre e = new Offre();
        
                float id = Float.parseFloat(obj.get("id").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
             
               e.setIdoffre((int)id);
               e.setDescription(obj.get("description").toString());
               e.setImage(obj.get("photo").toString());
               e.setPrixoffre((double)prix);
                 
                listEvent1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listEvent1;
    }
     
     public ArrayList<Offre> getListOffre() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showoffre");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceOffre sl = new ServiceOffre();
                try {
                    listOffre = sl.OffreParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffre;
    
    }
    
    
}
