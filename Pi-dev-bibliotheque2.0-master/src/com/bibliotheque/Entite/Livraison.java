/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Entite;

/**
 *
 * @author Mohamedhabib - pc
 */
public class Livraison {
    private int idlivraison;
    private Commande C;
    private int user;
    private int idc;
    
    

    public Livraison(int idlivraison, Commande C, int user, int idc) {
        this.idlivraison = idlivraison;
        this.C = C;
        this.user = user;
        this.idc = idc;
    }

   

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public Livraison(int idlivraison, int user, int idc) {
        this.idlivraison = idlivraison;
        this.user = user;
        this.idc = idc;
    }
    

    public Livraison(int idlivraison, Commande C, int user) {
        this.idlivraison = idlivraison;
        this.C = C;
        this.user = user;
    }

    public Livraison(Commande C, int user) {
        this.C = C;
        this.user = user;
    }
    

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
   

    public int getIdlivraison() {
        return idlivraison;
    }

    public Commande getC() {
        return C;
    }

    public void setC(Commande C) {
        this.C = C;
    }

 
    @Override
    public String toString()
    {
        return "livraison{" + "id livraison=" + idlivraison + ", user=" + user + ", Commande=" + C + '}';
    }
}
