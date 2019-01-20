<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Gestione pratiche responsabile ufficio</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
    <link rel="stylesheet" href="../css/gestionePratiche.css">
</head>
<body>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarResponsabileUfficio.jspf" %>

<%
    List<Pratica> pratiche = (List<Pratica>) request.getAttribute("pratiche");
    int filtro = (Integer) request.getAttribute("filtro");
    int pagina = (Integer) request.getAttribute("pagina");
    session.setAttribute("filtro", filtro);
    session.setAttribute("pagina", pagina);
    int maxPagina = (Integer) request.getAttribute("max_pagina");
%>

<div class="container">

    <br>
    <h1>Gestione pratiche</h1>
    <br>Filtra pratiche:<br><br>
    <a href="/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro=0&pagina=1">
        <button type="button" class="btn btn-outline-primary <%=(filtro==0)?"active":""%>">Nessun filtro</button>
    </a>
    <a href="/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro=1&pagina=1">
        <button type="button" class="btn btn-outline-primary <%=(filtro==1)?"active":""%>">Pratiche da valutare</button>
    </a>
    <a href="/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro=2&pagina=1">
        <button type="button" class="btn btn-outline-primary <%=(filtro==2)?"active":""%>">Pratiche sospese</button>
    </a>
    <a href="/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro=3&pagina=1">
        <button type="button" class="btn btn-outline-primary <%=(filtro==3)?"active":""%>">Pratiche chiuse</button>
    </a>
    <br><br><br>

    <table class="table table-striped">

        <thead>
        <tr>
            <th scope="col">Matricola</th>
            <th scope="col">Cognome</th>
            <th scope="col">Nome</th>
            <th scope="col">Tipo pratica</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <%
            if (pratiche != null && pratiche.size() > 0) {
                Iterator<?> it = pratiche.iterator();
                while (it.hasNext()) {
                    Pratica bean = (Pratica) it.next();
                    String mostraBeanUrl = "/gestione-pratiche/mostra-pratica?tipo=0&pratica=" + bean.getId();
        %>

        <tr>
            <td><%=bean.getAccountStudente().getMatricola()%>
            </td>
            <td><%=bean.getAccountStudente().getCognome()%>
            </td>
            <td><%=bean.getAccountStudente().getNome()%>
            </td>
            <td><%=bean.getTipo()%>
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
        <a href="/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro=<%=filtro%>&pagina=<%=pagina-1%>">
            <button type="button" class="btn btn-outline-primary" <%=(pagina > 1) ? "" : "disabled"%>>Pagina
                Precedente
            </button>
        </a>
        Pagina <%=pagina%>
        <a href="/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro=<%=filtro%>&pagina=<%=pagina+1%>">
            <button type="button" class="btn btn-outline-primary" <%=(pagina != maxPagina) ? "" : "disabled"%>>Pagina
                Successiva
            </button>
        </a>
    </div>
</div>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>


</body>
</html>