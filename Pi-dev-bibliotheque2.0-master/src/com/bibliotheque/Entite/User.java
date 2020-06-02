/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.Entite;

import java.util.TimeZone;

/**
 *
 * @author Firas
 */
public class User {
    
    
	protected int id;
         protected String nom;
        protected String prenom;
	protected String username;
	protected String email;
        protected String password;

    public User(String nom, String prenom, String username, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


	public User() {

	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username=" + username + ", email=" + email +", password=" + password + "}'";
	}

	public User(String username, String email) {
		this.username = username;
		this.email = email;
	
	}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
        

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        

	
}
