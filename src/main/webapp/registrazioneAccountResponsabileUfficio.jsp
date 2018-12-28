<%--
  Created by IntelliJ IDEA.
  User: lorenzo
  Date: 28/12/2018
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Registrazione account responsabile ufficio</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>

<div class="container">

    <h1>Registrazione account responsabile ufficio</h1><br>

    <form action="" method="post">

        <div class="form-group">
            <label for="inputNome">Nome *</label>
            <input name="nome" type="text" class="form-control" id="inputNome" placeholder="Mario" required>
        </div>

        <div class="form-group">
            <label for="inputCognome">Cognome *</label>
            <input name="cognome" type="text" class="form-control" id="inputCognome" placeholder="Rossi" required>
        </div>

        <div class="form-group">
            <label for="inputLuogoNascita">Luogo di nascita *</label>
            <input name="luogoNascita" type="text" class="form-control" id="inputLuogoNascita" placeholder="Salerno"
                   required>
        </div>

        <div class="form-group">
            <label for="inputDataNascita">Data di nascita *</label>
            <input name="dataNascita" type="date" class="form-control" id="inputDataNascita" required>
        </div>

        <div class="form-group">
            <label for="inputTelefono">Recapito telefonico</label>
            <input name="telefono" type="tel" class="form-control" id="inputTelefono" placeholder="3338988789">
        </div>

        <div class="form-group">
            <label for="inputEmail">Email *</label>
            <input name="email" type="email" class="form-control" id="inputEmail"
                   placeholder="mariorossi@studenti.unisa.it" required>
        </div>

        <div class="form-group">
            <label for="inputPassword">Password *</label>
            <input name="password" type="password" class="form-control" id="inputPassword" required>
        </div>

        <div class="form-group">
            <label for="inputConfermaPassword">Ripeti password *</label>
            <input type="password" class="form-control" id="inputConfermaPassword" required>
        </div>

        <div class="form-group">
            <label>Sesso *</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="sesso" id="radioUomo" value="uomo">
                <label class="form-check-label" for="radioUomo">Uomo</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="sesso" id="radioDonna" value="donna">
                <label class="form-check-label" for="radioDonna">Donna</label>
            </div>
        </div>

        <div class="form-group">
            <label for="inputCampus">Campus *</label>
            <input name="campus" type="text" class="form-control" id="inputCampus" placeholder="Fisciano"
                   required>
        </div>

        <div class="form-group">
            <label for="inputEdificio">Edificio *</label>
            <input name="edficio" type="text" class="form-control" id="inputEdificio" placeholder="F2"
                   required>
        </div>

        <div class="form-group">
            <label for="inputPiano">Piano *</label>
            <input name="piano" type="text" class="form-control" id="inputPiano" placeholder="Primo piano"
                   required>
        </div>

        <div class="form-group">
            <label for="inputNumeroStanza">Numero stanza *</label>
            <input name="numeroStanza" type="number" class="form-control" id="inputNumeroStanza" placeholder="000"
                   required>
        </div>

        <div class="form-group">
            <label for="selectTipologiaPratica">Tipologia pratica da gestire *</label>
            <select class="custom-select" name="tipologiaPratica" id="selectTipologiaPratica" required>
                <option selected>Selezionare una tipologia</option>
                <option value="linguaInglese">Lingua inglese</option>
                <option value="attivitaLavorativa">Attività lavorativa</option>
            </select>
        </div>

        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="privacyCheckbox" aria-describedby="campiObbligatoriHelp"
                   required>
            <label class="form-check-label" for="privacyCheckbox">Accetto il <a href="#">regolamento sulla privacy</a>
            </label>
            <small id="campiObbligatoriHelp" class="form-text text-muted">I campi contassegnati con * sono
                obbligatori.
            </small>
        </div>

        <button type="submit" class="btn btn-primary">Registrati</button>

    </form>

</div>


<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
</body>
</html>
