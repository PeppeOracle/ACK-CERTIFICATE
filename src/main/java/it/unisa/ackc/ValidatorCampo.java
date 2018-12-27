package it.unisa.ackc;

/**
 * Definisce la validazione di un singolo campo
 *
 * @param <T>
 * @version 0.0.1
 */
public abstract class ValidatorCampo<T> implements Validator {
    protected T valore;

    /**
     * Permette di istanziare un oggetto di tipo <code>ValidatorCampo</code>
     *
     * @param valore del campo
     * @since 0.0.1
     */
    public ValidatorCampo(T valore) {
        this.valore = valore;
    }

    /**
     * Restituisce il valore di ValidatorCampo
     *
     * @return valore
     * @since 0.0.1
     */
    public T getValore() {
        return valore;
    }

    /**
     * Permette di impostare il valore di ValidatorCampo
     *
     * @param valore
     * @since 0.0.1
     */
    public void setValore(T valore) {
        this.valore = valore;
    }
}
