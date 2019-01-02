package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

/**
 * Si occupa della convalida del tipo di domanda.
 * @version 0.0.1
 */
public final class CreazioneDomandaConvalida {
    /**
     * Costruttore di default.
     * @since 0.0.1
     */
    private CreazioneDomandaConvalida() {
    }

    /**
     * Convalida del tipo di domanda.
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TIPO_DI_DOMANDA =
        request -> {
            Notifica notifica = new Notifica();
            String tipoDiDomanda = request.getParameter(
                    CreazioneDomandaControl.TIPO_DI_DOMANDA_PARAMETRO
            );
            if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                notifica.addError(
                        "Il tipo di domanda non è stato indicato"
                );
            }
            return  notifica;
        };
}
