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
public class Tarifs {
   private int id;
    private double prix;
    private int typeVol;
    private Date dateDepart;
    private int fk_IdClasse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(int typeVol) {
        this.typeVol = typeVol;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getFk_IdClasse() {
        return fk_IdClasse;
    }

    public void setFk_IdClasse(int fk_IdClasse) {
        this.fk_IdClasse = fk_IdClasse;
    }
    
    
}
