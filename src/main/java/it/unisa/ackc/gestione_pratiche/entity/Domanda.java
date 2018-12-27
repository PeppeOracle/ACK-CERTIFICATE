package it.unisa.ackc.gestione_pratiche.entity;

import java.util.Date;

/**
 * Rappresenta la specifica di un attestazione.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}
 *
 * @version 0.0.1
 */
public abstract class Domanda {
    private String path;
    private Date dataCreazione;
    private Date dataAggiornamento;
    private int numeroCfu;

    /**
     * Permette di istanziare un oggetto di tipo <code>Domanda</code>
     *
     * @since 0.0.1
     */
    public Domanda() {
        this.dataCreazione = new Date();
        this.dataAggiornamento = new Date();
    }

    /**
     * Permette di istanziare un oggetto di tipo <code>Domanda</code>
     *
     * @param path      percorso del file
     * @param numeroCfu numero di CFU di cui si richiede il riconoscimento
     * @since 0.0.1
     */
    public Domanda(String path, int numeroCfu) {
        this();
        this.path = path;
        this.numeroCfu = numeroCfu;
    }

    /**
     * Restituisce il path della domanda
     *
     * @return path
     * @since 0.0.1
     */
    public String getPath() {
        return path;
    }

    /**
     * Permette di impostare il path della domanda
     *
     * @param path
     * @since 0.0.1
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Restituisce il numero di CFU della domanda
     *
     * @return numeroCfu
     * @since 0.0.1
     */
    public int getNumeroCfu() {
        return numeroCfu;
    }

    /**
     * Permette di impostare il numero di CFU della domanda
     *
     * @param numeroCfu
     * @since 0.0.1
     */
    public void setNumeroCfu(int numeroCfu) {
        this.numeroCfu = numeroCfu;
    }

    /**
     * Restituisce la data di creazione della domanda
     *
     * @return dataCreazione
     * @since 0.0.1
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Permette di impostare la data di creazione della domanda
     *
     * @param dataCreazione
     * @since 0.0.1
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * Restituisce la data di aggiornamento della domanda
     *
     * @return dataAggiornamento
     * @since 0.0.1
     */
    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Permette di impostare la data di aggiornamento della domanda
     *
     * @param dataAggiornamento
     * @since 0.0.1
     */
    public void setDataAggiornamento(Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }
}
