package it.unisa.ackc.http;

import java.io.OutputStream;

/**
 * Astrazione di una risposta http.
 */
public abstract class Risposta {
    /**
     * Notifica della risposta.
     */
    private Notifica notifica;

    /**
     * Imposta il tipo di contenuto.
     *
     * @param tipoDiContenuto da impostare
     */
    public abstract void impostaTipoContenuto(TipoDiContenuto tipoDiContenuto);

    /**
     * Imposta una nuova voce header.
     *
     * @param chiave della nuova voce
     * @param valore della nuova voce
     */
    public abstract void impostaHeader(String chiave, String valore);

    /**
     * Aggiunge un nuovo valore.
     *
     * @param chiave del nuovo attributo
     * @param valore del nuovo attributo
     */
    public abstract void aggiungiAttributo(String chiave, Object valore);

    /**
     * Reindirizzza all'url indicato.
     *
     * @param url a cui rendirizzare
     */
    public abstract void redirect(String url);

    /**
     * Inoltra la richiesta all'url indicato.
     *
     * @param url a cui inoltrare la richiesta
     */
    public abstract void inoltra(String url);

    /**
     * Scrive il file indicato nel path indicato.
     *
     * @param file parametro della richiesta
     * @param path dove salvare il file
     */
    public abstract void scriviFile(String file, String path);

    /**
     * Restituisce l'upload path.
     *
     * @param path da ottenere
     * @return upload path
     */
    public abstract String ottieniUploadPath(String path);

    /**
     * Restituisce l'output.
     *
     * @return output
     */
    public abstract OutputStream getOutput();

    /**
     * Restituisce la notifica.
     *
     * @return notifica
     */
    public Notifica getNotifica() {
        return notifica;
    }

    /**
     * Imposta la notifica.
     *
     * @param aNotifica notifica da impostare
     */
    public void setNotifica(final Notifica aNotifica) {
        this.notifica = notifica;
    }

    /**
     * Specifica il tipo di contenuto.
     */
    public enum TipoDiContenuto {
        /**
         * Documento pdf.
         */
        PDF
    }
}
