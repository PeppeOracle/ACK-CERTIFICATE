package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Si occupa della convalida dell'account studente.
 *
 * @version 0.0.1
 */
final class AccountStudenteConvalida {

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
    private AccountStudenteConvalida() { }

    /**
     * Convalida del luogo di nascita.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_LUOGO_DI_NASCITA =
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountStudenteControl.
                                LUOGO_DI_NASCITA_PARAMETRO
                );
            };

    /**
     * Convalida della data di nascita.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_DATA_DI_NASCITA =
            request -> {
                Notifica notifica = new Notifica();
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String dataDiNascita = request.getParameter(
                        RegistrazioneAccountStudenteControl.
                                DATA_DI_NASCITA_PARAMETRO
                );
                if (dataDiNascita == null || dataDiNascita.trim().equals("")) {
                    notifica.addError(
                            "Il periodo non è stato indicato"
                    );
                } else {
                    try {
                        format.parse(dataDiNascita);
                    } catch (ParseException e) {
                        notifica.addError(
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
    static final CondizioneConvalida VALIDA_INDIRIZZO_DI_RESIDENZA =
            request -> {
        Notifica notifica = new Notifica();
        String indirizzo = request.getParameter(
                RegistrazioneAccountStudenteControl.
                        INDIRIZZO_DI_RESIDENZA_PARAMETRO
        );
        if (indirizzo == null || indirizzo.trim().equals("")) {
            notifica.addError(
                    "L'indirizzo di residenza non è stato indicato"
            );
        } else if (indirizzo.length() > INDIRIZZO_DI_RESIDENZA_MAX) {
            notifica.addError(
                    "L'indirizzo di residenza non può superare i 64 caratteri"
            );
        }
        return  notifica;
    };

    /**
     * Convalida del numero civico.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_NUMERO_CIVICO =
            request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroCivico = Integer.parseInt(request.getParameter(
                    RegistrazioneAccountStudenteControl.
                            NUMERO_CIVICO_PARAMETRO
            ));
            if (!isNumeroUnaTreCifre(numeroCivico)) {
                notifica.addError(
                        "Il numero civico deve essere maggiore di 0 e "
                                + "deve essere un numero almeno a tre cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
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
    static final CondizioneConvalida VALIDA_CAP =
            request -> {
                Notifica notifica = new Notifica();
                String cap = request.getParameter(
                        RegistrazioneAccountStudenteControl.
                                CAP_PARAMETRO
                );
                if (cap == null || cap.trim().equals("")) {
                    notifica.addError(
                            "Il CAP non è stato indicato"
                    );
                } else if (cap.length() != CAP_LENGTH) {
                    notifica.addError(
                            "Il CAP deve essere di 5 caratteri"
                    );
                } else if (!cap.matches("[0-9]+")) {
                    notifica.addError(
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
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountStudenteControl.
                                CITTA_PARAMETRO
                );
            };

    /**
     * Convalida del paese.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PAESE =
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountStudenteControl.
                                PAESE_PARAMETRO
                );
            };

    /**
     * Convalida della matricola.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_MATRICOLA =
            request -> {
                Notifica notifica = new Notifica();
                String matricola = request.getParameter(
                        RegistrazioneAccountStudenteControl.
                                MATRICOLA_PARAMETRO
                );
                if (matricola == null || matricola.trim().equals("")) {
                    notifica.addError(
                            "La matricola non è stata indicata"
                    );
                } else if (matricola.length() != MATRICOLA_LENGTH) {
                    notifica.addError(
                            "La matricola deve essere di 10 caratteri"
                    );
                } else if (!matricola.matches("[0-9]+")) {
                    notifica.addError(
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
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountStudenteControl.
                                TIPOLOGIA_DI_LAUREA_PARAMETRO
                );
            };

    /**
     * Convalida del corso di laurea.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CORSO_DI_LAUREA =
            request -> {
                return AccountConvalida.validaNome(
                        request,
                        RegistrazioneAccountStudenteControl.
                                CORSO_DI_LAUREA_PARAMETRO
                );
            };

    /**
     * Convalida dell'anno di immatricolazione.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_ANNO_DI_IMMATRICOLAZIONE =
            request -> {
                Notifica notifica = new Notifica();
                String annoDiImmatricolazione = request.getParameter(
                        RegistrazioneAccountStudenteControl.
                                ANNO_DI_IMMATRICOLAZIONE_PARAMETRO
                );
                if (annoDiImmatricolazione == null
                        || annoDiImmatricolazione.trim().equals("")) {
                    notifica.addError(
                            "Il CAP non è stato indicato"
                    );
                } else if (annoDiImmatricolazione.length()
                        != ANNO_DI_IMMATRICOLAZIONE_LENGTH) {
                    notifica.addError(
                            "Il CAP deve essere di 4 caratteri"
                    );
                } else if (!annoDiImmatricolazione.matches("[0-9]+")) {
                    notifica.addError(
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
