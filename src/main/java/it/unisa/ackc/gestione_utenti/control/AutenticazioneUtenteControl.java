package it.unisa.ackc.gestione_utenti.control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Si occupa dell'autenticazione di un utente nel sistema
 *
 * @version 0.0.1
 */
public class AutenticazioneUtenteControl extends HttpServlet {
    /**
     * Si occupa di effettuare il controllo sui campi della form, in caso di successo
     * rendirizzerà alla componente jsp della homepage dell'utente loggato.
     *
     * @since 0.0.1
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
