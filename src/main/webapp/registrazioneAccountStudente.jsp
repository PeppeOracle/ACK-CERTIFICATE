<%--
  Created by IntelliJ IDEA.
  User: lorenzo
  Date: 28/12/2018
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Registrazione account studente</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="css/global.css">

</head>
<body>

<!-- Navbar -->
<jsp:include page="WEB-INF/jspf/navbarNoUser.jspf"/>

<div class="container">

    <br>
    <h1>Registrazione account studente</h1><br>

    <!-- Form profilo studente -->
    <jsp:include page="WEB-INF/jspf/formProfiloStudente.jspf"/>

</div>

<!-- Footer -->
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

</body>
</html>
