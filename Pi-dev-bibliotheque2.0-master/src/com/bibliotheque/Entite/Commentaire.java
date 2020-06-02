/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Entite;

import java.util.Objects;

/**
 *
 * @author Daly
 */
public class Commentaire {
    private int idc;
    private String description;
    private String date;
    private User user;
    private int idPublication;

    public Commentaire() {
        user = new User();
    }

    public Commentaire(int idc, String description, String date, User user, int idPublication) {
        this.idc = idc;
        this.description = description;
        this.date = date;
        this.user = user;
        this.idPublication = idPublication;
    }

    public Commentaire(String description, String date, User user, int idPublication) {
        this.description = description;
        this.date = date;
        this.user = user;
        this.idPublication = idPublication;
    }


    
    
    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idc=" + idc + ", description=" + description + ", date=" + date + ", user=" + user + ", idPublication=" + idPublication + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    
    
    
}
