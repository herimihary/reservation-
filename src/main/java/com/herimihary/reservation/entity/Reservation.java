/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.entity;

import java.util.Date;

/**
 *
 * @author rheri
 */
public class Reservation {

    private int id;
    private int typevol;
    private String reference;
    private String numVol;
    private Date depart;
    private Date arriver;
    private int paysDepart;
    private int paysArriver;
    private int nbAdulte;
    private int nbEnfant;

    public int getPaysDepart() {
        return paysDepart;
    }

    public void setPaysDepart(int paysDepart) {
        this.paysDepart = paysDepart;
    }

    public int getPaysArriver() {
        return paysArriver;
    }

    public void setPaysArriver(int paysArriver) {
        this.paysArriver = paysArriver;
    }

    public int getNbAdulte() {
        return nbAdulte;
    }

    public void setNbAdulte(int nbAdulte) {
        this.nbAdulte = nbAdulte;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }
    private Double prixTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Date getArriver() {
        return arriver;
    }

    public void setArriver(Date arriver) {
        this.arriver = arriver;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double PrixTotal) {
        this.prixTotal = PrixTotal;
    }

    public int getTypevol() {
        return typevol;
    }

    public void setTypevol(int typevol) {
        this.typevol = typevol;
    }
    
    
}
