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
 * @author syrin
 */
public class Reclamation {
    private int idr;
    private String nomr;
    private String sujetr;
    private Date dater;

    public Reclamation(int idr, String nomr, String sujetr, Date dater) {
        this.idr = idr;
        this.nomr = nomr;
        this.sujetr = sujetr;
        this.dater = dater;
    }

    public Reclamation(String nomr, String sujetr, Date dater) {
        this.nomr = nomr;
        this.sujetr = sujetr;
        this.dater = dater;
    }

  


    @Override
    public String toString() {
        return "Reclamation{" + "idr=" + idr + ", nomr=" + nomr + ", sujetr=" + sujetr + ", dater=" + dater + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Reclamation other = (Reclamation) obj;
        if (this.idr != other.idr) {
            return false;
        }
        if (!Objects.equals(this.nomr, other.nomr)) {
            return false;
        }
        if (!Objects.equals(this.sujetr, other.sujetr)) {
            return false;
        }
        if (!Objects.equals(this.dater, other.dater)) {
            return false;
        }
        return true;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getNomr() {
        return nomr;
    }

    public void setNomr(String nomr) {
        this.nomr = nomr;
    }

    public String getSujetr() {
        return sujetr;
    }

    public void setSujetr(String sujetr) {
        this.sujetr = sujetr;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }
   
    
   
}
