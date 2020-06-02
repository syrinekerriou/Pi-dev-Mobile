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
public class Service {
    private int ids;
    private Attestation a;
    private String description;
    private String date;
    private int ida;
   private String type;
      private String langue;

    public Service() {
    }

    public Service(String description) {
        this.description = description;
    }

  



 

  
  

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public String toString() {
        return "Service{" + "ids=" + ids + ", a=" + a + ", description=" + description + ", date=" + date + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Service(int ids, Attestation a, String description, String date, int ida, String type, String langue) {
        this.ids = ids;
        this.a = a;
        this.description = description;
        this.date = date;
        this.ida = ida;
        this.type = type;
        this.langue = langue;
    }

    


  

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public Attestation getA() {
        return a;
    }

    public void setA(Attestation a) {
        this.a = a;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
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
        final Service other = (Service) obj;
        if (this.ids != other.ids) {
            return false;
        }
        if (this.ida != other.ida) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.langue, other.langue)) {
            return false;
        }
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    public void getA(Attestation a) {
        this.a=a;
      
    }

   
    
    
}
