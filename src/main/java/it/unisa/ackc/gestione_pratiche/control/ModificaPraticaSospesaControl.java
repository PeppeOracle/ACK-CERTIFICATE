package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Si occupa della modifica di una pratica.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-pratiche/modifica-pratica-sospesa")
public class ModificaPraticaSospesaControl extends HttpServletWithCheck {
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
     * Macro della jsp di successo della modifica.
     */
    private static final String SUCCESSFUL_JSP =
            "";
    /**
     * Macro del messaggio di successo della modifica.
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
        valida(request);
        String messaggio = request.getParameter(MESSAGGIO_PARAMETRO);
        Part domandaPart = request.getPart(DOMANDA_PARAMETRO);
        Part attestatoPart = request.getPart(ATTESTATO_PARAMETRO);
        Pratica pratica = (Pratica) request.getAttribute("pratica");
        String uploadPath = getServletContext().getRealPath("")
                + File.separator
                + STUDENTI_PATH;
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        if (messaggio != null && messaggio.length() > 0) {
            pratica.setMessaggioStudente(messaggio);
        }
        if (domandaPart != null) {
            Domanda domanda = pratica.getDomanda();
            domanda.setDataAggiornamento(new Date());
            Domanda aDomanda = (Domanda) request
                    .getSession()
                    .getAttribute("domanda");
            if (aDomanda != null) {
                domanda.replace(aDomanda);
            }
            String domandaPath = uploadPath
                    + File.separator
                    + pratica.getId()
                    + "-" + "domanda.pdf";
            new File(domandaPath).delete();
            domandaPart.write(domandaPath);
        }
        if (attestatoPart != null) {
            Attestato attestato = pratica.getAttestato();
            attestato.setDataAggiornamento(new Date());
            String attestatoPath = uploadPath
                    + File.separator
                    + pratica.getId()
                    + "-" + "attestato.pdf";
            new File(attestatoPath).delete();
            attestatoPart.write(attestatoPath);
        }
        pratica.setDataAggiornamento(new Date());
        pratica.setStato(Pratica.Stato.IN_ATTESA);
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
                PraticaConvalida.VALIDA_PRATICA
        );
        addCondizione(
                ModificaPraticaSospesaConvalida.VALIDA_ATTESTATO
        );
        addCondizione(
                ModificaPraticaSospesaConvalida.VALIDA_DOMANDA
        );
        addCondizione(
                ModificaPraticaSospesaConvalida.VALIDA_MESSAGGIO
        );
        super.valida(request);
    }
}
