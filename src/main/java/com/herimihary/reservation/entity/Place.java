package com.herimihary.reservation.entity;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rheri
 */
public class Place  implements Comparable<Place>{
   private int  id;
   private String numeroPlace;
   private int  idClasse;
   private boolean isDanger;
   private boolean isDisponible;
   private boolean isBroked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(String numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    

    public boolean isIsDanger() {
        return isDanger;
    }

    public void setIsDanger(boolean isDanger) {
        this.isDanger = isDanger;
    }

    public boolean isIsDisponible() {
        return isDisponible;
    }

    public void setIsDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }

    public boolean isIsBroked() {
        return isBroked;
    }

    public void setIsBroked(boolean isBroked) {
        this.isBroked = isBroked;
    }
    
    @Override
    public int compareTo(Place o) {
        String a = String.valueOf(this.getNumeroPlace().charAt(0));
        String b = String.valueOf(o.getNumeroPlace().charAt(0));
        return this.id - o.getId();
    }

    
    
    

    
    
    
}
