<%-- 
    Document   : voyageur
    Created on : 30 Jan 2023, 10:02:04
    Author     : rasen
--%>
<%@page import="com.herimihary.reservation.service.ReservationService"%>
<%@page import="com.herimihary.reservation.entity.Voyageur"%>
<%@page import="java.util.List"%>
<%@page import="com.herimihary.reservation.entity.Reservation"%>
<%
    ReservationService reservationService = null;
    Reservation reservation = null;
    List<Voyageur> listVoyageur = null;
    String reference = null;
    try {
        reference = request.getParameter("reference");
        reservationService = new ReservationService();
        reservation = reservationService.getByReference(reference);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/bootstrap.css"></link> 
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
                <%for(int i=0;i<reservation.getNbAdulte();i++){%>
                <div class="col-md-10 mx-auto">
                    <form class="" action="/PromotionServlet" method="post">
                         <h4 class="mx-auto">Voyageur adlute <%=i+1%></h4>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="nom">Nom</label>
                                <input type="text" class="form-control" id="nom" name="nom" >
                            </div>
                            <div class="col-sm-6">
                                <label for="prenom">Prenom</label>
                                <input type="text" class="form-control" id="prenom" name="prenom">
                            </div>
                        </div>

                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="datenaissance">Date naissance</label>
                                <input type="date" class="form-control" id="datenaissance" name="datenaissance">
                            </div>
                            <div class="col-sm-6">
                                <label for="passeport">Passeport</label>
                                <input type="text" class="form-control" id="passeport" name="passeport">
                            </div>
                        </div>
                        
                       
                    </form>
                </div>
                <%}%>
                <%for(int i=0;i<reservation.getNbEnfant();i++){%>
                <div class="col-md-10 mx-auto">
                    <form class="" action="/PromotionServlet" method="post">
                        <h4 class="mx-auto">Voyageur enfant <%=i+1%></h4>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="nom">Nom</label>
                                <input type="text" class="form-control" id="nom" name="nom" >
                            </div>
                            <div class="col-sm-6">
                                <label for="prenom">Prenom</label>
                                <input type="text" class="form-control" id="prenom" name="prenom">
                            </div>
                        </div>

                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="datenaissance">Date naissance</label>
                                <input type="date" class="form-control" id="datenaissance" name="datenaissance">
                            </div>
                            <div class="col-sm-6">
                                <label for="passeport">Passeport</label>
                                <input type="text" class="form-control" id="passeport" name="passeport">
                            </div>
                        </div>
                        
                        
                    </form>
                </div>
                <%}%>
            </div>
        </div>

    </body>
</html>
