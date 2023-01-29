/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Classe;
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
public class ClasseService implements IClasseService {

    private Connection connection;

    @Override
    public Classe getById(int id) {
        String sql="select * from classe where id=?";
        Classe resp;
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1,id);
       
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    resp = new Classe();                  
                    resp.setId(rs.getInt("id"));
                    resp.setNom(rs.getString("nom"));
                    return resp;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Classe> getAll() {
        String sql="select * from classe";
        List<Classe> resp= new ArrayList<Classe>();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Classe temp = new Classe();                  
                    temp.setId(rs.getInt("id"));
                    temp.setNom(rs.getString("nom"));
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Classe> getByNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Classe save(Classe classe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Classe update(Classe classe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Classe classe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
