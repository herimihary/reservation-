<%-- 
    Document   : facture
    Created on : 31 Jan 2023, 01:52:27
    Author     : rasen
--%>
<%@page import="com.herimihary.reservation.view.ReservationDetails"%>
<%@page import="com.herimihary.reservation.service.VoyageurService"%>
<%@page import="com.herimihary.reservation.util.StringUtil"%>
<%@page import="com.herimihary.reservation.entity.Pays"%>
<%@page import="com.herimihary.reservation.service.PaysService"%>
<%@page import="com.herimihary.reservation.entity.Voyageur"%>
<%@page import="java.util.List"%>
<%@page import="com.herimihary.reservation.entity.Reservation"%>
<%@page import="com.herimihary.reservation.service.ReservationService"%>
<%
    ReservationService reservationService = null;
    PaysService paysService = null;
    VoyageurService voyageurService = null;
    Reservation reservation = null;
    List<Voyageur> listVoyageur = null;
    List<Pays> listPays = null;
    String reference = null;
    String paysDepart = "";
    String paysRetour = "";
    ReservationDetails reservationDetails = null;
    try {
        reference = request.getParameter("reference");
        reservationService = new ReservationService();
        paysService = new PaysService();
        voyageurService = new VoyageurService();
        reservation = reservationService.getByReference(reference);
        listVoyageur = voyageurService.getByReservation(reservation.getId());
        listPays = paysService.getAll();
        paysDepart = StringUtil.getPaysById(reservation.getPaysDepart(), listPays);
        paysRetour = StringUtil.getPaysById(reservation.getPaysArriver(), listPays);
        reservationDetails = reservationService.getDetailsByReference(reference);

    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Billets</title>
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
                <div class="col-md-10 mx-auto">
                    <h3>Vol details</h3>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Reference</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" value="<%=reservation.getReference()%>" disabled>
                        </div>
                    </div>
                    <div class="form-group row mt-4">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Numero Vol</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" value="<%=reservation.getNumVol()%>" disabled>
                        </div>
                    </div>                   
                </div>
                <hr class="mt-4 mb-3"/>
                <div class="col-md-10 mx-auto">     
                    <h3>Aller</h3>
                    <div class="form-group row row mb-2">
                        <div class="col-sm-6">
                            <div class="row">
                                <div class="col-sm-8">
                                    <label for="dateDebut">Depart</label>
                                    <input type="text"  class="form-control" id="dateDebut" name="dateDebut"  value="<%=paysDepart%>" disabled>
                                </div>
                                <div class="col-sm-4">
                                    <label for="dateDebut"></label>
                                    <input type="date" class="form-control" id="dateDebut" name="dateDebut"  value="<%=reservation.getDepart()%>" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="row">
                                <div class="col-sm-8">
                                    <label for="dateDebut">Arriver</label>
                                    <input type="text"  class="form-control" id="dateDebut" name="dateDebut"  value="<%=paysRetour%>" disabled>
                                </div>
                                <div class="col-sm-4">
                                    <label for="dateDebut"></label>
                                    <input type="date" class="form-control" id="dateDebut" name="dateDebut"  value="<%=reservation.getDepart()%>" disabled>
                                </div>
                            </div>
                        </div>
                    </div>    
                    <h3>Retour</h3>
                    <div class="form-group row row mb-2">
                        <div class="col-sm-6">
                            <div class="row">
                                <div class="col-sm-8">
                                    <label for="dateDebut">Depart</label>
                                    <input type="text"  class="form-control" id="dateDebut" name="dateDebut"  value="<%=paysRetour%>" disabled>
                                </div>
                                <div class="col-sm-4">
                                    <label for="dateDebut"></label>
                                    <input type="date" class="form-control" id="dateDebut" name="dateDebut"  value="<%=reservation.getArriver()%>" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="row">
                                <div class="col-sm-8">
                                    <label for="dateDebut">Arriver</label>
                                    <input type="text"  class="form-control" id="dateDebut" name="dateDebut"  value="<%=paysDepart%>" disabled>
                                </div>
                                <div class="col-sm-4">
                                    <label for="dateDebut"></label>
                                    <input type="date" class="form-control" id="dateDebut" name="dateDebut"  value="<%=reservation.getArriver()%>" disabled>
                                </div>
                            </div>
                        </div>
                    </div>      
                </div>
                <hr class="mt-4 mb-3"/>
                <div class="col-md-10 mx-auto">
                    <h3>Voyageur details</h3>
                    <table class="table">
                        <thead>
                            <tr>

                                <th scope="col">Nom</th>
                                <th scope="col">Prenom</th>
                                <th scope="col">Passeport</th>
                                <th scope="col">Date Naissance</th>
                            </tr>
                        </thead>
                        <tbody>    
                            <%if (listVoyageur != null) {%>
                            <%for (int i = 0; i < listVoyageur.size(); i++) {%>
                            <tr>      

                                <td><%=listVoyageur.get(i).getNom()%></td>
                                <td><%=listVoyageur.get(i).getPreNom()%></td>
                                <td><%=listVoyageur.get(i).getPasseport()%></td>
                                <td><%=listVoyageur.get(i).getDatedeNaissance()%></td>
                            </tr>
                            <%}
                                }%>
                        </tbody>
                    </table>
                </div>
                <hr class="mt-4 mb-3"/>
                <div class="col-md-11 mx-auto">
                    <h3>Price details</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Nb</th>
                                <th scope="col">Prix depart</th>
                                <th scope="col">Prix depart avec remise</th>
                                <th scope="col">Classe Depart</th>
                                <th scope="col">Remise Depart</th>
                                <th scope="col">Prix retour</th>
                                <th scope="col">Prix retour avec remise</th>
                                <th scope="col">Classe retour</th>
                                <th scope="col">Remise retour</th>
                                

                            </tr>
                        </thead>
                        <tbody>                          
                            <tr>      
                                <td>Adulte</td>
                                <td><%=reservationDetails.getNbadulte()%></td>
                                <td><%=reservationDetails.getPrixdepart()%></td>
                                <td><%=reservationDetails.getPrixdepartremise()%></td>
                                <td><%=reservationDetails.getClassedepart()%></td>
                                <td><%=reservationDetails.getRemisedepart()%> %</td>

                                <td><%=reservationDetails.getPrixretour()%></td>
                                <td><%=reservationDetails.getPrixretourremise()%></td>
                                <td><%=reservationDetails.getClasseretour()%></td>
                                <td><%=reservationDetails.getRemiseretour()%> %</td>


                            </tr>
                            <tr>      
                                <td>Enfant</td>
                                <td><%=reservationDetails.getNbenfant()%></td>
                                <td><%=reservationDetails.getPrixdepart()%></td>
                                <td><%=reservationDetails.getPrixdepartremise()%></td>
                                <td><%=reservationDetails.getClassedepart()%></td>
                                <td><%=reservationDetails.getRemisedepart()%> %</td>

                                <td><%=reservationDetails.getPrixretour()%></td>
                                <td><%=reservationDetails.getPrixretourremise()%></td>
                                <td><%=reservationDetails.getClasseretour()%></td>
                                <td><%=reservationDetails.getRemiseretour()%> %</td>
                            </tr>
                            <tr>
                            <tr>
                                <td></td>
                            </tr>
                             <tr>
                                <td colspan="3" style="text-align: right">Total Adulte sans remise</td>
                                <td colspan="2" style="text-align: center"><%=reservationDetails.getPrixTotalAdulteSansRemise()%></td>
                                <td colspan="3" style="text-align: right">Total Adulte avec remise</td>
                                <td colspan="2" style="text-align: center"><%=reservationDetails.getPrixTotalAdulteAvecRemise()%></td>
                                
                            </tr>
                            <tr>
                                <td colspan="3" style="text-align: right">Total enfant sans remise</td>
                                <td colspan="2" style="text-align: center"><%=reservationDetails.getPrixTotalEnfantSansRemise()%></td>
                                <td colspan="3" style="text-align: right">Total enfant avec remise</td>
                                <td colspan="2" style="text-align: center"><%=reservationDetails.getPrixTotalEnfantAvecRemise()%></td>
                                
                            </tr>
                            <tr>
                                <td colspan="3" style="text-align: right">Total sans remise</td>
                                <td colspan="2" style="text-align: center"><%=reservationDetails.getTotalSansRemise()%></td>
                                <td colspan="3" style="text-align: right">Total</td>
                                <td colspan="2" style="text-align: center;font-size: 20px"><b><%=reservationDetails.getTotal()%></b></td>
                            </tr>
                            <tr>
                                
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </body>
</html>
