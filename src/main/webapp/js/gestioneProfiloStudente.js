$(function () {

    $("#gestioneProfiloNavItem").addClass("active");
    $("#annullaButton").hide();
    $("#confermaModificaButton").hide();

    disabilitaCampiListener();
    abilitaCampiListener();

});

var campiFormModificabili = [
    "#inputTelefono",
    "#inputPassword",
    "#inputCitta",
    "#inputIndirizzo",
    "#inputNumeroCivico",
    "#inputCap",
    "#inputCorsoLaurea",
    "#inputPaese",
    "#inputTipologiaLaurea",
    "#inputAnnoImmatricolazione",
    "#inputLuogoNascita",
    "#inputDataNascita"
];

function disabilitaCampiListener() {
    $("#annullaButton").on("click", function () {
        for (i = 0; i < campiFormModificabili.length; i++) {
            $(campiFormModificabili[i]).attr('disabled', 'disabled');
        }
        $("#modificaButton").show();
        $("#annullaButton").hide();
        $("#confermaModificaButton").hide();
        $("#modificaProfiloForm").trigger("reset");
    });
}

function abilitaCampiListener() {
    $("#modificaButton").on("click", function () {
        for (i = 0; i < campiFormModificabili.length; i++) {
            $(campiFormModificabili[i]).removeAttr('disabled', 'disabled');
        }
        $("#modificaButton").hide();
        $("#confermaModificaButton").show();
        $("#annullaButton").show();
    });
}