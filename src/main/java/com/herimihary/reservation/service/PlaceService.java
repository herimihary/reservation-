/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Pays;
import com.herimihary.reservation.entity.Place;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rheri
 */
public class PlaceService implements IPlaceService{
     private Connection connection;

    @Override
    public Place getById(int id) {
         String sql="select * from place where id=? ";
        Place resp;
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1,id);
       
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    resp = new Place();                  
                    resp.setId(rs.getInt("id"));
                    resp.setNumeroPlace(rs.getInt("numeroPlace"));
                    resp.setFk_idClasse(rs.getInt("fk_idClasse"));
                    return resp;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Place> getAll() {
         String sql="select * from place";
        List<Place> resp= new ArrayList<Place>();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Place temp = new Place();                  
                    temp.setId(rs.getInt("id"));
                    temp.setNumeroPlace(rs.getInt("NumeroPlace"));
                    temp.setFk_idClasse(rs.getInt("fk_idClasse"));
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
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
    }


   
