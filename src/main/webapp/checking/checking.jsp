<%-- 
    Document   : checking
    Created on : 31 janv. 2023, 20:36:48
    Author     : rheri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checking</title>
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
                    <a class="nav-item nav-link" href="/checking/checking.jsp">Checking</a>
                    <a class="nav-item nav-link" href="/promotion/promotionList.jsp">Promotion</a>
                    <a class="nav-item nav-link" href="#">Classe</a>
                    <a class="nav-item nav-link" href="/tarifs/tarifsList.jsp">Tarifs</a>                  
                </div>
            </div>
        </nav>


        <div class="container">
            <div class="row" style="flex-direction: column;align-items: center;display: flex;">
                <div class="col-6" style="background-color:#d3dae9; padding: 20px;margin:  20px">
                    <form action="/CheckingServlet" method="post">
                        <div class="row mb-3">
                            <label  class="col-sm-3 col-form-label">Reference</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="reference" name="reference">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm">             
                                <input type="submit" class="btn btn-primary" value="Rechercher" >
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>



    </body>
</html>
