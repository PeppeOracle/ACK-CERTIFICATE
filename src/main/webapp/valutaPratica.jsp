<%@ page import="it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Attestato" %>
<%@ page import="it.unisa.ackc.gestione_pratiche.entity.Pratica" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="it.unisa.ackc.gestione_utenti.entity.AccountStudente" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Valuta pratica responsabile ufficio</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="css/global.css">

</head>
<body>


<!-- Navbar -->
<jsp:include page="WEB-INF/jspf/navbarResponsabileUfficio.jspf"/>

<div class="container">

    <br><br>
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
            <textarea class="form-control" id="textareaMessaggio" rows="5"></textarea>
        </div>

        <small class="form-text text-muted">I campi contrassegnati con * sono obbligatori.</small>
        <br><br>
        <button type="button" class="btn btn-danger">Annulla</button>
        <button type="submit" class="btn btn-success">Conferma valutazione</button>
    </form>

</div>

<!-- Footer -->
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

</body>
</html>