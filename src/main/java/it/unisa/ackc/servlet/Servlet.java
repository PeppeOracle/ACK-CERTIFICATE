package it.unisa.ackc.servlet;

import it.unisa.ackc.http.Control;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Astrazione di una servlet che delega la logica ad un oggetto Control.
 *
 * @param <E> control da istanziare
 */
public abstract class Servlet<E extends Control> extends HttpServlet {
    /**
     * Restituisce il control istanziando la classe indicata.
     *
     * @param controlClass da istanziare
     * @param request della servlet
     * @param response della servlet
     * @return l'istanza del control
     * @throws IllegalAccessException lanciata se ci sono problemi
     *                                con gli l'accesso alla classe
     * @throws InstantiationException lanciata se ci sono problemi
     *                                con l'istanziazione dell'oggetto
     * @throws NoSuchMethodException lanciata se un metodo richiesto
     *                               è stato trovato
     * @throws InvocationTargetException lanciata se ci sono stati problemi
     *                                   con l'invocazione di un oggetto.
     */
    public E ottieniControl(final Class<? extends E> controlClass,
                              final HttpServletRequest request,
                              final HttpServletResponse response)
            throws IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException {
        E control =
                controlClass.
                        getDeclaredConstructor(Sessione.class, Risposta.class)
                        .newInstance(
                new SessioneServlet(request.getSession()),
                new RispostaServlet(request, response)
        );
        return control;
    }
}
