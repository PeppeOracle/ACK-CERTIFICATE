<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Valuta pratica</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>
<%
    Pratica pratica = (Pratica) request.getAttribute("pratica");
    String annullaValutazioneUrl = "/gestione-pratiche/mostra-pratica?tipo=0&pratica="+pratica.getId();
    String confermaValutazioneUrl = "/gestione-pratiche/valuta-pratica?tipo=0&pratica="+pratica.getId();
%>
<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarResponsabileUfficio.jspf" %>

<div class="container">

    <br><h1>Valuta pratica</h1><br>
    <form>
        <div class="form-group">
            <label for="selectStatoPratica">Stato pratica *</label>
            <select class="custom-select" name="statoPratica" id="selectStatoPratica" required>
                <option selected>Selezionare uno stato</option>
                <option value="approvata">Approvata</option>
                <option value="bocciata">Bocciata</option>
            </select>
        </div>

        <div class="form-group">
            <label for="textareaMessaggio">Messaggio</label>
            <textarea name="messaggio" class="form-control" id="textareaMessaggio" rows="5"></textarea>
        </div>

        <small class="form-text text-muted">I campi contrassegnati con * sono obbligatori.</small>
        <br><br>
        <a href="<%=annullaValutazioneUrl%>"><button type="button" class="btn btn-danger">Annulla</button></a>
        <a href="<%=confermaValutazioneUrl%>"><button type="submit" class="btn btn-success">Conferma valutazione</button></a>
    </form>

</div>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>