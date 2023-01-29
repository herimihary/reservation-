/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rheri
 */
public class ReservationService implements IReservationService {

    private Connection connection;

    @Override
    public Reservation getByid(int id) {
        String sql = "select * from reservation where id=? ";
        Reservation resp;
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resp = new Reservation();
                    resp.setId(rs.getInt("id"));
                    resp.setTypevol(rs.getInt("typevol"));
                    resp.setArriver(rs.getDate("arriver"));
                    resp.setDepart(rs.getDate("depart"));
                    resp.setNumVol(rs.getString("numvol"));
                    resp.setPaysArriver(rs.getInt("payarriver"));
                    resp.setPaysDepart(rs.getInt("paydepart"));
                    resp.setReference(rs.getString("reference"));
                    resp.setNbAdulte(rs.getInt("nbadulte"));
                    resp.setNbEnfant(rs.getInt("nbenfant"));
                    resp.setPrixTotal(rs.getDouble("prixtotal"));
                    return resp;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservation getByReference(String reference) {
           String sql = "select * from reservation where reference=? ";
        Reservation resp;
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setString(1, reference);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resp = new Reservation();
                    resp.setId(rs.getInt("id"));
                    resp.setTypevol(rs.getInt("typevol"));
                    resp.setArriver(rs.getDate("arriver"));
                    resp.setDepart(rs.getDate("depart"));
                    resp.setNumVol(rs.getString("numvol"));
                    resp.setPaysArriver(rs.getInt("payarriver"));
                    resp.setPaysDepart(rs.getInt("paydepart"));
                    resp.setReference(rs.getString("reference"));
                    resp.setNbAdulte(rs.getInt("nbadulte"));
                    resp.setNbEnfant(rs.getInt("nbenfant"));
                    resp.setPrixTotal(rs.getDouble("prixtotal"));
                    return resp;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;   
    }

    @Override
    public List<Reservation> getByDate(Date datedepart, Date datearriver) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reservation save(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reservation update(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
