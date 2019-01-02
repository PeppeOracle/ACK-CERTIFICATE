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
    private AccountConvalida() {

    }

    /**
     * Convalida del nome.
     *
     * @since 0.0.1
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
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            request -> {
                Notifica notifica = new Notifica();
                String tipoDiDomanda = request.getParameter(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (tipoDiDomanda == null || tipoDiDomanda.trim().equals("")) {
                    notifica.addError(
                            "Il tipo di domanda non è stato indicato"
                    );
                }
                return  notifica;
            };
}