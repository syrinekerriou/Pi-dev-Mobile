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
 * @author Daly
 */
public class Publication {
    
    private int id;
    private String type;
    private String description;
    private Date date;
    private int IdUser;

    public Publication() {
    }

    public Publication(int id, String type, String description, Date date, int IdUser) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.date = date;
        this.IdUser = IdUser;
    }

    public Publication(String type, String description, Date date, int IdUser) {
        this.type = type;
        this.description = description;
        this.date = date;
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", type=" + type + ", description=" + description + ", date=" + date + ", IdUser=" + IdUser + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Publication other = (Publication) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.IdUser != other.IdUser) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }
    
    
}
