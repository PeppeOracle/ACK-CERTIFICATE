package it.unisa.ackc.validator;

import it.unisa.ackc.proposta.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Si occupa della validazione di un insieme di elementi.
 *
 * @version 0.0.1
 */
public class ValidatorGroup implements Validatore {
    private Notification notification;
    private List<Validatore> validatori;

    /**
     * Permette di istanziare un oggetto di tipo <code>ValidatorForm</code>.
     *
     * @since 0.0.1
     */
    public ValidatorGroup() {
        validatori = new ArrayList<>();
    }

    /**
     * Aggiunge un nuovo validatore.
     *
     * @param validatore da aggiungere
     */
    public void aggiungiValidatore(final Validatore validatore) {
        validatori.add(validatore);
    }

    /**
     * Permette di validare i campi di ValidatorCampo.
     *
     * @return true se e solo se tutti i campi sono validi,
     *         false altrimenti
     * @throws RuntimeException
     * @since 0.0.1
     */
    public boolean valida() throws RuntimeException {
        boolean risultato = true;
        for (Validatore validatore : validatori) {
            boolean valida = validatore.valida();
            if(!valida) {

            }
            risultato = risultato & valida;
       }
       return risultato;
    }
}
