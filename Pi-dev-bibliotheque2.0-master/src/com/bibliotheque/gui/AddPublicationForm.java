/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Service.PublicationServices;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.bibliotheque.Entite.Publication;
import com.bibliotheque.Service.ServiceUser;
import static com.bibliotheque.gui.CommentaireForm.res;

/**
 *
 * @author Daly
 */
public class AddPublicationForm {
    
    
    com.codename1.ui.util.Resources resourceObjectInstance;
    
     public void AddPublication() {
         
         Form f = new Form("Ajouter une publication");
         TextArea description = new TextArea();
         Button ajouter = new Button("Ajouter");
         TextField type = new TextField();
         
         
         ajouter.addActionListener(e -> {
         PublicationServices ps = new PublicationServices();
         Publication P = new Publication();
         P.setDescription(description.getText());
         P.setType(type.getText());
         P.setIdUser(ServiceUser.currentUser.getId());
         ps.AddPublication(P);
         new PublicationForm(res).show();
         });
         
         Container c1 = new Container(new BorderLayout());
         Container c2 = new Container(new BorderLayout());
         Container c3 = new Container(new BorderLayout());
         Container c4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         f.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
         
         c1.add(BorderLayout.CENTER, description);
         c2.add(BorderLayout.CENTER, ajouter);
         c3.add(BorderLayout.CENTER, type);
         c4.addAll(c3,c1,c2); 
         f.addComponent(BorderLayout.CENTER, c4);
         f.show();
     }
}
