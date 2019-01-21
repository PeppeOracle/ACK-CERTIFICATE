<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Crea domanda attivit&agrave lavorativa</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

<div class="container">

    <br>
    <h1>Crea domanda attivit&agrave lavorativa</h1>
    <br>
    <form action="/gestione-pratiche/creazione-domanda-attivita-lavorativa" method="get">

        <div class="form-group">
            <label for="inputNumeroCfu">Numero CFU</label>
            <input name="numeroCfu" type="number" class="form-control" id="inputNumeroCfu"
                   placeholder="6" required>
        </div>

        <div class="form-group">
            <label for="inputEnte">Ente</label>
            <input name="ente" type="text" class="form-control" id="inputEnte"
                   placeholder="PippoSoftware" required>
        </div>

        <div class="form-group">
            <label for="inputIndirizzoSede">Indirizzo sede</label>
            <input name="indirizzoSede" type="text" class="form-control" id="inputIndirizzoSede"
                   placeholder="Via Marco Polo, 132, 84084, Fisciano (SA)" required>
        </div>

        <div class="form-group">
            <label for="inputProfilo">Profilo</label>
            <input name="profilo" type="text" class="form-control" id="inputProfilo"
                   placeholder="Programmatore" required>
        </div>

        <div class="form-group">
            <label for="inputTipoContratto">Tipo contratto</label>
            <input name="tipoContratto" type="text" class="form-control" id="inputTipoContratto"
                   placeholder="Tempo determinato" required>
        </div>

        <div class="form-group">
            <label for="inputPeriodo">Periodo</label>
            <input name="periodo" type="text" class="form-control" id="inputPeriodo"
                   placeholder="gg-mm-aaaa / gg-mm-aaaa" required>
        </div>

        <div class="form-group">
            <label for="inputOreSvolte">Ore svolte</label>
            <input name="oreSvolte" type="number" class="form-control" id="inputOreSvolte"
                   placeholder="180" required>
        </div>

        <small class="form-text text-muted">Tutti i campi sono obbligatori.</small>
        <br><br>
        <a href="#" class="btn btn-primary" id="downloadButton" download>Scarica</a>

        <br><br>
        <a href="<%=((Integer)request.getAttribute("azione"))==1?"/gestione-pratiche/mostra-pratica?tipo=2&pratica="+session.getAttribute("pratica"):"/studente/creaPratica.jsp?tipo=ATTIVITA_LAVORATIVA"%>" style="display:none;" class="btn btn-primary" id="avantiButton">Continua</a>

    </form>

</div>

<!-- Footer -->
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>

<script>
    $(document).ready(function() {
        $("#downloadButton").click(function(event) {
            event.preventDefault();
            window.open("/gestione-pratiche/creazione-domanda-attivita-lavorativa"
                + "?profilo=" + $("#inputProfilo").val()
                + "&tipoContratto=" + $("#inputTipoContratto").val()
                + "&periodo=" + $("#inputPeriodo").val()
                + "&oreSvolte=" + $("#inputOreSvolte").val()
                + "&indirizzoSede=" + $("#inputIndirizzoSede").val()
                + "&ente=" + $("#inputEnte").val()
                + "&numeroCfu=" + $("#inputNumeroCfu").val(),"download");
            $("#avantiButton").show();
        })
    });
</script>

</body>
</html>