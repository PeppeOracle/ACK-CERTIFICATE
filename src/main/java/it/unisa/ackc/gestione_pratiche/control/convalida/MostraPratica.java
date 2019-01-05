package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Contiene le condizioni di convalida per mostrare una pratica.
 *
 * @version 0.1.1
 */
public final class MostraPratica {
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private MostraPratica() { }

    /**
     * Convalida il tipo di visualizzazione.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_TIPO = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Integer tipo = formDati.ottieniDatoIntero(
                    it.unisa.ackc.gestione_pratiche.control
                            .MostraPratica.TIPO_PARAMETRO
            );
            switch (tipo) {
                case it.unisa.ackc.gestione_pratiche.control
                        .MostraPratica.PRATICA_RESPONSABILE_UFFICIO:
                case it.unisa.ackc.gestione_pratiche.control
                        .MostraPratica.PRATICA_RESPONSABILE_UFFICIO_VALUTA:
                case it.unisa.ackc.gestione_pratiche.control
                        .MostraPratica.PRATICA_STUDENTE:
                case it.unisa.ackc.gestione_pratiche.control
                        .MostraPratica.PRATICA_STUDENTE_MODIFICA:
                    break;
                default:
                    notifica.aggiungiErrore(
                            "Il tipo di visualizzazione non è valido"
                    );
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
                    "Il tipo di visualizzazione deve essere un numero",
                    e
            );
        }
        return  notifica;
    };
}
