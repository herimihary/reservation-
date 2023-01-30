/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Classe;
import com.herimihary.reservation.entity.Tarifs;
import com.herimihary.reservation.util.DateUtil;
import com.herimihary.reservation.view.TarifClasse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rheri
 */
public class TarifsService implements ITarifsService{
    private Connection connection;
    
    @Override
    public Tarifs getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tarifs> getAll() {
         String sql="select * from tarifs";
        List<Tarifs> resp= new ArrayList<Tarifs>();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Tarifs temp = new Tarifs();                  
                    temp.setId(rs.getInt("id"));
                    temp.setDateDepart(rs.getDate("datedepart"));
                    temp.setTypeVol(rs.getInt("typevol"));
                    temp.setFk_IdClasse(rs.getInt("idclasse"));
                    temp.setPrix(rs.getDouble("prix"));
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Tarifs> getByDate(Date date) {
        String sql="select * from tarifs where datedepart = ?";
        List<Tarifs> resp= new ArrayList<Tarifs>();
        DateUtil utilDate = new DateUtil();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setDate(1, utilDate.parseUtilToSqlDate(date));
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Tarifs temp = new Tarifs();                  
                    temp.setId(rs.getInt("id"));
                    temp.setDateDepart(rs.getDate("datedepart"));
                    temp.setTypeVol(rs.getInt("typevol"));
                    temp.setFk_IdClasse(rs.getInt("idclasse"));
                    temp.setPrix(rs.getDouble("prix"));
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public Tarifs save(Tarifs tarifs) {
        DateUtil dateUtil = new DateUtil();
        String sql = "insert into tarifs(prix,typevol,datedepart,idclasse) values (?,?,?,?)";

        try {
            this.connection = ConnectionManager.getConnection();
//            this.connection.setAutoCommit(false);
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setDouble(1, tarifs.getPrix());
            ps.setInt(2, tarifs.getTypeVol());
            ps.setDate(3, dateUtil.parseUtilToSqlDate(tarifs.getDateDepart()) );
            ps.setInt(4, tarifs.getFk_IdClasse());
            
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    tarifs.setId(rs.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarifs;
    }

    @Override
    public Tarifs update(Tarifs tarifs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Tarifs tarifs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TarifClasse> getTarifClasseByDate(Date date, int typevol) {
        String sql="select * from gettarifclassebydate(?,?)";
        List<TarifClasse> resp= new ArrayList<TarifClasse>();
        DateUtil utilDate = new DateUtil();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setDate(1, utilDate.parseUtilToSqlDate(date));
            ps.setInt(2, typevol);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    TarifClasse temp = new TarifClasse();                  
                    temp.setIdClasse(rs.getInt("idclasse"));
                    temp.setIdTarif(rs.getInt("idtarif"));
                    temp.setNomClasse(rs.getString("nomclasse"));
                    temp.setPrix(rs.getDouble("prix"));
                    temp.setTypeVol(rs.getInt("typevol"));
                    temp.setRemise(rs.getInt("remise"));
                    temp.setIsdiscount(rs.getBoolean("isdiscount"));
                   
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resp;
    }
    
}
