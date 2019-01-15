package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Contiene le condizioni di convalida della domanda di attivita lavorativa.
 *
 * @version 0.1.1
 */
public final class CreazioneDomandaAttivitaLavorativa {
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
     * Macro della lunghezza minima per email.
     */
    private static final int MIN_ANNO = 1000;
    /**
     * Macro della lunghezza massima per email.
     */
    private static final int MAX_ANNO = 9999;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private CreazioneDomandaAttivitaLavorativa() { }

    /**
     * Convalida dell'ente.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_ENTE = formDati -> {
        Notifica notifica = new Notifica();
        String ente = formDati.ottieniDato(
                it.unisa.ackc.gestione_pratiche.control
                        .CreazioneDomandaAttivitaLavorativa.
                        ENTE_PARAMETRO
        );
        if (ente == null || ente.trim().equals("")) {
            notifica.aggiungiErrore(
                    "L'ente non è stato indicato"
            );
        } else if (ente.length() > ENTE_MAX) {
            notifica.aggiungiErrore(
                    "L'ente non può superare i 64 caratteri"
            );
        }
        return  notifica;
    };

    /**
     * Convalida dell'indirizzo della sede.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_INDIRIZZO_SEDE =
            formDati -> {
        Notifica notifica = new Notifica();
        String indirizzoSede = formDati.ottieniDato(
                it.unisa.ackc.gestione_pratiche.control
                        .CreazioneDomandaAttivitaLavorativa.
                        INDIRIZZO_SEDE_PARAMETRO
        );
        if (indirizzoSede == null || indirizzoSede.trim().equals("")) {
            notifica.aggiungiErrore(
                    "L'indirizzo della sede non è stato indicato"
            );
        } else if (indirizzoSede.length() > INDIRIZZO_SEDE_MAX) {
            notifica.aggiungiErrore(
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
    public static final CondizioneConvalida VALIDA_PROFILO = formDati -> {
        Notifica notifica = new Notifica();
        String profilo = formDati.ottieniDato(
                it.unisa.ackc.gestione_pratiche.control
                        .CreazioneDomandaAttivitaLavorativa.
                        PROFILO_PARAMETRO
        );
        if (profilo == null || profilo.trim().equals("")) {
            notifica.aggiungiErrore(
                    "Il profilo non è stato indicato"
            );
        } else if (profilo.length() > PROFILO_MAX) {
            notifica.aggiungiErrore(
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
    public static final CondizioneConvalida VALIDA_TIPO_CONTRATTO =
            formDati -> {
                Notifica notifica = new Notifica();
                String tipoDiContratto = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .CreazioneDomandaAttivitaLavorativa.
                                TIPO_CONTRATTO_PARAMETRO
                );
                if (tipoDiContratto == null
                        || tipoDiContratto.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il tipo di contratto non è stato indicato"
                    );
                } else if (tipoDiContratto.length() > TIPO_CONTRATTO_MAX) {
                    notifica.aggiungiErrore(
                            "Il tipo di contratto non può superare"
                                    + " i 64 caratteri"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida del periodo.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PERIODO = formDati -> {
        Notifica notifica = new Notifica();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String periodo = formDati.ottieniDato(
                it.unisa.ackc.gestione_pratiche.control
                        .CreazioneDomandaAttivitaLavorativa.
                        PERIODO_PARAMETRO
        );
        if (periodo == null || periodo.trim().equals("")) {
            notifica.aggiungiErrore(
                    "Il periodo non è stato indicato"
            );
        } else if (periodo.contains("/")) {
            String[] splitPeriodo = periodo.split("/");
            try {
                format.parse(splitPeriodo[0]);
                Integer y1 = Integer.parseInt(splitPeriodo[0].split("-")[2]);
                if (y1 < MIN_ANNO || y1 > MAX_ANNO) {
                    notifica.aggiungiErrore(
                            "L'anno della prima data non è valido"
                    );
                }
                format.parse(splitPeriodo[1]);
                Integer y2 = Integer.parseInt(splitPeriodo[1].split("-")[2]);
                if (y2 < MIN_ANNO || y2 > MAX_ANNO) {
                    notifica.aggiungiErrore(
                            "L'anno della seconda data non è valido"
                    );
                }
            } catch (ParseException e) {
                notifica.aggiungiErrore(
                        "Il periodo non è nel giusto formato"
                                + "[dd-mm-yyyy/dd-mm-yyyy]", e
                );
            }
        } else {
            notifica.aggiungiErrore(
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
    public static final CondizioneConvalida VALIDA_ORE_SVOLTE = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroOreSvolte = formDati.ottieniDatoIntero(
                    it.unisa.ackc.gestione_pratiche.control
                            .CreazioneDomandaAttivitaLavorativa.
                            ORE_SVOLTE_PARAMETRO
            );
            if (!isNumeroDueTreCifre(numeroOreSvolte)) {
                notifica.aggiungiErrore(
                        "Il numero di ore svolte deve essere maggiore di 0 e "
                                + "deve essere un numero almeno a due cifre e "
                                + "al più a tre cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
                    "Il numero di ore svolte deve essere un numero", e
            );
        }
        return  notifica;
    };

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
