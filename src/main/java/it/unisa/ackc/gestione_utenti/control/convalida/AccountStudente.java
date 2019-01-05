package it.unisa.ackc.gestione_utenti.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountStudente;
import it.unisa.ackc.http.Notifica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Si occupa della convalida dell'account studente.
 *
 * @version 0.0.1
 */
public final class AccountStudente {
    /**
     * Lunghezza massima di un numero a tre cifre positivo.
     */
    private static final int MAX_NUMBER_TRE_CIFRE = 999;
    /**
     * Lunghezza massima dell'indirizzo di residenza.
     */
    static final int INDIRIZZO_DI_RESIDENZA_MAX = 64;
    /**
     * Lunghezza del cap.
     */
    static final int CAP_LENGTH = 5;
    /**
     * Lunghezza della matricola.
     */
    static final int MATRICOLA_LENGTH = 10;
    /**
     * Lunghezza dell'anno di immatricolazione.
     */
    static final int ANNO_DI_IMMATRICOLAZIONE_LENGTH = 10;
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private AccountStudente() { }

    /**
     * Convalida del luogo di nascita.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_LUOGO_DI_NASCITA =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        RegistrazioneAccountStudente.
                                LUOGO_DI_NASCITA_PARAMETRO
                );
            };

    /**
     * Convalida della data di nascita.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_DATA_DI_NASCITA =
            formDati -> {
                Notifica notifica = new Notifica();
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String dataDiNascita = formDati.ottieniDato(
                        RegistrazioneAccountStudente.
                                DATA_DI_NASCITA_PARAMETRO
                );
                if (dataDiNascita == null || dataDiNascita.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il periodo non è stato indicato"
                    );
                } else {
                    try {
                        format.parse(dataDiNascita);
                    } catch (ParseException e) {
                        notifica.aggiungiErrore(
                                "Il formato del periodo"
                                        + " non è stato rispettato", e
                        );
                    }
                }
                return notifica;
            };

    /**
     * Convalida dell'indirizzo di residenza.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_INDIRIZZO_DI_RESIDENZA =
            formDati -> {
                Notifica notifica = new Notifica();
                String indirizzo = formDati.ottieniDato(
                        RegistrazioneAccountStudente.
                                INDIRIZZO_DI_RESIDENZA_PARAMETRO
                );
                if (indirizzo == null || indirizzo.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "L'indirizzo di residenza non è stato indicato"
                    );
                } else if (indirizzo.length() > INDIRIZZO_DI_RESIDENZA_MAX) {
                    notifica.aggiungiErrore(
                            "L'indirizzo di residenza non "
                                    + "può superare i 64 caratteri"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida del numero civico.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NUMERO_CIVICO =
            formDati -> {
                Notifica notifica = new Notifica();
                try {
                    Integer numeroCivico = formDati.ottieniDatoIntero(
                            RegistrazioneAccountStudente.
                                    NUMERO_CIVICO_PARAMETRO
                    );
                    if (!isNumeroUnaTreCifre(numeroCivico)) {
                        notifica.aggiungiErrore(
                                "Il numero civico deve essere maggiore di 0 e "
                                        + "deve essere un numero "
                                        + "almeno a tre cifre"
                        );
                    }
                } catch (NumberFormatException e) {
                    notifica.aggiungiErrore(
                            "Il numero civico deve essere un numero", e
                    );
                }
                return  notifica;
            };

    /**
     * Convalida del CAP.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CAP =
            formDati -> {
                Notifica notifica = new Notifica();
                String cap = formDati.ottieniDato(
                        RegistrazioneAccountStudente.
                                CAP_PARAMETRO
                );
                if (cap == null || cap.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il CAP non è stato indicato"
                    );
                } else if (cap.length() != CAP_LENGTH) {
                    notifica.aggiungiErrore(
                            "Il CAP deve essere di 5 caratteri"
                    );
                } else if (!cap.matches("[0-9]+")) {
                    notifica.aggiungiErrore(
                            "Il CAP deve essere composto solo da cifre"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida della città.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CITTA =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        RegistrazioneAccountStudente.
                                CITTA_PARAMETRO
                );
            };

    /**
     * Convalida del paese.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PAESE =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        RegistrazioneAccountStudente.
                                PAESE_PARAMETRO
                );
            };

    /**
     * Convalida della matricola.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_MATRICOLA =
            formDati -> {
                Notifica notifica = new Notifica();
                String matricola = formDati.ottieniDato(
                        RegistrazioneAccountStudente.
                                MATRICOLA_PARAMETRO
                );
                if (matricola == null || matricola.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "La matricola non è stata indicata"
                    );
                } else if (matricola.length() != MATRICOLA_LENGTH) {
                    notifica.aggiungiErrore(
                            "La matricola deve essere di 10 caratteri"
                    );
                } else if (!matricola.matches("[0-9]+")) {
                    notifica.aggiungiErrore(
                            "La matricola deve essere composta solo da cifre"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida della tipologia di laurea.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TIPOLOGIA_DI_LAUREA =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        RegistrazioneAccountStudente.
                                TIPOLOGIA_DI_LAUREA_PARAMETRO
                );
            };

    /**
     * Convalida del corso di laurea.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CORSO_DI_LAUREA =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        RegistrazioneAccountStudente.
                                CORSO_DI_LAUREA_PARAMETRO
                );
            };

    /**
     * Convalida dell'anno di immatricolazione.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_ANNO_DI_IMMATRICOLAZIONE =
            formDati -> {
                Notifica notifica = new Notifica();
                String annoDiImmatricolazione = formDati.ottieniDato(
                        RegistrazioneAccountStudente.
                                ANNO_DI_IMMATRICOLAZIONE_PARAMETRO
                );
                if (annoDiImmatricolazione == null
                        || annoDiImmatricolazione.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il CAP non è stato indicato"
                    );
                } else if (annoDiImmatricolazione.length()
                        != ANNO_DI_IMMATRICOLAZIONE_LENGTH) {
                    notifica.aggiungiErrore(
                            "Il CAP deve essere di 4 caratteri"
                    );
                } else if (!annoDiImmatricolazione.matches("[0-9]+")) {
                    notifica.aggiungiErrore(
                            "Il CAP deve essere composto solo da cifre"
                    );
                }
                return  notifica;
            };

    /**
     * Controlla se un numero è positivo e al più di tre cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è positivo con al più tre cifre,
     * false altrimenti
     * @since 0.0.1
     */
    private static boolean isNumeroUnaTreCifre(final Integer number) {
        return number <= MAX_NUMBER_TRE_CIFRE && number > 0;
    }
}
