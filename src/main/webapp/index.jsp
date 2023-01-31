<%@page import="com.herimihary.reservation.util.StringUtil"%>
<%@page import="com.herimihary.reservation.service.PaysService"%>
<%@page import="com.herimihary.reservation.entity.Pays"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<%
    PaysService paysService = null;
    List<Pays> listPays = null;
    try {
        paysService = new PaysService();
        listPays = paysService.getAll();
    } catch (Exception e) {
        e.printStackTrace();
    }

%>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css"></link> 
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
                    <a class="nav-item nav-link" href="promotion/promotionList.jsp">Promotion</a>
                    <a class="nav-item nav-link" href="#">Classe</a>
                    <a class="nav-item nav-link" href="/tarifs/tarifsList.jsp">Tarifs</a>
                    <a class="nav-item nav-link" href="/checking/checking.jsp">Checking</a>



                </div>
            </div>
        </nav>
        <div class="container">


            <div class="row">

                <div class="col-md-10 mx-auto">

                    <form class="" action="/ReservationServlet" method="post">
                        <h1 class="mx-auto">Reservation</h1>
                        <div class="form-group row mb-2">
                            <div class="col-sm-6">
                                <input class="form-check-input" type="radio" name="typevol" value="1" id="aller">
                                <label class="form-check-label" for="aller">
                                    Aller simple
                                </label>
                                <input class="form-check-input" type="radio" name="typevol" value="2" id="retour">
                                <label class="form-check-label" for="retour">
                                    Aller et retour
                                </label>
                            </div>

                        </div>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="paysDepart">Pays de depart</label>
                                <select class="form-control" id="paysDepart" name="paysDepart">
                                    <%for (int i = 0; i < listPays.size(); i++) {%>
                                    <option value="<%=listPays.get(i).getId()%>"> <%=StringUtil.formatPays(listPays.get(i))%> </option>
                                    <%}%>

                                </select>
                            </div>
                            <div class="col-sm-6">
                                <label for="paysArrivee">Pays d'arrivee</label>
                                <select class="form-control" id="paysArrivee" name="paysArrivee">
                                    <%for (int i = 0; i < listPays.size(); i++) {%>
                                    <option value="<%=listPays.get(i).getId()%>"> <%=StringUtil.formatPays(listPays.get(i))%> </option>
                                    <%}%>                                  
                                </select>
                            </div>
                        </div>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="dateDepart">Date depart</label>
                                <input type="date" class="form-control" id="dateDepart" name="dateDepart" >
                            </div>
                            <div class="col-sm-6">
                                <label for="dateArrivee">Date arrivee</label>
                                <input type="date" class="form-control" id="dateArrivee" name="dateArrivee">
                            </div>
                        </div>
                        <div class="form-group row row mb-2">                          
                            <div class="col-sm-3">
                                <label for="nbAdulte">Adulte</label>
                                <input type="number" class="form-control" id="nbAdulte" name="nbAdulte" >
                            </div>
                            <div class="col-sm-3">
                                <label for="nbEnfant">Enfant</label>
                                <input type="number" class="form-control" id="nbEnfant" name ="nbEnfant" >
                            </div>
                        </div>
                        <div class="form-group row row mb-2">
                            <div class="col-sm-6">
                                <label for="promocode">Code Promo</label>
                                <input type="text" class="form-control" id="promocode" name="promocode">
                            </div>

                        </div>
                        <input type="submit" class="btn btn-primary mt-2 px-4 float-right" value="Reserver"/>
                    </form>
                </div>
            </div>


        </div>

    </body>
</html>
