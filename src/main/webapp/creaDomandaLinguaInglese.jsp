<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Crea domanda lingua inglese</title>

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
    <h1>Crea domanda lingua inglese</h1>
    <br>
    <form action="" method="post">

        <div class="form-group">
            <label for="inputNumeroCfu">Numero CFU</label>
            <input name="numeroCfu" type="number" class="form-control" id="inputNumeroCfu"
                   placeholder="6" required>
        </div>

        <div class="form-group">
            <label for="inputEnteCertificatore">Ente certificatore</label>
            <input name="enteCertificatore" type="text" class="form-control" id="inputEnteCertificatore"
                   placeholder="Trinity College" required>
        </div>

        <div class="form-group">
            <label for="inputGrade">Grade</label>
            <input name="grade" type="number" class="form-control" id="inputGrade"
                   placeholder="7" required>
        </div>

        <div class="form-group">
            <label for="inputCefr">CEFR</label>
            <input name="cefr" type="text" class="form-control" id="inputCefr"
                   placeholder="B2.1" required>
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