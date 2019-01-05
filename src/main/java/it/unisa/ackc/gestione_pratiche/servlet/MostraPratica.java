package it.unisa.ackc.gestione_pratiche.servlet;

import it.unisa.ackc.servlet.ServletForm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Interfaccia http per il control
 * {@link
 * it.unisa.ackc.gestione_pratiche.control.MostraPratica
 * }.
 *
 * @version 1.0.0
 */
@WebServlet("/gestione-pratiche/mostra-pratica")
public class MostraPratica
        extends ServletForm {
    /**
     * Interfaccia http esposta per il servizio di
     * MostraPratica.
     *
     * @param richiesta http ricevuta
     * @param risposta  http da inviare
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
                            .MostraPratica.class,
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
