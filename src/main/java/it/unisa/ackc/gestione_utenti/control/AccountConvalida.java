package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

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
     * @since asz0.0.1
     */
    public static final CondizioneConvalida VALIDA_NOME =
            request -> {
                Notifica notifica = new Notifica();
                String nome = request.getParameter(
                        AccountConvalida.NOME_PARAMETRO
                );
                if (nome != null) {
                    //Controlli validazione
                }
                return  notifica;
            };

    /**
     * Convalida del cognome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_COGNOME =
            request -> {
                Notifica notifica = new Notifica();
                String cognome = request.getParameter(
                        AccountConvalida.COGNOME_PARAMETRO
                );
                if (cognome != null) {
                    //Controlli validazione
                }
                return  notifica;
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
                    //Controlli validazione
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
                    //Controlli validazione
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
                    //Controlli validazione
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
                    //Controlli validazione
                }
                return  notifica;
            };
}
