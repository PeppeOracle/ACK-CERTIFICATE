package it.unisa.ackc_v2.servlet;

import it.unisa.ackc_v2.http.Control;
import it.unisa.ackc_v2.http.Risposta;
import it.unisa.ackc_v2.http.Sessione;

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
                new RispostaServlet(response)
        );
        return control;
    }
}
