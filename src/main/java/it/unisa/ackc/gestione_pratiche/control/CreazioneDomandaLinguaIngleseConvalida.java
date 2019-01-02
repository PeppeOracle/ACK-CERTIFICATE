package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

/**
 * Si occupa della convalida della domanda di lingua inglese.
 * @version 0.0.1
 */
public final class CreazioneDomandaLinguaIngleseConvalida {
    /**
     * Costruttore di default.
     * @since 0.0.1
     */
    private CreazioneDomandaLinguaIngleseConvalida() {
    }

    /**
     * Lunghezza massima ente certificatore.
     */
    private static final int ENTE_CERTIFICATORE_MAX = 64;

    /**
     * Lunghezza massima del livello cefr.
     */
    private static final int LIVELLO_CEFR_MAX = 6;

    /**
     * Lunghezza massima di un numero a due cifre positivo.
     */
    private static final int MAX_NUMBER_DUE_CIFRE = 99;

    /**
     * Convalida dell'ente certificatore.
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_ENTE_CERTIFICATORE =
        request -> {
            Notifica notifica = new Notifica();
            String enteCertificatore = request.getParameter(
                    CreazioneDomandaLinguaIngleseControl.ENTE_PARAMETRO
            );
            if (enteCertificatore == null || enteCertificatore.trim().equals("")) {
                notifica.addError(
                        "L'ente certificatore non è stato indicato"
                );
            } else if (enteCertificatore.length() > ENTE_CERTIFICATORE_MAX) {
                notifica.addError(
                        "L'ente certificatore non può superare i 64 caratteri"
                );
            }
            return  notifica;
        };

    /**
     * Convalida del numero di cfu.
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NUMERO_CFU = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroCfu = Integer.parseInt(request.getParameter(
                    CreazioneDomandaLinguaIngleseControl.NUMERO_CFU_PARAMETRO
            ));
            if (!isNumeroUnaDueCifre(numeroCfu)) {
                notifica.addError(
                        "Il numero di cfu deve essere maggiore di 0 e "
                                + "può essere al più un numero a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il numero di cfu deve essere un numero"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del grade.
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_GRADE = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer grade = Integer.parseInt(request.getParameter(
                    CreazioneDomandaLinguaIngleseControl.GRADE_PARAMETRO
            ));
            if (!isNumeroUnaDueCifre(grade)) {
                notifica.addError(
                        "Il grade deve essere maggiore di 0 e "
                                + "può essere al più un numero a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il grade deve essere un numero"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del livello cefr.
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_LIVELLO_CEFR = request -> {
        Notifica notifica = new Notifica();
        String livelloCefr = request.getParameter(
                CreazioneDomandaLinguaIngleseControl.LIVELLO_CEFR_PARAMETRO
        );
        if (livelloCefr == null || livelloCefr.trim().equals("")) {
            notifica.addError(
                    "Il livello cefr non è stato indicato"
            );
        } else if (livelloCefr.length() > LIVELLO_CEFR_MAX) {
            notifica.addError(
                    "Il livello cefr non può superare i 6 caratteri"
            );
        }
        return  notifica;
    };

    /**
     * Controlla se un numero è positivo e al più di due cifre.
     * @param number che si vuole controllare
     * @return true se number è positivo a due cifre, false altrimenti
     * @since 0.0.1
     */
    private static boolean isNumeroUnaDueCifre(final Integer number) {
        return number <= MAX_NUMBER_DUE_CIFRE && number > 0;
    }
}
