package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

/**
 * Si occupa della convalida dell'account responsabile ufficio.
 *
 * @version 0.0.1
 */
final class AccountResponsabileUfficioConvalida {
    /**
     * Lunghezza massima di un numero a due cifre.
     */
    private static final int MAX_NUMBER_DUE_CIFRE = 99;
    /**
     * Lunghezza massima di un numero a tre cifre.
     */
    private static final int MAX_NUMBER_TRE_CIFRE = 999;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private AccountResponsabileUfficioConvalida() { }

    /**
     * Convalida del campus.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CAMPUS =
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountResponsabileUfficioControl.
                            CAMPUS_PARAMETRO
                );
            };

    /**
     * Convalida dell'edificio.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EDIFICIO =
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountResponsabileUfficioControl.
                                EDIFICIO_PARAMETRO
                );
            };
    /**
     * Convalida la tipologia di pratiche.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TIPOLOGIA_PRATICHE =
            request -> {
                Notifica notifica = new Notifica();
                String[] tipologiaPratiche = request.getParameterValues(
                        RegistrazioneAccountResponsabileUfficioControl
                                .TIPOLOGIA_PRATICHE_PARAMETRO
                );
                if (tipologiaPratiche == null) {
                    notifica.addError(
                            "Le tipologia delle pratiche pratica"
                                    + " non è stata indicata"
                    );
                } else {
                    try {
                        for (String tipo : tipologiaPratiche) {
                            Pratica.Tipo.valueOf(tipo);
                        }
                    } catch (IllegalArgumentException e) {
                        notifica.addError(
                                "Il tipo indicato"
                                        + "non è corretto"
                        );
                    }
                }
                return  notifica;
            };
    /**
     * Convalida del numero del piano.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PIANO = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroPiano = Integer.parseInt(request.getParameter(
                    RegistrazioneAccountResponsabileUfficioControl.
                            PIANO_PARAMETRO
            ));
            if (!isInteroUnaDueCifre(numeroPiano)) {
                notifica.addError(
                        "Il numero del piano "
                                + "deve essere un intero al più a due cifre e "
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il numero del piano deve essere un intero", e
            );
        }
        return  notifica;
    };

    /**
     * Convalida del numero della stanza.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_NUMERO_STANZA = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroStanza = Integer.parseInt(request.getParameter(
                    RegistrazioneAccountResponsabileUfficioControl.
                            NUMERO_STANZA_PARAMETRO
            ));
            if (!isNumeroUnaTreCifre(numeroStanza)) {
                notifica.addError(
                        "Il numero della stanza deve essere maggiore di 0 e "
                                + "deve essere un numero al più a tre cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il numero della stanza deve essere un positivo", e
            );
        }
        return  notifica;
    };

    /**
     * Controlla se un numero è al più di due cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è al più due cifre,
     * false altrimenti
     * @since 0.0.1
     */
    private static boolean isInteroUnaDueCifre(final Integer number) {
        return number <= MAX_NUMBER_DUE_CIFRE
                && number >= -MAX_NUMBER_DUE_CIFRE;
    }
    /**
     * Controlla se un numero è positivo e al più di due cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è positivo con al più due cifre,
     * false altrimenti
     * @since 0.0.1
     */
    private static boolean isNumeroUnaTreCifre(final Integer number) {
        return number <= MAX_NUMBER_TRE_CIFRE && number > 0;
    }
}
