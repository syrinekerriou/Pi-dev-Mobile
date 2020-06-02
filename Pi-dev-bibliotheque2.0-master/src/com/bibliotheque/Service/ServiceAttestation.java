/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.bibliotheque.Entite.Attestation;
import com.bibliotheque.Entite.Service;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author syrin
 */
public class ServiceAttestation {
     public void AddAttestation(Attestation P) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/addAttestation?ida=" + P.getIda()+ "&type=" + P.getTypea()+ "&langue=" + P.getLangue()+"&idUser=" + ServiceUser.currentUser.getId();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
      ArrayList<Attestation> listAttestation = new ArrayList<>();
   //ArrayList<Service> listlivreone = new ArrayList<>(); 
    public ArrayList<Attestation> AttestationParseJson(String json) throws ParseException {

        ArrayList<Attestation> listAttestation1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Attestation e = new Attestation();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
  
                //float prix = Float.parseFloat(obj.get("description").toString());
//               float ida = Float.parseFloat(obj.get("ida").toString());
//               float idu = Float.parseFloat(obj.get("idUser").toString());
            e.setLangue(obj.get("langue").toString());
      
        //  e.setIda((int)ida);
           
           
            e.setTypea(obj.get("typea").toString());
            
                 
                listAttestation1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listAttestation1;
    }
     
     public ArrayList<Attestation> getListAttestation() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showatt");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAttestation sl = new ServiceAttestation();
                try {
                    listAttestation = sl.AttestationParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAttestation;
    
    }
     
}
