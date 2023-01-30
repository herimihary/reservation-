/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.herimihary.reservation.service;

import com.herimihary.reservation.ConnectionManager;
import com.herimihary.reservation.entity.Voyageur;
import com.herimihary.reservation.util.DateUtil;
import com.herimihary.reservation.view.TarifClasse;
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
public class VoyageurService implements IVoyageurService {

    private Connection connection;

    @Override
    public Voyageur getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Voyageur getByNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Voyageur getByPasseport(String passeport) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Voyageur save(Voyageur voyageur) {
        DateUtil dateUtil = new DateUtil();
        String sql = "insert into voyageur(nom,prenom,datedenaissance,passeport,idreservation) values (?,?,?,?,?)";
        try {
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, voyageur.getNom());
            ps.setString(2, voyageur.getPreNom());
            ps.setDate(3, dateUtil.parseUtilToSqlDate(voyageur.getDatedeNaissance()));
            ps.setString(4, voyageur.getPasseport());
            ps.setInt(5, voyageur.getIdreservation());

            if (ps.executeUpdate() > 1) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    voyageur.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return voyageur;
    }

    @Override
    public Voyageur update(Voyageur voyageur) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Voyageur voyageur) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveBatch(List<Voyageur> voyageurs) {
        String sql = "insert into voyageur(nom,prenom,datedenaissance,passeport,idreservation) values (?,?,?,?,?)";
        DateUtil dateUtil = new DateUtil();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareStatement(sql);
            for(int i=0;i<voyageurs.size();i++){
                ps.setString(1, voyageurs.get(i).getNom());
                ps.setString(2, voyageurs.get(i).getPreNom());
                ps.setDate(3, dateUtil.parseUtilToSqlDate(voyageurs.get(i).getDatedeNaissance()));
                ps.setString(4, voyageurs.get(i).getPasseport());
                ps.setInt(5, voyageurs.get(i).getIdreservation());
                ps.addBatch();
            }
            ps.executeBatch();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Voyageur> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Voyageur> getByReservation(int idreservation) {
       String sql="select * from voyageur where idreservation=?";
        List<Voyageur> resp= new ArrayList<Voyageur>();
        DateUtil utilDate = new DateUtil();
        try{
            this.connection = ConnectionManager.getConnection();
            PreparedStatement ps = this.connection.prepareCall(sql);
            ps.setInt(1, idreservation);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Voyageur temp = new Voyageur();                  
                    temp.setNom(rs.getString("nom"));
                    temp.setPreNom(rs.getString("prenom"));
                    temp.setPasseport(rs.getString("passeport"));
                    temp.setDatedeNaissance(rs.getDate("datedenaissance"));
                    temp.setId(rs.getInt("id"));
                    temp.setIdreservation(rs.getInt("idreservation"));
                    
                   
                    resp.add(temp);   
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resp;
    }

}
