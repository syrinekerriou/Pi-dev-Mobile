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

import com.bibliotheque.Service.CommentaireServices;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.bibliotheque.Entite.Commentaire;
import com.bibliotheque.Service.ServiceUser;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class CommentaireForm extends BaseForm {
    
    public static com.codename1.ui.util.Resources res;

    public CommentaireForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public CommentaireForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        res = resourceObjectInstance;
        //IMAGE 1
        /* ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL); */
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });

        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
    }

////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    protected com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    protected com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    protected com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    protected com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("Commentaires");
        setName("TrendingForm");
        
         Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ADD, s);
        getToolbar().addCommandToRightBar("", icon, e -> {            
            AddCommentaireForm f = new AddCommentaireForm();
            f.AddComment(PublicationForm.pub);
        });
       
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_imageContainer1.setInlineStylesTheme(resourceObjectInstance);
        gui_imageContainer1.setName("imageContainer1");
        gui_separator1.setUIID("Separator");
        gui_separator1.setInlineStylesTheme(resourceObjectInstance);
        gui_separator1.setName("separator1");
        gui_null_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_null_1_1.setName("null_1_1");
        gui_imageContainer2.setInlineStylesTheme(resourceObjectInstance);
        gui_imageContainer2.setName("imageContainer2");
        gui_Label_1_1_1.setUIID("Separator");
        gui_Label_1_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1_1_1.setName("Label_1_1_1");
        addComponent(gui_Container_1);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Multi_Button_1.setName("Multi_Button_1");
        gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", PublicationForm.pub.getType());

      
        
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        gui_LA.setUIID("Label");
        gui_LA.setInlineStylesTheme(resourceObjectInstance);
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", "");
        gui_LA.setPropertyValue("line2", "in Esprit Ghazela");
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");
        
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
      
        CommentaireServices cs = new CommentaireServices();
        List<Commentaire> myList = cs.AfficherComPub(PublicationForm.pub.getId());
        for (Commentaire c : myList) {
            Style ss = UIManager.getInstance().getComponentStyle("TitleCommand");
            FontImage iconDel = FontImage.createMaterial(FontImage.MATERIAL_DELETE, ss);

            Button delete = new Button();
            delete.setIcon(iconDel);
            delete.setVisible(false);

            if (c.getUser().getId() == ServiceUser.currentUser.getId()) {
                delete.setVisible(true);
            }

            delete.addActionListener(e -> {
                cs.deleteComm(c.getIdc());
                new CommentaireForm(resourceObjectInstance).show();
            });

            Label DesLabel = new Label("   " + c.getDescription());
            Label UsernameLabel = new Label(c.getUser().getUsername() + " :");
            Container gui_imageContainer1 = new Container(new BorderLayout());
            Container gui_usernameContainer = new Container(new BorderLayout());
            Container gui_buttonContainer = new Container(new BorderLayout());
            gui_usernameContainer.add(BorderLayout.WEST, UsernameLabel);
            gui_imageContainer1.add(BorderLayout.CENTER, DesLabel);
            gui_buttonContainer.add(BorderLayout.EAST, delete);
            addComponent(gui_usernameContainer);
            addComponent(gui_imageContainer1);
            addComponent(gui_buttonContainer);
        }

        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Text_Area_1.setText(PublicationForm.pub.getDescription());
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1, "\ue5c8".charAt(0));
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        addComponent(gui_separator1);
        addComponent(gui_null_1_1);
        gui_null_1_1_1.setUIID("Label");
        gui_null_1_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_null_1_1_1.setName("null_1_1_1");
        gui_null_1_1_1.setIcon(resourceObjectInstance.getImage("contact-b.png"));
        gui_null_1_1_1.setPropertyValue("uiid1", "Label");
        gui_null_1_1_1.setPropertyValue("uiid2", "RedLabel");
        gui_newYork.setUIID("Label");
        gui_newYork.setInlineStylesTheme(resourceObjectInstance);
        gui_newYork.setName("newYork");
        gui_newYork.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_newYork.setPropertyValue("uiid2", "RedLabelRight");
        //  gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_null_1_1_1);
        //  gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_newYork);
        addComponent(gui_imageContainer2);
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_imageContainer2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_3);
        gui_Text_Area_2.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_2.setName("Text_Area_2");
        gui_Button_2.setText("");
        gui_Button_2.setUIID("Label");
        gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setName("Button_2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_2, "\ue5c8".charAt(0));
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_2);
        // gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_2);
        addComponent(gui_Label_1_1_1);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
}
