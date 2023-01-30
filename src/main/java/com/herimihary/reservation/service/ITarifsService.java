/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Tarifs;
import com.herimihary.reservation.view.TarifClasse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface ITarifsService {

    Tarifs getById(int id);

    List<Tarifs> getAll();

    List<Tarifs> getByDate(Date date);

    Tarifs save(Tarifs tarifs);

    Tarifs update(Tarifs tarifs);

    void delete(Tarifs tarifs);

    List<TarifClasse> getTarifClasseByDate(Date date, int typevol);

}
