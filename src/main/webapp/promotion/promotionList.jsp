<%-- 
    Document   : edit
    Created on : 29 Jan 2023, 13:02:33
    Author     : rasen
--%>

<%@page import="com.herimihary.reservation.util.StringUtil"%>
<%@page import="com.herimihary.reservation.entity.Classe"%>
<%@page import="com.herimihary.reservation.service.ClasseService"%>
<%@page import="com.herimihary.reservation.entity.Promotion"%>
<%@page import="com.herimihary.reservation.service.PromotionService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>

<%
    PromotionService service = null;
    ClasseService classeService = null;
    List<Promotion> listPromotion = null;
    List<Classe> classes = null;
    try {
        service = new PromotionService();
        classeService = new ClasseService();
        listPromotion = service.getAll();
        classes = classeService.getAll();
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
                            <div class="col-sm-6">
                                <label for="idclasse">Classe</label>
                                <select class="form-select" name="idclasse">
                                    <%if (classes != null) {%>
                                    <% for (int i = 0; i < classes.size(); i++) {%>
                                    <option value="<%=classes.get(i).getId()%>"><%=classes.get(i).getNom()%></option>
                                    <%}
                                        }%>
                                </select>
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
                                <th scope="col">Classe</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%if (listPromotion != null) {%>
                            <%for (int i = 0; i < listPromotion.size(); i++) {%>
                            <tr>
                                <td scope="col"><%=listPromotion.get(i).getId()%></td>
                                <td scope="col"><%=listPromotion.get(i).getDateDebut()%></td>
                                <td scope="col"><%=listPromotion.get(i).getDateFin()%></td>
                                <td scope="col"><%=listPromotion.get(i).getRemise()%></td>
                                <td scope="col"><%=listPromotion.get(i).getCode()%></td>
                                <td scope="col"><%=StringUtil.getClasseLibelle(listPromotion.get(i).getIdclasse(), classes)%></td>
                                <td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"><i class="fa fa-pencil"></i>edit </button></td>

                            </tr>

                            <%}
                                }%>



                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="myModal" class="modal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Update Promotion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-10 mx-auto">

                            <form class="" action="/PromotionServlet" method="post">

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
                                    <div class="col-sm-6">
                                        <label for="idclasse">Classe</label>
                                        <select class="form-select" name="idclasse">
                                            <%if (classes != null) {%>
                                            <% for (int i = 0; i < classes.size(); i++) {%>
                                            <option value="<%=classes.get(i).getId()%>"><%=classes.get(i).getNom()%></option>
                                            <%}
                                                }%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row row mb-2">
                                    <div class="col-sm-6">
                                        <label for="code">Code Promo</label>
                                        <input type="text" class="form-control" id="code" name="code">
                                    </div>

                                </div>

                            </form>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Save changes</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


    </body>

</html>

<script>
    $(document).ready(function () {
        $("#exampleModal").modal();
    });
    </sricpt>