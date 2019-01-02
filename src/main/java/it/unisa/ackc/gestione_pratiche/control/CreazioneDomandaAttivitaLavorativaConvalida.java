package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Si occupa della convalida della domanda di attivita lavorativa.
 *
 * @version 0.0.1
 */
final class CreazioneDomandaAttivitaLavorativaConvalida {
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private CreazioneDomandaAttivitaLavorativaConvalida() {
    }

    /**
     * Lunghezza massima ente.
     */
    private static final int ENTE_MAX = 64;

    /**
     * Lunghezza massima dell'indirizzo della sede.
     */
    private static final int INDIRIZZO_SEDE_MAX = 64;

    /**
     * Lunghezza massima del profilo.
     */
    private static final int PROFILO_MAX = 64;

    /**
     * Lunghezza massima del tipo di contratto.
     */
    private static final int TIPO_CONTRATTO_MAX = 64;

    /**
     * Lunghezza massima di un numero a una cifra positivo.
     */
    private static final int MAX_NUMBER_UNA_CIFRA = 9;

    /**
     * Lunghezza massima di un numero a due cifre positivo.
     */
    private static final int MAX_NUMBER_DUE_CIFRE = 99;

    /**
     * Lunghezza massima di un numero a tre cifre positivo.
     */
    private static final int MAX_NUMBER_TRE_CIFRE = 999;

    /**
     * Convalida dell'ente.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_ENTE = request -> {
        Notifica notifica = new Notifica();
        String ente = request.getParameter(
                CreazioneDomandaAttivitaLavorativaControl.ENTE_PARAMETRO
        );
        if (ente == null || ente.trim().equals("")) {
            notifica.addError(
                    "L'ente non è stato indicato"
            );
        } else if (ente.length() > ENTE_MAX) {
            notifica.addError(
                    "L'ente non può superare i 64 caratteri"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del numero di cfu.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_NUMERO_CFU = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroCfu = Integer.parseInt(request.getParameter(
                    CreazioneDomandaAttivitaLavorativaControl.
                            NUMERO_CFU_PARAMETRO
            ));
            if (!isNumeroUnaDueCifre(numeroCfu)) {
                notifica.addError(
                        "Il numero di cfu deve essere maggiore di 0 e "
                                + "può essere al più un numero a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il numero di cfu deve essere un numero", e
            );
        }
        return  notifica;
    };

    /**
     * Convalida dell'indirizzo della sede.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_INDIRIZZO_SEDE = request -> {
        Notifica notifica = new Notifica();
        String indirizzoSede = request.getParameter(
                CreazioneDomandaAttivitaLavorativaControl.
                        INDIRIZZO_SEDE_PARAMETRO
        );
        if (indirizzoSede == null || indirizzoSede.trim().equals("")) {
            notifica.addError(
                    "L'indirizzo della sede non è stato indicato"
            );
        } else if (indirizzoSede.length() > INDIRIZZO_SEDE_MAX) {
            notifica.addError(
                    "L'indirizzo della sede non può superare i 64 caratteri"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del profilo.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PROFILO = request -> {
        Notifica notifica = new Notifica();
        String profilo = request.getParameter(
                CreazioneDomandaAttivitaLavorativaControl.PROFILO_PARAMETRO
        );
        if (profilo == null || profilo.trim().equals("")) {
            notifica.addError(
                    "Il profilo non è stato indicato"
            );
        } else if (profilo.length() > PROFILO_MAX) {
            notifica.addError(
                    "Il profilo  non può superare i 64 caratteri"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del tipo di ocntratto.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_TIPO_CONTRATTO =
        request -> {
            Notifica notifica = new Notifica();
            String tipoDiContratto = request.getParameter(
                    CreazioneDomandaAttivitaLavorativaControl.
                            TIPO_CONTRATTO_PARAMETRO
            );
            if (tipoDiContratto == null || tipoDiContratto.trim().equals("")) {
                notifica.addError(
                        "Il tipo di contratto non è stato indicato"
                );
            } else if (tipoDiContratto.length() > TIPO_CONTRATTO_MAX) {
                notifica.addError(
                        "Il tipo di contratto non può superare i 64 caratteri"
                );
            }
            return  notifica;
        };

    /**
     * Convalida del periodo.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PERIODO = request -> {
        Notifica notifica = new Notifica();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String periodo = request.getParameter(
                CreazioneDomandaAttivitaLavorativaControl.
                        PROFILO_PARAMETRO
        );
        if (periodo == null || periodo.trim().equals("")) {
            notifica.addError(
                    "Il periodo non è stato indicato"
            );
        } else if (periodo.contains("/")) {
            String[] splitPeriodo = periodo.split("/");
            try {
                format.parse(splitPeriodo[0]);
                format.parse(splitPeriodo[1]);
            } catch (ParseException e) {
                notifica.addError(
                        "Il periodo non è nel giusto formato"
                                + "[dd-mm-yyyy/dd-mm-yyyy]", e
                );
            }
        } else {
            notifica.addError(
                    "Il periodo non è nel giusto formato"
                            + "[dd-mm-yyyy/dd-mm-yyyy]"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del numero di ore svolte.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_ORE_SVOLTE = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroOreSvolte = Integer.parseInt(request.getParameter(
                    CreazioneDomandaAttivitaLavorativaControl.
                            NUMERO_CFU_PARAMETRO
            ));
            if (!isNumeroDueTreCifre(numeroOreSvolte)) {
                notifica.addError(
                        "Il numero di ore svolte deve essere maggiore di 0 e "
                                + "deve essere un numero almeno a due cifre e "
                                + "al più a tre cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il numero di ore svolte deve essere un numero", e
            );
        }
        return  notifica;
    };

    /**
     * Controlla se un numero è positivo e al più di due cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è positivo a due cifre, false altrimenti
     * @since 0.0.1
     */
    private static boolean isNumeroUnaDueCifre(final Integer number) {
        return number <= MAX_NUMBER_DUE_CIFRE && number > 0;
    }

    /**
     * Controlla se un numero è positivo e
     * almeno di due e al più di tre cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è positivo
     * e almeno di due e al più di tre cifre,
     * false altrimenti
     * @since 0.0.1
     */
    private static boolean isNumeroDueTreCifre(final Integer number) {
        return number <= MAX_NUMBER_TRE_CIFRE && number > MAX_NUMBER_UNA_CIFRA;
    }
}
