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

import com.bibliotheque.Entite.User;
import com.bibliotheque.Service.ServiceUser;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignInForm extends com.codename1.ui.Form {
Resources res;

    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        //getToolbar().addCommandToLeftBar("",mat,  e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField username = new com.codename1.ui.TextField("", "Username", 30, TextField.ANY);
    private com.codename1.ui.TextField password = new com.codename1.ui.TextField("", "Password", 30, TextField.PASSWORD);
    private com.codename1.ui.Button SignIn = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button SignUp = new com.codename1.ui.Button();
    

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        SignIn.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == SignIn) {
    //                onButton_2ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Sign In");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(username);
        gui_Component_Group_1.addComponent(password);
        
       
        gui_Container_1.addComponent(SignIn);
       // gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
       // gui_Label_1.setName("Label_1");
        //gui_Label_1.setIcon(resourceObjectInstance.getImage("profile_image.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        SignIn.setText("Sign In");
          ConnectionRequest con = new ConnectionRequest();
        SignIn.addActionListener((e) -> {
            
     ServiceUser us = new ServiceUser();
            if (us.login1(username.getText(), password.getText())) 
            {
                System.out.println("sign in");
                new InboxForm().show();
                Dialog.show("Sign In", "Welcome Back "+username.getText()+"!", "ok", null);
            }
            else
            {
                System.out.println("erreur");
                Dialog.show("Sign In", "Verifier vos Coordonées !", "ok", null);
                new SignInForm().show();
            }
 
        });
       // gui_Button_2.setName("Button_2");
        gui_Button_3.setText("Forgot Your Password");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, SignUp);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        SignUp.setText("Create New Account");
        SignUp.setUIID("CenterLabel");
        SignUp.setName("Button_1");
        SignUp.addActionListener((e->{
        SignUpForm a = new SignUpForm();
        a.su.show();
        }));
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
  

}
