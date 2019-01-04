<%--
  Created by IntelliJ IDEA.
  User: lorenzo
  Date: 28/12/2018
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>Registrazione account studente</title>
    <%@ include file="WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<!-- Navbar -->
<%@ include file="WEB-INF/jspf/navbarNoUser.jspf" %>

<div class="container">

    <br>
    <h1>Registrazione account studente</h1><br>

    <!-- Form profilo studente -->
    <jsp:include page="WEB-INF/jspf/formProfiloStudente.jspf"/>

</div>

<!-- Footer -->
<%@ include file="WEB-INF/jspf/footer.jspf" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>

</body>
</html>
