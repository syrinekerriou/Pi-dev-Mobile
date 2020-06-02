/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Service.CommentaireServices;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.bibliotheque.Entite.Commentaire;
import com.bibliotheque.Entite.Publication;
import com.bibliotheque.Service.ServiceUser;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Daly
 */
public class AddCommentaireForm {
    
       
    com.codename1.ui.util.Resources resourceObjectInstance;
    Resources res;
     public void AddComment(Publication P) {
        
         
      Form f = new Form("Ajouter un commentaire");
         Style ss = UIManager.getInstance().getComponentStyle("TitleCommand");
            FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_CANCEL, ss);

         f.getToolbar().addCommandToLeftBar("", icon, ev ->{
             new PublicationForm().showBack();
         });
         TextArea comment = new TextArea();
         Label PubDes = new Label(P.getDescription());
         Label PubType = new Label(P.getType());
         Button ajouter = new Button("Ajouter");
         
         ajouter.addActionListener(e -> {
         Commentaire c = new Commentaire();
         c.getUser().setId(ServiceUser.currentUser.getId());
         c.setDescription(comment.getText());
         c.setIdPublication(P.getId());
         CommentaireServices cs = new CommentaireServices();
         cs.AddComment(c);
         
         new CommentaireForm(CommentaireForm.res).show();
         });
         
         Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Container c2 = new Container(new BorderLayout());
         Container c3 = new Container(new BorderLayout());
         Container c5 = new Container(new BorderLayout());
         Container c4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         f.setLayout(new BorderLayout());
         
         c1.add(comment);
         c2.add(BorderLayout.CENTER, ajouter);
         c3.add(BorderLayout.CENTER, PubType);
         c5.add(BorderLayout.CENTER, PubDes);
         c4.addAll(c3,c5,c1,c2); 
         f.addComponent(BorderLayout.CENTER, c4);
         f.show();
     }
}
