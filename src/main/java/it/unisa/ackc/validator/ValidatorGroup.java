package it.unisa.ackc.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Si occupa della validazione di un insieme di elementi.
 *
 * @version 0.0.1
 */
public class ValidatorGroup implements Validator {
    private List<Validator> validators;

    /**
     * Permette di istanziare un oggetto di tipo <code>ValidatorForm</code>.
     *
     * @since 0.0.1
     */
    public ValidatorGroup() {
        validators = new ArrayList<>();
    }

    /**
     * Aggiunge un nuovo validator.
     *
     * @param validator da aggiungere
     */
    public void addValidator(final Validator validator) {
        validators.add(validator);
    }

    /**
     * Permette di validare i campi di ValidatorCampo.
     *
     * @return true se e solo se tutti i campi sono validi,
     *         false altrimenti
     * @throws RuntimeException
     * @since 0.0.1
     */
    public void valida() throws RuntimeException {
        for (Validator validator : validators) {
            validator.valida();
        }
    }
}
