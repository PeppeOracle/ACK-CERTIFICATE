package it.unisa.ackc.filters;

import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filtro per verificare che un utente sia loggato.
 */
@WebFilter(filterName = "AccountFilter", urlPatterns = {
        "/gestione-pratiche/creazione-domanda-attivita-lavorativa",
        "/gestione-pratiche/creazione-domanda",
        "/gestione-pratiche/creazione-domanda-lingua-inglese",
        "/gestione-pratiche/creazione-pratica",
        "/gestione-pratiche/download-file",
        "/gestione-pratiche/modifica-pratica-sospesa",
        "/gestione-pratiche/mostra-pratica",
        "/gestione-pratiche/valutazione-pratica",
        "/gestione-pratiche/visualizza-pratiche-responsabile-ufficio",
        "/gestione-pratiche/visualizza-pratiche-studente"
})
public class AccountFilter implements Filter {
    /**
     * Macro della jsp di login.
     */
    private static final String LOGIN_JSP =
            "";

    @Override
    public void init(final FilterConfig filterConfig)
            throws ServletException { }

    /**
     * Veririfica che l'utente che ha richiesto la
     * servlet sia loggato.
     *
     * @param req specifica la richiesta http
     * @param res specifica la risposta http
     * @param chain la catena di filtri
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain
    ) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("account") == null) {
            response.sendRedirect(request.getContextPath() + LOGIN_JSP);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() { }
}

