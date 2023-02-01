/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.util;

import com.herimihary.reservation.entity.Classe;
import com.herimihary.reservation.entity.Pays;
import com.herimihary.reservation.entity.Place;
import com.herimihary.reservation.entity.Tarifs;
import com.herimihary.reservation.service.PlaceService;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rasen
 */
public class StringUtil {

    public static String formatPays(Pays pays) {
        if (pays == null) {
            return "";
        }
        return pays.getCodePays().toUpperCase() + "-" + pays.getNomPays().toUpperCase();
    }
    
    public static String getPaysById(int idpays,List<Pays> pays){
        Pays pay = new Pays();
        for(int i=0;i<pays.size();i++){
            if(idpays==pays.get(i).getId()){
                pay =pays.get(i);
            }
        }
        return formatPays(pay);
    }

    public  String generateReference() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString.toUpperCase();
    }
    
    public static String getClasseLibelle(Tarifs tarif, List<Classe> classes){
        String rep = "";
        for(int i=0;i<classes.size();i++){
            if(tarif.getFk_IdClasse()==classes.get(i).getId()){
                rep = classes.get(i).getNom();
            }
        }
        return rep;
    }
    
    public static String getClasseLibelle(int idclasse, List<Classe> classes){
        String rep = "";
        for(int i=0;i<classes.size();i++){
            if(idclasse==classes.get(i).getId()){
                rep = classes.get(i).getNom();
            }
        }
        return rep;
    }
    
    public static String getTypeVolLibelle(int typevol){
        if(typevol==1){
            return "Aller";
        }
        return "Retour";
    }
    
    public static String getPlaceLibelle(int idplace){
        PlaceService service = new PlaceService();
        Place p = service.getById(idplace);
        if(p!=null){
            return p.getNumeroPlace();
        }
        return null;
         
    }
    
    
}
