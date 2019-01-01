package it.unisa.ackc.gestione_pratiche.entity;

import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;


/**
 * Rappresenta l'insieme dei documenti necessari
 * per richiedere l'approvazione del riconoscimento dei CFU.
 * La pratica ha uno stato
 * {@see it.unisa.ackc.gestione_pratiche.entity.Pratica.Stato}.
 *
 * @version 0.1.1
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllPratiche",
                query = "SELECT p FROM Pratica p"),
        @NamedQuery(name = "findPraticaById",
                query = "SELECT p FROM Pratica p WHERE p.id= :id"),
        @NamedQuery(name = "findPraticheByTipo",
                query = "SELECT p FROM Pratica p WHERE p.tipo=:tipo"),
        @NamedQuery(name = "findPraticheByStato",
                query = "SELECT p FROM Pratica p WHERE p.stato=:stato")
})
public class Pratica implements Serializable {
    /**
     * Id della pratica.
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Stato della pratica.
     */
    @Enumerated(EnumType.STRING)
    private Stato stato;
    /**
     * Tipo della pratica.
     */
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    /**
     * Domanda allegata alla pratica.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Domanda domanda;
    /**
     * Attestato allegato alla pratica.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Attestato attestato;
    /**
     * Account studente che ha aperto la pratica.
     */
    @ManyToOne
    @JoinColumn
    private AccountStudente accountStudente;
    /**
     * Messaggio dello studente associato alla pratica.
     */
    private String messaggioStudente;
    /**
     * Messaggio del responsabile ufficio associato alla pratica.
     */
    private String messaggioResponsabileUfficio;
    /**
     * Data di creazione della pratica.
     */
    private Date dataCreazione;
    /**
     * Data di aggiornamento della pratica.
     */
    private Date dataAggiornamento;

    /**
     * Permette di istanziare
     * un oggetto di tipo <code>Pratica</code>.
     *
     * @since 0.0.1
     */
    public Pratica() {
    }

    /**
     * Permette di istanziare
     * un oggetto di tipo <code>Pratica</code>, specificandone gli attributi.
     *
     * @param aDomanda domanda da allegare alla pratica
     * @param aAttestato attestato da allegare alla pratica
     * @param aMessaggioStudente messaggio dello studente associto alla pratica
     * @since 0.0.1
     */
    public Pratica(final Domanda aDomanda,
                   final Attestato aAttestato,
                   final String aMessaggioStudente) {
        this.dataCreazione = new Date();
        this.dataAggiornamento = new Date();
        this.stato = Stato.IN_ATTESA;
        this.domanda = aDomanda;
        this.attestato = aAttestato;
        this.messaggioStudente = aMessaggioStudente;
    }

    /**
     * Restituisce
     * l'id della pratica.
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * Restituisce
     * la domanda associata alla pratica.
     *
     * @return domanda
     * @since 0.0.1
     */
    public Domanda getDomanda() {
        return domanda;
    }

    /**
     * Permette di associare
     * una domanda alla pratica.
     *
     * @param aDomanda nuova domanda
     * @since 0.0.1
     */
    public void setDomanda(final Domanda aDomanda) {
        this.domanda = aDomanda;
    }

    /**
     * Restituisce
     * l'attestato associato alla pratica.
     *
     * @return attestato
     * @since 0.0.1
     */
    public Attestato getAttestato() {
        return attestato;
    }

    /**
     * Permette di associare
     * un attestato alla pratica.
     *
     * @param aAttestato nuovo attestato
     * @since 0.0.1
     */
    public void setAttestato(final Attestato aAttestato) {
        this.attestato = aAttestato;
    }

    /**
     * Restituisce
     * lo stato della pratica.
     *
     * @return stato
     * @since 0.0.1
     */
    public Stato getStato() {
        return stato;
    }

    /**
     * Permette di impostare
     * uno stato alla pratica.
     *
     * @param aStato nuovo stato
     * @since 0.0.1
     */
    public void setStato(final Stato aStato) {
        this.stato = aStato;
    }

    /**
     * Restituisce
     * il messaggio dello studente associato alla pratica.
     *
     * @return messaggioStudente
     * @since 0.0.1
     */
    public String getMessaggioStudente() {
        return messaggioStudente;
    }

    /**
     * Permette di associare alla pratica
     * un messaggio dello studente.
     *
     * @param aMessaggioStudente nuovo messaggio da parte dello studente
     * @since 0.0.1
     */
    public void setMessaggioStudente(final String aMessaggioStudente) {
        this.messaggioStudente = aMessaggioStudente;
    }

    /**
     * Restituisce
     * il messaggio del responsabile ufficio associato alla pratica.
     *
     * @return messaggioResponsabileUfficio
     * @since 0.0.1
     */
    public String getMessaggioResponsabileUfficio() {
        return messaggioResponsabileUfficio;
    }

    /**
     * Permette di associare alla pratica
     * un messaggio del responsabile ufficio.
     *
     * @param aMessaggioResponsabileUfficio nuovo messaggio
     *                                      del responsabile ufficio
     * @since 0.0.1
     */
    public void setMessaggioResponsabileUfficio(
            final String aMessaggioResponsabileUfficio) {
        this.messaggioResponsabileUfficio = aMessaggioResponsabileUfficio;
    }

    /**
     * Restituisce
     * la data di creazione della pratica.
     *
     * @return dataCreazione
     * @since 0.0.1
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Permette di impostare
     * la data di creazione della pratica.
     *
     * @param aDataCreazione nuova data di creazione
     * @since 0.0.1
     */
    public void setDataCreazione(final Date aDataCreazione) {
        this.dataCreazione = aDataCreazione;
    }

    /**
     * Restituisce
     * la data di aggiornamento della pratica.
     *
     * @return dataAggiornamento
     * @since 0.0.1
     */
    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Permette di impostare
     * la data di aggiornamento della pratica.
     *
     * @param aDataAggiornamento nuova data di aggiornamento
     * @since 0.0.1
     */
    public void setDataAggiornamento(final Date aDataAggiornamento) {
        this.dataAggiornamento = aDataAggiornamento;
    }

    /**
     * Restituisce
     * il tipo della pratica.
     *
     * @return tipo
     * @since 0.0.1
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Permette di impostare
     * il tipo della pratica.
     *
     * @param aTipo nuovo tipo
     * @since 0.0.1
     */
    public void setTipo(final Tipo aTipo) {
        this.tipo = aTipo;
    }
    /**
     * Permette di associare
     * una pratica ad un account studente.
     *
     * @param aAccountStudente che ha aperto la pratica
     * @since 0.1.1
     */
    public void setAccountStudente(final AccountStudente aAccountStudente) {
        this.accountStudente = aAccountStudente;
    }
    /**
     * Restituisce
     * l'account studente associato alla pratica.
     *
     * @return account studente
     * @since 0.1.1
     */
    public AccountStudente getAccountStudente() {
        return accountStudente;
    }
    /**
     * Possibili stati di una pratica.
     * Una pratica è considerata aperta se nello stato di attesa o sospesa.
     * Una pratica è considerata chiusa se bocciata o approvata.
     *
     * <ul>
     * <li>{@link #BOCCIATA} Una pratica chiusa non approvata</li>
     * <li>{@link #APPROVATA} Una pratica chiusa approvata</li>
     * <li>{@link #SOSPESA} Una pratica aperta che richiede una modifica</li>
     * <li>{@link #IN_ATTESA} Una pratica aperta
     * di cui non è stata valutata la correttezza</li>
     * </ul>
     *
     * @version 0.0.1
     */
    public enum Stato {
        /**
         * Pratica valutata come bocciata.
         */
        BOCCIATA,
        /**
         * Pratica valutata come approvata.
         */
        APPROVATA,
        /**
         * Pratica valutata come sospesa,
         * richiede nuova sottomissione da parte dello studente.
         */
        SOSPESA,
        /**
         * Pratica sottomessa dallo studente e in attesa di valutazione.
         */
        IN_ATTESA
    }

    /**
     * Possibili tipologie della pratica:
     * <ul>
     * <li>{@link #LINGUA_INGLESE} Una pratica per riconoscimento di CFU
     * per l'attestazione di lingua inglese</li>
     * <li>{@link #ATTIVITA_LAVORATIVA} Una pratica per riconoscimento di CFU
     * per lo svolgimento di attività lavorativa</li>
     * </ul>.
     *
     * @version 0.0.1
     */
    public enum Tipo {
        /**
         * Pratica relativa ad
         * un'attestazione di lingua inglese.
         */
        LINGUA_INGLESE,
        /**
         * Pratica relativa ad
         * un'attestazione di attività lavorativa.
         */
        ATTIVITA_LAVORATIVA
    }

}
