/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Pays;
import com.herimihary.reservation.entity.Promotion;
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
public class PromotionService implements IPromotionService {

    private Connection connection;

    @Override
    public Promotion getById(int id) {
        String sql = "select * from promotion where id=? ";
        Promotion resp;
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resp = new Promotion();
                    resp.setId(rs.getInt("id"));
                    resp.setCode(rs.getString("code"));
                    resp.setRemise(rs.getInt("remise"));
                    resp.setDateFin(rs.getDate("datefin"));
                    resp.setDateDebut(rs.getDate("datefin"));
                    return resp;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Promotion> getAll() {
        String sql = "select * from pays";
        List<Promotion> resp = new ArrayList<Promotion>();
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Promotion temp = new Promotion();
                    temp.setId(rs.getInt("id"));
                    temp.setCode(rs.getString("code"));
                    temp.setRemise(rs.getInt("remise"));
                    temp.setDateFin(rs.getDate("datefin"));
                    temp.setDateDebut(rs.getDate("datefin"));

                    resp.add(temp);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Promotion> getByDate(Date datedebut, Date datefin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Promotion save(Promotion promotion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Promotion update(Promotion promotion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Promotion promotion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
