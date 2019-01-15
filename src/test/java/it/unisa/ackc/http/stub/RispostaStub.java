package it.unisa.ackc.http.stub;

import it.unisa.ackc.http.Risposta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream getOutput() {
        try {
            File file = new File("test.pdf");
            if (file.exists())
                file.delete();
            OutputStream out = new FileOutputStream(file);
            return out;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String ottieniUploadPath() {
        return "myPath";
    }
}
