/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.herimihary.reservation.controller;

import com.herimihary.reservation.entity.Reservation;
import com.herimihary.reservation.service.ReservationService;
import com.herimihary.reservation.util.DateUtil;
import com.herimihary.reservation.util.StringUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author rasen
 */
@WebServlet(name = "ReservationServlet", urlPatterns = {"/ReservationServlet"})
public class ReservationServlet extends HttpServlet {

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
        ReservationService reservationService = new ReservationService();
        if(request.getParameter("Suivant")!=null){
            String reference  =  request.getParameter("reference");
            int idtarifDepart = Integer.parseInt( request.getParameter("tarifDepart"));
            int idtarifRetour = Integer.parseInt( request.getParameter("tarifRetour"));
            Reservation reservation = reservationService.getByReference(reference);
            reservation.setArriver(dateUtil.parseDate(request.getParameter("dateRetour")));
            reservation.setDepart(dateUtil.parseDate(request.getParameter("dateDebut")));
            reservation.setTarifDepart(idtarifDepart);
            reservation.setTarifRetour(idtarifRetour);
            reservationService.update(reservation);
            response.sendRedirect(request.getContextPath() + "/reservation/voyageur.jsp?reference="+reservation.getReference());
        }else{
            
            Reservation reservation = new Reservation();
            reservation.setTypevol(Integer.parseInt(request.getParameter("typevol")));
            reservation.setPaysDepart(Integer.parseInt(request.getParameter("paysDepart")));
            reservation.setPaysArriver(Integer.parseInt(request.getParameter("paysArrivee")));
            reservation.setDepart(dateUtil.parseDate(request.getParameter("dateDepart")));
            reservation.setArriver(dateUtil.parseDate(request.getParameter("dateArrivee")));
            reservation.setNbAdulte(Integer.parseInt(request.getParameter("nbAdulte")));
            reservation.setNbEnfant(Integer.parseInt(request.getParameter("nbEnfant")));
            reservation.setNumVol("MK289");
            String promoCode = request.getParameter("promocode");

            reservation.setReference(stringUtil.generateReference());

            Reservation save = reservationService.save(reservation);

            response.sendRedirect(request.getContextPath() + "/reservation/vol.jsp?reference="+reservation.getReference());
        }
        
        
        
        
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
