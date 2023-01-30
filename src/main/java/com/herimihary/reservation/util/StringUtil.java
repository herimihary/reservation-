/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.util;

import com.herimihary.reservation.entity.Pays;
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
}
