package it.unisa.ackc.filters;

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
 * Filtro per verificare che l'utente loggato sia un amministratore.
 */
@WebFilter(filterName = "AmministratoreFilter", urlPatterns = {
        "/gestione-utenti/registrazione-account-responsabile-ufficio"
})
public class AmministratoreFilter implements Filter {
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
     * servlet sia un amministratore.
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
        if (account.getRuolo().equals(Account.Ruolo.AMMINISTRATORE)) {
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
