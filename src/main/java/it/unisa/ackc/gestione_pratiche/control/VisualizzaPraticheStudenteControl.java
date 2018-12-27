package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa della visualizzazione delle pratiche per uno studente.
 *
 * @version 0.0.1
 */
public class VisualizzaPraticheStudenteControl extends HttpServlet {
    /**
     * Recupera le informazioni relative alla lista di pratiche per uno studente.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}