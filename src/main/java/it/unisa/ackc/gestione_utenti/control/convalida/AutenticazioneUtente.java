package it.unisa.ackc.gestione_utenti.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Si occupa della convalida dell'autenticazione.
 *
 * @version 0.1.1
 */
public final class AutenticazioneUtente {
    /**
     * Macro della lunghezza minima per email.
     */
    static final int MIN_MAIL = 10;
    /**
     * Macro della lunghezza massima per email.
     */
    static final int MAX_MAIL = 64;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private AutenticazioneUtente() { }

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
        formDati -> {
            Notifica notifica = new Notifica();
            String email = formDati.ottieniDato(
                    AccountConvalida.EMAIL_PARAMETRO
            );
            if (email == null || email.trim().equals("")) {
                notifica.aggiungiErrore(
                        "La mail non è stato indicato"
                );
            } else {
                if (email.length() < MIN_MAIL
                        || email.length() > MAX_MAIL) {
                    notifica.aggiungiErrore("La lunghezza dell'email "
                            + "deve compresa tra 19 e 64");
                }
            }
            return  notifica;
        };
}
