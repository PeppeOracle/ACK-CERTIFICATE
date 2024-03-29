<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>ACK Certificate Login</title>
    <%@ include file="WEB-INF/jspf/headLink.jspf" %>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<%
    session.removeAttribute("account");
%>

<!-- Navbar -->
<%@ include file="WEB-INF/jspf/navbarNoUser.jspf" %>
<div class="container">

    <form action="/gestione-utente/autenticazione-utente" method="post" id="loginForm">

        <img src="images/ackc-logo.png" alt="Logo">

        <div class="form-group">
            <%--<label for="inputLoginUsername">Email</label>--%>
            <input name="email" type="email" class="form-control" id="inputLoginUsername"
                   placeholder="Username" required>
        </div>

        <div class="form-group">
            <%--<label for="inputLoginPassword">Password</label>--%>
            <input name="password" type="password" class="form-control" id="inputLoginPassword"
                   placeholder="Password" required>
        </div>
        <!--<input name="filtro" type="hidden" value=0>
        <input name="pagina" type="hidden" value=1>-->
        <button type="submit" class="btn btn-primary">Accedi</button>
        <br><br>
        <a href="registrazioneAccountStudente.jsp">Non hai un account? Registrati!</a>
    </form>

</div>

<!-- Footer -->
<%@ include file="WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>