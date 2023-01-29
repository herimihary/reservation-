<%-- 
    Document   : edit
    Created on : 29 Jan 2023, 13:02:33
    Author     : rasen
--%>

<%@page import="com.herimihary.reservation.entity.Promotion"%>
<%@page import="com.herimihary.reservation.service.PromotionService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>

<%
    PromotionService service = null;
     List<Promotion> listPromotion =null;
    try {
         service = new PromotionService();
         listPromotion = service.getAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
    

    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promotion</title>
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
                <div class="col-md-10 mx-auto">

                    <form class="" action="/PromotionServlet" method="post">
                        <h1 class="mx-auto">Creer promotion</h1>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="dateDebut">Date debut</label>
                                <input type="date" class="form-control" id="dateDebut" name="dateDebut" >
                            </div>
                            <div class="col-sm-6">
                                <label for="dateFin">Date fin</label>
                                <input type="date" class="form-control" id="dateFin" name="dateFin">
                            </div>
                        </div>

                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="remise">Remise</label>
                                <input type="number" class="form-control" id="remise" name="remise">
                            </div>
                        </div>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="code">Code Promo</label>
                                <input type="text" class="form-control" id="code" name="code">
                            </div>

                        </div>
                        <input type="submit" class="btn btn-primary mt-2 px-4 float-right" value="Enregistrer"/>
                    </form>
                </div>
            </div>
            <hr class="mt-4 mb-3"/>
            <div class="row">
                <div class="col-md-10 mx-auto">
                    <h1 class="mx-auto">Liste promotion</h1>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Date debut</th>
                                <th scope="col">Date fin</th>
                                <th scope="col">Remise (%)</th>
                                <th scope="col">Code promo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%if(listPromotion!=null){%>
                            <%for (int i = 0; i < listPromotion.size(); i++) {%>
                            <tr>
                                <td scope="col"><%=listPromotion.get(i).getId()%></td>
                                <td scope="col"><%=listPromotion.get(i).getDateDebut()%></td>
                                <td scope="col"><%=listPromotion.get(i).getDateFin()%></td>
                                <td scope="col"><%=listPromotion.get(i).getRemise()%></td>
                                <td scope="col"><%=listPromotion.get(i).getCode()%></td>
                            </tr>
                            <%}}%>



                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
