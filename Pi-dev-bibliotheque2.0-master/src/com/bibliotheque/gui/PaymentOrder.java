/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import java.lang.String;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;


public class PaymentOrder {

    private String cardnumber, cvv, exp_month, exp_year,name;
    private double ammount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentOrder(String cardnumber, String cvv, String exp_month, String exp_year, Double ammount) {
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.ammount = ammount;
        
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExp_month() {
        return exp_month;
    }

    public void setExp_month(String exp_month) {
        this.exp_month = exp_month;
    }

    public String getExp_year() {
        return exp_year;
    }

    public void setExp_year(String exp_year) {
        this.exp_year = exp_year;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    

    public Charge createCharge(String api, double ammount, String name, String cc, String exp_m, String exp_y, String cvv) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, StripeException {
        Stripe.apiKey = api;

        Charge charge;
        Map<String, Object> chargeParams = new HashMap<>();

        chargeParams.put("amount", (int) Math.round(ammount * 1));
        chargeParams.put("currency", "usd");
        chargeParams.put("customer", createClient(name, cc, exp_y, exp_m, cvv).getId());
        charge = Charge.create(chargeParams);
        System.out.println(charge);
        return charge;
    }

    public Token createToken(String name, String cc, String exp_y, String exp_m, String cvv) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, StripeException {
        Token token;

        Map<String, Object> tokenParams = new HashMap<>();
        Map<String, Object> cardParams = new HashMap<>();
        cardParams.put("name", name);
        cardParams.put("number", cc);
        cardParams.put("exp_month", exp_m);
        cardParams.put("exp_year", exp_y);
        cardParams.put("cvc", cvv);
        tokenParams.put("card", cardParams);

        token = Token.create(tokenParams);

        return token;

    }

    public Customer createClient(String name, String cc, String exp_y, String exp_m, String cvv) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, StripeException {
        Customer customer = null;
        Map<String, Object> customerParams = new HashMap<String, Object>();

        
        customerParams.put("source", createToken(name, cc, exp_y, exp_m, cvv).getId());
        customer = Customer.create(customerParams);

        return customer;
    }

}
