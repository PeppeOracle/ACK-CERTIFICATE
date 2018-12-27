package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa della modifica di una pratica
 *
 * @version 0.0.1
 */
public class ModificaPraticaSospesaControl extends HttpServlet {
    /**
     * Recupera le informazioni relative ad una pratica e delega la presentazione alla componente
     * jsp per la modifica della pratica.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     * Verifica che entrambi i file (attestato e domande) siano stati sottomessi,
     * procede alla validazione e in caso successo procede alla modifica della pratica,
     * infine reindirizza alla componente jsp responsabile della visualizzazione della pratica.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
