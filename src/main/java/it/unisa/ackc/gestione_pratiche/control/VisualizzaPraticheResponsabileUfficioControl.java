package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Si occupa della visualizzazione e filtraggio delle pratiche per un responsabile ufficio.
 *
 * @version 0.0.2
 */
@WebServlet("/gestione-pratiche/visualizza-pratiche-responsabile-ufficio")
public class VisualizzaPraticheResponsabileUfficioControl extends HttpServletWithCheck {
    /**
     * Macro del parametro filtro.
     */
    static final String FILTRO_PARAMETRO = "filtro";
    /**
     * Macro del parametro pagina.
     */
    static final String PAGINA_PARAMETRO = "pagina";
    /**
     * Macro della jsp della lista di pratiche.
     */
    private static final String PRATICHE_JSP = "";
    /**
     * Macro del filtro nessun_filtro.
     */
    static final int NESSUN_FILTRO = 0;
    /**
     * Macro del filtro pratiche_da_valutare.
     */
    static final int PRATICHE_DA_VALUTARE = 1;
    /**
     * Macro del filtro pratiche_sospese.
     */
    static final int PRATICHE_SOSPESE = 2;
    /**
     * Macro del filtro pratiche_chiuse.
     */
    static final int PRATICHE_CHIUSE = 3;
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
        AccountResponsabileUfficio account = (AccountResponsabileUfficio)
                request.getSession().getAttribute("account");
        int filtro = Integer.parseInt(request.getParameter(FILTRO_PARAMETRO));
        int pagina = Integer.parseInt(request.getParameter(PAGINA_PARAMETRO));
        List<Pratica> praticheResponsabileUfficio;
        switch (filtro) {
            case PRATICHE_SOSPESE:
                praticheResponsabileUfficio =
                        ackStorage.findPraticheSospeseForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
                break;
            case PRATICHE_DA_VALUTARE:
                praticheResponsabileUfficio =
                        ackStorage.findPraticheDaValutareForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
                break;
            case PRATICHE_CHIUSE:
                praticheResponsabileUfficio =
                        ackStorage.findPraticheChiuseForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
                break;
            case NESSUN_FILTRO:
            default:
                praticheResponsabileUfficio =
                        ackStorage.findAllPraticheForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
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
        addCondizione(
                VisualizzaPraticheResponsabileUfficioConvalida.VALIDA_FILTRO
        );
        addCondizione(
                VisualizzaPraticheResponsabileUfficioConvalida.VALIDA_PAGINA
        );
        super.valida(request);
    }
}
