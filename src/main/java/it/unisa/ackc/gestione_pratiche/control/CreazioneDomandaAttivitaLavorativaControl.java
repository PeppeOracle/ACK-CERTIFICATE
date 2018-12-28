package it.unisa.ackc.gestione_pratiche.control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Si occupa della creazione di una nuova domanda di attività lavorativa.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/creazione-domanda-attivita-lavorativa")
public class CreazioneDomandaAttivitaLavorativaControl extends HttpServlet {
    /**
     * Si occupa di effettuare il controllo sui campi della form, in caso di successo
     * farà partire il download del file e rendirizzerà alla componente jsp che si
     * occuperà di continuare l'attività (modifica / creazione di una pratica).
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
