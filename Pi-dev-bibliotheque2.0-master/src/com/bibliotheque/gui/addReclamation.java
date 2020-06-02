/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bibliotheque.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
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



import com.bibliotheque.Entite.Reclamation;


import com.bibliotheque.Service.ServiceReclamation;

import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

import java.util.Date;







/**
 *
 * @author syrin
 */
public class addReclamation {
    


  public static int idu=3;

      Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
    TextField nomr;
    TextArea sujetr;
    Date dater;

    Reclamation mainRec;
   
        
    
   

    
    Button btnajout;
      Button b;
   
   public addReclamation (Resources res) {

 
        
       
       
        
      
        hi = new Form("Reclamation", BoxLayout.y());
       nomr = new TextField("", "objet", 20, 0);
        sujetr= new TextField("", "sujet", 60, 20);
        Picker dater = new Picker();
 
        btnajout = new Button("ajouter");
     b =new Button("Send us an email! ");
        installSidemenu(res);
        TextField search=new TextField();
        
       hi.getToolbar().addCommandToRightBar("add", res.getImage(""), e -> {
       //new addBook().su.show();
       });
      
        hi.add(nomr);
        hi.add(sujetr);
       // hi.add(b);
        hi.add(btnajout);
   
       //hi.add(btnaff);
       
        
        
        
        
      
     
             
      
        
      
           
       
       


   
         
      
        btnajout.addActionListener(new ActionListener() {
            {  
            }
        
                     
         @Override
         public void actionPerformed(ActionEvent evt) {
        
             if(nomr.getText().toString().equals("") || nomr.getText().toString() == null){
             Dialog.show("Cher client","Veuillez ajouter un objet de la reclamation", "ok", null);
             }else if(sujetr.getText().toString().equals("") || sujetr.getText().toString() == null){
             Dialog.show("Cher client","Veuillez ajouter un sujet de la reclamation", "ok", null);
             }else {
   
             mainRec = new Reclamation(nomr.getText(), sujetr.getText(),dater.getDate());
            ServiceReclamation s = new ServiceReclamation();
             s.AddReclamation(mainRec);
     
            Dialog.show("Cher client","Reclamation ajouter avec succes", "ok", null); 
       
  
       

             }
             
         }

 
        
   
     });
     
  com.codename1.messaging.Message m = new com.codename1.messaging.Message("I have seen your menu and I ....  ");
b.addActionListener(
        (ma) -> 
        { Display.getInstance().sendMessage(new String[] {"syrine.kerriou@esprit.tn"}, "Menus", m);

});
    
   }

    public Button getB() {
        return b;
    }

    public void setB(Button b) {
        this.b = b;
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
    
       hi. getToolbar().addCommandToSideMenu("Bibliotheques", null, e -> {
         displayLivre a = new displayLivre(res);
           a.hi.show();
        });
 
       hi. getToolbar().addCommandToSideMenu("My Commande", null, e -> {
         displayMycom a = new displayMycom(res);
            a.hi.show();
        });
        
       hi. getToolbar().addCommandToSideMenu("My Profile", null, e -> {
         displayProfile a = new displayProfile(res);
            a.hi.show();
        });

       hi. getToolbar().addCommandToSideMenu("Publication", statsImage, e -> {
      
                new PublicationForm(res).show();
     
        });
         hi.   getToolbar().addCommandToSideMenu("Service", null, e -> {
         displayService a = new displayService(res);
           a.hi.show();
        });
        hi.     getToolbar().addCommandToSideMenu("Attestation", null, e -> {
            addAttestation m = new addAttestation(res);
           m.hi.show();
             });
             hi. getToolbar().addCommandToSideMenu("Reclamation", null, e -> {
            addReclamation x = new addReclamation(res);
           x.hi.show();
             });
      hi.  getToolbar().addCommandToSideMenu("Blog", calendarImage, e -> new BlogForm(res).show());
         
    hi.    getToolbar().addCommandToSideMenu("Event", null, e -> {
          displayEvent a = new displayEvent(res);
          a.hi.show();
        });
       hi. getToolbar().addCommandToSideMenu("Offre", null, e -> {
          displayOffre a = new displayOffre(res);
          a.hi.show();
        });
          hi.   getToolbar().addCommandToSideMenu("LogOut", null, e -> {
                new SignInForm().showBack();
        });
    
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
        return nomr;
    }

    public void setNomr(TextField nomr) {
        this.nomr = nomr;
    }

    public TextArea getSujetr() {
        return sujetr;
    }

    public void setSujetr(TextArea sujetr) {
        this.sujetr = sujetr;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }

    
   
    
    
}

