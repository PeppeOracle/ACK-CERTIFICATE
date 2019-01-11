<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Gestione pratiche responsabile ufficio</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%
    //   /* **********************************************
    //  STUB TEST
    AccountStudente a1 = new AccountStudente();
    a1.setMatricola("782673");
    a1.setNome("Mario");
    a1.setCognome("Rossi");

    AccountStudente a2 = new AccountStudente();
    a2.setMatricola("128973");
    a2.setNome("Salvatore");
    a2.setCognome("Bianchi");

    Pratica p1 = new Pratica();
    p1.setTipo(Pratica.Tipo.ATTIVITA_LAVORATIVA);
    p1.setAccountStudente(a1);

    Pratica p2 = new Pratica();
    p2.setTipo(Pratica.Tipo.LINGUA_INGLESE);
    p2.setAccountStudente(a2);

    ArrayList<Pratica> x = new ArrayList<>();
    x.add(p1);
    x.add(p2);
    x.add(p1);
    //   ****************************** */

    Collection<?> pratiche = x;

%>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarResponsabileUfficio.jspf" %>

<div class="container">

    <br>
    <h1>Gestione pratiche</h1>
    <br>Filtra pratiche:<br><br>
    <button type="button" class="btn btn-outline-primary active">Nessun filtro</button>
    <button type="button" class="btn btn-outline-primary">Pratiche da valutare</button>
    <button type="button" class="btn btn-outline-primary">Pratiche sospese</button>
    <button type="button" class="btn btn-outline-primary">Pratiche chiuse</button>
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

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>