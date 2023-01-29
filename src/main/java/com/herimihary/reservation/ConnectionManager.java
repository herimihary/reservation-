/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herimihary.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rasen
 */
public class ConnectionManager {

    private static String urlConnection = "jdbc:postgresql://localhost:5432/reservation?user=postgres&password=herimihary";

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(urlConnection);
        return con;
    }
}
