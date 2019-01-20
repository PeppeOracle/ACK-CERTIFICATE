<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Gestione profilo studente</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.Account" %>
<%
    AccountStudente accountBean = (AccountStudente) session.getAttribute("account");
    SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
%>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

<div class="container">

    <br>
    <h1>Gestione profilo</h1><br>
    <form action="/gestione-utenti/modifica-profilo-studente" method="post" id="modificaProfiloForm">

        <div class="form-group">
            <label for="inputNome">Nome</label>
            <input name="nome" type="text" class="form-control" id="inputNome"
                   value="<%= accountBean.getNome() %>" required disabled>
            <input name="nome" type="hidden"
                   value="<%= accountBean.getNome() %>">
        </div>

        <div class="form-group">
            <label for="inputCognome">Cognome</label>
            <input name="cognome" type="text" class="form-control" id="inputCognome"
                   value="<%= accountBean.getCognome() %>" required disabled>
            <input name="cognome" type="hidden"
                   value="<%= accountBean.getCognome() %>">
        </div>

        <div class="form-group">
            <label for="inputSesso">Sesso</label>
            <input name="sesso" type="text" class="form-control" id="inputSesso"
                   value="<%= (accountBean.getSesso()==Account.Sesso.FEMMINA)?"Donna":"Uomo" %>" required disabled>
            <input name="sesso" type="hidden"
                   value="<%= accountBean.getSesso() %>">
        </div>

        <div class="form-group">
            <label for="inputLuogoNascita">Luogo di nascita</label>
            <input name="luogoNascita" type="text" class="form-control" id="inputLuogoNascita"
                   value="<%= accountBean.getLuogoDiNascita() %>" required disabled>
            <input name="luogoNascita" type="hidden"
                   value="<%= accountBean.getLuogoDiNascita() %>">
        </div>

        <div class="form-group">
            <label for="inputDataNascita">Data di nascita</label>
            <input name="dataNascita" type="text" class="form-control" id="inputDataNascita"
                   value="<%= format.format(accountBean.getDataDiNascita()) %>" required disabled>
            <input name="dataNascita" type="hidden"
                   value="<%= format.format(accountBean.getDataDiNascita()) %>">
        </div>

        <div class="form-group">
            <label for="inputMatricola">Matricola</label>
            <input name="matricola" type="number" class="form-control" id="inputMatricola"
                   value="<%= accountBean.getMatricola() %>" required disabled>
            <input name="matricola" type="hidden"
                   value="<%= accountBean.getMatricola() %>">
        </div>

        <div class="form-group">
            <label for="inputEmail">Email</label>
            <input name="email" type="email" class="form-control" id="inputEmail"
                   value="<%= accountBean.getEmail() %>" required disabled>
            <input name="email" type="hidden"
                   value="<%= accountBean.getEmail() %>">
        </div>

        <div class="form-group">
            <label for="inputPassword">Password</label>
            <input name="password" type="password" class="form-control" id="inputPassword"
                   value="<%= accountBean.getPassword() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputCitta">Citt&agrave;</label>
            <input name="citta" type="text" class="form-control" id="inputCitta"
                   value="<%= accountBean.getCitta() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputIndirizzo">Indirizzo</label>
            <input name="indirizzo" type="text" class="form-control" id="inputIndirizzo"
                   value="<%= accountBean.getIndirizzoDiResidenza() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputNumeroCivico">Numero civico</label>
            <input name="numeroCivico" type="text" class="form-control" id="inputNumeroCivico"
                   value="<%= accountBean.getNumeroCivico() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputCap">CAP</label>
            <input name="cap" type="number" class="form-control" id="inputCap"
                   value="<%= accountBean.getCap() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputPaese">Paese</label>
            <input name="paese" type="text" class="form-control" id="inputPaese"
                   value="<%= accountBean.getPaese() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputCorsoLaurea">Corso di laurea</label>
            <input name="corsoLaurea" type="text" class="form-control" id="inputCorsoLaurea"
                   value="<%= accountBean.getCorsoDiLaurea() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputTipologiaLaurea">Tipologia laurea</label>
            <input name="tipologiaLaurea" type="text" class="form-control" id="inputTipologiaLaurea"
                   value="<%= accountBean.getTipologiaDiLaurea() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputAnnoImmatricolazione">Anno di immatricolazione</label>
            <input name="annoImmatricolazione" type="text" class="form-control" id="inputAnnoImmatricolazione"
                   value="<%= accountBean.getAnnoDiImmatricolazione() %>" required disabled>
        </div>

        <div class="form-group">
            <label for="inputTelefono">Recapito telefonico</label>
            <input name="telefono" type="tel" class="form-control" id="inputTelefono"
                   value="<%= accountBean.getTelefono() %>" disabled>
        </div>

        <br><br>
        <a href="#">
            <button type="button" class="btn btn-primary" id="modificaButton">Modifica</button>
        </a>
        <a href="#">
            <button type="button" class="btn btn-danger" id="annullaButton">Annulla modifica</button>
        </a>
        <button type="submit" class="btn btn-success" id="confermaModificaButton">Conferma modifica</button>

    </form>

</div>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

<!-- JS -->
<script src="../js/gestioneProfiloStudente.js"></script>

</body>
</html>