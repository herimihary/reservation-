<%-- 
    Document   : vol
    Created on : 30 Jan 2023, 10:51:16
    Author     : rasen
--%>
<%@page import="com.herimihary.reservation.entity.Classe"%>
<%@page import="java.util.List"%>
<%@page import="com.herimihary.reservation.service.ClasseService"%>
<%
    ClasseService classeService = null;
    List<Classe> classes = null;
    String reference = request.getParameter("reference");
    try {
        classeService = new ClasseService();
        classes = classeService.getAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vol</title>
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
            <form method="post" action="/ReservationServlet">
                <div class="row">
                    <div class="col-6">
                        <h4>Depart</h4>
                        <div class="form-group row row mb-2">
                            <input type="hidden" class="form-control" id="reference" name="reference" value="<%=reference%>">
                            <input type="date" class="form-control" id="dateDebut" name="dateDebut" >
                            <table class="table">
                                <thead>
                                    <tr id="listTarifTh">
                                        <%for (int i = 0; i < classes.size(); i++) {%>
                                        <th><%=classes.get(i).getNom()%></th>                                  
                                            <%}%>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr id="listTarifTdDepart">

                                    </tr>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="col-6">
                        <h4>Arriver</h4>
                        <input type="date" class="form-control" id="dateRetour" name="dateRetour" >
                        <table class="table">
                            <thead>
                                <tr>
                                    <%for (int i = 0; i < classes.size(); i++) {%>
                                    <th><%=classes.get(i).getNom()%></th>                                  
                                        <%}%>
                                </tr>
                            </thead>
                            <tbody>
                                <tr id="listTarifTdRetour">


                                </tr>


                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <input type="Submit" class="btn btn-success btn-lg" value="Suivant" name="Suivant"/>
                </div>
            </form>
        </div>
    </body>
</html>
<script>
    $(document).ready(function () {
        var date = new Date().toISOString().split("T")[0];

        callJqueryAjax(date, 1);
        callJqueryAjax(date, 2);

        $("#dateDebut").change(function () {
            var date = $('#dateDebut').val();
            callJqueryAjax(date, 1);
        });
        $("#dateRetour").change(function () {
            var date = $('#dateRetour').val();
            callJqueryAjax(date, 2);
        });
    });
    function callJqueryAjax(date, typevol) {

        $.ajax({
            url: '/VolServlet',
            method: 'POST',
            data: {
                date: date,
                typevol: typevol
            },
            success: function (resp) {
                console.log(resp);
                if (typevol === 1) {
                    $("#listTarifTdDepart").html("");
                } else {
                    $("#listTarifTdRetour").html("");
                }

                for (var i = 0; i < resp.length; i++) {
                    var disable = "";
                    var styleremise = "";
                    if (resp[i].prix === null || resp[i].prix === 0) {
                        disable = "disabled";
                    }
                    if (resp[i].isdiscount === true) {
                        styleremise = ";background-color: #b5668c;";
                    }
                    if (typevol === 1) {

                        $("#listTarifTdDepart").append('<td style="padding:20px' + styleremise + '"><input value="' +  resp[i].idTarif + '" style="margin-right: 19px" class="form-check-input" type="radio" name="tarifDepart" ' + disable + '/>' + resp[i].prix + '</td>');
                    } else {

                        $("#listTarifTdRetour").append('<td style="padding:20px' + styleremise + '"><input value="' + resp[i].idTarif + '" style="margin-right: 19px" class="form-check-input" type="radio" name="tarifRetour" ' + disable + '/>' + resp[i].prix + '</td>');
                    }


                }
            },
            error: function (jqXHR, exception) {
                console.log('Error occured!!');
            }
        });
    }

</script>
