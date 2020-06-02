/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.bibliotheque.gui;

import com.codename1.admob.AdMobManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
     private AdMobManager admob;
    int n = 0;
    public void installSidemenu(Resources res) {
    
         try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //   String admobId = "ca-app-pub-3940256099942544~3347511713";
        String admobId = "ca-app-pub-3940256099942544/1033173712";
        if (Display.getInstance().getPlatformName().equals("ios")) {
            admobId = "ca-app-pub-3940256099942544/1033173712";
        }

        // Note:  admobId is the ID of the target ads you want to display
        // not your admob App ID.
        // See instructions for Android and iOS below for specifying admob app ID
        // via build hints.
        admob = new AdMobManager(admobId);
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
        getToolbar().addComponentToSideMenu(inbox);
        

        getToolbar().addCommandToSideMenu("Bibliotheques", null, e -> {
         displayLivre a = new displayLivre(res);
           a.hi.show();
        });
 
        getToolbar().addCommandToSideMenu("My Commande", null, e -> {
         displayMycom a = new displayMycom(res);
            a.hi.show();
        });
        
        getToolbar().addCommandToSideMenu("My Profile", null, e -> {
         displayProfile a = new displayProfile(res);
            a.hi.show();
        });
        

            
        getToolbar().addCommandToSideMenu("Publication", statsImage, e -> {
            if (n % 2 == 0) {
                admob.loadAndShow();
               n++;
           } else {
                n++;
                new PublicationForm(res).show();
           }
        });
            getToolbar().addCommandToSideMenu("Service", null, e -> {
         displayService a = new displayService(res);
           a.hi.show();
        });
             getToolbar().addCommandToSideMenu("Attestation", null, e -> {
            addAttestation m = new addAttestation(res);
           m.hi.show();
             });
              getToolbar().addCommandToSideMenu("Reclamation", null, e -> {
            addReclamation x = new addReclamation(res);
           x.hi.show();
             });
        getToolbar().addCommandToSideMenu("Blog", calendarImage, e -> new BlogForm(res).show());
         
        getToolbar().addCommandToSideMenu("Event", null, e -> {
          displayEvent a = new displayEvent(res);
          a.hi.show();
        });
        getToolbar().addCommandToSideMenu("Offre", null, e -> {
          displayOffre a = new displayOffre(res);
          a.hi.show();
        });
             getToolbar().addCommandToSideMenu("LogOut", null, e -> {
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
