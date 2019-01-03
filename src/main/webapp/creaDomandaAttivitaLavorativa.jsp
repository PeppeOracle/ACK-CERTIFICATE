<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Crea domanda attivit&agrave lavorativa</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="css/global.css">

</head>
<body>

<!-- Navbar -->
<jsp:include page="WEB-INF/jspf/navbarStudente.jspf"/>

<div class="container">

    <br>
    <h1>Crea domanda attivit&agrave lavorativa</h1>
    <br>
    <form action="" method="post">

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
                   placeholder="gg/mm/aaaa - gg/mm/aaaa" required>
        </div>

        <div class="form-group">
            <label for="inputOreSvolte">Ore svolte</label>
            <input name="oreSvolte" type="number" class="form-control" id="inputOreSvolte"
                   placeholder="180" required>
        </div>

        <small class="form-text text-muted">Tutti i campi sono obbligatori.</small>
        <br><br>
        <button type="submit" class="btn btn-primary">Scarica</button>

    </form>

</div>

<!-- Footer -->
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

</body>
</html>