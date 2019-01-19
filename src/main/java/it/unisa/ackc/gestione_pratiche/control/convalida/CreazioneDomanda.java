package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Contiene le condizioni di convalida della domanda.
 *
 * @version 0.1.1
 */
public final class CreazioneDomanda {
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private CreazioneDomanda() { }

    /**
     * Convalida del tipo di domanda.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TIPO_DI_DOMANDA =
            formDati -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .CreazioneDomanda.TIPO_DI_DOMANDA_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };
}
