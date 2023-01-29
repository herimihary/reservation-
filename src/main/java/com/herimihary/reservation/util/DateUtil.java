/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rasen
 */
public class DateUtil {

    public  final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd");

    public  Date parseDate(String value) {
        Date result = null;//from w  w  w.  j  a va2s  . c om
        try {
            result = DATE_FORMAT.parse(value);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }
    
    public java.sql.Date parseUtilToSqlDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
}
