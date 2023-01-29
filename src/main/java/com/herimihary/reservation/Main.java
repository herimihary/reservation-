/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation;

import com.herimihary.reservation.entity.Classe;
import com.herimihary.reservation.service.ClasseService;
import com.herimihary.reservation.service.ReservationService;

/**
 *
 * @author rasen
 */
public class Main {
     public static void main(String[] args) {
       ClasseService test = new ClasseService();
       Classe  tests=  test.getById(1);
    }
}
