/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.herimihary.reservation.controller;

import com.herimihary.reservation.entity.Reservation;
import com.herimihary.reservation.entity.Voyageur;
import com.herimihary.reservation.service.ReservationService;
import com.herimihary.reservation.service.VoyageurService;
import com.herimihary.reservation.util.DateUtil;
import com.herimihary.reservation.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasen
 */
@WebServlet(name = "VoyageurServlet", urlPatterns = {"/VoyageurServlet"})
public class VoyageurServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DateUtil dateUtil = new DateUtil();
        StringUtil stringUtil = new StringUtil();
        VoyageurService voyageurService = new VoyageurService();
        String reference = request.getParameter("reference");
        ReservationService reservationService = new ReservationService();
        Reservation reservation = reservationService.getByReference(reference);
        List<Voyageur> voyageurList = new ArrayList<Voyageur>();
        for(int i=0;i<reservation.getNbAdulte()+reservation.getNbEnfant();i++){
            Voyageur temp = new Voyageur();
            temp.setIdreservation(reservation.getId());
            temp.setNom(request.getParameter("nom_"+i));
            temp.setPreNom(request.getParameter("prenom_"+i));
            temp.setDatedeNaissance(dateUtil.parseDate(request.getParameter("datenaissance_"+i)));
            temp.setPasseport(request.getParameter("passeport_"+i));
            voyageurList.add(temp);            
        }
        voyageurService.saveBatch(voyageurList);
        
        response.sendRedirect(request.getContextPath() + "/reservation/facture.jsp?reference="+reservation.getReference());

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
