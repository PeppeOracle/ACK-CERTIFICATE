package it.unisa.ackc.gestione_utenti.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa della modifica del profilo di uno studente
 *
 * @version 0.0.1
 */
public class ModificaProfiloStudenteControl extends HttpServlet {
    /**
     * Recupera le informazioni dell'utente e delega la presentazione alla componente jsp
     * del profilo dello studente.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }

    /**
     * Si occupa di effettuare il controllo sui campi della form, in caso di successo
     * aggiornerà l'account dello studente e rendirizzerà alla componente jsp del profilo dello studente.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
