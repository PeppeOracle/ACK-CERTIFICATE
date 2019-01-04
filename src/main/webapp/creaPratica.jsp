<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>Crea pratica</title>
    <%@ include file="WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<!-- Navbar -->
<%@ include file="WEB-INF/jspf/navbarStudente.jspf" %>

<div class="container">

    <br>
    <h1>Nuova pratica</h1>
    <br>
    <form action="" method="post">

        <div class="form-group">
            <label for="inputFileDomanda">File domanda</label>
            <input name="fileDomanda" type="file" value="file.pdf" class="form-control-file" id="inputFileDomanda" required>
        </div>

        <div class="form-group">
            <label for="inputFileAttestato">File attestato</label>
            <input name="fileAttestato" type="file" class="form-control-file" id="inputFileAttestato" required>
        </div>

        <div class="form-group">
            <label for="textareaMessaggio">Messaggio</label>
            <textarea class="form-control" id="textareaMessaggio" rows="3"></textarea>
        </div>

        <br><br>

        <button type="submit" class="btn btn-danger">Annulla</button>
        <button type="submit" class="btn btn-success">Conferma</button>

    </form>

</div>

<!-- Footer -->
<%@ include file="WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>