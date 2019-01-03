<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Attestato" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Gestione pratiche studente</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="css/global.css">

</head>
<body>

<!-- Navbar -->
<jsp:include page="WEB-INF/jspf/navbarStudente.jspf"/>

<%
    //   /* **********************************************
    //  STUB TEST
    DomandaLinguaInglese d = new DomandaLinguaInglese();
    Attestato a = new Attestato();
    Pratica p1 = new Pratica(d, a, null);
    p1.setTipo(Pratica.Tipo.ATTIVITA_LAVORATIVA);
    Pratica p2 = new Pratica(d, a, null);
    p2.setTipo(Pratica.Tipo.LINGUA_INGLESE);

    ArrayList<Pratica> x = new ArrayList<>();
    x.add(p1);
    x.add(p2);
    //   ****************************** */

    Collection<?> pratiche = x;

%>

<div class="container">

    <br>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#creaNuovaDomandaModal">+ Nuova pratica</button>
    <br><br>
    <table class="table table-striped">

        <thead>
        <tr>
            <th scope="col">Tipo pratica</th>
            <th scope="col">Stato</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <%
            if (pratiche != null && pratiche.size() > 0) {
                Iterator<?> it = pratiche.iterator();
                while (it.hasNext()) {
                    Pratica bean = (Pratica) it.next();
        %>

        <tr>
            <td><%=bean.getTipo()%>
            </td>
            <td><%=bean.getStato()%>
            </td>
            <td>
                <a href="#">
                    <button>Visualizza</button>
                </a>
            </td>
        </tr>

        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3">Nessuna pratica presente</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</div>

<!-- Modal creazione nuova domanda -->
<jsp:include page="WEB-INF/jspf/creaNuovaDomandaModal.jspf"/>

<!-- Footer -->
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

<!-- JS -->
<script src="js/gestionePraticheStudente.js"></script>

</body>
</html>