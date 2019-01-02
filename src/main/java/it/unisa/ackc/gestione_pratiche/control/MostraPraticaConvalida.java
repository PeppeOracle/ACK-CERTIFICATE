package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

/**
 * Si occupa della convalida per la visualizzazione di una pratica.
 *
 * @version 0.0.1
 */
final class MostraPraticaConvalida {
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private MostraPraticaConvalida() {
    }

    /**
     * Convalida il tipo di visualizzazione.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_TIPO = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer tipo = Integer.parseInt(request.getParameter(
                    MostraPraticaControl.TIPO_PARAMETRO
            ));
            switch (tipo) {
                case MostraPraticaControl.PRATICA_RESPONSABILE_UFFICIO:
                case MostraPraticaControl.PRATICA_RESPONSABILE_UFFICIO_VALUTA:
                case MostraPraticaControl.PRATICA_STUDENTE:
                case MostraPraticaControl.PRATICA_STUDENTE_MODIFICA:
                    break;
                default:
                    notifica.addError(
                            "Il tipo di visualizzazione non è valido"
                    );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il tipo di visualizzazione deve essere un numero"
            );
        }
        return  notifica;
    };
}
