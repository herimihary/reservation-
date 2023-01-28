/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Pays;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface IPaysService {

    Pays getById(int id);

    List<Pays> getAll();

    Pays getByCode(String codePays);

    Pays save(Pays pays);

    Pays update(Pays pays);

    void delete(Pays pays);

}
