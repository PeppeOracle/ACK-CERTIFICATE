package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.http.Notifica;

/**
 * Contiene le condizioni di convalida per la valutazione di una pratica.
 *
 * @version 0.1.1
 */
public final class ValutazionePratica {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private ValutazionePratica() { }

    /**
     * Convalida il messaggio del responsabile ufficio.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_MESSAGGIO =
            formDati -> {
                Notifica notifica = new Notifica();
                String messaggio = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .ValutazionePratica.MESSAGGIO_PARAMETRO
                );
                if (messaggio != null) {
                    if (messaggio.length() > MESSAGGIO_MAX) {
                        notifica.aggiungiErrore(
                                "Il messaggio del responsabile ufficio "
                                        + "non può superare i 512 caratteri"
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
    public static final CondizioneConvalida VALIDA_STATO =
            formDati -> {
                Notifica notifica = new Notifica();
                String stato = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .ValutazionePratica.STATO_PARAMETRO
                );
                if (stato == null) {
                    notifica.aggiungiErrore(
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
                        notifica.aggiungiErrore(
                                "Lo stato indicato non è valido"
                        );
                    }
                }
                return  notifica;
            };
}
