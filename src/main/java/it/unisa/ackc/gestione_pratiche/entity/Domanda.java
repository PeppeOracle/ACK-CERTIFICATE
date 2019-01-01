package it.unisa.ackc.gestione_pratiche.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Rappresenta la specifica di un attestazione.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}
 *
 * @version 0.1.2
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Domanda implements Serializable {
    /**
     * Id della pratica.
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Path del file della domanda.
     */
    private String path;
    /**
     * Data di creazione della domanda.
     */
    private Date dataCreazione;
    /**
     * Data di aggiornamento della domanda.
     */
    private Date dataAggiornamento;
    /**
     * Numero di cfu relativi all'attestazione.
     */
    private int numeroCfu;
    /**
     * Pratica che contiene la domanda.
     */
    @OneToOne(mappedBy = "domanda")
    private Pratica pratica;
    /**
     * Permette di istanziare
     * un oggetto di tipo <code>Domanda</code>.
     *
     * @since 0.0.1
     */
    public Domanda() {
        this.dataCreazione = new Date();
        this.dataAggiornamento = new Date();
    }

    /**
     * Permette di istanziare
     * un oggetto di tipo <code>Domanda</code>.
     *
     * @param aPath      percorso del file
     * @param aNumeroCfu numero di CFU di cui si richiede il riconoscimento
     * @since 0.0.1
     */
    public Domanda(final String aPath, final int aNumeroCfu) {
        this();
        this.path = aPath;
        this.numeroCfu = aNumeroCfu;
    }

    /**
     * Restituisce
     * l'id della domanda.
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * Restituisce
     * il path della domanda.
     *
     * @return path
     * @since 0.0.1
     */
    public String getPath() {
        return path;
    }

    /**
     * Permette di impostare
     * il path della domanda.
     *
     * @param aPath nuovo path
     * @since 0.0.1
     */
    public void setPath(final String aPath) {
        this.path = aPath;
    }

    /**
     * Restituisce
     * il numero di CFU della domanda.
     *
     * @return numeroCfu
     * @since 0.0.1
     */
    public int getNumeroCfu() {
        return numeroCfu;
    }

    /**
     * Permette di impostare
     * il numero di CFU della domanda.
     *
     * @param aNumeroCfu nuovo numero di cfu
     * @since 0.0.1
     */
    public void setNumeroCfu(final int aNumeroCfu) {
        this.numeroCfu = aNumeroCfu;
    }

    /**
     * Restituisce
     * la data di creazione della domanda.
     *
     * @return dataCreazione
     * @since 0.0.1
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Permette di impostare
     * la data di creazione della domanda.
     *
     * @param aDataCreazione nuova data di creazione
     * @since 0.0.1
     */
    public void setDataCreazione(final Date aDataCreazione) {
        this.dataCreazione = aDataCreazione;
    }

    /**
     * Restituisce
     * la data di aggiornamento della domanda.
     *
     * @return dataAggiornamento
     * @since 0.0.1
     */
    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Permette di impostare
     * la data di aggiornamento della domanda.
     *
     * @param aDataAggiornamento nuova data di aggiornamento
     * @since 0.0.1
     */
    public void setDataAggiornamento(final Date aDataAggiornamento) {
        this.dataAggiornamento = aDataAggiornamento;
    }

    /**
     * Permette di rimpiazzare i campi di una domanda.
     * @param aDomanda da cui prendere i campi
     * @since 0.1.1
     */
    public void replace(final Domanda aDomanda) {
        dataAggiornamento = aDomanda.getDataAggiornamento();
        dataCreazione = aDomanda.getDataCreazione();
        path = aDomanda.getPath();
        numeroCfu = aDomanda.getNumeroCfu();
    }
}
