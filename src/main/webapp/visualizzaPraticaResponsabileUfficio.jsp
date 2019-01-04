<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>Visualizza pratica responsabile ufficio</title>
    <%@ include file="WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%
    //   /* **********************************************
    //  STUB TEST
    AccountStudente a1 = new AccountStudente();
    a1.setMatricola("782673");
    a1.setNome("Mario");
    a1.setCognome("Rossi");

    Pratica p1 = new Pratica();
    p1.setTipo(Pratica.Tipo.ATTIVITA_LAVORATIVA);
    p1.setAccountStudente(a1);

    //   ****************************** */

    Pratica praticaBean = p1;
%>

<!-- Navbar -->
<%@ include file="WEB-INF/jspf/navbarResponsabileUfficio.jspf" %>

<div class="container">

    <br>
    <h1>Dettaglio pratica</h1><br>
    <form>
        <div class="form-group row">
            <label for="staticMatricola" class="col-sm-2 col-form-label">Matricola</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticMatricola"
                       value="<%=praticaBean.getAccountStudente().getMatricola()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticCognome" class="col-sm-2 col-form-label">Cognome</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticCognome"
                       value="<%=praticaBean.getAccountStudente().getCognome()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticNome" class="col-sm-2 col-form-label">Nome</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticNome"
                       value="<%=praticaBean.getAccountStudente().getNome()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticTipologiaPratica" class="col-sm-2 col-form-label">Tipologia pratica</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticTipologiaPratica"
                       value="<%=praticaBean.getTipo()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticFileDomanda" class="col-sm-2 col-form-label">Visualizza domanda</label>
            <div class="col-sm-10">
                <a href="#">
                    <input type="text" readonly class="form-control-plaintext" id="staticFileDomanda"
                           value="domanda.pdf"></a>
            </div>
        </div>

        <div class="form-group row">
            <label for="staticFileAttestato" class="col-sm-2 col-form-label">Visualizza attestato</label>
            <div class="col-sm-10">
                <a href="#">
                    <input type="text" readonly class="form-control-plaintext" id="staticFileAttestato"
                           value="attestato.pdf"></a>
            </div>
        </div>

    </form>

    <br><br>
    <button type="button" class="btn btn-danger">Annulla</button>
    <button type="button" class="btn btn-success">Valuta pratica</button>

</div>

<!-- Footer -->
<%@ include file="WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>