<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Gestione pratiche studente</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

<%
    //   /* **********************************************
    //  STUB TEST
    Pratica p1 = new Pratica();
    p1.setStato(Pratica.Stato.IN_ATTESA);
    p1.setTipo(Pratica.Tipo.ATTIVITA_LAVORATIVA);
    Pratica p2 = new Pratica();
    p2.setStato(Pratica.Stato.APPROVATA);
    p2.setTipo(Pratica.Tipo.LINGUA_INGLESE);

    ArrayList<Pratica> x = new ArrayList<>();
    x.add(p1);
    x.add(p2);
    //   ****************************** */

    Collection<?> pratiche = x;

%>

<div class="container">

    <br>
    <h1>Gestione pratiche</h1><br>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#creaNuovaDomandaModal">
        + Nuova pratica
    </button>
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
<jsp:include page="../WEB-INF/jspf/creaNuovaDomandaModal.jspf"/>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

<!-- JS -->
<script src="../js/gestionePraticheStudente.js"></script>

</body>
</html>