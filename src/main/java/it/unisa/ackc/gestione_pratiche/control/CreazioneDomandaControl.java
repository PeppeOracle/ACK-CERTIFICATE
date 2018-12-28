package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.validator.ValidatorLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Si occupa della creazione di una domanda da allegare ad una pratica.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-pratiche/creazione-domanda")
public class CreazioneDomandaControl extends HttpServlet {
    /**
     * Mappa contenente i tipi di domanda e i path dei relativi control.
     */
    private Map<String, String> pathDomande;

    /**
     * Istanzia gli oggetti necessari al funzionamento della servlet.
     *
     * @since 0.1.1
     */
    public CreazioneDomandaControl() {
        pathDomande = new HashMap<>();
        pathDomande.put(
                "attivitaLavorativa",
                "/gestione-pratiche/creazione-domanda-attivita-lavorativa"
        );
        pathDomande.put(
                "linguaInglese",
                "/gestione-pratiche/creazione-domanda-lingua-inglese"
        );
    }

    /**
     * Reindirizza sulla base della tipologia scelta ad una componente
     * jsp per la creazione di una domanda.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response)
            throws ServletException, IOException {
        String domanda = request.getParameter("tipo_di_domanda");
        ValidatorLogic.CAMPO_NON_VUOTO(
                "Tipo di domanda",
                domanda
        ).valida();
        String path = pathDomande.get(domanda);
        if (path != null) {
            request.getRequestDispatcher(path).forward(request, response);
        } else {
            throw new IllegalArgumentException(
                    "Il tipo di domanda specificato non è supportato"
            );
        }
        request.getRequestDispatcher(path).forward(request, response);
    }
}
