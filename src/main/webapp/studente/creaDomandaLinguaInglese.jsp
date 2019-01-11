<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Crea domanda lingua inglese</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

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
<%@ include file="../WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="../WEB-INF/jspf/bootstapScript.jspf" %>


</body>
</html>