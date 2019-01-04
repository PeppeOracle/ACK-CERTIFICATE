$(function () {
    nascondiItems();
    modificaButtonListener();
    annullaButtonListener();
});

var togglable = [
    "#areaCaricaAttestato",
    "#areaCaricaDomanda",
    "#annullaButton",
    "#confermaModificaButton"
];

function nascondiItems() {
    for (i = 0; i < togglable.length; i++) {
        $(togglable[i]).hide();
    }
}

function mostraItems() {
    for (i = 0; i < togglable.length; i++) {
        $(togglable[i]).show();
    }
}

function annullaButtonListener() {
    $("#annullaButton").on("click", function () {
        nascondiItems();
        $("#modificaButton").show();
        $("#modificaPraticaForm").trigger("reset");
    });
}

function modificaButtonListener() {
    $("#modificaButton").on("click", function () {
        mostraItems();
        $("#modificaButton").hide();
    });
}