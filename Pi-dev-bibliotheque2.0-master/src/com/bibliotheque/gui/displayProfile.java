/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Entite.User;
import com.bibliotheque.Service.ServiceCommande;
import com.bibliotheque.Service.ServiceLivraison;
import com.bibliotheque.Service.ServiceUser;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.List;

/**
 *
 * @author Mohamedhabib - pc
 */
public class displayProfile {
      Form hi = new Form("",new BoxLayout(BoxLayout.Y_AXIS));
   
    public static int idu=1;
    public static int idee = 0;
    public static int xx = 0;
    public displayProfile(Resources res)
    {
       hi. getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("My Profile", "Title")
                        
                )
        );
         installSidemenu(res);
        
        hi.getToolbar().addCommandToRightBar("", res.getImage("toolbar-profile-pic.png"), e -> {});
        ServiceUser serviceTask = new ServiceUser();

      



        


     List<User> list = serviceTask.getUser();
          for (User l:list)
      { 
          
          String nom=l.getNom();
          String prenom=l.getPrenom();
          String email=l.getEmail();


          System.out.println(l);
hi.add(createRankWidget(l,nom,prenom,email,res));

    }
       
  }

    displayProfile() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
          public SwipeableContainer createRankWidget(User c,String nom,String prenom,String email,Resources res) {
            MultiButton button = new MultiButton(email);  
           // Button reserver = new Button("annuler");
           
       //add(button);
        //add(reserver);
       
    // button.setTextLine1("" + Contenu);

        button.setHeight(100);
        Label lb = new Label();
        lb.setText(email);

    
         button.setTextLine2("nom: "+nom+" prenom: "+prenom);
         //button.setTextLine3(prenom);
              button.addActionListener(e->{
                  dialog(c, res);
         
           
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
         private void dialog(User a,Resources res) {
        
    Dialog d = new Dialog(a.getEmail());
      
        //TextArea popupBody = new TextArea( "prix:"+a.getPrixlivre()+"millimes" + "\n"  , 8, 12);
      //  popupBody.setUIID("Label");
      //  popupBody.setEditable(false);
      TextField mdp = new TextField("", "mdp", 45, TextField.PASSWORD);
      mdp.setEditable(true);
      mdp.setHint("nouveau mot de passe");
      TextField cmdp = new TextField("", "cmdp", 45, TextField.PASSWORD);
      cmdp.setEditable(true);
       cmdp.setHint("confirmer mot de passe");
          Button annuler = new Button("modifier");
        d.setLayout(new BorderLayout());
        d.addComponent(BorderLayout.NORTH, mdp);
         d.addComponent(BorderLayout.CENTER, cmdp);
          d.addComponent(BorderLayout.SOUTH, annuler);
         
       
        
          annuler.addActionListener((ActionEvent e) -> {
          if(mdp.getText().isEmpty()||cmdp.getText().isEmpty())
          {
               Dialog.show("AVERTISSEMENT !!!", "Veuillez verifier vos champs Mercii !!!", "OK", null);
          }else{
               if(mdp.getText().equals(cmdp.getText())){
         
            ServiceUser se= new ServiceUser();
            se.updatemdp(mdp.getText());
                mdp.clear();
                cmdp.clear();
             
          }
          }
       
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
