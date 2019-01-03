<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Crea pratica</title>

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
    <h1>Crea pratica</h1>
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

        <button type="submit" class="btn btn-primary">Conferma</button>

    </form>

</div>

<!-- Footer -->
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

</body>
</html>