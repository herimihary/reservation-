/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Promotion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface IPromotionService {

    Promotion getById(int id);

    List<Promotion> getAll();

    List<Promotion> getByDate(Date datedebut, Date datefin);

    Promotion save(Promotion promotion);

    Promotion update(Promotion promotion);

    void delete(Promotion promotion);

}
