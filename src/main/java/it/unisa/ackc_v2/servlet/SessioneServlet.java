package it.unisa.ackc_v2.servlet;

import it.unisa.ackc_v2.http.Sessione;

import javax.servlet.http.HttpSession;

public class SessioneServlet implements Sessione {
    private HttpSession sessione;

    public SessioneServlet(HttpSession sessione) {
        this.sessione = sessione;
    }

    @Override
    public Object ottieni(final String chiave) {
        return sessione.getAttribute(chiave);
    }

    @Override
    public void aggiungi(String chiave, Object valore) {
        sessione.setAttribute(chiave, valore);
    }
}
