<%-- 
    Document   : place
    Created on : 1 Feb 2023, 00:22:49
    Author     : rasen
--%>
<%@page import="com.herimihary.reservation.service.VoyageurService"%>
<%@page import="com.herimihary.reservation.entity.Voyageur"%>
<%@page import="com.herimihary.reservation.entity.Reservation"%>
<%@page import="com.herimihary.reservation.service.ReservationService"%>
<%@page import="java.lang.String"%>
<%@page import="com.herimihary.reservation.entity.Place"%>
<%@page import="java.util.List"%>
<%@page import="com.herimihary.reservation.service.PlaceService"%>
<%
    PlaceService placeService = null;
    ReservationService reservationService = null;
    Reservation reservation = null;
    VoyageurService voyageurService = null;
    List<Voyageur> listVoyageur = null;
    List<Place> places = null;
    int i, j = 0;

    int indiceList = 0;
    int nbCol = 7;
    String reference = request.getParameter("reference");
    String test = (String) request.getAttribute("test");
    List<String> errors = (List<String>) request.getAttribute("errors");
    try {
        reservationService = new ReservationService();
        reservation = reservationService.getByReference(reference);
        voyageurService = new VoyageurService();
        listVoyageur = voyageurService.getByReservation(reservation.getId());
        placeService = new PlaceService();
        places = placeService.reorderPlace(placeService.getPlacesDisponible());
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place</title>
        <link rel="stylesheet" href="../css/bootstrap.css"></link> 
        <script src="../js/jquery/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Airport</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="/index.jsp">Reservation</a>
                    <a class="nav-item nav-link active" href="#">Checking</a>
                    <a class="nav-item nav-link" href="/promotion/promotionList.jsp">Promotion</a>
                    <a class="nav-item nav-link" href="#">Classe</a>
                    <a class="nav-item nav-link" href="#">Tarifs</a>                  
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <form action="/CheckingServlet" method="post">
                    <input type="hidden" name="reference" value="<%=reference%>"/>
                    <div class="col-md-10 mx-auto">
                        <h2>Choix places </h2>
                        <div>
                            <div class="alert alert-danger" role="alert">
                                <%
                                    if (errors != null) {
                                        for (int p = 0; p < errors.size(); p++) {%>
                                <p><%=errors.get(p)%></p>
                                <%}
                                    }%>

                            </div>
                        </div>
                        <div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Nom</th>
                                        <th scope="col">Prenom</th>
                                        <th scope="col">Passeport</th>
                                        <th scope="col">Date Naissance</th>
                                        <th scope="col">Age</th>                                
                                    </tr>
                                </thead>
                                <tbody>
                                    <%if (listVoyageur != null) {%>
                                    <%for (int l = 0; l < listVoyageur.size(); l++) {%>
                                    <tr>      

                                        <td><%=listVoyageur.get(l).getNom()%></td>
                                        <td><%=listVoyageur.get(l).getPreNom()%></td>
                                        <td><%=listVoyageur.get(l).getPasseport()%></td>
                                        <td><%=listVoyageur.get(l).getDatedeNaissance()%></td>
                                        <td><%=listVoyageur.get(l).geAge()%></td>

                                    </tr>
                                    <%}
                                }%>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <div class="col-sm-6">
                                <input class="form-check-input" type="checkbox" name="automatic" value="1" id="automatic">
                                <label class="form-check-label" for="aller">
                                    Remlpir place automatiquement
                                </label>
                            </div>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">A</th>
                                    <th scope="col">B</th>
                                    <th scope="col">couloir</th>
                                    <th scope="col">C</th>
                                    <th scope="col">D</th>
                                    <th scope="col">E</th>
                                    <th scope="col">couloir</th>
                                    <th scope="col">F</th>
                                    <th scope="col">G</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (i = 0; i < 7; i++) { %>
                                <%if (i == 3) {%>
                                <tr>
                                    <td scope="col" colspan="9">couloir</td>
                                </tr>
                                <%} else {%>
                                <tr>
                                    <%for (j = indiceList; j < nbCol; j++) {
                                            String disabled = "";
                                            String dangerstyle = "";
                                            String disabledStyle = "";
                                            if (!places.get(j).isIsDisponible()) {
                                                disabled = "disabled";
                                                disabledStyle = "background-color:blue;";
                                            }
                                            if (places.get(j).isIsDanger()) {
                                                dangerstyle = "background-color:#ed7474;";
                                            }
                                    %>
                                    <%if (j == 2 || j == 5 || j == 9 || j == 12
                                                || j == 16 || j == 19 || j == 23 || j == 26 || j == 30 || j == 33 || j == 37 || j == 40) {%>
                                    <td scope="col"></td>
                                    <%}%>
                                    <td scope="col" style="<%=dangerstyle + disabledStyle%>">
                                        <input  <%=disabled%> value="<%=places.get(j).getId()%>" style="margin-right: 19px" class="form-check-input" type="checkbox"  name="checkedPlaces"/><%=places.get(j).getNumeroPlace()%>
                                    </td>
                                    <% }
                                        indiceList = nbCol;
                                        nbCol = nbCol + 7;%>
                                </tr>
                                <%}%>

                                <%}%>                          
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-10 mx-auto row">
                        <input type="Submit" class="btn btn-success btn-lg" value="Valider" name="Valider"/>
                    </div>
                </form>
            </div>
        </div>

    </nav>
</body>
</html>
