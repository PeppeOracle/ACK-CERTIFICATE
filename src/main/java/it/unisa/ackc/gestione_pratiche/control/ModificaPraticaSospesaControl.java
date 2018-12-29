package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Si occupa della modifica di una pratica.
 *
 * @version 0.0.1
 */
public class ModificaPraticaSospesaControl extends HttpServlet {
    private static final String MESSAGGIO_PARAMETRO = "messaggio";
    private static final String DOMANDA_PARAMETRO = "domanda";
    private static final String ATTESTATO_PARAMETRO = "attestato";
    private static final String PRATICA_PARAMETRO = "pratica";
    private static final String MODIFICA_JSP = "";
    private static final String SUCCESSFUL_JSP = "";
    private static final String SUCCESSFUL_MESSAGE = "";
    private static final String STUDENTI_PATH = "files-studenti";

    /**
     * Recupera le informazioni relative ad una pratica e
     * delega la presentazione alla componente jsp per la
     * modifica della pratica.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PRATICA_PARAMETRO));
        Pratica pratica = null;
        //TODO pratica = ACKStorageFacade.getDomandaById(id)
        request.setAttribute("pratica", pratica);
        request.getRequestDispatcher(MODIFICA_JSP).forward(request, response);
    }

    /**
     * Verifica che entrambi i file (attestato e domande)
     * siano stati sottomessi, procede alla validazione e
     * in caso successo procede alla modifica della pratica,
     * infine reindirizza alla componente jsp responsabile
     * della visualizzazione della pratica.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws IOException, ServletException {
        Account account = (Account) request.getAttribute("account");
        String messaggio = request.getParameter(MESSAGGIO_PARAMETRO);
        Part domandaPart = request.getPart(DOMANDA_PARAMETRO);
        Part attestatoPart = request.getPart(ATTESTATO_PARAMETRO);
        //TODO controllo sui dati
        String uploadPath = getServletContext().getRealPath("")
                + File.separator
                + STUDENTI_PATH;
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        if (domandaPart != null) {
        }
        if (attestatoPart != null) {
        }
        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
    }
}
