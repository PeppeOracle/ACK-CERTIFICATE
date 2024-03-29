package it.unisa.ackc.servlet.gestione_pratiche;

import it.unisa.ackc.servlet.ServletForm;
import it.unisa.ackc.storage.ACKStorageFacade;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Interfaccia http per il control
 * {@link
 * it.unisa.ackc.gestione_pratiche.control.CreazioneDomanda
 * }.
 *
 * @version 1.0.0
 */
@WebServlet("/gestione-pratiche/creazione-domanda")
public class CreazioneDomanda extends ServletForm {
    /**
     * Istanza dell'EJB per accedere al database.
     */
    @Inject
    private ACKStorageFacade ackStorage;
    /**
     * Interfaccia http esposta per il servizio di
     * CreazioneDomanda.
     *
     * @param richiesta http ricevuta
     * @param risposta http da inviare
     * @since 1.0.0
     */
    @Override
    public void doGet(
            final HttpServletRequest richiesta,
            final HttpServletResponse risposta
    ) {
        try {
            sottomettiForm(
                    it.unisa.ackc.gestione_pratiche.control
                            .CreazioneDomanda.class,
                    richiesta,
                    risposta,
                    ackStorage
            );

        } catch (IllegalArgumentException e) {
            throw new Error(
                    "Input errato "
                            + '\n' + '\n' + "Causa: " + '\n' + e.getMessage()
            );
        } catch (InvocationTargetException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException e) {
            throw new Error(
                    "Si è verificato un problema riprovare più tardi "
            );
        }
    }
}
