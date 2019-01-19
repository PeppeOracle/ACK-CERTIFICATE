package it.unisa.ackc.servlet.gestione_utenti;

import it.unisa.ackc.servlet.ServletForm;
import it.unisa.ackc.storage.ejb.ACKStorageFacadeDefault;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Interfaccia http per il control
 * {@link
 * it.unisa.ackc.gestione_utenti.control.AutenticazioneUtente
 * }.
 *
 * @version 1.0.0
 */
@WebServlet("/gestione-utenti/autenticazione-utente")
public class AutenticazioneUtente extends ServletForm {
    /**
     * Istanza dellEJB per accedere al database.
     */
    @Inject
    private ACKStorageFacadeDefault ackStorage;
    /**
     * Interfaccia http esposta per il servizio di
     * AutenticazioneUtente.
     *
     * @param richiesta http ricevuta
     * @param risposta http da inviare
     * @since 1.0.0
     */
    public void doPost(

            final HttpServletRequest richiesta,
            final HttpServletResponse risposta
    ) {
        try {
            sottomettiForm(
                    it.unisa.ackc.gestione_utenti.control
                            .AutenticazioneUtente.class,
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
