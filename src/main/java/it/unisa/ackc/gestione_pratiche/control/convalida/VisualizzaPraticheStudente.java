package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Contiene le condizioni di convalida per la visualizzazione delle
 * pratiche per uno studente.
 *
 * @version 0.1.1
 */
public final class VisualizzaPraticheStudente {
    /**
     * Istanza dello storage facade.
     */

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private VisualizzaPraticheStudente() { }

    /**
     * Convalida il numero di pagina della lista di pratica.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PAGINA =
            formDati -> {
                Notifica notifica = new Notifica();
                int pagina = formDati.ottieniDatoIntero(
                        it.unisa.ackc.gestione_pratiche.
                                control.VisualizzaPraticheStudente.
                                PAGINA_PARAMETRO
                );
                int maxPag = formDati.ottieniDatoIntero("max_pagina");
                maxPag++;
                if (pagina < 0) {
                    notifica.aggiungiErrore(
                            "Il numero di pagina non può essere negativo"
                    );
                } else if (pagina > maxPag) {
                    notifica.aggiungiErrore(
                            "Il numero di pagina supera il valore ammissibile"
                    );
                }
                return  notifica;
            };
}
