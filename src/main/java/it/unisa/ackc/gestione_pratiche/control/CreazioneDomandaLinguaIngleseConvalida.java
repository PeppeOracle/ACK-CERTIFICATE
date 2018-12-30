package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

public final class CreazioneDomandaLinguaIngleseConvalida {
    private CreazioneDomandaLinguaIngleseConvalida() {
    }

    /**
     * Lunghezza massima ente certificatore.
     */
    private static final int ENTE_CERTIFICATORE_MAX = 64;

    private static final int MAX_NUMBER_DUE_CIFRE = 99;

    public static final CondizioneConvalida VALIDA_ENTE_CERTIFICATORE = request -> {
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

    public static final CondizioneConvalida VALIDA_NUMERO_CFU = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroCfu = Integer.parseInt(request.getParameter(
                    CreazioneDomandaLinguaIngleseControl.NUMERO_CFU_PARAMETRO
            ));
            if (!isNumeroDueCifre(numeroCfu)) {
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

    public static final CondizioneConvalida VALIDA_GRADE = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer grade = Integer.parseInt(request.getParameter(
                    CreazioneDomandaLinguaIngleseControl.GRADE_PARAMETRO
            ));
            if (!isNumeroDueCifre(grade)) {
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

    public static final CondizioneConvalida VALIDA_LIVELLO_CEFR = request -> {
        Notifica notifica = new Notifica();
        String livelloCefr = request.getParameter(
                CreazioneDomandaLinguaIngleseControl.LIVELLO_CEFR_PARAMETRO
        );
        if (livelloCefr == null || livelloCefr.trim().equals("")) {
            notifica.addError(
                    "Il livello cefr non è stato indicato"
            );
        } else if (livelloCefr.length() > 6) {
            notifica.addError(
                    "Il livello cefr non può superare i 6 caratteri"
            );
        }
        return  notifica;
    };

    private static boolean isNumeroDueCifre(final Integer number) {
        return number < MAX_NUMBER_DUE_CIFRE && number > 0;
    }
}
