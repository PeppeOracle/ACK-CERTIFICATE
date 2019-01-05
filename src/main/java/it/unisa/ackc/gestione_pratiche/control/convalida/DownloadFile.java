package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Si occupa della convalida per il download di un file.
 *
 * @version 0.0.1
 */
public final class DownloadFile {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private DownloadFile() { }

    /**
     * Convalida il file.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_FILE =
            formDati -> {
                Notifica notifica = new Notifica();
                String fileName = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .DownloadFile.FILE_PARAMETRO
                );
                if (fileName == null || fileName.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il file non è stato indicato"
                    );
                } else {
                    String[] splitFileName =
                            fileName.split(".");
                    if (splitFileName.length == 2
                            && splitFileName[1].equals("pdf")) {
                        notifica.aggiungiErrore(
                                "Il formato del file non è corretto [pdf]"
                        );
                    }
                }
                return  notifica;
            };
}
