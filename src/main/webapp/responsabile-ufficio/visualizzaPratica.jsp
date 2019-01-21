<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Visualizza pratica responsabile ufficio</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%
    Pratica pratica = (Pratica) request.getAttribute("pratica");
    String mostraPraticaUrl = "/gestione-pratiche/mostra-pratica?tipo=1&pratica="+pratica.getId();
    String gestionePraticheUrl = "/gestione-pratiche/visualizza-pratiche-responsabile-ufficio?filtro="+session.getAttribute("filtro")+"&pagina="+session.getAttribute("pagina");
%>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarResponsabileUfficio.jspf" %>

<div class="container">

    <br>
    <h1>Dettaglio pratica</h1><br>
    <form>
        <div class="form-group row">
            <label for="staticMatricola" class="col-sm-2 col-form-label">Matricola</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticMatricola"
                       value="<%=pratica.getAccountStudente().getMatricola()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticCognome" class="col-sm-2 col-form-label">Cognome</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticCognome"
                       value="<%=pratica.getAccountStudente().getCognome()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticNome" class="col-sm-2 col-form-label">Nome</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticNome"
                       value="<%=pratica.getAccountStudente().getNome()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticTipologiaPratica" class="col-sm-2 col-form-label">Tipologia pratica</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticTipologiaPratica"
                       value="<%=pratica.getTipo()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticTipologiaPratica" class="col-sm-2 col-form-label">Stato</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticStatoPratica"
                       value="<%=pratica.getStato()%>">
            </div>
        </div>

        <div class="form-group row">
            <label for="staticFileDomanda" class="col-sm-2 col-form-label">Domanda</label>
            <div class="col-sm-10">
                <a href="/gestione-pratiche/download-file?file_name=<%=pratica.getDomanda().getPath()%>" class="form-control-plaintext" id="staticFileDomanda" download>
                    Download
                </a>
            </div>
        </div>

        <div class="form-group row">
            <label for="staticFileAttestato" class="col-sm-2 col-form-label">Attestato</label>
            <div class="col-sm-10">
                <a href="/gestione-pratiche/download-file?file_name=<%=pratica.getAttestato().getPath()%>" class="form-control-plaintext" id="staticFileAttestato" download>
                    Download
                </a>
            </div>
        </div>

    </form>

    <br><br>
    <a href="<%=gestionePraticheUrl%>">
    <button type="button" class="btn btn-danger">Torna indietro</button>
    </a>
    <a style="display:<%=(pratica.getStato()==Pratica.Stato.IN_ATTESA)?"block":"none"%>;" href="<%=mostraPraticaUrl%>">
    <button type="button" class="btn btn-success">Valuta pratica</button>
    </a>

</div>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>