<%--
  User: lorenzo
  Date: 29/12/2018
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>ACKC Login</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/login.css">

</head>
<body>

<!-- Navbar -->
<jsp:include page="WEB-INF/jspf/navbarNoUser.jspf"/>

<div class="container">

    <form action="" method="post" id="loginForm">

        <img src="images/ackc-logo.png" alt="Logo">

        <div class="form-group">
            <%--<label for="inputLoginUsername">Email</label>--%>
            <input name="loginUsername" type="email" class="form-control" id="inputLoginUsername"
                   placeholder="Username" required>
        </div>

        <div class="form-group">
            <%--<label for="inputLoginPassword">Password</label>--%>
            <input name="loginPassword" type="password" class="form-control" id="inputLoginPassword"
                   placeholder="Password" required>
        </div>

        <button type="submit" class="btn btn-primary">Accedi</button>
        <br><br>
        <a href="registrazioneAccountStudente.jsp">Non hai un account? Registrati!</a>
    </form>

</div>

<!-- Footer -->
<jsp:include page="WEB-INF/jspf/footer.jspf"/>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<jsp:include page="WEB-INF/jspf/bootstapScript.jspf"/>

</body>
</html>