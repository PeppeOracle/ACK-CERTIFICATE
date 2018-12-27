package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Si occupa della creazione di una nuova pratica
 *
 * @version 0.0.1
 */
public class CreazionePraticaControl extends HttpServlet {
    /**
     * Verifica che entrambi i file (attestato e domande) siano stati sottomessi,
     * procede alla validazione e in caso successo procede al creazione della pratica,
     * infine reindirizza alla componente jsp responsabile della visualizzazione della pratica.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }
}
