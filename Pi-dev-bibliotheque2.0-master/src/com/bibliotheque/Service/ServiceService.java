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
import com.codename1.io.MultipartRequest;
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
public class ServiceService {
     ArrayList<Service> listService = new ArrayList<>();
   //ArrayList<Service> listlivreone = new ArrayList<>(); 
    public ArrayList<Service> ServiceParseJson(String json) throws ParseException {

        ArrayList<Service> listService1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");

            for (Map<String, Object> obj : list) {

                Service e = new Service();
               // float id = Float.parseFloat(obj.get("idExperience").toString());
              
                float id = Float.parseFloat(obj.get("ids").toString());
                //float prix = Float.parseFloat(obj.get("description").toString());
               float ida = Float.parseFloat(obj.get("ida").toString());
//               float idu = Float.parseFloat(obj.get("idUser").toString());
            e.setDescription(obj.get("description").toString());
             e.setDate(obj.get("date").toString());
          e.setIda((int)ida);
           
            e.setIds((int)id);
            e.setType(obj.get("typea").toString());
            
                 
                listService1.add(e);

            }

        } catch (IOException ex) {
        }
         //System.out.println(listLivre1);
        return listService1;
    }
     
     public ArrayList<Service> getListService() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showservice");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceService sl = new ServiceService();
                try {
                    listService = sl.ServiceParseJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listService;
    
    }
      public void AddService(Service c ,String a) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/addService?" + "Attestation="+ a +"&description=" + c.getDescription() +"&idUser="+ServiceUser.currentUser.getId() ;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

    }
}
