<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Gestione pratiche studente</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
    <link rel="stylesheet" href="../css/gestionePratiche.css">
</head>
<body>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

<%
    List<Pratica> pratiche = (List<Pratica>) request.getAttribute("pratiche");
    int pagina = (Integer) request.getAttribute("pagina");
    session.setAttribute("pagina", pagina);
    long maxPagina = (Long) request.getAttribute("max_pagina");
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
                    String mostraBeanUrl = "/gestione-pratiche/mostra-pratica?tipo=2&pratica="+bean.getId();
        %>

        <tr>
            <td><%=bean.getTipo()%>
            </td>
            <td><%=bean.getStato()%>
            </td>
            <td>
            <a href="<%=mostraBeanUrl%>">
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
    <div class="fixed-bottom paginazione">
        <a href="/gestione-pratiche/visualizza-pratiche-studente?pagina=<%=pagina-1%>">
            <button type="button" class="btn btn-outline-primary" <%=(pagina > 1) ? "" : "disabled"%>>
                &lt;
            </button>
        </a>
        Pagina <%=pagina%>
        <a href="/gestione-pratiche/visualizza-pratiche-studente?&pagina=<%=pagina+1%>">
            <button type="button" class="btn btn-outline-primary" <%=(pagina != maxPagina) ? "" : "disabled"%>>
                &gt;
            </button>
        </a>
    </div>
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