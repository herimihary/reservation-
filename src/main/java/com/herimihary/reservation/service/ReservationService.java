/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Reservation;
import com.herimihary.reservation.util.DateUtil;
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
                    resp.setTarifDepart(rs.getInt("tarifdepart"));
                    resp.setTarifDepart(rs.getInt("tarifretour"));
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
                    resp.setPaysArriver(rs.getInt("paysarriver"));
                    resp.setPaysDepart(rs.getInt("paysdepart"));
                    resp.setReference(rs.getString("reference"));
                    resp.setNbAdulte(rs.getInt("nbadulte"));
                    resp.setNbEnfant(rs.getInt("nbenfant"));
                    resp.setTarifDepart(rs.getInt("tarifdepart"));
                    resp.setTarifDepart(rs.getInt("tarifretour"));
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
        DateUtil dateUtil = new DateUtil();
        String sql = "insert into reservation(reference,numvol,depart,arriver,paysdepart,paysarriver,nbadulte,nbenfant,typevol,tarifdepart,tarifretour) values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            this.connection = ConnectionManager.getConnection();
//            this.connection.setAutoCommit(false);
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, reservation.getReference());
            ps.setString(2, reservation.getNumVol());
            ps.setDate(3, dateUtil.parseUtilToSqlDate(reservation.getDepart()));
            ps.setDate(4, dateUtil.parseUtilToSqlDate(reservation.getArriver()));
            ps.setInt(5, reservation.getPaysDepart());
            ps.setInt(6, reservation.getPaysArriver());
            ps.setInt(7, reservation.getNbAdulte());
            ps.setInt(8, reservation.getNbEnfant());
            ps.setInt(9, reservation.getTypevol());
            ps.setInt(10, reservation.getTarifDepart());
            ps.setInt(11, reservation.getTarifRetour());
        
            

            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    reservation.setId(rs.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        DateUtil dateUtil = new DateUtil();
        String sql = "update reservation set reference=?,numvol=?,depart=?,arriver=?,paysdepart=?,paysarriver=?,nbadulte=?,nbenfant=?,typevol=?,tarifdepart=?,tarifretour=? where id=?";

        try {
            this.connection = ConnectionManager.getConnection();
//            this.connection.setAutoCommit(false);
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, reservation.getReference());
            ps.setString(2, reservation.getNumVol());
            ps.setDate(3, dateUtil.parseUtilToSqlDate(reservation.getDepart()));
            ps.setDate(4, dateUtil.parseUtilToSqlDate(reservation.getArriver()));
            ps.setInt(5, reservation.getPaysDepart());
            ps.setInt(6, reservation.getPaysArriver());
            ps.setInt(7, reservation.getNbAdulte());
            ps.setInt(8, reservation.getNbEnfant());
            ps.setInt(9, reservation.getTypevol());
            ps.setInt(10, reservation.getTarifDepart());
            ps.setInt(11, reservation.getTarifRetour());
            ps.setInt(12, reservation.getId());
        
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    reservation.setId(rs.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void delete(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
