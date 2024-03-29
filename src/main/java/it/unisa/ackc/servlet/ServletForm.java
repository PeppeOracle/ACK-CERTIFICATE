package it.unisa.ackc.servlet;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.storage.ACKStorageFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Astrazione di una servlet che espone un servizio di gestione
 * di una form.
 */
public abstract class   ServletForm extends Servlet<FormControl> {
    /**
     * Macro della grandezza del buffer.
     */
    private static final int BUFFER_SIZE = 1024;

    /**
     * Chiama il metodo sottometttiForm dell'oggetto indicato.
     *
     * @param controlClass da istanziare
     * @param richiesta http ricevuta
     * @param risposta http da inviare
     * @param ackStorageFacade facade per l'accesso allo storage
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
            final HttpServletResponse risposta,
            final ACKStorageFacade ackStorageFacade
     ) throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        FormControl control = ottieniControl(
                controlClass,
                richiesta,
                risposta
        );
        control.setAckStorage(ackStorageFacade);
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
        if (richiesta.getContentType() != null
                && richiesta.getContentType()
                .toLowerCase()
                .indexOf("multipart/form-data") > -1) {
            try {
                for (Part part : richiesta.getParts()) {
                    if (part.getName().contains("file")) {
                        formDati.aggiungiDato(part.getName(),
                                Paths.get(part.getSubmittedFileName())
                                        .getFileName().toString());
                    } else {
                        formDati.aggiungiDato(part.getName(), getValue(part));
                    }
                }
            } catch (IOException | ServletException e) {
                // ignore
            }
        }
        return formDati;
    }

    /**
     * Permette di ottenere il valore di un part del form.
     *
     * @param part del form
     * @return valore del part
     * @throws IOException se ci sono problemi nella lettura
     */
    private static String getValue(final Part part) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(part.getInputStream(), "UTF-8")
        );
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[BUFFER_SIZE];
        for (int length = reader.read(buffer);
             length > 0; length = reader.read(buffer)) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }
}
