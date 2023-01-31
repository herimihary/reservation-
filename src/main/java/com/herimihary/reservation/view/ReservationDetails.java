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
public class ReservationDetails {
    private final int discountEnfant = 15;
    
    public String reference;
    public String numvol;
    public Date depart;
    public Date arriver;
    public int nbadulte;
    public int nbenfant;
    public double prixdepart;
    public double prixdepartremise;
    public String classedepart;
    public int remisedepart;
    public double prixretour;
    public double prixretourremise;
    public String classeretour;
    public int remiseretour;
    
    
    public double totalSansRemise;
    public double total;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNumvol() {
        return numvol;
    }

    public void setNumvol(String numvol) {
        this.numvol = numvol;
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

    public double getPrixdepart() {
        return prixdepart;
    }

    public void setPrixdepart(double prixdepart) {
        this.prixdepart = prixdepart;
    }

    public double getPrixdepartremise() {
        return prixdepartremise;
    }

    public void setPrixdepartremise(double prixdepartremise) {
        this.prixdepartremise = prixdepartremise;
    }

    public String getClassedepart() {
        return classedepart;
    }

    public void setClassedepart(String classedepart) {
        this.classedepart = classedepart;
    }

    public int getRemisedepart() {
        return remisedepart;
    }

    public void setRemisedepart(int remisedepart) {
        this.remisedepart = remisedepart;
    }

    public double getPrixretour() {
        return prixretour;
    }

    public void setPrixretour(double prixretour) {
        this.prixretour = prixretour;
    }

    public double getPrixretourremise() {
        return prixretourremise;
    }

    public void setPrixretourremise(double prixretourremise) {
        this.prixretourremise = prixretourremise;
    }

    public String getClasseretour() {
        return classeretour;
    }

    public void setClasseretour(String classeretour) {
        this.classeretour = classeretour;
    }

    public int getRemiseretour() {
        return remiseretour;
    }

    public void setRemiseretour(int remiseretour) {
        this.remiseretour = remiseretour;
    }

    

  

    public int getNbadulte() {
        return nbadulte;
    }

    public void setNbadulte(int nbadulte) {
        this.nbadulte = nbadulte;
    }

    public int getNbenfant() {
        return nbenfant;
    }

    public void setNbenfant(int nbenfant) {
        this.nbenfant = nbenfant;
    }
    
    public double getPrixTotalEnfantSansRemise(){
        double prixenfantDepart = this.remiseEnfant(this.prixdepart);
        double prixenfantRetour = this.remiseEnfant(this.prixretour);
        return (prixenfantDepart + prixenfantRetour)*this.nbenfant;
    }
    public double getPrixTotalEnfantAvecRemise(){
        double prixenfantDepart = this.remiseEnfant(this.prixdepartremise);
        double prixenfantRetour = this.remiseEnfant(this.prixretourremise);
        return (prixenfantDepart + prixenfantRetour)*this.nbenfant;
    }
    
    public double getPrixTotalAdulteSansRemise(){
       
        return (this.prixdepart+this.prixretour)*this.nbadulte;
    }
    public double getPrixTotalAdulteAvecRemise(){

        return (this.prixdepartremise+this.prixretourremise)*this.nbadulte;
    }
    
    public double remiseEnfant(double prix){
        return (prix*(100-this.discountEnfant))/100;
    }
    
    public double getTotalSansRemise() {
        return getPrixTotalEnfantSansRemise()+getPrixTotalAdulteSansRemise();
    }
    
    public double getTotal() {        
        return  getPrixTotalAdulteAvecRemise()+getPrixTotalEnfantAvecRemise();
    }

    

   

    
    
    
    
}
