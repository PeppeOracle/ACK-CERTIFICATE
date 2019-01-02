package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Si occupa della convalida della modifica della pratica sospesa.
 *
 * @version 0.0.1
 */
final class ModificaPraticaSospesaConvalida {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private ModificaPraticaSospesaConvalida() {
    }

    /**
     * Convalida il messaggio dello studente.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_MESSAGGIO =
        request -> {
            Notifica notifica = new Notifica();
            String messaggio = request.getParameter(
                    ModificaPraticaSospesaControl.MESSAGGIO_PARAMETRO
            );
            if (messaggio != null) {
                if (messaggio.length() > MESSAGGIO_MAX) {
                    notifica.addError(
                            "Il messaggio dello studente "
                                    + "non può superare i 64 caratteri"
                    );
                }
            }
            return  notifica;
        };

    /**
     * Convalida la domanda.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_DOMANDA =
        request -> {
            Notifica notifica = new Notifica();
            Part domanda;
            try {
                domanda = request.getPart(
                        ModificaPraticaSospesaControl.DOMANDA_PARAMETRO
                );
                if (domanda == null) {
                    return notifica;
                }
                String[] splitDomanda =
                        domanda.getSubmittedFileName().split(".");
                if (splitDomanda.length == 2
                        && splitDomanda[1].equals("pdf")) {
                    notifica.addError(
                            "Il formato della domanda non è corretto [pdf]"
                    );
                }
            } catch (IOException | ServletException e) {
                notifica.addError(
                        "La domanda non è stata caricata con successo"
                );
            }
            return  notifica;
        };

    /**
     * Convalida l'attestato.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_ATTESTATO =
        request -> {
            Notifica notifica = new Notifica();
            Part attestato;
            try {
                attestato = request.getPart(
                        ModificaPraticaSospesaControl.ATTESTATO_PARAMETRO
                );
                if (attestato == null) {
                    return notifica;
                }
                String[] splitAttestato =
                        attestato.getSubmittedFileName().split(".");
                if (splitAttestato.length == 2
                        && splitAttestato[1].equals("pdf")) {
                    notifica.addError(
                            "Il formato dell'attestato non è corretto [pdf]"
                    );
                }
            } catch (IOException | ServletException e) {
                notifica.addError(
                        "L'attestato non è stato caricato con successo"
                );
            }
            return  notifica;
        };
}
