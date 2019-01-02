package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Si occupa della visualizzazione e filtraggio delle pratiche per un responsabile ufficio.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/visualizza-pratiche-responsabile-ufficio")
public class VisualizzaPraticheResponsabileUfficioControl extends HttpServletWithCheck {
    private static final String FILTRO_PARAMETRO = "filtro";
    private static final String PAGINA_PARAMETRO = "pagina";
    private static final String PRATICHE_JSP = "";
    private static final int NESSUN_FILTRO = 0;
    private static final int PRATICHE_DA_VALUTARE = 1;
    private static final int PRATICHE_SOSPESE = 2;
    private static final int PRATICHE_CHIUSE = 3;

    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Recupera le informazioni (opportunamente filtrate) relative alla
     * lista di pratiche per un responsabile ufficio.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        Account account = (Account)
                request.getSession().getAttribute("account");
        int filtro = Integer.parseInt(request.getParameter(FILTRO_PARAMETRO));
        int pagina = Integer.parseInt(request.getParameter(PAGINA_PARAMETRO));
        List<Pratica> praticheResponsabileUfficio = null;
        switch (filtro) {
            case PRATICHE_SOSPESE:
                //TODO praticheStudente = ACKStorageFacade.getPraticheByResponsabileUfficioSospese(account, pagina)
                break;
            case PRATICHE_DA_VALUTARE:
                //TODO praticheStudente = ACKStorageFacade.getPraticheByResponsabileUfficioDaValutare(account, pagina)
                break;
            case PRATICHE_CHIUSE:
                //TODO praticheStudente = ACKStorageFacade.getPraticheByResponsabileUfficioChiuse(account, pagina)
                break;
            case NESSUN_FILTRO:
            default:
                //TODO praticheStudente = ACKStorageFacade.getPraticheByResponsabileUfficio(account, pagina)
        }
        request.setAttribute("pratiche", praticheResponsabileUfficio);
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
        //TODO aggiungi convalida
        super.valida(request);
    }
}
