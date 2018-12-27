package it.unisa.ackc.gestione_pratiche.entity;

import java.util.Date;

/**
 * Rappresenta un documento che attesta l'attività svolte e le conoscenze acquisite.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}
 *
 * @version 0.0.1
 */
public class Attestato {
    private String path;
    private Date dataCreazione;
    private Date dataAggiornamento;

    /**
     * Permette di istanziare un oggetto di tipo <code>Attestato</code>
     *
     * @since 0.0.1
     */
    public Attestato() {
        this.dataCreazione = new Date();
        this.dataAggiornamento = new Date();
    }

    /**
     * Permette di istanziare un oggetto di tipo <code>Attestato</code>
     *
     * @param path percorso del file
     * @since 0.0.1
     */
    public Attestato(String path) {
        this();
        this.path = path;
    }

    /**
     * Restituisce il path dell'attestato
     *
     * @return path
     * @since 0.0.1
     */
    public String getPath() {
        return path;
    }

    /**
     * Permette di impostare il path dell'attestato
     *
     * @param path
     * @since 0.0.1
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Restituisce la data di creazione dell'attestato
     *
     * @return dataCreazione
     * @since 0.0.1
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Permette di impostare la data di creazione dell'attestato
     *
     * @param dataCreazione
     * @since 0.0.1
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * Restituisce la data di aggiornamento dell'attestato
     *
     * @return dataAggiornamento
     * @since 0.0.1
     */
    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Permette di impostare la data di aggiornamento dell'attestato
     *
     * @param dataAggiornamento
     * @since 0.0.1
     */
    public void setDataAggiornamento(Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }
}
