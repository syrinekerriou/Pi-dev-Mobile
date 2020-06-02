/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Entite.Livre;
import com.bibliotheque.Service.ServiceCommande;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import com.bibliotheque.gui.displayLivre;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.UIBuilder;
/**
 *
 * @author Mohamedhabib - pc
 */
public class displayoneBook {
    Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;
 private Resources theme;

  
    public displayoneBook(Livre l,Resources res)
    {
             
 
     String img=l.getImage_name();
    String url="http://localhost/pi-dev/web/uploads/images/"+img;
        hi.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label(l.getNomlivre(), "Title")
                        
                )
        );
         //installSidemenu(res);
        
        hi.getToolbar().addCommandToLeftBar("back", res.getImage(""),new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
               displayLivre a = new displayLivre(res);
                a.hi.showBack();
         }
     });
       
        TextArea popupBody = new TextArea("Auteur:"+ l.getAuteurlivre() + "\n" +"prix:"+ l.getPrixlivre()+"millimes" + "\n"+ "Contenu:"+ l.getContenu() + "\n"  , 8, 12);
        popupBody.setEditable(false);
         try {
            enc = EncodedImage.create("/load.png");
                    } catch (IOException ex) {
     
        }
        // Form f1 = new Form("",new BoxLayout(BoxLayout.Y_AXIS));
          Button reserver = new Button("Commender");
          reserver.addActionListener(e -> {
         
           // System.out.println(idl);
            Commande ser = new Commande();
            ServiceCommande se= new ServiceCommande();
            se.Commender(l.getIdlivre());
              Dialog.show("My Commande", "Commande éffectué avec succée !", "ok", null);
         
        });
        imgs = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE_TO_FILL);
    
         imgv = new ImageViewer(imgs);
        Container C1= new Container( new BoxLayout(BoxLayout.Y_AXIS));
        
        C1.add(popupBody);
        Container C2= new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.add(imgv);
       hi.add(C2);
      hi.add(C1);
      hi.add(reserver);
       
       hi.show();   
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
  
}
