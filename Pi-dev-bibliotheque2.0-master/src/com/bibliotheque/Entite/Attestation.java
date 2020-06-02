/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Entite;


import java.util.Objects;

/**
 *
 * @author syrin
 */
public class Attestation 
{
    private int ida;
    private String typea;
    private String langue;

    public Attestation(int ida, String typea, String langue) {
        this.ida = ida;
        this.typea = typea;
        this.langue = langue;
    }

    public Attestation(String typea, String langue) {
        this.typea = typea;
        this.langue = langue;
    }

    public Attestation() {
       
    }

    



    @Override
    public String toString() {
        return "Attestation{" + "ida=" + ida + ", typea=" + typea + ", langue=" + langue + '}';
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
        final Attestation other = (Attestation) obj;
        if (this.ida != other.ida) {
            return false;
        }
        if (!Objects.equals(this.typea, other.typea)) {
            return false;
        }
        if (!Objects.equals(this.langue, other.langue)) {
            return false;
        }
        return true;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public String getTypea() {
        return typea;
    }

    public void setTypea(String typea) {
        this.typea = typea;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

   

   

   
    
    
    
}
