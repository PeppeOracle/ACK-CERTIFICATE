package it.unisa.ackc;

import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtro per verificare che l'utente loggato sia uno studente.
 */
@WebFilter(filterName = "AccountFilter", urlPatterns = {
        "/gestione-pratiche/creazione-domanda-attivita-lavorativa",
        "/gestione-pratiche/creazione-domanda",
        "/gestione-pratiche/creazione-domanda-lingua-inglese",
        "/gestione-pratiche/creazione-pratica",
        "/gestione-pratiche/modifica-pratica-sospesa",
        "/gestione-pratiche/visualizza-pratiche-studente"
})
public class StudenteFilter  implements Filter {
    /**
     * Macro della jsp nel caso in cui venga negato il permessso.
     */
    public static final String PERMESSO_NEGATO_JSP =
            "";

    @Override
    public void init(final FilterConfig filterConfig)
            throws ServletException { }

    /**
     * Veririfica che l'utente che ha richiesto la
     * servlet sia uno studente.
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
        Account account = (Account)
                request.getSession(false).getAttribute("account");
        if (account.getRuolo().equals(Account.Ruolo.STUDENTE)) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(
                    request.getContextPath() + PERMESSO_NEGATO_JSP
            );
        }
    }

    @Override
    public void destroy() { }
}
