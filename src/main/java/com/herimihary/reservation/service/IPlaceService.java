/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.entity.Place;
import com.herimihary.reservation.entity.PlaceDisponible;
import com.herimihary.reservation.entity.Voyageur;
import java.util.List;

/**
 *
 * @author rheri
 */
public interface IPlaceService {

    Place getById(int id);

    List<Place> getAll();
    
    List<Place> getPlacesDisponible();

    List<Place> getBynumeroPlace(int numeroPlace);

    Place save(Place place);

    Place Update(Place place);

    void delete(Place place);
    
    List<Place> reorderPlace(List<Place> places);
    
    void udpatePlaceDisponible(List<PlaceDisponible> placesdisponibles);
    
    void automaticChecking(List<Voyageur> voyageurs);

}
