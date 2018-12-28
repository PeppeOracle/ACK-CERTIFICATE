package it.unisa.ackc.validator;

/**
 * Definisce la validazione di un singolo campo
 *
 * @param <T>
 * @version 0.0.1
 */
public abstract class ValidatorCampo<T> implements Validator {
    private String nome;
    private T valore;

    /**
     * Permette di istanziare un oggetto di tipo <code>ValidatorCampo</code>
     *
     * @param aValore del campo
     * @since 0.0.1
     */
    public ValidatorCampo(String aNome, T aValore) {
        this.valore = aValore;
        this.nome = aNome;
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
     * @param aValore
     * @since 0.0.1
     */
    public void setValore(T aValore) {
        this.valore = aValore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}