package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Si occupa della convalida della domanda di lingua inglese.
 *
 * @version 0.0.1
 */
public final class CreazioneDomandaLinguaInglese {
    /**
     * Lunghezza massima ente certificatore.
     */
    private static final int ENTE_CERTIFICATORE_MAX = 64;

    /**
     * Lunghezza massima del livello cefr.
     */
    private static final int LIVELLO_CEFR_MAX = 6;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private CreazioneDomandaLinguaInglese() { }

    /**
     * Convalida dell'ente certificatore.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_ENTE_CERTIFICATORE =
            formDati -> {
                Notifica notifica = new Notifica();
                String enteCertificatore = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .CreazioneDomandaLinguaInglese.ENTE_PARAMETRO
                );
                if (enteCertificatore == null
                        || enteCertificatore.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "L'ente certificatore non è stato indicato"
                    );
                } else {
                    if (enteCertificatore.length() > ENTE_CERTIFICATORE_MAX) {
                        notifica.aggiungiErrore(
                                "L'ente certificatore non può superare "
                                        + "i 64 caratteri"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del grade.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_GRADE = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Integer grade = formDati.ottieniDatoIntero(
                    it.unisa.ackc.gestione_pratiche.control
                            .CreazioneDomandaLinguaInglese.GRADE_PARAMETRO
            );
            if (!GestionePratiche.isNumeroUnaDueCifre(grade)) {
                notifica.aggiungiErrore(
                        "Il grade deve essere maggiore di 0 e "
                                + "può essere al più un numero a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
                    "Il grade deve essere un numero"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del livello cefr.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_LIVELLO_CEFR = formDati -> {
        Notifica notifica = new Notifica();
        String livelloCefr = formDati.ottieniDato(
                it.unisa.ackc.gestione_pratiche.control
                        .CreazioneDomandaLinguaInglese.LIVELLO_CEFR_PARAMETRO
        );
        if (livelloCefr == null || livelloCefr.trim().equals("")) {
            notifica.aggiungiErrore(
                    "Il livello cefr non è stato indicato"
            );
        } else if (livelloCefr.length() > LIVELLO_CEFR_MAX) {
            notifica.aggiungiErrore(
                    "Il livello cefr non può superare i 6 caratteri"
            );
        }
        return  notifica;
    };
}
