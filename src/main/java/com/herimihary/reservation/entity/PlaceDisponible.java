/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.entity;

/**
 *
 * @author rasen
 */
public class PlaceDisponible {
    private int idvol;
    private int idplace;
    private boolean isdisponible;
    private boolean isbroked;

    public int getIdvol() {
        return idvol;
    }

    public void setIdvol(int idvol) {
        this.idvol = idvol;
    }

    public int getIdplace() {
        return idplace;
    }

    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

    public boolean getIsdisponible() {
        return isdisponible;
    }

    public void setIsdisponible(boolean isdisponible) {
        this.isdisponible = isdisponible;
    }

    public boolean isIsbroked() {
        return isbroked;
    }

    public void setIsbroked(boolean isbroked) {
        this.isbroked = isbroked;
    }
    
    
    
    
}
