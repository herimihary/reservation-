/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.view;

import java.util.Date;

/**
 *
 * @author rasen
 */
public class TarifClasse {
    private int idClasse;
    private int idTarif;
    private String nomClasse;
    private Double prix;
    private Date date;
    private int typeVol;
    private int remise;
    private boolean isdiscount;

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String NomClasse) {
        this.nomClasse = NomClasse;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(int typeVol) {
        this.typeVol = typeVol;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }

    public boolean getIsdiscount() {
        return isdiscount;
    }

    public void setIsdiscount(boolean isdiscount) {
        this.isdiscount = isdiscount;
    }
    
    
    
}
