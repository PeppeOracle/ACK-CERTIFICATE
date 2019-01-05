package it.unisa.ackc_v2.gestione_pratiche.servlet;

import it.unisa.ackc_v2.servlet.ServletForm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Interfaccia http per il control
 * {@link
 * it.unisa.ackc_v2.gestione_pratiche.control.CreazioneDomandaAttivitaLavorativa
 * }.
 */
@WebServlet("/gestione-pratiche/creazione-domanda-attivita-lavorativa")
public class CreazioneDomandaAttivitaLavorativa
        extends ServletForm {
    /**
     * Interfaccia http esposta per il servizio di
     * CreazioneDomandaAttivitaLavorativa.
     *
     * @param richiesta http ricevuta
     * @param risposta http da inviare
     */
    @Override
    public void doGet(
            final HttpServletRequest richiesta,
            final HttpServletResponse risposta
    ) {
        try {
            sottomettiForm(
                    it.unisa.ackc_v2.gestione_pratiche.control
                            .CreazioneDomandaAttivitaLavorativa.class,
                    richiesta,
                    risposta
            );
        } catch (InvocationTargetException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException e) {
            throw new Error(
                    "Si è verificato un problema riprovare più tardi"
            );
        }
    }
}
