package com.herimihary.reservation.entity;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rheri
 */
public class Voyageur {
   private int id;
   private String  nom;
    private String  preNom;
     private Date datedeNaissance;
    private String passeport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public Date getDatedeNaissance() {
        return datedeNaissance;
    }

    public void setDatedeNaissance(Date datedeNaissance) {
        this.datedeNaissance = datedeNaissance;
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }
    
    
    
    
}
