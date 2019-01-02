package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Si occupa della creazione di una nuova pratica.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-pratiche/creazione-pratica")
public class CreazionePraticaControl extends HttpServletWithCheck {
    /**
     * Macro del parametro messaggio.
     */
    static final String MESSAGGIO_PARAMETRO =
            "messaggio";
    /**
     * Macro del parametro domanda.
     */
    static final String DOMANDA_PARAMETRO =
            "domanda";
    /**
     * Macro del parametro attestato.
     */
    static final String ATTESTATO_PARAMETRO =
            "attestato";
    /**
     * Macro della jsp di successo della creazione.
     */
    private static final String SUCCESSFUL_JSP =
            "";
    /**
     * Macro del messaggio di successo della creazione.
     */
    private static final String SUCCESSFUL_MESSAGE =
            "";
    /**
     * Macro del path dei file degli studenti.
     */
    private static final String STUDENTI_PATH =
            "files-studenti";

    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

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
        valida(request);
        Account account = (Account)
                request.getSession().getAttribute("account");
        String messaggio = request.getParameter(MESSAGGIO_PARAMETRO);
        Part domandaPart = request.getPart(DOMANDA_PARAMETRO);
        Part attestatoPart = request.getPart(ATTESTATO_PARAMETRO);
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
                + "-" + "domanda.pdf";
        domandaPart.write(domandaPath);
        String attestatoPath = uploadPath
                + File.separator
                + account.getId()
                + "-" + "attestato.pdf";
        attestatoPart.write(attestatoPath);
        Domanda domanda = (Domanda) request
                .getSession()
                .getAttribute("domanda");
        request.getSession().removeAttribute("domanda");
        domanda.setPath(domandaPath);
        Attestato attestato = new Attestato(attestatoPath);
        Pratica pratica = new Pratica(
                domanda,
                attestato,
                messaggio
        );
        ((AccountStudente) account).addPratica(pratica);
        ackStorage.updateAccount(account);
        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
    }

    /**
     * Valida i parametri della richiesta.
     * @param request contenente i parametri da validare
     * @since 0.0.1
     */
    @Override
    public void valida(final HttpServletRequest request) {
        addCondizione(
                CreazionePraticaConvalida.VALIDA_ATTESTATO
        );
        addCondizione(
                CreazionePraticaConvalida.VALIDA_DOMANDA
        );
        addCondizione(
                CreazionePraticaConvalida.VALIDA_MESSAGGIO
        );
        super.valida(request);
    }
}
