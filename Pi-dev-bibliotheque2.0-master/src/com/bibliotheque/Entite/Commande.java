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
public class Commande {
    private int idcommande;
    private Livre l;
    private User us;
    private String datecommande;
    private int user;
 private int idl;
 private Double prixlivre;

    public Commande(Livre l, User us) {
        this.l = l;
        this.us = us;
    }

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }

    public Double getPrixlivre() {
        return prixlivre;
    }

    //private LocalDate date;
    public void setPrixlivre(Double prixlivre) {
        this.prixlivre = prixlivre;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }
 

    public Commande(int user, int idl) {
        this.user = user;
        this.idl = idl;
    }
 
 
    public Commande(Livre l, int user) {
        this.l = l;
        this.user = user;
    }

    public Commande(Livre l) {
     this.l = l;
    }

    public Commande() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getIdl() {
        return idl;
    }

    public void setIdl(int idl) {
        this.idl = idl;
    }

    public Commande(int idcommande, int user,int idl, String datecommande) {
        this.idcommande = idcommande;
        this.user = user;
        this.idl = idl;
        this.datecommande = datecommande;
        
    }

    public Commande(Livre l, int user, String datecommande) {
        this.l = l;
        this.datecommande = datecommande;
        this.user = user;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public Livre getL() {
        return l;
    }

    public void setL(Livre l) {
        this.l = l;
    }

    public String getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(String datecommande) {
        this.datecommande = datecommande;
    }
    @Override
    public String toString()
    {
         return "livraison{" + "id commande=" + idcommande + ", Livre=" + l + ", datecommande=" + datecommande + '}';
    }

 
    
    
}
