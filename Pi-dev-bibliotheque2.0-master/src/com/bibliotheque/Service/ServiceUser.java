package com.bibliotheque.Service;


import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Entite.User;
import com.bibliotheque.gui.SignInForm;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamedhabib - pc
 */
public class ServiceUser {
        public void inscription(User e) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/register?" + "nom=" + e.getNom() + "&prenom=" + e.getPrenom() + "&username=" + e.getUsername() + "&email=" + e.getEmail() + "&password=" + e.getPassword() ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
          
        con.addResponseListener((ee) -> {
            
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public static User currentUser=new User();
    public String Login(String username , String password) {
        String msg1 = "";
       // String pw_hash=BCrypt.hashpw(password);
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/login" + "/" + username
                + "/" + password;
             
               
        con.setUrl(Url);

        System.out.println("verifying");

        con.addResponseListener((event) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        return Url;
    }

    public Boolean login1(String username, String password) {
        String msg1 = "";
        Label msg2=new Label();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl(Login(username, password));

        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
        
                JSONParser jsonp = new JSONParser();
                System.out.println("debut1");
                try {
                    Map<String, Object> User = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
     
                    System.out.println("*********************event******************************");
                    System.out.println(User);
                    System.out.println("********************************************");
                    System.out.println(User.get("root"));
                    System.out.println("********************************************");
                    List<Map<String, Object>> list = (List<Map<String, Object>>) User.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println("*********************obj******************************");
                        System.out.println(obj);
                        System.out.println("********************************************");
                        LinkedHashMap<String, Object> objUser = (LinkedHashMap<String, Object>) obj.get("user");

                        String msg = obj.get("message").toString();
                        System.out.println(msg);
                                msg2.setText(msg);
                        if (msg.equals("connection etablie")) {
                            User u = new User();

                            u.setId((int) Float.parseFloat(objUser.get("id").toString()));
                            u.setUsername(objUser.get("username").toString());
                            u.setEmail(objUser.get("email").toString());
                            String psw = objUser.get("password").toString();
                            u.setPassword(psw);
                            u.setNom(objUser.get("nom").toString());
                          u.setPrenom(objUser.get("prenom").toString());
                 

                            currentUser=u;
                            System.out.println(u);
                        }
                    
                        
                    
                       
                        

                    }
                } catch (IOException ex) {
                   // System.out.println(ex.getMessage());
                }

            }

           
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        boolean test=false;
         msg1=msg2.getText();
        System.out.println("msg1  : "+msg1);
       
        if (msg1.equals("connection etablie"))
        {
            test=true;
        }
        else{
            Dialog.show("Sign In", "Verifier vos Coordonées !", "ok", null);
                new SignInForm().show();
            return test;
        }
        System.out.println("test= "+test);
        return test;
    }
    public ArrayList<User> parseListprofileJson(String json) {

        ArrayList<User> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
        Map<String, Object> experiences = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) experiences.get("root");
            System.out.println(list);
            for (Map<String, Object> obj : list) {

              User e = new User();

              //  float id = Float.parseFloat(obj.get("id").toString());
              //float idliv = Float.parseFloat(obj.get("idlivre").toString());
             // Double prix = Double.parseDouble(obj.get("prixlivre").toString());
              String nom =obj.get("nom").toString();
              String prenom =obj.get("prenom").toString();
              String email =obj.get("email").toString();
               // e.setId((int) id);
              e.setNom(nom);
              e.setPrenom(prenom);
              e.setEmail(email);
              //e.setL(new Livre(nomlivre));
               
             


                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        return listTasks;

    }
    ArrayList<User> lis = new ArrayList<>();
      public ArrayList<User> getUser() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-dev/web/app_dev.php/mobile/showprofile?" + "id=" + ServiceUser.currentUser.getId());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
             public void actionPerformed(NetworkEvent evt) {
                ServiceUser sl = new ServiceUser();
                lis = sl.parseListprofileJson(new String(con.getResponseData()));

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return lis;
    }
              public void updatemdp(String password) {
        MultipartRequest con = new MultipartRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/pi-dev/web/app_dev.php/mobile/updatemdp?"+ "id=" + ServiceUser.currentUser.getId()+ "&password=" + password ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
          
        con.addResponseListener((ee) -> {
            
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
