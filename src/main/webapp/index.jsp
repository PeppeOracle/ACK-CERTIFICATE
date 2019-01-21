<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/headMeta.jspf" %>
    <title>Testpage</title>
    <%@ include file="WEB-INF/jspf/headLink.jspf" %>
</head>
<body>

<div class="container">
</div>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%@ include file="WEB-INF/jspf/bootstapScript.jspf" %>
<script>
    window.location = "login.jsp";
</script>
</body>
</html>