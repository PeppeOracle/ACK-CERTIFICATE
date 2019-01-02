package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

/**
 * Si occupa della convalida della creazione della pratica.
 *
 * @version 0.0.1
 */
final class DownloadFileConvalida {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private DownloadFileConvalida() { }

    /**
     * Convalida il file.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_FILE =
        request -> {
            Notifica notifica = new Notifica();
            String fileName = request.getParameter(
                    DownloadFileControl.
                            FILE_PARAMETRO
            );
            if (fileName == null || fileName.trim().equals("")) {
                notifica.addError(
                        "Il file non è stato indicato"
                );
            } else {
                String[] splitFileName =
                        fileName.split(".");
                if (splitFileName.length == 2
                        && splitFileName[1].equals("pdf")) {
                    notifica.addError(
                            "Il formato del file non è corretto [pdf]"
                    );
                }
            }
            return  notifica;
        };
}
