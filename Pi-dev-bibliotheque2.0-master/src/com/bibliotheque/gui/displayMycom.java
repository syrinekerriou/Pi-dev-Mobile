/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Entite.Livre;
import com.bibliotheque.Service.ServiceCommande;
import com.bibliotheque.Service.ServiceLivraison;
import com.bibliotheque.Service.ServiceLivre;
import static com.bibliotheque.gui.displayLivre.idu;
import com.codename1.components.InteractionDialog;
import com.codename1.components.MultiButton;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Mohamedhabib - pc
 */
public class displayMycom  {
    Form hi = new Form("",new BoxLayout(BoxLayout.Y_AXIS));
   
    public static int idu=1;
    public static int idee = 0;
    public static int xx = 0;
    public displayMycom(Resources res)
    {
       hi. getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("MyCommande", "Title")
                        
                )
        );
         installSidemenu(res);
        
        hi.getToolbar().addCommandToRightBar("", res.getImage("toolbar-profile-pic.png"), e -> {});
        ServiceCommande serviceTask = new ServiceCommande();
      



        


     List<Commande> list = serviceTask.getCommande();
          for (Commande l:list)
      { 
          String a=l.getL().getNomlivre();


          System.out.println(l);
hi.add(createRankWidget(l,l.getIdcommande(),a, l.getPrixlivre(),res));

    }
       
  }

    displayMycom() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
          public SwipeableContainer createRankWidget(Commande c,int id,String auteur,Double Contenu,Resources res) {
            MultiButton button = new MultiButton(auteur);  
            Button reserver = new Button("annuler");
           
       //add(button);
        //add(reserver);
       
    // button.setTextLine1("" + Contenu);

        button.setHeight(100);
        Label lb = new Label();
        lb.setText(""+id);

    
         button.setTextLine2(""+Contenu+"mil");
         button.setTextLine3("payer");
              button.addActionListener(e->{
         
             dialog(c,res);
         });
        reserver.addActionListener(e -> {
         
         
            ServiceCommande se= new ServiceCommande();
            se.deleteCom(id);
            
        displayMycom a = new displayMycom(res);
            a.hi.show();
                       Dialog.show("My Commande", "Commande éannulé avec succée !", "ok", null);
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
         private void dialog(Commande a,Resources res) {
        
    Dialog d = new Dialog(a.getL().getNomlivre());
        Double prixpay=a.getPrixlivre();
        TextArea popupBody = new TextArea( "prix:"+a.getPrixlivre()+"millimes" + "\n"  , 8, 12);
        popupBody.setUIID("Label");
        popupBody.setEditable(false);
         Button livrer = new Button("livraison");
         Button payer = new Button("payer");
          Button annuler = new Button("annuler");
        d.setLayout(new BorderLayout());
        d.addComponent(BorderLayout.NORTH, popupBody);
        d.addComponent(BorderLayout.EAST, livrer);
         d.addComponent(BorderLayout.CENTER, payer);
          d.addComponent(BorderLayout.SOUTH, annuler);
          
         livrer.addActionListener(ev -> {
             ServiceLivraison se= new ServiceLivraison();
             se.Livrer(a.getIdcommande());
      Dialog.show("My Commande", "your order is going to be delivred!", "ok", null);
            
        });
          payer.addActionListener(ev -> {
         
             new StripeForm(prixpay).getF().show();
        });
          annuler.addActionListener((ActionEvent e) -> {
         
         
            ServiceCommande se= new ServiceCommande();
            se.deleteCom(a.getIdcommande());
            
       // displayMycom a = new displayMycom(res);
         //   a.show();
       
        });
        d.setTransitionInAnimator(CommonTransitions.createEmpty());
        d.setTransitionOutAnimator(CommonTransitions.createFade(300));
        Rectangle rec = new Rectangle();
        rec.setX(700);
        rec.setY(500);
        d.showPopupDialog(rec);
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
    

