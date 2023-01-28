package com.herimihary.reservation.entity;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rheri
 */
public class Place {
   private int  id;
    private int numeroPlace;
   private int  fk_idClasse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public int getFk_idClasse() {
        return fk_idClasse;
    }

    public void setFk_idClasse(int fk_idClasse) {
        this.fk_idClasse = fk_idClasse;
    }

    
    
}
