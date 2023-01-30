/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Pays;
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
public class PaysService implements IPaysService {
     private Connection connection;

    @Override
    public Pays getById(int id) {
        
        String sql="select * from pays where id=? ";
        Pays resp;
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1,id);
       
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    resp = new Pays();                  
                    resp.setId(rs.getInt("id"));
                    resp.setNomPays(rs.getString("nompays"));
                    resp.setCodePays(rs.getString("codepays"));
                    return resp;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pays> getAll() {
        String sql="select * from pays";
        List<Pays> resp= new ArrayList<Pays>();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Pays temp = new Pays();                  
                    temp.setId(rs.getInt("id"));
                    temp.setNomPays(rs.getString("nompays"));
                    temp.setCodePays(rs.getString("codepays"));
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public Pays getByCode(String codePays) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pays save(Pays pays) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pays update(Pays pays) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Pays pays) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    }

   