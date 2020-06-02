/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Entite;

import java.util.Date;

/**
 *
 * @author Mohamedhabib - pc
 */
public class Livre {
    private int idlivre;
    private String nomlivre;
    private String auteurlivre;
    private String datelivre;
    private int prixlivre;
    private String contenu;
    private int quantitelivre;
    private String image_name;
    

    public Livre(int idlivre, String nomlivre, String auteurlivre,String datelivre,int prixlivre,String contenu,int quantitelivre,String image_name) {
        this.idlivre=idlivre;
        this.nomlivre=nomlivre;
        this.auteurlivre=auteurlivre;
        this.datelivre=datelivre;
        this.contenu=contenu;
        this.prixlivre=prixlivre;
        this.quantitelivre=quantitelivre;
        this.image_name=image_name;
    }

    public Livre(String nomlivre, String auteurlivre, int prixlivre, String contenu, int quantitelivre) {
        this.nomlivre = nomlivre;
        this.auteurlivre = auteurlivre;
        this.prixlivre = prixlivre;
        this.contenu = contenu;
        this.quantitelivre = quantitelivre;
       // this.image_name = image_name;
    }

    public Livre(String nomlivre) {
        this.nomlivre=nomlivre;
    }

    public void setIdlivre(int idlivre) {
        this.idlivre = idlivre;
    }

    public void setNomlivre(String nomlivre) {
        this.nomlivre = nomlivre;
    }






    public Livre() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public int getIdlivre() {
        return idlivre;
    }

    public String getNomlivre() {
        return nomlivre;
    }

    public void setNom(String nomlivre) {
        this.nomlivre = nomlivre;
    }

    public String getAuteur() {
        return auteurlivre;
    }

    public void setAuteur(String auteurlivre) {
        this.auteurlivre = auteurlivre;
    }
    
    public String getDatelivre() {
        return datelivre;
    }

    public void setDatelivre(String datelivre) {
        this.datelivre = datelivre;
    }
       public int getPrixlivre() {
        return prixlivre;
    }

    public String getAuteurlivre() {
        return auteurlivre;
    }

    public void setAuteurlivre(String auteurlivre) {
        this.auteurlivre = auteurlivre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getQuantitelivre() {
        return quantitelivre;
    }

    public void setQuantitelivre(int quantitelivre) {
        this.quantitelivre = quantitelivre;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
    
      public void setPrixlivre(int prixlivre) {
        this.prixlivre = prixlivre;
    }

    @Override
    public String toString() {
        return "Livre{" + "idlivre=" + idlivre + ", nomlivre=" + nomlivre + ", auteurlivre=" + auteurlivre + ", datelivre=" + datelivre + ", prixlivre=" + prixlivre + ", contenu=" + contenu + ", quantitelivre=" + quantitelivre + ", image_name=" + image_name + '}';
    }

  


  
    
}
