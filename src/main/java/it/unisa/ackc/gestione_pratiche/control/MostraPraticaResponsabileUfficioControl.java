package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa di reperire le informazioni relative ad una pratica per un responsabile ufficio
 *
 * @version 0.0.1
 */
public class MostraPraticaResponsabileUfficioControl extends HttpServlet {
    /**
     * Recupera le informazioni relative ad una pratica e delega la presentazione alla componente jsp
     * della visualizzazione della pratica per un responsabile ufficio.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
