<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/headMeta.jspf" %>
    <title>Crea domanda lingua inglese</title>
    <%@ include file="../WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<%
%>

<!-- Navbar -->
<%@ include file="../WEB-INF/jspf/navbarStudente.jspf" %>

<div class="container">

    <br>
    <h1>Crea domanda lingua inglese</h1>
    <br>
    <form>

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
        <a href="#" class="btn btn-primary" id="downloadButton" download>Scarica</a>

        <br><br>
        <a href="<%=((Integer)request.getAttribute("azione"))==1?"/gestione-pratiche/mostra-pratica?tipo=2&pratica="+session.getAttribute("pratica"):"/studente/creaPratica.jsp?tipo=LINGUA_INGLESE"%>" style="display:none;" class="btn btn-primary" id="avantiButton">Continua</a>

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
            window.open("/gestione-pratiche/creazione-domanda-lingua-inglese"
            + "?cefr=" + $("#inputCefr").val()
            + "&grade=" + $("#inputGrade").val()
            + "&enteCertificatore=" + $("#inputEnteCertificatore").val()
            + "&numeroCfu=" + $("#inputNumeroCfu").val(),"download");
            $("#avantiButton").show();
        })
    });
</script>

</body>
</html>