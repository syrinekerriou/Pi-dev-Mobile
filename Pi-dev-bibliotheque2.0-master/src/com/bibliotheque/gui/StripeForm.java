/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

//import Entities.PaymentOrder;
//import Services.MatchmakingService;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.bibliotheque.Entite.Commande;
import com.bibliotheque.Service.ServiceCommande;

/**
 *
 * @author bn-sk
 */
public class StripeForm {

    private Form f;
    private Resources theme;
    private Container c;
    private UIBuilder uiBuilder;
   

    public StripeForm(Double prix) {

        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        uiBuilder = new UIBuilder();
        theme = UIManager.initFirstTheme("/theme");
        f = new Form("Payment");
        f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                displayMycom a = new displayMycom(theme);
                a.hi.showBack();
                    
            }
        });
        TextField name = new TextField();
        name.setHint("Nom");
        name.getAllStyles().setFgColor(333);
        TextField cc = new TextField();
        cc.getAllStyles().setFgColor(333);
        cc.setHint("Numero carte bancaire");
        TextField cvv = new TextField();
        cvv.getAllStyles().setFgColor(333);
        cvv.setHint("code cryptogramme");
        TextField exp_m = new TextField();
        exp_m.getAllStyles().setFgColor(333);
        exp_m.setHint("Mois d'expiration");
        TextField exp_y = new TextField();
        exp_y.getAllStyles().setFgColor(333);
        exp_y.setHint("Année d'expiration");
     

        Button commander = new Button("Valider");

        commander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                PaymentOrder payment = new PaymentOrder(cc.getText(), cvv.getText(), exp_m.getText(), exp_y.getText(),prix);
                try {
 
                    createPayment(payment);
                } catch (StripeException ex) {
                    System.out.println("");
                }

                Dialog.show("Payment", "Payement éffectué avec succée !", "ok", null);
            }
        });
        Validator validator = new Validator();
        validator.addConstraint(name, new LengthConstraint(1)).addConstraint(cc, new LengthConstraint(16)).addConstraint(cvv, new LengthConstraint(3)).addConstraint(exp_m, new LengthConstraint(2)).addConstraint(exp_y, new LengthConstraint(4));
        validator.addSubmitButtons(commander);
        validator.setShowErrorMessageForFocusedComponent(true);
        f.add(name);
        f.add(cc);
        f.add(cvv);
        f.add(exp_m);
        f.add(exp_y);
        f.add(commander);
    }

    public void createPayment(PaymentOrder payment) throws StripeException {

        try {
            Charge charge = payment.createCharge("sk_test_gpKkx2i75i9ZEgbDtmczQo3600enJvzSfr", payment.getAmmount(), "cus_H0RyFibMrama3r", payment.getCardnumber(), payment.getExp_month(), payment.getExp_year(), payment.getCvv());
            System.out.println("charge : " + charge.getStatus());
            if (charge.getStatus().equalsIgnoreCase("succeeded")) {

                  
             
               /*
                 String accountSID = "AC157ed6b425cf8748aec24231da1e9577";
                 String authToken = "e85507e1c7cdfd17aed6ca8874721153";
                 String fromPhone = "+12056351318";
                 String destinationPhone = "+21654577109";

                 Response<Map> SMS = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                 queryParam("To", destinationPhone).
                 queryParam("From", fromPhone).
                 queryParam("Body", "TEST").
                 header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                 getAsJsonMap();    */
                System.out.println("success");

            } else {
                ToastBar.showMessage("Skipped dialog", FontImage.MATERIAL_INFO);
            }
        } catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException | APIException ex) {
            if (ex.getMessage() != null || !(ex.getMessage().equals(""))) {
           
                System.out.println("error");
            }
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
