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
import com.bibliotheque.Entite.Commentaire;
import com.bibliotheque.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Daly
 */
public class CommentaireServices {

    public List<Commentaire> AfficherComPub(int idp) {
        List<Commentaire> myList = new ArrayList();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/forum/affichercp?idPub=" + idp);
        con.addResponseListener(a -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> prods = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) prods.get("root");
                Result result = Result.fromContent(prods);
                for (Map<String, Object> obj : list) {
                    Commentaire p = new Commentaire();
                    User u = new User();
                    float idc = Float.parseFloat(obj.get("idc").toString());
                    p.setIdc((int) idc);
                    p.setDescription(obj.get("descriptionc").toString());
                    LinkedHashMap m = new LinkedHashMap();
                    m = (LinkedHashMap) obj.get("iduser");
                    List<String> listValues = new ArrayList<String>(m.values());
                    Object var = listValues.get(2);
                    u.setId((int) Math.round((double) var));
                    u.setUsername(listValues.get(3));
                    p.setUser(u);
                    p.setIdPublication(idp);
                    p.setDate(obj.get("datec").toString());
                    myList.add(p);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return myList;
    }

    public void deleteComm(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pi-dev/web/app_dev.php/forum/supprimerComMobile?idCom=" + id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void AddComment(Commentaire c) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/pi-dev/web/app_dev.php/forum/ajouterComMobile?idUser=" + c.getUser().getId() + "&description=" + c.getDescription() + "&idPub=" + c.getIdPublication();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

    }
}
