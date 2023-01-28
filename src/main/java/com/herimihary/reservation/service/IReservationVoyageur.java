/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

/**
 *
 * @author rheri
 */
public interface IReservationVoyageur {

    ReservationVoyageur getById(int id);

    ReservationVoyageur getByFk_idvoyageur(int fk_idvoyageur);

    ReservationVoyageur getByFk_idreservation(int fk_idreservation);

    ReservationVoyageur save(ReservationVoyageur reservationVoyageur);

    ReservationVoyageur update(ReservationVoyageur reservationVoyageur);

    void delete(ReservationVoyageur reservationVoyageur);

}
