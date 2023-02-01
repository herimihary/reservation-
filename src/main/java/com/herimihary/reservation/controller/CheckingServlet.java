/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.herimihary.reservation.controller;

import com.herimihary.reservation.entity.Place;
import com.herimihary.reservation.entity.PlaceDisponible;
import com.herimihary.reservation.entity.Reservation;
import com.herimihary.reservation.entity.Voyageur;
import com.herimihary.reservation.service.PlaceService;
import com.herimihary.reservation.service.ReservationService;
import com.herimihary.reservation.service.VoyageurService;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name = "CheckingServlet", urlPatterns = {"/CheckingServlet"})
public class CheckingServlet extends HttpServlet {

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
        if (request.getParameter("Valider") != null) {
            try {
                List<String> errors = new ArrayList<>();
                String reference = request.getParameter("reference");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checking/place.jsp?reference=" + reference);

                ReservationService reservationService = new ReservationService();
                Reservation reservation = reservationService.getByReference(reference);
                VoyageurService voyageurService = new VoyageurService();
                PlaceService placeservice = new PlaceService();
                List<Voyageur> voyageurs = voyageurService.getByReservation(reservation.getId());
                List<PlaceDisponible> placedispo = new ArrayList<>();
                String[] checkedPlaces = request.getParameterValues("checkedPlaces");
                String[] automaticCheckbox = request.getParameterValues("automatic");
                if (checkedPlaces == null) {
                    errors.add("Nombre total de voyageur doit etre egat au nombre de place choisit");
                }
                if (checkedPlaces != null && voyageurs.size() != checkedPlaces.length) {
                    errors.add("Nombre total de voyageur doit etre egat au nombre de place choisit");
                }
                if (voyageurs.get(0).getIdplace() > 0) {
                    errors.add("le voyageur a deja une place");
                    request.setAttribute("errors", errors);

                    dispatcher.forward(request, response);
                    return;
                }

                if (automaticCheckbox != null) {
                    placeservice.automaticChecking(voyageurs);
                    response.sendRedirect(request.getContextPath() + "/checking/place.jsp?reference=" + reference);
                    return;
                } else {
                    try {

                        for (int i = 0; i < voyageurs.size(); i++) {

                            int idplace = Integer.parseInt(checkedPlaces[i]);
                            Place place = placeservice.getById(idplace);
                            if (voyageurs.get(i).geAge() < 16 && place.isIsDanger()) {
                                errors.add("Les enfants moins de 16 ans ne doivent pas s'assoir dans les places danger");
                            }
                            voyageurs.get(i).setIdplace(idplace);
                            PlaceDisponible temp = new PlaceDisponible();
                            temp.setIdplace(idplace);
                            temp.setIdvol(1);
                            temp.setIsdisponible(false);
                            placedispo.add(temp);
                        }
                    } catch (Exception e) {
                        errors.add(e.getMessage());
                        e.printStackTrace();

                    }

                }

                if (errors.size() > 0) {
                    request.setAttribute("errors", errors);
                    request.setAttribute("test", "test");
                    dispatcher.forward(request, response);
                } else {
                    voyageurService.updateBatch(voyageurs);
                    placeservice.udpatePlaceDisponible(placedispo);

                    response.sendRedirect(request.getContextPath() + "/checking/place.jsp?reference=" + reference);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            if (!request.getParameter("reference").isBlank()) {
                String reference = request.getParameter("reference");
                ReservationService reservationService = new ReservationService();
                Reservation reservation = reservationService.getByReference(reference);
                if (reservation != null) {
                    response.sendRedirect(request.getContextPath() + "/checking/place.jsp?reference=" + reference);
                } else {
                    response.sendRedirect(request.getContextPath() + "/checking/checking.jsp");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/checking/checking.jsp");
            }
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
