<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isErrorPage="true" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>ACK Certificate Login</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="css/global.css">
</head>
<body>

<%
    session.removeAttribute("account");
%>

<!-- Navbar -->
<%@ include file="WEB-INF/jspf/navbarNoUser.jspf" %>
<div class="container">
    <br><br>
    Siamo spiacenti si è verificato un errore imprevisto.<br>
    Contattare l'amministratore del sito se il problema persiste.<br>

    <br><br>STAMPARE ERRORE<br><br>
    <br> <a href="<%=request.getContextPath()%>">Torna alla
    homepage</a>

</div>

<!-- Footer -->
<%@ include file="WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>