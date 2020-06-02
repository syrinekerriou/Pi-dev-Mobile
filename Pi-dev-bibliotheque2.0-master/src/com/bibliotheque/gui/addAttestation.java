/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bibliotheque.gui;


import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.GenericListCellRenderer;

import com.bibliotheque.Entite.Attestation;

import com.bibliotheque.Service.ServiceAttestation;

import com.codename1.ui.util.Resources;


import java.util.Date;






/**
 *
 * @author syrin
 */
public class addAttestation{
    


  public static int idu=3;

      Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
    TextField types;
    TextArea langue;
    Date dater;

    Attestation mainRec;
   
        
        

    
    Button btnajout;
    
   
   public addAttestation(Resources res) {

 
        
       
       
        
      
        hi = new Form("Attestation", BoxLayout.y());
       types = new TextField("", "Type", 20, 0);
        langue= new TextField("", "langue", 60, 20);
      
 
        btnajout = new Button("ajouter");
    
        installSidemenu(res);
        TextField search=new TextField();
        
       hi.getToolbar().addCommandToRightBar("add", res.getImage(""), e -> {
       //new addBook().su.show();
       });
      
        hi.add(types);
        hi.add(langue);
 
        hi.add(btnajout);
   
       //hi.add(btnaff);
       
        
        
        
        
      
     
             
      
        
      
           
       
       


   
         
      
        btnajout.addActionListener(new ActionListener() {
            {  
            }
        
                     
         @Override
         public void actionPerformed(ActionEvent evt) {
        
             if(types.getText().toString().equals("") || types.getText().toString() == null){
             Dialog.show("Cher client","Veuillez ajouter le type", "ok", null);
             }else if(langue.getText().toString().equals("") || langue.getText().toString() == null){
             Dialog.show("Cher client","Veuillez ajouter une langue", "ok", null);
             }else {
   
             mainRec = new Attestation(types.getText(), langue.getText());
            ServiceAttestation s = new ServiceAttestation();
             s.AddAttestation(mainRec);
     
            Dialog.show("Cher client","Attestation ajouté avec succés", "ok", null); 
       
  
       

             }
             
         }

 
        
   
     });
     
 
    
   }

  


    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnajout() {
        return btnajout;
    }
    
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Button inboxButton = new Button("Inbox", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new InboxForm().show());
        hi.getToolbar().addComponentToSideMenu(inbox);
        
        //
        
        //getToolbar().addCommandToSideMenu("Stats", statsImage, e -> new StatsForm(res).show());
       //getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
        hi.getToolbar().addCommandToSideMenu("Service", null, e -> {
        displayService a = new displayService(res);
          a.hi.show();
        });
       // 
      // getToolbar().addCommandToSideMenu("Trending", trendingImage, e -> new TrendingForm(res).show());
        hi.getToolbar().addCommandToSideMenu("Attestation", null, e -> {
     addAttestation m = new addAttestation(res);
            m.hi.show();
        });
                     hi.getToolbar().addCommandToSideMenu("Reclamation", null, e -> {
       addReclamation x = new addReclamation(res);
            x.hi.show();
        });
        

            hi.getToolbar().addCommandToSideMenu("LogOut", null, e -> {
                new SignInForm().showBack();
        });
        
        // spacer
        hi.getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        hi.getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        hi.getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
        hi.getToolbar().addComponentToSideMenu(new Label("Long Beach, CA", "SideCommandSmall"));
    
    }
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }

    public Form getHi() {
        return hi;
    }

    public void setHi(Form hi) {
        this.hi = hi;
    }

    public TextField getNomr() {
        return types;
    }

    public void setNomr(TextField types) {
        this.types = types;
    }

    public TextArea getSujetr() {
        return langue;
    }

    public void setSujetr(TextArea langue) {
        this.langue = langue;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }

    
   
    
    
}

