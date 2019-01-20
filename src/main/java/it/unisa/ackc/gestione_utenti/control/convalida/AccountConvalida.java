package it.unisa.ackc.gestione_utenti.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.http.Notifica;

/**
 * Si occupa della convalida dell'account.
 *
 * @version 0.1.1
 */
public final class AccountConvalida {
    /**
     * Macro del parametro email.
     */
    public static final String EMAIL_PARAMETRO = "email";
    /**
     * Macro del parametro password.
     */
    public static final String PASSWORD_PARAMETRO = "password";
    /**
     * Macro del parametro telefono.
     */
    public static final String TELEFONO_PARAMETRO = "telefono";
    /**
     * Macro del parametro nome.
     */
    public static final String NOME_PARAMETRO = "nome";
    /**
     * Macro del parametro cognome.
     */
    public static final String COGNOME_PARAMETRO = "cognome";
    /**
     * Macro del parametro ruolo.
     */
    public static final String RUOLO_PARAMETRO = "ruolo";
    /**
     * Macro del parametro sesso.
     */
    public static final String SESSO_PARAMETRO = "sesso";
    /**
     * Macro della lunghezza minima per email.
     */
    static final int MIN_MAIL = 10;
    /**
     * Macro della lunghezza massima per email.
     */
    static final int MAX_MAIL = 64;
    /**
     * Macro della lunghezza minima per password.
     */
    static final int MIN_PASSWORD = 2;
    /**
     * Macro della lunghezza massima per password.
     */
    static final int MAX_PASSWORD = 8;
    /**
     * Macro della lunghezza minima per il telefono.
     */
    static final int MIN_TELEFONO = 9;
    /**
     * Macro della lunghezza massima per il telefono.
     */
    static final int MAX_TELEFONO = 11;
    /**
     * Macro della lunghezza massima per un nome.
     */
    static final int MAX_NOME = 64;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private AccountConvalida() {
    }

    /**
     * Convalida del nome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NOME =
            formDati -> {
                return validaNome(formDati, AccountConvalida.NOME_PARAMETRO);
            };

    /**
     * Convalida del cognome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_COGNOME =
            formDati -> {
                return validaNome(formDati, AccountConvalida.COGNOME_PARAMETRO);
            };

    /**
     * Convalida della password.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PASSWORD =
            formDati -> {
                Notifica notifica = new Notifica();
                String password = formDati.ottieniDato(
                        AccountConvalida.PASSWORD_PARAMETRO
                );
                if (password == null || password.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "La password non è stata indicata"
                    );
                } else {
                    if (password.length() < MIN_PASSWORD
                            || password.length() > MAX_PASSWORD) {
                        notifica.aggiungiErrore("La lunghezza della password "
                                + "deve compresa tra 2 e 8");
                    } else if (!password.matches("[A-Z, a-z, 0-9]+")) {
                        notifica.aggiungiErrore("Il formato della password "
                                + "non è stato rispettato");
                    } else if (!containsLetteraENumero(password)) {
                        notifica.aggiungiErrore("La password deve "
                                + "contenere almeno "
                                + "una lettera e un numero");
                    }
                }
                return notifica;
            };

    /**
     * Convalida del telefono.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TELEFONO =
            formDati -> {
                Notifica notifica = new Notifica();
                String telefono = formDati.ottieniDato(
                        AccountConvalida.TELEFONO_PARAMETRO
                );
                if (telefono == null || telefono.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il telefono non è stato indicato"
                    );
                } else {
                    if (telefono.length() < MIN_TELEFONO
                            || telefono.length() > MAX_TELEFONO) {
                        notifica.aggiungiErrore("La lunghezza del telefono "
                                + "deve compresa tra 9 e 10");
                    } else if (!telefono.matches("[0-9]+")) {
                        notifica.aggiungiErrore("Il formato del telefono "
                                + "non è stato rispettato");
                    }
                }
                return notifica;
            };

    /**
     * Convalida del sesso.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_SESSO =
            formDati -> {
                Notifica notifica = new Notifica();
                String sesso = formDati.ottieniDato(
                        AccountConvalida.SESSO_PARAMETRO
                );
                if (sesso == null || sesso.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il sesso non è stato indicato"
                    );
                } else {
                    try {
                        Account.Sesso.valueOf(sesso);
                    } catch (IllegalArgumentException e) {
                        notifica.aggiungiErrore(
                                "Il sesso indicato "
                                        + "non è corretto"
                        );
                    }
                }
                return notifica;
            };

    /**
     * Restituisce la notifica degli errori su una convalida del nome.
     *
     * @param formDati da cui prendere il parametro
     * @param nome     del parametro
     * @return notifica
     * @since 0.0.1
     */
    static Notifica validaNome(
            final FormDati formDati, final String nome
    ) {
        Notifica notifica = new Notifica();
        String val = formDati.ottieniDato(nome);
        if (val == null || val.trim().equals("")) {
            notifica.aggiungiErrore("Il " + nome
                    + " non è stato indicato");
        } else {
            if (val.length() > MAX_NOME) {
                notifica.aggiungiErrore("La lunghezza del " + nome
                        + " deve essere compresa tra 1 e 64");
            }
            if (!val.matches("[A-Z, a-z,']+")) {
                notifica.aggiungiErrore("Il formato del " + nome
                        + " non è stato rispettato");
            }
        }
        return notifica;
    }

    /**
     * Controlla se la string contiene almeno una lettera e un numero.
     *
     * @param stringa da controllare
     * @return true se la stringa contiene almeno
     * una lettera e un numero,
     * false altrimenti
     * @since 0.1.1
     */
    protected static boolean containsLetteraENumero(final String stringa) {
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
