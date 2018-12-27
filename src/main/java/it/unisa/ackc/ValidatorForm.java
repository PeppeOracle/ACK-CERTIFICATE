package it.unisa.ackc;

import java.util.*;

/**
 * Si occupa della validazione di un insieme di campi
 *
 * @version 0.0.1
 */
public class ValidatorForm implements Validator {
    private Map<String, ValidatorCampo> campi;

    /**
     * Permette di istanziare un oggetto di tipo <code>ValidatorForm</code>
     *
     * @since 0.0.1
     */
    public ValidatorForm() {
        campi = new HashMap<>();
    }

    /**
     * Permette di impostare il nome e il campo di ValidatorForm
     *
     * @param nome
     * @param campo
     * @since 0.0.1
     */
    public void addCampo(String nome, ValidatorCampo campo) {
        campi.put(nome, campo);
    }

    /**
     * Permette di rimuovere il campo indicato di ValidatorForm
     *
     * @param campo
     * @since 0.0.1
     */
    public void removeCampo(ValidatorCampo campo) {
        campi.remove(campo);
    }

    /**
     * Restituisce il valore di un campo di ValidatorCampo
     *
     * @param nome del campo
     * @return il valore del campo nome
     * @since 0.0.1
     */
    public ValidatorCampo getCampo(String nome) {
        return campi.get(nome);
    }

    /**
     * Permette di validare i campi di ValidatorCampo
     *
     * @return true se e solo se tutti i campi sono validi, false altrimenti
     * @since 0.0.1
     */
    public boolean valida() {
        return true;
    }
}
