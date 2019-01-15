package it.unisa.ackc;

import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtro per verificare che l'utente loggato sia un consumer.
 */
@WebFilter(filterName = "AccountFilter", urlPatterns = {
        "/gestione-pratiche/download-file",
        "/gestione-pratiche/mostra-pratica"
})
public class ConsumerFilter implements Filter {
    /**
     * Macro della jsp nel caso in cui venga negato il permessso.
     */
    private static final String PERMESSO_NEGATO_JSP =
            "";

    @Override
    public void init(final FilterConfig filterConfig)
            throws ServletException { }

    /**
     * Veririfica che l'utente che ha richiesto la
     * servlet sia un consumer.
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
        if (account.getRuolo().equals(Account.Ruolo.STUDENTE)
                || account.getRuolo().equals(
                        Account.Ruolo.RESPONSABILE_UFFICIO
        )) {
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
