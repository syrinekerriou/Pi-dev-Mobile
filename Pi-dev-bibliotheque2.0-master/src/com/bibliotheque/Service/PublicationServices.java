/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import com.bibliotheque.Entite.Publication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Daly
 */
public class PublicationServices {

    public List<Publication> returnPublication() {

        List<Publication> myList = new ArrayList();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/forum/afficherp");
        con.addResponseListener(a -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> prods = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) prods.get("root");
                Result result = Result.fromContent(prods);
                for (Map<String, Object> obj : list) {
                    Publication p = new Publication();
                    float id = Float.parseFloat(obj.get("id").toString());
                    p.setId((int) id);
                    p.setDescription(obj.get("descriptionp").toString());
                    p.setType(obj.get("typep").toString());
                    LinkedHashMap m = new LinkedHashMap();
                    m = (LinkedHashMap) obj.get("idUser");
                    List<String> listValues = new ArrayList<String>(m.values());
                    Object var = listValues.get(2);
                    p.setIdUser((int) Math.round((double) var));
                    myList.add(p);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return myList;
    }

    public void AddPublication(Publication P) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/pi-dev/web/app_dev.php/forum/ajouterPubMobile?idUser=" +ServiceUser.currentUser.getId()+ "&type=" + P.getType() + "&description=" + P.getDescription();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public void SupprimerPublucation(int id) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/pi-dev/web/app_dev.php/forum/supprimerPubMobile?idPub=" + id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

    }
}
