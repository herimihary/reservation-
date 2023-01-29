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
    private String reference;
    private  String numVol;
    private Date depart;
    private Date arriver;
    private String paysDepart;
    private String paysArriver;
    private int nbVoyageur;
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

    public String getPayDepart() {
        return paysDepart;
    }

    public void setPayDepart(String payDepart) {
        this.paysDepart = payDepart;
    }

    public String getPayArriver() {
        return paysArriver;
    }

    public void setPayArriver(String payArriver) {
        this.paysArriver = payArriver;
    }

    public int getNbVoyageur() {
        return nbVoyageur;
    }

    public void setNbVoyageur(int nbVoyageur) {
        this.nbVoyageur = nbVoyageur;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double PrixTotal) {
        this.prixTotal = PrixTotal;
    }
}
