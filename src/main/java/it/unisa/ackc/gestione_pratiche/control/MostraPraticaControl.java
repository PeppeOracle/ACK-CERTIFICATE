package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Si occupa di reperire le informazioni relative ad una pratica
 * per un responsabile ufficio.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-pratiche/mostra-pratica")
public class MostraPraticaControl extends HttpServletWithCheck {
    /**
     * Macro del parametro tipo di visualizzione richiesta.
     */
    static final String TIPO_PARAMETRO = "tipo";
    /**
     * Macro della jsp per il responsabile ufficio (visualizzazione).
     */
    private static final String PRATICA_RESPONSABILE_UFFICIO_JSP = "";
    /**
     * Tipo jsp per responsabile ufficio (visualizzazione).
     */
    static final int PRATICA_RESPONSABILE_UFFICIO = 0;
    /**
     * Macro della jsp per il responsabile ufficio (valutazione).
     */
    private static final String PRATICA_RESPONSABILE_UFFICIO_VALUTA_JSP = "";
    /**
     * Tipo jsp per responsabile ufficio (valutazione).
     */
    static final int PRATICA_RESPONSABILE_UFFICIO_VALUTA = 1;
    /**
     * Macro della jsp per lo studente (visualizzazione).
     */
    private static final String PRATICA_STUDENTE_JSP = "";
    /**
     * Tipo jsp per lo studente  (visualizzazione).
     */
    static final int PRATICA_STUDENTE = 2;
    /**
     * Macro della jsp per lo studente (modifica).
     */
    private static final String PRATICA_STUDENTE_MODIFICA_JSP = "";
    /**
     * Tipo jsp per lo studente  (modifica).
     */
    static final int PRATICA_STUDENTE_MODIFICA = 3;

    /**
     * Recupera le informazioni relative ad una pratica e delega
     * la presentazione alla componente jsp della visualizzazione
     * della pratica per un responsabile ufficio.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        int tipo = Integer.parseInt(
                request.getParameter(TIPO_PARAMETRO)
        );
        request.getRequestDispatcher(getJSP(tipo)).forward(request, response);
    }

    /**
     * Restituisce la jsp corrispondente al tipo.
     *
     * @param tipo di visualizzazione richiesta
     * @return jsp corrispondente al tipo indicato
     */
    private String getJSP(final int tipo) {
        switch (tipo) {
            case PRATICA_RESPONSABILE_UFFICIO:
                return PRATICA_RESPONSABILE_UFFICIO_JSP;
            case PRATICA_RESPONSABILE_UFFICIO_VALUTA:
                return PRATICA_RESPONSABILE_UFFICIO_VALUTA_JSP;
            case PRATICA_STUDENTE:
                return PRATICA_STUDENTE_JSP;
            case PRATICA_STUDENTE_MODIFICA:
                return PRATICA_STUDENTE_MODIFICA_JSP;
            default:
                return null;
        }
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
                PraticaConvalida.VALIDA_PRATICA
        );
        addCondizione(
                MostraPraticaConvalida.VALIDA_TIPO
        );
        super.valida(request);
    }
}
