package it.unisa.ackc.gestione_utenti.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio;
import it.unisa.ackc.http.Notifica;

/**
 * Si occupa della convalida dell'account responsabile ufficio.
 *
 * @version 0.0.1
 */
public final class AccountResponsabileUfficio {

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
    private AccountResponsabileUfficio() { }

    /**
     * Convalida del campus.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CAMPUS =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        RegistrazioneAccountResponsabileUfficio.
                                CAMPUS_PARAMETRO
                );
            };

    /**
     * Convalida dell'edificio.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EDIFICIO =
            formDati -> {
                Notifica notifica = new Notifica();
                String edificio = formDati.ottieniDato(
                        RegistrazioneAccountResponsabileUfficio.
                                EDIFICIO_PARAMETRO
                );
                if (edificio == null || edificio.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "L'edificio non è stato indicato"
                    );
                } else if (edificio.length() > AccountConvalida.MAX_NOME) {
                    notifica.aggiungiErrore(
                            "Il nome dell'edificio non "
                                    + "può superare i 64 caratteri"
                    );
                }
                return  notifica;
            };
    /**
     * Convalida la tipologia di pratiche.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TIPOLOGIA_PRATICHE =
            formDati -> {
                Notifica notifica = new Notifica();
                String[] tipologiaPratiche = formDati.ottieniDati(
                        RegistrazioneAccountResponsabileUfficio
                                .TIPOLOGIA_PRATICHE_PARAMETRO
                );
                if (tipologiaPratiche == null) {
                    notifica.aggiungiErrore(
                            "Le tipologia delle pratiche pratica"
                                    + " non è stata indicata"
                    );
                } else {
                    try {
                        for (String tipo : tipologiaPratiche) {
                            Pratica.Tipo.valueOf(tipo);
                        }
                    } catch (IllegalArgumentException e) {
                        notifica.aggiungiErrore(
                                "Il tipo indicato"
                                        + " non è corretto"
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
    public static final CondizioneConvalida VALIDA_PIANO = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroPiano = formDati.ottieniDatoIntero(
                    RegistrazioneAccountResponsabileUfficio.
                            PIANO_PARAMETRO
            );
            if (!isInteroUnaDueCifre(numeroPiano)) {
                notifica.aggiungiErrore(
                        "Il numero del piano "
                                + "deve essere un intero al più a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
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
    public static final CondizioneConvalida VALIDA_NUMERO_STANZA = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroStanza = formDati.ottieniDatoIntero(
                    RegistrazioneAccountResponsabileUfficio.
                            NUMERO_STANZA_PARAMETRO
            );
            if (!isNumeroUnaTreCifre(numeroStanza)) {
                notifica.aggiungiErrore(
                        "Il numero della stanza deve essere maggiore di 0 e "
                                + "deve essere un numero al più a tre cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
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
