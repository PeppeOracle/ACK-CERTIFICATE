package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa della visualizzazione e filtraggio delle pratiche per un responsabile ufficio.
 *
 * @version 0.0.1
 */
public class VisualizzaPraticheResponsabileUfficioControl extends HttpServlet {
    /**
     * Recupera le informazioni (opportunamente filtrate) relative alla lista di pratiche per
     * un responsabile ufficio.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
