<%@ page import="it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Attestato" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Gestione pratiche responsabile ufficio</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="css/global.css">

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
    DomandaLinguaInglese d = new DomandaLinguaInglese();
    Attestato a = new Attestato();
    Pratica p1 = new Pratica(d, a, null);
    p1.setTipo(Pratica.Tipo.ATTIVITA_LAVORATIVA);
    Pratica p2 = new Pratica(d, a, null);
    p1.setAccountStudente(a1);
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
<jsp:include page="WEB-INF/jspf/navbarResponsabileUfficio.jspf"/>

<div class="container">

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
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

</body>
</html>