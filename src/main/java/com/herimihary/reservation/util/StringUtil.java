/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.util;

import com.herimihary.reservation.entity.Pays;

/**
 *
 * @author rasen
 */
public class StringUtil {
    public static String formatPays(Pays pays){
        if(pays==null)return "";
        return  pays.getCodePays().toUpperCase()+"-"+pays.getNomPays().toUpperCase();
    }
}
