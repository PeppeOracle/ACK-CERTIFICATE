package it.unisa.ackc.gestione_pratiche.entity;

import java.util.Date;

/**
 * Rappresenta l'insieme dei documenti necessari per richiedere l'approvazione del riconoscimento dei CFU.
 * La pratica ha uno stato {@see it.unisa.ackc.gestione_pratiche.entity.Pratica.Stato}
 *
 * @version 0.0.1
 */
public class Pratica {
    private Stato stato;
    private Tipo tipo;
    private Domanda domanda;
    private Attestato attestato;
    private String messaggioStudente;
    private String messaggioResponsabileUfficio;
    private Date dataCreazione;
    private Date dataAggiornamento;

    /**
     * Permette di istanziare un oggetto di tipo <code>Pratica</code>
     *
     * @since 0.0.1
     */
    public Pratica() {
        this.dataCreazione = new Date();
        this.dataAggiornamento = new Date();
    }

    /**
     * Permette di istanziare un oggetto di tipo <code>Pratica</code>, specificandone gli attributi.
     *
     * @param domanda           domanda da allegare alla pratica
     * @param attestato         attestato da allegare alla pratica
     * @param messaggioStudente messaggio dello studente associto alla pratica
     * @since 0.0.1
     */
    public Pratica(Domanda domanda, Attestato attestato, String messaggioStudente) {
        this();
        this.stato = Stato.IN_ATTESA;
        this.domanda = domanda;
        this.attestato = attestato;
        this.messaggioStudente = messaggioStudente;
    }

    /**
     * Restituisce la domanda associata alla pratica
     *
     * @return domanda
     * @since 0.0.1
     */
    public Domanda getDomanda() {
        return domanda;
    }

    /**
     * Permette di associare una domanda alla pratica
     *
     * @param domanda
     * @since 0.0.1
     */
    public void setDomanda(Domanda domanda) {
        this.domanda = domanda;
    }

    /**
     * Restituisce l'attestato associato alla pratica
     *
     * @return attestato
     * @since 0.0.1
     */
    public Attestato getAttestato() {
        return attestato;
    }

    /**
     * Permette di associare un attestato alla pratica
     *
     * @param attestato
     * @since 0.0.1
     */
    public void setAttestato(Attestato attestato) {
        this.attestato = attestato;
    }

    /**
     * Restituisce lo stato della pratica
     *
     * @return stato
     * @since 0.0.1
     */
    public Stato getStato() {
        return stato;
    }

    /**
     * Permette di impostare uno stato alla pratica
     *
     * @param stato
     * @since 0.0.1
     */
    public void setStato(Stato stato) {
        this.stato = stato;
    }

    /**
     * Restituisce il messaggio dello studente associato alla pratica
     *
     * @return messaggioStudente
     * @since 0.0.1
     */
    public String getMessaggioStudente() {
        return messaggioStudente;
    }

    /**
     * Permette di associare alla pratica un messaggio dello studente
     *
     * @param messaggioStudente
     * @since 0.0.1
     */
    public void setMessaggioStudente(String messaggioStudente) {
        this.messaggioStudente = messaggioStudente;
    }

    /**
     * Restituisce il messaggio del responsabile ufficio associato alla pratica
     *
     * @return messaggioResponsabileUfficio
     * @since 0.0.1
     */
    public String getMessaggioResponsabileUfficio() {
        return messaggioResponsabileUfficio;
    }

    /**
     * Permette di associare alla pratica un messaggio del responsabile ufficio
     *
     * @param messaggioResponsabileUfficio
     * @since 0.0.1
     */
    public void setMessaggioResponsabileUfficio(String messaggioResponsabileUfficio) {
        this.messaggioResponsabileUfficio = messaggioResponsabileUfficio;
    }

    /**
     * Restituisce la data di creazione della pratica
     *
     * @return dataCreazione
     * @since 0.0.1
     */
    public Date getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Permette di impostare la data di creazione della pratica
     *
     * @param dataCreazione
     * @since 0.0.1
     */
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    /**
     * Restituisce la data di aggiornamento della pratica
     *
     * @return dataAggiornamento
     * @since 0.0.1
     */
    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Permette di impostare la data di aggiornamento della pratica
     *
     * @param dataAggiornamento
     * @since 0.0.1
     */
    public void setDataAggiornamento(Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }

    /**
     * Restituisce il tipo della pratica
     *
     * @return tipo
     * @since 0.0.1
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Permette di impostare il tipo della pratica
     *
     * @param tipo
     * @since 0.0.1
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Possibili stati di una pratica. Una pratica è considerata aperta se nello stato di attesa o sospesa.
     * Una pratica è considerata chiusa se bocciata o approvata.
     *
     * <ul>
     * <li>{@link #BOCCIATA} Una pratica chiusa non approvata</li>
     * <li>{@link #APPROVATA} Una pratica chiusa approvata</li>
     * <li>{@link #SOSPESA} Una pratica aperta che richiede una modifica</li>
     * <li>{@link #IN_ATTESA} Una pratica aperta di cui non è stata valutata la correttezza</li>
     * </ul>
     *
     * @version 0.0.1
     */
    public enum Stato {
        BOCCIATA,
        APPROVATA,
        SOSPESA,
        IN_ATTESA
    }

    /**
     * Possibili tipologie della pratica:
     * <ul>
     * <li>{@link #LINGUA_INGLESE} Una pratica per riconoscimento di CFU per l'attestazione di lingua inglese</li>
     * <li>{@link #ATTIVITA_LAVORATIVA} Una pratica per riconoscimento di CFU per lo svolgimento di attività lavorativa</li>
     * </ul>
     *
     * @version 0.0.1
     */
    public enum Tipo {
        LINGUA_INGLESE,
        ATTIVITA_LAVORATIVA
    }

}
