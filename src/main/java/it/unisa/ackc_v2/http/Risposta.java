package it.unisa.ackc_v2.http;

import it.unisa.ackc.validator.Notifica;

import java.io.OutputStream;

public abstract class Risposta {
    private OutputStream output;
    private Notifica notifica;

    public abstract void impostaTipoContenuto(TIPO_CONTENUTO contenuto);

    public abstract void impostaHeader(String chiave, String valore);

    public OutputStream getOutput() {
        return output;
    }

    public Notifica getNotifica() {
        return notifica;
    }

    public void setNotifica(Notifica notifica) {
        this.notifica = notifica;
    }

    public enum TIPO_CONTENUTO {
        PDF
    }
}
