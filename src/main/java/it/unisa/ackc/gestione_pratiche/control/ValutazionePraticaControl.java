package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.GestionePraticheConvalida;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa della valutazione di una pratica.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/valutazione-pratica")
public class ValutazionePraticaControl extends HttpServletWithCheck {
    /**
     * Macro del parametro stato della pratica.
     */
    static final String STATO_PARAMETRO = "stato";
    /**
     * Macro del parametro messaggio.
     */
    static final String MESSAGGIO_PARAMETRO =
            "messaggio";
    /**
     * Macro della jsp di successo della valutazione.
     */
    private static final String SUCCESSFUL_JSP =
            "";
    /**
     * Macro del messaggio di successo della valutazione.
     */
    private static final String SUCCESSFUL_MESSAGE =
            "";

    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Aggiorna lo stato della pratica e rendirizza alla componente
     * responsabile della gestione pratiche del responsabile ufficio.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        Pratica.Stato stato = Pratica.Stato.valueOf(
                request.getParameter(STATO_PARAMETRO)
        );
        String messaggioPratica = request.getParameter(MESSAGGIO_PARAMETRO);
        Pratica pratica = (Pratica) request.getAttribute("pratica");
        pratica.setMessaggioResponsabileUfficio(messaggioPratica);
        pratica.setStato(stato);
        ackStorage.updatePratica(pratica);
        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
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
                GestionePraticheConvalida.VALIDA_PRATICA
        );
        addCondizione(
                ValutazionePraticaConvalida.VALIDA_STATO
        );
        addCondizione(
                ValutazionePraticaConvalida.VALIDA_MESSAGGIO
        );
        super.valida(request);
    }
}
