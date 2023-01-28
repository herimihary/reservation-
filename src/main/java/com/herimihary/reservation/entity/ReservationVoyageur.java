package com.herimihary.reservation.entity;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rheri
 */
public class ReservationVoyageur {
   private  int id;
private int fk_IdReservation;
 private int fK_IdVoyageur;
private int fK_IdPlace;
 private Boolean isActive;
private int fK_IdClasse;
 private Double PrixNormal;
private int Remise;
 private Double PrixAvecRemise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_IdReservation() {
        return fk_IdReservation;
    }

    public void setFk_IdReservation(int fk_IdReservation) {
        this.fk_IdReservation = fk_IdReservation;
    }

    public int getfK_IdVoyageur() {
        return fK_IdVoyageur;
    }

    public void setfK_IdVoyageur(int fK_IdVoyageur) {
        this.fK_IdVoyageur = fK_IdVoyageur;
    }

    public int getfK_IdPlace() {
        return fK_IdPlace;
    }

    public void setfK_IdPlace(int fK_IdPlace) {
        this.fK_IdPlace = fK_IdPlace;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public int getfK_IdClasse() {
        return fK_IdClasse;
    }

    public void setfK_IdClasse(int fK_IdClasse) {
        this.fK_IdClasse = fK_IdClasse;
    }

    public Double getPrixNormal() {
        return PrixNormal;
    }

    public void setPrixNormal(Double PrixNormal) {
        this.PrixNormal = PrixNormal;
    }

    public int getRemise() {
        return Remise;
    }

    public void setRemise(int Remise) {
        this.Remise = Remise;
    }

    public Double getPrixAvecRemise() {
        return PrixAvecRemise;
    }

    public void setPrixAvecRemise(Double PrixAvecRemise) {
        this.PrixAvecRemise = PrixAvecRemise;
    }
    
}
