package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

/**
 * Si occupa della convalida della valutazione di una pratica.
 *
 * @version 0.0.1
 */
final class ValutazionePraticaConvalida {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private ValutazionePraticaConvalida() { }

    /**
     * Convalida il messaggio del responsabile ufficio.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_MESSAGGIO =
            request -> {
                Notifica notifica = new Notifica();
                String messaggio = request.getParameter(
                        ValutazionePraticaControl.MESSAGGIO_PARAMETRO
                );
                if (messaggio != null) {
                    if (messaggio.length() > MESSAGGIO_MAX) {
                        notifica.addError(
                                "Il messaggio dell responsabile ufficio "
                                        + "non può superare i 64 caratteri"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida lo stato della pratica.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_STATO =
            request -> {
                Notifica notifica = new Notifica();
                String stato = request.getParameter(
                        ValutazionePraticaControl.STATO_PARAMETRO
                );
                if (stato == null) {
                    notifica.addError(
                            "Indicare il nuovo stato"
                    );
                } else {
                    boolean found = false;
                    for (Pratica.Stato statoPratica : Pratica.Stato.values()) {
                        if (statoPratica.name().equals(stato)) {
                            found = true;
                        }
                    }
                    if (!found) {
                        notifica.addError(
                                "Lo stato indicato non è valido"
                        );
                    }
                }
                return  notifica;
            };
}
