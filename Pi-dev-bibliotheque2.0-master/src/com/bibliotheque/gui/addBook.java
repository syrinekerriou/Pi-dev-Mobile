/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Entite.Livre;
import com.bibliotheque.Entite.User;
import com.bibliotheque.Service.ServiceLivre;
import com.bibliotheque.Service.ServiceUser;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.EventDispatcher;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mohamedhabib - pc
 */
public class addBook {
    
    Form su= new Form();
     private EventDispatcher listeners = new EventDispatcher();
        EncodedImage enc;
       Image imgs;
       String img;
    ImageViewer imgv;
     public ArrayList<Livre> exp2 = new ArrayList<>();
  private Resources theme;
    private Container c;
    private UIBuilder uiBuilder;
    public addBook() {
      su = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        uiBuilder = new UIBuilder();
        theme = UIManager.initFirstTheme("/theme");
       
        su= new Form("signUp");
           su.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("addBook", "Title")
                        
                )
        );
               su.getToolbar().addCommandToLeftBar("back",null,new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
              
             new displayLivre(theme).hi.showBack();
         }
     });
         TextField nom = new TextField("", "nom", 201, TextField.ANY);
        nom.setHint("Titre");
        
         TextField auteur = new TextField("", "auteur", 201, TextField.ANY);
        auteur.setHint("Auteur");
        
        TextField prix = new TextField("", "prix", 201, TextField.ANY);
        prix.setHint("prix");
       
        TextField quantite = new TextField("", "quantite", 201, TextField.NUMERIC);
     
        quantite.setHint("quantite");
        TextField contenu = new TextField("", "contenu", 45, TextField.PASSWORD);
 
        contenu.setHint("Contenu");
       // TextField cmdp = new TextField("", "confirmation mdp", 45, TextField.PASSWORD);
   
       // cmdp.setHint("Confirmer mote de passe");
       ComboBox<String> imgnom=new ComboBox<>();
       ServiceLivre sl = new ServiceLivre();
       exp2=sl.getListLivre();
          for (int i = 0; i < exp2.size(); i++) {
            imgnom.addItem(exp2.get(i).getImage_name());
           // System.out.println(exp2.get(i).getIdPays().get("name").toString());
        }


        try {
            enc = EncodedImage.create("/load.png");
           // listeners.addListener(img);
        } catch (IOException ex) {
           // Logger.getLogger(addBook.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        Button signup = new Button("add");
                 Validator validator = new Validator();
        //validator.addConstraint(email, RegexConstraint.validEmail());
       validator.addSubmitButtons(signup);
        su.add(nom);
        su.add(auteur);
        su.add(prix);
        su.add(quantite);
        su.add(contenu);

        //su.add(cmdp);
        su.add(imgnom);
       
     
//        imgv.respondsToPointerEvents();
        su.add(signup);
         
         
     imgnom.addActionListener(e->{
   img= imgnom.getSelectedItem();
       String url="http://localhost/pi-dev/web/uploads/images/"+img;
             imgs = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE_TO_FILL);
    
     
    System.out.println(img);
      imgv = new ImageViewer(imgs);
     // imgv.remove();
       su.add(imgv);
       imgv.refreshTheme();
    
});

   
       // signup.requestFocus();
       signup.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
       
     
                        
                    
              ServiceUser sU= new ServiceUser();
              Livre u= new Livre(nom.getText(),auteur.getText(),Integer.valueOf(prix.getText()),contenu.getText(),Integer.valueOf(quantite.getText()));
              sl.addbook(u,img);
              nom.clear();
              quantite.clear();
              auteur.clear();
              contenu.clear();
              prix.clear();
              //cmdp.clear();
               new displayLivre(theme).hi.showBack();
              
               
          }
      });
       
    }
    
    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }
    
}
