<%-- 
    Document   : listTarifs
    Created on : 30 Jan 2023, 11:46:26
    Author     : rasen
--%>
<%@page import="com.herimihary.reservation.util.StringUtil"%>
<%@page import="com.herimihary.reservation.service.ClasseService"%>
<%@page import="com.herimihary.reservation.entity.Classe"%>
<%@page import="com.herimihary.reservation.entity.Tarifs"%>
<%@page import="java.util.List"%>
<%@page import="com.herimihary.reservation.service.TarifsService"%>
<%
    TarifsService service = null;
    List<Tarifs> listTarifs = null;
    ClasseService classeService = null;
     List<Classe> classes = null;
    
    try {
        service = new TarifsService();
        classeService = new ClasseService();
        listTarifs = service.getAll();
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
        <title>Liste tarirfs</title>
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
                    <a class="nav-item nav-link" href="/tarifs/tarifsList.jsp">Tarifs</a>                  
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-10 mx-auto">

                    <form class="" action="/TarifsServlet" method="post">
                        <h1 class="mx-auto">Creer tarifs</h1>
                        <div class="form-group row row mb-4">
                            <div class="col-sm-6">
                                <label for="dateDebut">Date</label>
                                <input type="date" class="form-control" id="dateDepart" name="dateDepart" >
                            </div>        
                            <div class="col-sm-6">
                                <label for="remise">Classe</label>
                                <select class="form-select" name="classe">
                                     <%if(classes!=null){%>
                                     <% for(int i=0;i<classes.size();i++){%>
                                     <option value="<%=classes.get(i).getId() %>"><%=classes.get(i).getNom()%></option>
                                     <%}}%>
                                </select>
                            </div>
                        </div>

                        <div class="form-group  row mb-2">
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
                             <div class="col-sm-6">
                                <label for="prix">Tarif</label>
                               <input type="text" class="form-control" id="prix" name="prix" >
                            </div>
                        </div>
                       
                        <input type="submit" class="btn btn-primary mt-2 px-4 float-right" value="Enregistrer"/>
                    </form>
                </div>
            </div>
            <hr class="mt-4 mb-3"/>
            <div class="row">
                <div class="col-md-10 mx-auto">
                    <h1 class="mx-auto">Liste tarifs</h1>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Prix</th>
                                <th scope="col">Type vol</th>
                                <th scope="col">Date</th>
                                <th scope="col">Classe</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%if (listTarifs != null) {%>
                            <%for (int i = 0; i < listTarifs.size(); i++) {%>
                            <tr>
                                <td scope="col"><%=listTarifs.get(i).getId()%></td>
                                <td scope="col"><%=listTarifs.get(i).getPrix()%></td>
                                <td scope="col"><%=StringUtil.getTypeVolLibelle(listTarifs.get(i).getTypeVol()) %></td>
                                <td scope="col"><%=listTarifs.get(i).getDateDepart()%></td>
                                <td scope="col"><%=StringUtil.getClasseLibelle(listTarifs.get(i), classes) %></td>
                            </tr>
                            <%}
                                }%>



                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
