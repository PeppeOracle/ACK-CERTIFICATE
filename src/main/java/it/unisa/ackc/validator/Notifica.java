package it.unisa.ackc.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Permette di collezionare un insieme di errori.
 */
public class Notifica {
    /**
     * Contiene la lista degli errori aggiunti.
     */
    private List<Error> errors = new ArrayList<>();

    /**
     * Aggiunge un errore.
     *
     * @param message messaggio dell'errore
     */
    public void addError(final String message) {
        addError(message, null);
    }

    /**
     * Aggiunge un errore.
     *
     * @param message messaggio dell'errore
     * @param cause eccezzione causa dell'errore
     */
    public void addError(final String message, final Exception cause) {
        errors.add(new Error(message, cause));
    }

    /**
     * Veririfica se sono presenti errori o meno.
     *
     * @return true se ci sono errori, false altrimenti
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Restituisce gli errori sotto forma di stringa.
     *
     * @return stringa di errori concatenati da ','
     */
    public String errorMessage() {
        return errors.stream()
                .map(e -> e.message)
                .collect(Collectors.joining(", "));
    }

    /**
     * Aggiunge gli errori contenuti nella notifica
     * a quella attuale.
     *
     * @param aNotifica contenente gli errori da aggiungere
     */
    public void addErrors(final Notifica aNotifica) {
        errors.addAll(aNotifica.errors);
    }

    /**
     * Incapsula le informazioni riguardante un errore.
     */
    private final class Error {
        /**
         * Messaggio dell'errore.
         */
        private String message;
        /**
         * Causa dell'errore.
         */
        private Exception cause;

        /**
         * Permette di instanziare un oggetto di tipo <code>Notifica</code>.
         *
         * @param aMessage messaggio dell'erore
         * @param aCause causa dell'errore
         */
        private Error(final String aMessage, final Exception aCause) {
            this.message = aMessage;
            this.cause = aCause;
        }
    }
}

