package it.unisa.ackc.http.stub;

import it.unisa.ackc.http.Risposta;

public class RispostaStub extends Risposta {
    @Override
    public void impostaTipoContenuto(TipoDiContenuto tipoDiContenuto) {

    }

    @Override
    public void impostaHeader(String chiave, String valore) {

    }

    @Override
    public void aggiungiAttributo(String chiave, Object valore) {

    }

    @Override
    public void redirect(String url) {

    }

    @Override
    public void inoltra(String url) {

    }

    @Override
    public void scriviFile(String file, String path) {

    }

    @Override
    public String ottieniUploadPath() {
        return "myPath";
    }
}
