<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Attestato" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Domanda" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>Visualizza pratica studente</title>
    <%@ include file="WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%

    Pratica pratica = new Pratica();

/*********************** STUB ******************************/
    AccountStudente account = new AccountStudente();
    account.setMatricola("782673");
    account.setNome("Mario");
    account.setCognome("Rossi");

    Attestato attestato = new Attestato();
    attestato.setPath("attestatoMarioRossi8796.pdf");

    Domanda domanda = new Domanda();
    domanda.setPath("domandaMarioRossi8796.pdf");

    pratica.setTipo(Pratica.Tipo.ATTIVITA_LAVORATIVA);
    pratica.setMessaggioResponsabileUfficio("Attestazione non riconosciuta.");
    pratica.setStato(Pratica.Stato.BOCCIATA);
    pratica.setAttestato(attestato);
    pratica.setDomanda(domanda);
    pratica.setAccountStudente(account);
/***********************************************************/

%>

<!-- Navbar -->
<%@ include file="WEB-INF/jspf/navbarStudente.jspf" %>

<div class="container">

    <br>
    <h1>Dettaglio pratica</h1><br>

    <div class="card">
        <h5 class="card-header">Stato: <%= pratica.getStato() %>
        </h5>
        <div class="card-body">
            <p class="card-text"><%= pratica.getMessaggioResponsabileUfficio() %>
            </p>
        </div>
    </div>
    <br>

    <form action="" method="post" id="modificaPraticaForm">

        <div class="row">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Domanda</h5>
                        <a href="#"><%= pratica.getDomanda().getPath()%>
                        </a>
                        <div class="form-group" id="areaCaricaDomanda">
                            <br>
                            <label for="inputFileDomanda">Carica nuova domanda</label>
                            <input name="fileDomanda" type="file" value="file.pdf" class="form-control-file"
                                   id="inputFileDomanda">
                            <br>
                            <a href="#">
                                <button type="button" class="btn btn-primary">Crea nuova domanda</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Attestato</h5>
                        <a href="#"><%= pratica.getAttestato().getPath()%>
                        </a>
                        <div class="form-group" id="areaCaricaAttestato">
                            <br>
                            <label for="inputFileAttestato">Carica nuovo attestato</label>
                            <input name="fileAttestato" type="file" class="form-control-file" id="inputFileAttestato">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <a href="#">
            <button type="button" class="btn btn-danger" id="annullaButton">Annulla modifica</button>
        </a>
        <button type="submit" class="btn btn-success" id="confermaModificaButton">Conferma modifica</button>
    </form>

    <br>
    <a href="#">
        <button type="button" class="btn btn-primary" id="modificaButton">Modifica</button>
    </a>

</div>

<!-- Footer -->
<%@ include file="WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>

<!-- JS -->
<script src="js/visualizzaPraticaStudente.js"></script>

</body>
</html>