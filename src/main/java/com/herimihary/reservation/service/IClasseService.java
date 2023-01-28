/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Classe;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface IClasseService {

    Classe getById(int id);

    List<Classe> getAll();

    List<Classe> getByNom(String nom);

    Classe save(Classe classe);

    Classe update(Classe classe);

    void delete(Classe classe);
}
