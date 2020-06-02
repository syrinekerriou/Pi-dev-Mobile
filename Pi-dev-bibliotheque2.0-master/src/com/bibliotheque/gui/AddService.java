/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Entite.Attestation;
import com.bibliotheque.Entite.Service;
import com.bibliotheque.Service.ServiceAttestation;
import com.bibliotheque.Service.ServiceService;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.ArrayList;


/**
 *
 * @author syrin
 */
public class AddService {
       Form su= new Form();
  private Resources theme;
    private Container c;
    private UIBuilder uiBuilder;
    public AddService() {
      su = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        uiBuilder = new UIBuilder();
        theme = UIManager.initFirstTheme("/theme");
       
        su= new Form("Ajout");
           su.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Ajout", "Title")
                        
                )
        );
               su.getToolbar().addCommandToLeftBar("back",null,new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
              
               new SignInForm().showBack();
         }
     });
         TextField nom = new TextField("", "nom", 201, TextField.ANY);
        nom.setHint("nom");
        

        
       ComboBox<String> cat= new ComboBox<>();
        ServiceAttestation sc=new ServiceAttestation();
        ArrayList<Attestation> listCat = sc.getListAttestation();
        for(int i=0;i<listCat.size();i++ )
        {
            cat.addItem(listCat.get(i).getTypea());
        }
  
        Button signup = new Button("ajouter");

        su.add(nom);
   
        su.add(cat);

        su.add(signup);
         
     
   
       // signup.requestFocus();
       signup.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
       
             String idCat=cat.getSelectedItem();
             String desc=nom.getText();
              
              System.out.println(idCat);
              System.out.println(desc);
              ServiceService sU= new ServiceService();
              Service u= new Service(desc);
              sU.AddService(u,idCat);
                    
                         com.codename1.messaging.Message m = new com.codename1.messaging.Message("");
                                 Display.getInstance().sendMessage(new String[] {"syrine.kerriou@esprit.tn"}, "Menus", m);


   
               new displayService(theme).hi.showBack();
                       Dialog.show("Cher client","Service ajouter avec succes", "ok", null); 
                    }
                 
                
               
          
      });
       
    }
    
    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }
    
}
