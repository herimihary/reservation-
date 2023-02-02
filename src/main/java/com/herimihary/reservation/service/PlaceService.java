/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Place;
import com.herimihary.reservation.entity.PlaceDisponible;
import com.herimihary.reservation.entity.Voyageur;
import com.herimihary.reservation.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rheri
 */
public class PlaceService implements IPlaceService {

    private Connection connection;

    @Override
    public Place getById(int id) {
        String sql = "select * from place where id=? ";
        Place resp;
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resp = new Place();
                    resp.setId(rs.getInt("id"));
                    resp.setNumeroPlace(rs.getString("numeroplace"));
                    resp.setIdClasse(rs.getInt("idclasse"));
                    resp.setIsDanger(rs.getBoolean("isdanger"));
                    return resp;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Place> getAll() {
        String sql = "select * from place";
        List<Place> resp = new ArrayList<Place>();
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Place temp = new Place();
                    temp.setId(rs.getInt("id"));
                    temp.setNumeroPlace(rs.getString("numeroplace"));
                    temp.setIdClasse(rs.getInt("idclasse"));
                    temp.setIsDanger(rs.getBoolean("isdanger"));
                    resp.add(temp);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Place> getBynumeroPlace(int numeroPlace) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Place save(Place place) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Place Update(Place place) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Place place) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Place> reorderPlace(List<Place> places) {
        List<Place> rep = new ArrayList<>();
        List<Place> ligne1 = new ArrayList<>();
        List<Place> ligne2 = new ArrayList<>();
        List<Place> ligne3 = new ArrayList<>();
        List<Place> ligne4 = new ArrayList<>();
        List<Place> ligne5 = new ArrayList<>();
        List<Place> ligne6 = new ArrayList<>();

        for (int i = 0; i < places.size(); i++) {
            String numero = places.get(i).getNumeroPlace();
            if (numero.contains("1")) {
                ligne1.add(places.get(i));
            }
            if (numero.contains("2")) {
                ligne2.add(places.get(i));
            }
            if (numero.contains("3")) {
                ligne3.add(places.get(i));
            }
            if (numero.contains("4")) {
                ligne4.add(places.get(i));
            }
            if (numero.contains("5")) {
                ligne5.add(places.get(i));
            }
            if (numero.contains("6")) {
                ligne6.add(places.get(i));
            }
        }
        Collections.sort(ligne1, Collections.reverseOrder().reversed());
        Collections.sort(ligne2, Collections.reverseOrder().reversed());
        Collections.sort(ligne3, Collections.reverseOrder().reversed());
        Collections.sort(ligne4, Collections.reverseOrder().reversed());
        Collections.sort(ligne5, Collections.reverseOrder().reversed());
        Collections.sort(ligne6, Collections.reverseOrder().reversed());

        rep.addAll(ligne1);
        rep.addAll(ligne2);
        rep.addAll(ligne3);
        rep.addAll(ligne4);
        rep.addAll(ligne5);
        rep.addAll(ligne6);
        return rep;
    }

    @Override
    public List<Place> getPlacesDisponible() {
        String sql = "select p.*,pd.isdisponible,pd.isbroken from placedisponible pd join place p on pd.idplace = p.id";
        List<Place> resp = new ArrayList<Place>();
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Place temp = new Place();
                    temp.setId(rs.getInt("id"));
                    temp.setNumeroPlace(rs.getString("numeroplace"));
                    temp.setIdClasse(rs.getInt("idclasse"));
                    temp.setIsDanger(rs.getBoolean("isdanger"));
                    temp.setIsDisponible(rs.getBoolean("isdisponible"));
                    temp.setIsBroked(rs.getBoolean("isbroken"));
                    resp.add(temp);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public void udpatePlaceDisponible(List<PlaceDisponible> placesdisponibles) {
        String sql = "update placedisponible set isdisponible=? where idvol=? and idplace=?";
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareStatement(sql);
            for (int i = 0; i < placesdisponibles.size(); i++) {
                ps.setBoolean(1, placesdisponibles.get(i).getIsdisponible());
                ps.setInt(2, placesdisponibles.get(i).getIdvol());
                ps.setInt(3, placesdisponibles.get(i).getIdplace());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void automaticChecking(List<Voyageur> voyageurs) {
        int nbVoyageur = voyageurs.size();
        List<Place> placeDisponible = this.reorderPlace(this.getPlacesDisponible());
        
        boolean avecEnfant = false;
        for(int i=0;i<nbVoyageur;i++){
            if(voyageurs.get(i).geAge()<16){
                avecEnfant = true;
                break;
            }
        }
        List<Place> ranger1 = placeDisponible.subList(0, 7);
        List<Place> ranger2 = placeDisponible.subList(7, 14);
        List<Place> ranger3 = placeDisponible.subList(14, 21);
        List<Place> ranger4 = placeDisponible.subList(21, 28);
        List<Place> ranger5 = placeDisponible.subList(28, 35);
        List<Place> ranger6 = placeDisponible.subList(35, 42);
        

        if(avecEnfant){
            List<Place> placeDisponibleAvecEnfant =  new ArrayList<>();
            placeDisponibleAvecEnfant.addAll(ranger1);
            placeDisponibleAvecEnfant.addAll(ranger2);
            placeDisponibleAvecEnfant.addAll(ranger5);
            placeDisponibleAvecEnfant.addAll(ranger6);
            setPlaceListVoyageur(1,placeDisponibleAvecEnfant,voyageurs);

        }else{
            setPlaceListVoyageur(1,placeDisponible,voyageurs);
        }
      
    }
    
    private void setPlaceListVoyageur(int idvol,List<Place> places, List<Voyageur> voyageurs){
        int count = 0;
        List<PlaceDisponible> placedispo = new ArrayList<>();
        for(int i=0;i<places.size();i++){
           
            if(places.get(i).isIsDisponible() && !places.get(i).isIsBroked()){
                voyageurs.get(count).setIdplace(places.get(i).getId());
                PlaceDisponible temp = new PlaceDisponible();
                temp.setIdplace(places.get(i).getId());
                temp.setIdvol(idvol);
                temp.setIsdisponible(false);
                placedispo.add(temp);
                count++;
            }
            if(count==voyageurs.size()){
                break;
            }
        }
        VoyageurService voyageurservice = new VoyageurService();
        voyageurservice.updateBatch(voyageurs);
        this.udpatePlaceDisponible(placedispo);

    }

    @Override
    public Place getByIdPlaceDisponible(int id) {
        String sql = "select p.id,p.numeroplace,p.idclasse,pd.isdisponible,p.isdanger,pd.isbroken from place p join placedisponible pd on pd.idplace=p.id where p.id=? ";
        Place resp;
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resp = new Place();
                    resp.setId(rs.getInt("id"));
                    resp.setNumeroPlace(rs.getString("numeroplace"));
                    resp.setIdClasse(rs.getInt("idclasse"));
                    resp.setIsDanger(rs.getBoolean("isdanger"));
                    resp.setIsBroked(rs.getBoolean("isbroken"));
                    return resp;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
