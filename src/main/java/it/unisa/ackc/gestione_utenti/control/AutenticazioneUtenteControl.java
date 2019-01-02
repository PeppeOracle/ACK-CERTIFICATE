package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa dell'autenticazione di un utente nel sistema.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-utenti/autenticazione-utente")
public class AutenticazioneUtenteControl extends HttpServletWithCheck {
    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Si occupa di effettuare il controllo sui campi della form,
     * in caso di successo rendirizzerà alla componente jsp della
     * homepage dell'utente loggato.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        String email = request.getParameter(EMAIL_PARAMETRO);
        String password = request.getParameter(PASSWORD_PARAMETRO);
        Account account = ackStorage.findAccountByEmail(email);
        if (account != null && account.getPassword().equals(password)) {
            request.getSession(true).setAttribute("account", account);
            request.getRequestDispatcher(HOME_JSP).forward(request, response);
        } else {
            request.setAttribute("message", ERROR_MESSAGE);
            request.getRequestDispatcher(ERROR_JSP).forward(request, response);
        }
    }
}
