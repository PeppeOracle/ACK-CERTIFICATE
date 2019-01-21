package it.unisa.ackc.servlet.gestione_pratiche;

import it.unisa.ackc.servlet.ServletForm;
import it.unisa.ackc.storage.ACKStorageFacade;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Interfaccia http per il control
 * {@link
 * it.unisa.ackc.gestione_pratiche.control.CreazionePratica
 * }.
 *
 * @version 1.0.0
 */
@WebServlet("/gestione-pratiche/creazione-pratica")
@MultipartConfig(location = "/", fileSizeThreshold =
        CreazionePratica.FILE_THRESHOLD,
        maxFileSize = CreazionePratica.MAX_FILE_SIZE, maxRequestSize =
        CreazionePratica.MAX_REQUEST_SIZE)
public class CreazionePratica
        extends ServletForm {
    /**
     * Macro max file size.
     */
    static final int FILE_THRESHOLD = 1024 * 1024;
    /**
     * Macro max file size.
     */
    static final int MAX_FILE_SIZE = FILE_THRESHOLD * 5;
    /**
     * Macro max file size.
     */
    static final int MAX_REQUEST_SIZE = MAX_FILE_SIZE * 5;
    /**
     * Istanza dell'EJB per accedere al database.
     */
    @Inject
    private ACKStorageFacade ackStorage;
    /**
     * Interfaccia http esposta per il servizio di
     * CreazionePratica.
     *
     * @param richiesta http ricevuta
     * @param risposta http da inviare
     * @since 1.0.0
     */
    @Override
    public void doPost(
            final HttpServletRequest richiesta,
            final HttpServletResponse risposta
    ) {
        try {
            sottomettiForm(
                    it.unisa.ackc.gestione_pratiche.control
                            .CreazionePratica.class,
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
