package it.unisa.ackc_v2.servlet;

import it.unisa.ackc_v2.form.FormControl;
import it.unisa.ackc_v2.form.FormDati;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Astrazione di una servlet che espone un servizio di gestione
 * di una form.
 */
public abstract class ServletForm extends Servlet<FormControl> {
    /**
     * Chiama il metodo sottometttiForm dell'oggetto indicato.
     *
     * @param controlClass da istanziare
     * @param richiesta http ricevuta
     * @param risposta http da inviare
     * @throws InvocationTargetException sollevata se ci sono stati errori
     *                                   con ottieniControl
     * @throws NoSuchMethodException sollevata se ci sono stati errori
     *                               con ottieniControl
     * @throws InstantiationException sollevata se ci sono stati errori
     *                                con ottieniControl
     * @throws IllegalAccessException sollevata se ci sono stati errori
     *                                con ottieniControl
     */
    public void sottomettiForm(
            final Class<? extends FormControl> controlClass,
            final HttpServletRequest richiesta,
            final HttpServletResponse risposta
    ) throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        FormControl control = ottieniControl(
                controlClass,
                richiesta,
                risposta
        );
        control.sottomettiForm(ottieniFormDati(richiesta));
    }

    /**
     * Costruisce un oggetto FormDati a partire dalla richiesta http.
     *
     * @param richiesta http ricevuta
     * @return formDati corrispondente alla richiesta
     */
    public FormDati ottieniFormDati(final HttpServletRequest richiesta) {
        FormDati formDati = new FormDati();
        for (Map.Entry<String, String[]> entry : richiesta.getParameterMap()
                .entrySet()) {
            if (entry.getValue() != null && entry.getValue().length != 0) {
                if (entry.getValue().length == 1) {
                    formDati.aggiungiDato(entry.getKey(), entry.getValue()[0]);
                } else {
                    formDati.aggiungiDato(entry.getKey(), entry.getValue());
                }
            }
        }
        return formDati;
    }
}
