/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Entite.Livre;
import com.bibliotheque.Service.ServiceCommande;
import com.bibliotheque.Service.ServiceLivre;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.List;
import com.bibliotheque.gui.BaseForm;
import com.codename1.ui.TextField;
import static jdk.nashorn.internal.objects.NativeString.search;



/**
 *
 * @author Mohamedhabib - pc
 */
public class displayLivre {
    public static int idu=3;
    public static int idl=0;
    Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
//h.add(lb);
  public displayLivre(Resources res) {
 
 
        
        hi.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Bibliotheques", "Title")
                        
                )
        );
        installSidemenu(res);
        TextField search=new TextField();
        
       hi.getToolbar().addCommandToRightBar("add", res.getImage(""), e -> {
       new addBook().su.show();
       });
        ServiceLivre serviceTask = new ServiceLivre();
      

     List<Livre> list = serviceTask.getListLivre();
          for (Livre l:list)
      {
         String img=l.getImage_name();
  Image Image = res.getImage("/"+img);
//        Image.scaledSmallerRatio(20, 20);
        ImageViewer imgv = new ImageViewer(Image);
      //  System.out.println(Image);
        //  addItem(l);
     
    
hi.add(createRankWidget(l,l.getIdlivre(),l.getNomlivre(), l.getAuteurlivre(),l.getPrixlivre(),l.getContenu(),l.getImage_name(),res));
 hi.showBack();
    }
    
  }
  
          public SwipeableContainer createRankWidget(Livre l,int id,String name, String auteur,int price,String Contenu,String img,Resources res) {
            MultiButton button = new MultiButton(name);  
            Button reserver = new Button("Commender");
        //add(reserver);
    

      
        button.setHeight(100);

        //button.setIcon(Image);
        button.setTextLine1(name);
        button.setTextLine2(auteur);
        button.setTextLine3("" + price);
        
             
         //button.setTextLine4(Contenu);
         button.addActionListener(e->{
            
               displayoneBook a = new displayoneBook(l,res);
         
             //dialog(l,res);
         });
          
        reserver.addActionListener(e -> {
         
           // System.out.println(idl);
            Commande ser = new Commande();
            ServiceCommande se= new ServiceCommande();
            se.Commender(id);
            Dialog.show("Sign In", "your book "+name+"has been ordered", "ok", null);
        });
       
    return new SwipeableContainer(FlowLayout.encloseCenterMiddle(createStarRankSlider()), 
            button);
}
private Slider createStarRankSlider() {
    Slider starRank = new Slider();

     return starRank;
}
   private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
       private void dialog(Livre e,Resources res) {
       
        Dialog d = new Dialog(e.getNomlivre());
        String img=e.getImage_name();
        TextArea popupBody = new TextArea( e.getAuteurlivre() + "\n" + e.getPrixlivre() + "\n" + e.getContenu() + "\n"  , 8, 12);
  
        popupBody.setUIID("Label");
        popupBody.setEditable(false);
        Button b = new Button("test");
        d.setLayout(new BorderLayout());
        
        d.addComponent(BorderLayout.CENTER, popupBody);
      //  d.add(BorderLayout.SOUTH,imgv);
   
        d.setTransitionInAnimator(CommonTransitions.createEmpty());
        d.setTransitionOutAnimator(CommonTransitions.createFade(300));
        Rectangle rec = new Rectangle();
        rec.setX(700);
        rec.setY(1000);
        d.showPopupDialog(rec);
    }
        private void notif()
  {
         LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("your book has been added to your Order list");
        n.setAlertTitle("Order added!");
        n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
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

 
