/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Entite;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author farouk
 */
public class Offre {
    
    private int idoffre;
    private double prixoffre;
    private Date date_debut ;
    private Date date_fin ;
    private String description ;
    private String image;

    public Offre(int idoffre, double prixoffre, Date date_debut, Date date_fin, String description) {
        this.idoffre = idoffre;
        this.prixoffre = prixoffre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
    }

    public Offre(double prixoffre, Date date_debut, Date date_fin, String description) {
        this.prixoffre = prixoffre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
    }

    public Offre(double prixoffre, String description) {
        this.prixoffre = prixoffre;
        this.description = description;
    }

    public Offre() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdoffre() {
        return idoffre;
    }

    public double getPrixoffre() {
        return prixoffre;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getDescription() {
        return description;
    }
    public String getImage(){
    return this.image;
    }
    public void setIdoffre(int idoffre) {
        this.idoffre = idoffre;
    }

    public void setPrixoffre(double prixoffre) {
        this.prixoffre = prixoffre;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(String image){
        this.image= image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (this.idoffre != other.idoffre) {
            return false;
        }
        if (Double.doubleToLongBits(this.prixoffre) != Double.doubleToLongBits(other.prixoffre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

    public Offre(int idoffre, double prixoffre, String description) {
        this.idoffre = idoffre;
        this.prixoffre = prixoffre;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "idoffre=" + idoffre + ", prixoffre=" + prixoffre + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + '}';
    }
    
    
    
    
}
