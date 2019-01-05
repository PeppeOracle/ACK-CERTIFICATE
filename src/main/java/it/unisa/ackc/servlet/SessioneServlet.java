package it.unisa.ackc.servlet;

import it.unisa.ackc.http.Sessione;

import javax.servlet.http.HttpSession;

/**
 * Implementazione della sessione per le servlet.
 */
public class SessioneServlet implements Sessione {
    /**
     * Sessione della servlet.
     */
    private HttpSession sessione;

    /**
     * Permette di instanziare un oggetto di tipo <code>SessioneServlet</code>.
     *
     * @param aSessione della servlet
     */
    public SessioneServlet(final HttpSession aSessione) {
        this.sessione = aSessione;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object ottieni(final String chiave) {
        return sessione.getAttribute(chiave);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void aggiungi(final String chiave, final Object valore) {
        sessione.setAttribute(chiave, valore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rimuovi(final String chiave) {
        sessione.removeAttribute(chiave);
    }
}
