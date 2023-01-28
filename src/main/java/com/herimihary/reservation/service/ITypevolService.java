/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Typevol;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface ITypevolService {

    Typevol getById(int id);

    List<Typevol> getAll();

    List<Typevol> getByLibelle(String Libelle);

    Typevol save(Typevol typevol);

    Typevol update(Typevol typevol);

    void delete(Typevol typevol);

}
