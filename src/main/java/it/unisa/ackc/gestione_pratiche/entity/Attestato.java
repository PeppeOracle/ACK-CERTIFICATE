package it.unisa.ackc.gestione_pratiche.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Rappresenta un documento che attesta
 * le attività svolte e le conoscenze acquisite
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}.
 *
 * @version 0.0.3
 */
@Entity
public class Attestato implements Serializable {
    /**
     * Id della pratica.
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Path del file dell'attestato.
     */
    private String path;
    /**
     * Data di creazione dell'attestato.
     */
    private Date dataCreazione;
    /**
     * Data di aggiornamento dell'attestato.
     */
    private Date dataAggiornamento;

    /**
     * Pratica che contiene l'attestato.
     */
    @OneToOne(mappedBy = "attestato")
    private Pratica pratica;
    /**
     * Permette di istanziare
     * un oggetto di tipo <code>Attestato</code>.
     *
     * @since 0.0.1
     */
    public Attestato() {
        this.dataCreazione = new Date();
        this.dataAggiornamento = new Date();
    }

    /**
     * Permette di istanziare
     * un oggetto di tipo <code>Attestato</code>.
     *
     * @param aPath percorso del file
     * @since 0.0.1
     */
    public Attestato(final String aPath) {
        this();
        this.path = aPath;
    }

    /**
     * Restituisce
     * l'id dell'attestato.
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * Restituisce
     * il path dell'attestato.
     *
     * @return path
     * @since 0.0.1
     */
    public String getPath() {
        return path;
    }

    /**
     * Permette di impostare
     * il path dell'attestato.
     *
     * @param aPath nuovo path
     * @since 0.0.1
     */
    public void setPath(final String aPath) {
        this.path = aPath;
    }

    /**
     * Restituisce
     * la data di creazione dell'attestato.
     *
     * @return dataCreazione
     * @since 0.0.1
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Permette di impostare
     * la data di creazione dell'attestato.
     *
     * @param aDataCreazione uova data di creazione
     * @since 0.0.1
     */
    public void setDataCreazione(final Date aDataCreazione) {
        this.dataCreazione = aDataCreazione;
    }

    /**
     * Restituisce
     * la data di aggiornamento dell'attestato.
     *
     * @return dataAggiornamento
     * @since 0.0.1
     */
    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Permette di impostare
     * la data di aggiornamento dell'attestato.
     *
     * @param aDataAggiornamento nuova data di aggiornamento
     * @since 0.0.1
     */
    public void setDataAggiornamento(final Date aDataAggiornamento) {
        this.dataAggiornamento = aDataAggiornamento;
    }
}
