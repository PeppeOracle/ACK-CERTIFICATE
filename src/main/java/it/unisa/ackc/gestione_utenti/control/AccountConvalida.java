package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.servlet.http.HttpServletRequest;

/**
 * Si occupa della convalida dell'account.
 *
 * @version 0.0.1
 */
public class AccountConvalida {
    /**
     * Macro del parametro email.
     */
    static final String EMAIL_PARAMETRO = "email";
    /**
     * Macro del parametro password.
     */
    static final String PASSWORD_PARAMETRO = "password";
    /**
     * Macro del parametro telefono.
     */
    static final String TELEFONO_PARAMETRO = "telefono";
    /**
     * Macro del parametro nome.
     */
    static final String NOME_PARAMETRO = "nome";
    /**
     * Macro del parametro cognome.
     */
    static final String COGNOME_PARAMETRO = "cognome";
    /**
     * Macro del parametro ruolo.
     */
    static final String RUOLO_PARAMETRO = "ruolo";
    /**
     * Macro del parametro sesso.
     */
    static final String SESSO_PARAMETRO = "sesso";

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private AccountConvalida() { }

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
     * Convalida del email.
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
                    if (email.matches("[A-Z,a-z,0-9,-,.,_ ]+[@studenti.unisa.it]+")) {
                        notifica.addError("Il formato dell'email " +
                                "non è stato rispettato");
                    }
                    if (email.matches("^[A-Z,a-z,0-9,-,.,_ ]{1,64}+[@studenti.unisa.it]+")) {
                        notifica.addError("La lunghezza dell'email " +
                                "deve compresa tra 1 e 64");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del password.
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
                    if (password.matches("\\w{1,64}$")) {
                        notifica.addError("La lunghezza della password " +
                                "deve compresa tra 1 e 64");
                    }
                    if (password.matches("[A-Z, a-z,']+")) {
                        notifica.addError("Il formato della password " +
                                "non è stato rispettato");
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
                    if (telefono.matches("\\w{9,10}$")) {
                        notifica.addError("La lunghezza del telefono " +
                                "deve compresa tra 9 e 10");
                    }
                    if (telefono.matches("[0-9]+")) {
                        notifica.addError("Il formato del telefono " +
                                "non è stato rispettato");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del ruolo.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_RUOLO =
            request -> {
                Notifica notifica = new Notifica();
                String ruolo = request.getParameter(
                        AccountConvalida.RUOLO_PARAMETRO
                );
                if (ruolo != null) {
                    //Controlli validazione
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
                    boolean found = false;
                    for (Account.Sesso sessoAccount : Account.Sesso.values()) {
                        if (sessoAccount.name().equals(sesso)) {
                            found = true;
                        }
                    }
                    if (!found) {
                        notifica.addError(
                                "Il formato del sesso non è valido"
                        );
                    }
                }
                return  notifica;
            };

    /**
     *
     * @param request
     * @param nome
     * @return
     */
    private static Notifica validaNome(
            final HttpServletRequest request, final String nome
    ) {
        Notifica notifica = new Notifica();
        String val = request.getParameter(nome);
        if (val != null) {
            if (val.matches("\\w{1,64}$")) {
                notifica.addError("La lunghezza del " + nome +
                        " deve compresa tra 1 e 64");
            }
            if (val.matches("[A-Z, a-z,']+")) {
                notifica.addError("Il formato del " + nome +
                        " non è stato rispettato");
            }
        }
    }
}
