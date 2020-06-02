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
import com.bibliotheque.Entite.Blog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Daly
 */
public class BlogServices {

    public List<Blog> afficherBlog() {

        List<Blog> myList = new ArrayList();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/blog/afficher");
        con.addResponseListener(a -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> prods = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) prods.get("root");
                for (Map<String, Object> obj : list) {
                    Blog p = new Blog();
                    float idB = Float.parseFloat(obj.get("idb").toString());
                    p.setIdb((int) idB);
                    p.setDescription(obj.get("description").toString());
                    p.setSujet(obj.get("sujet").toString());
                    p.setType(obj.get("type").toString());
                    myList.add(p);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return myList;
    }
}
