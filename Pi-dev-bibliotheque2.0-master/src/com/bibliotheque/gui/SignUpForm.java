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

import com.bibliotheque.Service.ServiceUser;
import com.bibliotheque.Entite.User;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm  {
Form su= new Form();
  private Resources theme;
    private Container c;
    private UIBuilder uiBuilder;
    public SignUpForm() {
      su = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        uiBuilder = new UIBuilder();
        theme = UIManager.initFirstTheme("/theme");
       
        su= new Form("signUp");
           su.getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("sign Up", "Title")
                        
                )
        );
               su.getToolbar().addCommandToLeftBar("back",null,new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
              
               new SignInForm().showBack();
         }
     });
         TextField nom = new TextField("", "nom", 201, TextField.ANY);
        nom.setHint("nom");
        
         TextField prenom = new TextField("", "prenom", 201, TextField.ANY);
        prenom.setHint("prenom");
        
        TextField username = new TextField("", "username", 201, TextField.ANY);
        username.setHint("username");
       
        TextField email = new TextField("", "email", 201, TextField.EMAILADDR);
     
        email.setHint("email");
        TextField mdp = new TextField("", "mdp", 45, TextField.PASSWORD);
 
        mdp.setHint("mot de passe ");
        TextField cmdp = new TextField("", "confirmation mdp", 45, TextField.PASSWORD);
   
        cmdp.setHint("Confirmer mote de passe");

        Button signup = new Button("s'inscrire");
                 Validator validator = new Validator();
        validator.addConstraint(email, RegexConstraint.validEmail());
       validator.addSubmitButtons(signup);
        su.add(nom);
        su.add(prenom);
        su.add(username);
        su.add(email);
        su.add(mdp);
        su.add(cmdp);
        su.add(signup);
         
     
   
       // signup.requestFocus();
       signup.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
       
                if (nom.getText().isEmpty() || prenom.getText().isEmpty() || username.getText().isEmpty() ||  email.getText().isEmpty() || mdp.getText().isEmpty()|| cmdp.getText().isEmpty() ){
                    Dialog.show("AVERTISSEMENT !!!", "Veuillez verifier vos champs Mercii !!!", "OK", null);
                    

                }
                else{
                    if(mdp.getText().equals(cmdp.getText())){
                        
                    
              ServiceUser sU= new ServiceUser();
              User u= new User(nom.getText(),prenom.getText(),username.getText(),email.getText(),mdp.getText());
              sU.inscription(u);
              nom.clear();
              prenom.clear();
              username.clear();
              email.clear();
              mdp.clear();
              cmdp.clear();
               new SignInForm().showBack();
                    }
                     else{
                        Dialog.show("AVERTISSEMENT !!!", "vos mdp ne sont pas identiques", "OK", null);
                        
                        }
                }
               
          }
      });
       
    }
    
    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

}
