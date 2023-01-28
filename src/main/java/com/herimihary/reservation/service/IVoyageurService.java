/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Voyageur;

/**
 *
 * @author rheri
 */
public interface IVoyageurService {

    Voyageur getById(int id);

    Voyageur getByNom(String nom);

    Voyageur getByPasseport(String passeport);

    Voyageur save(Voyageur voyageur);

    Voyageur update(Voyageur voyageur);

    void delete(Voyageur voyageur);

}
