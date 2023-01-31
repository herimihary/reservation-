/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Reservation;
import com.herimihary.reservation.view.ReservationDetails;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface IReservationService {

    Reservation getByid(int id);

    Reservation getByReference(String id);

    List<Reservation> getByDate(Date datedepart, Date datearriver);

    Reservation save(Reservation reservation);

    Reservation update(Reservation reservation);

    void delete(Reservation reservation);
    
    ReservationDetails getDetailsByReference(String reference);
}
