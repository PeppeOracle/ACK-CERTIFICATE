package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Si occupa della creazione di una nuova pratica.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/creazione-pratica")
public class CreazionePraticaControl extends HttpServlet {
    private static final String MESSAGGIO_PARAMETRO = "messaggio";
    private static final String DOMANDA_PARAMETRO = "domanda";
    private static final String ATTESTATO_PARAMETRO = "attestato";
    private static final String SUCCESSFUL_JSP = "";
    private static final String SUCCESSFUL_MESSAGE = "";
    private static final String STUDENTI_PATH = "files-studenti";

    /**
     * Verifica che entrambi i file (attestato e domande) siano
     * stati sottomessi, procede alla validazione e in caso successo
     * procede al creazione della pratica, infine reindirizza alla
     * componente jsp responsabile della visualizzazione della pratica.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
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
        String domandaPath = uploadPath
                + File.separator
                + account.getId()
                + "-" + "domanda";
        domandaPart.write(domandaPath);
        String attestatoPath = uploadPath
                + File.separator
                + account.getId()
                + "-" + "attestato";
        attestatoPart.write(attestatoPath);
        Domanda domanda = (Domanda) request
                .getSession()
                .getAttribute("domanda");
        domanda.setPath(domandaPath);
        //TODO ACKStorageFacade.createDomanda(domanda)
        Attestato attestato = new Attestato(attestatoPath);
        //TODO ACKStorageFacade.createAttestato(attestato)
        Pratica pratica = new Pratica(
                domanda,
                attestato,
                messaggio
        );
        //TODO ACKStorageFacade.createPratica(pratica)
        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
    }
}
