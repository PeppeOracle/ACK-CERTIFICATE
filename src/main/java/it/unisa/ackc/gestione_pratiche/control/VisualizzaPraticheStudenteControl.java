package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Si occupa della visualizzazione delle pratiche per uno studente.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/visualizza-pratiche-studente")
public class VisualizzaPraticheStudenteControl extends HttpServletWithCheck {
    /**
     * Macro della jsp della lista di pratiche.
     */
    private static final String PRATICHE_JSP = "";
    /**
     * Macro del parametro pagina.
     */
    static final String PAGINA_PARAMETRO = "pagina";
    /**
     * Macro del limite di pratiche in una pagina.
     */
    static final int LIMITE_PAGINA = 10;

    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Recupera
     * le informazioni relative alla lista di pratiche per uno studente.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        AccountStudente account = (AccountStudente)
                request.getSession().getAttribute("account");
        int pagina = Integer.parseInt(request.getParameter(PAGINA_PARAMETRO));
        valida(request);
        List<Pratica> praticheStudente = null;
        praticheStudente = ackStorage.findAllPraticheForStudente(
                account,
                LIMITE_PAGINA,
                (pagina - 1) * LIMITE_PAGINA);
        request.setAttribute("pratiche", praticheStudente);
        request.getRequestDispatcher(PRATICHE_JSP).forward(request, response);
    }

    /**
     * Valida i parametri della richiesta.
     *
     * @param request contenente i parametri da validare
     * @since 0.0.1
     */
    @Override
    public void valida(final HttpServletRequest request) {
        addCondizione(
                VisualizzaPraticheStudenteConvalida.VALIDA_PAGINA
        );
        super.valida(request);
    }
}
