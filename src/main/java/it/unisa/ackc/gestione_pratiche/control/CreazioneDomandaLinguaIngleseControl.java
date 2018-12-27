package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa della creazione di una nuova pratica di lingua inglese
 *
 * @version 0.0.1
 */
public class CreazioneDomandaLinguaIngleseControl extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("ciao");
    }
    /**
     * Reindirizza sulla base della tipologia scelta ad una componente jsp per la
     * creazione di una domanda.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
