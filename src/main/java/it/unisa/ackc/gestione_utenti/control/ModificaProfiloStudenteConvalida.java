package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.gestione_utenti.entity.Account.Sesso;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Si occupa della convalida dell'account.
 *
 * @version 0.1.1
 */
final class ModificaProfiloStudenteConvalida {
    /**
     * Lunghezza massima di un numero a tre cifre positivo.
     */
    private static final int MAX_NUMBER_TRE_CIFRE = 999;
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private ModificaProfiloStudenteConvalida() { }

    /**
     * Convalida del nome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NOME =
            request -> {
                return validaNome(request, AccountConvalida.NOME_PARAMETRO);
            };

    /**
     * Convalida del cognome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_COGNOME =
            request -> {
                return validaNome(request, AccountConvalida.COGNOME_PARAMETRO);
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String email = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (email != null) {
                    if (!email.matches("\\w{18,64}$")) {
                        notifica.addError("La lunghezza dell'email "
                                + "deve compresa tra 18 e 64");
                    }
                    if (!email.matches(
                            "[A-Z,a-z,0-9,-,.,_ ]+[@studenti.unisa.it]+")) {
                        notifica.addError("Il formato dell'email "
                                + "non è stato rispettato");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida della password.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PASSWORD =
            request -> {
                Notifica notifica = new Notifica();
                String password = request.getParameter(
                        AccountConvalida.PASSWORD_PARAMETRO
                );
                if (password != null) {
                    if (!password.matches("\\w{2,8}$")) {
                        notifica.addError("La lunghezza della password "
                                + "deve compresa tra 2 e 8");
                    }
                    if (!password.matches("[A-Z, a-z,0-9]+")) {
                        notifica.addError("Il formato della password "
                                + "non è stato rispettato");
                    }
                    if (containsLetteraENumero(password)) {
                        notifica.addError("La password deve contenere almeno "
                                + "una lettera e un numero");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del telefono.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TELEFONO =
            request -> {
                Notifica notifica = new Notifica();
                String telefono = request.getParameter(
                        AccountConvalida.TELEFONO_PARAMETRO
                );
                if (telefono != null) {
                    if (!telefono.matches("\\w{9,10}$")) {
                        notifica.addError("La lunghezza del telefono "
                                + "deve compresa tra 9 e 10");
                    }
                    if (!telefono.matches("[0-9]+")) {
                        notifica.addError("Il formato del telefono "
                                + "non è stato rispettato");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del sesso.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_SESSO =
            request -> {
                Notifica notifica = new Notifica();
                String sesso = request.getParameter(
                        AccountConvalida.SESSO_PARAMETRO
                );
                if (sesso != null) {
                    try {
                        Sesso.valueOf(sesso);
                    } catch (IllegalArgumentException e) {
                        notifica.addError(
                                "Il sesso indicato"
                                        + "non è corretto"
                        );
                    }
                }
                return  notifica;
            };

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
                if (dataDiNascita != null) {
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
                if (indirizzo != null) {
                    if (indirizzo.length()
                            > AccountStudenteConvalida.
                            INDIRIZZO_DI_RESIDENZA_MAX) {
                        notifica.addError(
                                "L'indirizzo di residenza "
                                       + "non può superare i 64 caratteri"
                        );
                    }
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
                if (request.getParameter(
                        RegistrazioneAccountStudenteControl.
                                NUMERO_CIVICO_PARAMETRO
                    ) != null) {
                    try {
                        Integer numeroCivico =
                                Integer.parseInt(request.getParameter(
                                RegistrazioneAccountStudenteControl.
                                        NUMERO_CIVICO_PARAMETRO
                        ));
                        if (!isNumeroUnaTreCifre(numeroCivico)) {
                            notifica.addError(
                                    "Il numero civico deve essere"
                                            + " maggiore di 0 e deve essere"
                                            + " un numero almeno a tre cifre"
                            );
                        }
                    } catch (NumberFormatException e) {
                        notifica.addError(
                                "Il numero civico deve essere un numero", e
                        );
                    }
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
                if (cap != null) {
                    if (cap.length()
                            != AccountStudenteConvalida.CAP_LENGTH) {
                        notifica.addError(
                                "Il CAP deve essere di 5 caratteri"
                        );
                    } else if (!cap.matches("[0-9]+")) {
                        notifica.addError(
                                "Il CAP deve essere composto solo da cifre"
                        );
                    }
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
                if (matricola != null) {
                    if (matricola.length()
                            != AccountStudenteConvalida.MATRICOLA_LENGTH) {
                        notifica.addError(
                                "La matricola deve essere di 10 caratteri"
                        );
                    } else if (!matricola.matches("[0-9]+")) {
                        notifica.addError(
                                "La matricola deve essere composta"
                                        + " solo da cifre"
                        );
                    }
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
                if (annoDiImmatricolazione != null) {
                    if (annoDiImmatricolazione.length()
                            != AccountStudenteConvalida.
                            ANNO_DI_IMMATRICOLAZIONE_LENGTH) {
                        notifica.addError(
                                "Il CAP deve essere di 4 caratteri"
                        );
                    } else if (!annoDiImmatricolazione.matches("[0-9]+")) {
                        notifica.addError(
                                "Il CAP deve essere composto solo da cifre"
                        );
                    }
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
    /**
     * Restituisce la notifica degli errori su una convalida del nome.
     * @param request da cui prendere il parametro
     * @param nome del parametro
     * @return notifica
     * @since 0.0.1
     */
    static Notifica validaNome(
            final HttpServletRequest request, final String nome
    ) {
        Notifica notifica = new Notifica();
        String val = request.getParameter(nome);
        if (val != null) {
            if (!val.matches("\\w{1,64}$")) {
                notifica.addError("La lunghezza del " + nome
                        + " deve essere compresa tra 1 e 64");
            }
            if (!val.matches("[A-Z, a-z,']+")) {
                notifica.addError("Il formato del " + nome
                        + " non è stato rispettato");
            }
        }
        return notifica;
    }

    /**
     * Controlla se la string contiene almeno una lettera e un numero.
     * @param stringa da controllare
     * @return true se la stringa contiene almeno
     * una lettera e un numero,
     * false altrimenti
     * @since 0.1.1
     */
    private static boolean containsLetteraENumero(final String stringa) {
        boolean digit = false;
        boolean letter = false;
        for (Character ch : stringa.toCharArray()) {
            if (Character.isLetter(ch)) {
                letter = true;
            }
            if (Character.isDigit(ch)) {
                digit = true;
            }
        }
        return digit && letter;
    }
}
