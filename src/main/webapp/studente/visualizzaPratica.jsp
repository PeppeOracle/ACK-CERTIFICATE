<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Attestato" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Domanda" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Visualizza pratica studente</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%
    Pratica pratica = (Pratica) request.getAttribute("pratica");
%>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

<div class="container">

    <br>
    <h1>Dettaglio pratica</h1><br>

    <div class="card">
        <h5 class="card-header">Stato: <%= pratica.getStato() %>
        </h5>
        <div class="card-body">
            <p class="card-text"><%= (pratica.getMessaggioResponsabileUfficio()==null || pratica.getMessaggioResponsabileUfficio().trim().equals(""))?"Il responsabile ufficio non ha lasciato nessun messaggio.":pratica.getMessaggioResponsabileUfficio() %>
            </p>
        </div>
    </div>
    <br>

    <form action="/gestione-pratiche/modifica-pratica-sospesa" method="post" id="modificaPraticaForm">
        <div class="row">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <a href="/gestione-pratiche/download-file?file_name=<%=pratica.getDomanda().getPath()%>"> <h5 class="card-title">Domanda</h5> </a>
                        <div class="form-group" id="areaCaricaDomanda">
                            <br>
                            <label for="inputFileDomanda">Carica nuova domanda</label>
                            <input name="fileDomanda" type="file" class="form-control-file"
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
                        <a href="/gestione-pratiche/download-file?file_name=<%=pratica.getAttestato().getPath()%>" download> <h5 class="card-title">Attestato</h5> </a>
                        <div class="form-group" id="areaCaricaAttestato">
                            <br>
                            <label for="inputFileAttestato">Carica nuovo attestato</label>
                            <input name="fileAttestato" type="file" class="form-control-file" id="inputFileAttestato">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" value="<%=pratica.getId()%>" name="pratica" />
        <br>
        <a href="#">
            <button type="button" class="btn btn-danger" id="annullaButton">Annulla modifica</button>
        </a>
        <button type="submit" class="btn btn-success" id="confermaModificaButton">Conferma modifica</button>

    </form>

    <br>
    <a style="display:<%=(pratica.getStato()==Pratica.Stato.SOSPESA)?"block":"none"%>;" href="#">
        <button type="button" class="btn btn-primary" id="modificaButton">Modifica</button>
    </a>
</div>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

<!-- JS -->
<script src="../js/visualizzaPraticaStudente.js"></script>

</body>
</html>