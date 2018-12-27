package it.unisa.ackc.gestione_utenti.entity;


import java.util.Date;

/**
 * Rappresenta il concetto di account studente
 *
 * @version 0.0.1
 */
public class AccountStudente extends Account {

    private String matricola;
    private Date dataDiNascita;
    private String luogoDiNascita;
    private String indirizzoDiResidenza;
    private int numeroCivico;
    private String cap;
    private String citta;
    private String paese;
    private String tipologiaDiLaurea;
    private String corsoDiLaurea;
    private String annoDiImmatricolazione;

    /**
     * Permette di istanziare un oggetto di tipo <code>AccountStudente</code>
     *
     * @param email                  dell'account dello studente
     * @param password               dell'account dello studente
     * @param telefono               dello studente
     * @param nome                   dello studente
     * @param cognome                dello studente
     * @param sesso                  dello studente
     * @param matricola              dello studente
     * @param dataDiNascita          dello studente
     * @param luogoDiNascita         dello studente
     * @param indirizzoDiResidenza   dello studente
     * @param numeroCivico           dell'indirizzo di residenza dello studente
     * @param cap                    della città dello studente
     * @param citta                  dove vive lo studente
     * @param paese                  dove vive lo studente
     * @param tipologiaDiLaurea      dello studente
     * @param corsoDiLaurea          a cui lo studente è iscritto
     * @param annoDiImmatricolazione dello studente
     */
    public AccountStudente(String email, String password, String telefono, String nome, String cognome, Sesso sesso, String matricola, Date dataDiNascita, String luogoDiNascita, String indirizzoDiResidenza, int numeroCivico, String cap, String citta, String paese, String tipologiaDiLaurea, String corsoDiLaurea, String annoDiImmatricolazione) {
        super(email, password, telefono, nome, cognome, Ruolo.STUDENTE, sesso);
        this.matricola = matricola;
        this.dataDiNascita = dataDiNascita;
        this.luogoDiNascita = luogoDiNascita;
        this.indirizzoDiResidenza = indirizzoDiResidenza;
        this.numeroCivico = numeroCivico;
        this.cap = cap;
        this.citta = citta;
        this.paese = paese;
        this.tipologiaDiLaurea = tipologiaDiLaurea;
        this.corsoDiLaurea = corsoDiLaurea;
        this.annoDiImmatricolazione = annoDiImmatricolazione;
    }

    /**
     * Restituisce la matricola dello studente
     *
     * @return matricola
     * @since 0.0.1
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * Permette di impostare la matricola dello studente
     *
     * @param matricola
     * @since 0.0.1
     */
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * Restituisce la data di nascita dello studente
     *
     * @return dataDiNascita
     * @since 0.0.1
     */
    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * Permette di impostare la data di nascita dello studente
     *
     * @param dataDiNascita
     * @since 0.0.1
     */
    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    /**
     * Restituisce il luogo di nascita dello studente
     *
     * @return luogoDiNascita
     * @since 0.0.1
     */
    public String getLuogoDiNascita() {
        return luogoDiNascita;
    }

    /**
     * Permette di impostare il luogo di nascita dello studente
     *
     * @param luogoDiNascita
     * @since 0.0.1
     */
    public void setLuogoDiNascita(String luogoDiNascita) {
        this.luogoDiNascita = luogoDiNascita;
    }

    /**
     * Restituisce l'indirizzo di residenza dello studente
     *
     * @return indirizzoDiResidenza
     * @since 0.0.1
     */
    public String getIndirizzoDiResidenza() {
        return indirizzoDiResidenza;
    }

    /**
     * Permette di impostare l'indirizzo di residenza dello studente
     *
     * @param indirizzoDiResidenza
     * @since 0.0.1
     */
    public void setIndirizzoDiResidenza(String indirizzoDiResidenza) {
        this.indirizzoDiResidenza = indirizzoDiResidenza;
    }

    /**
     * Restituisce il numero civico dell'indirizzo di residenza dello studente
     *
     * @return numeroCivico
     * @since 0.0.1
     */
    public int getNumeroCivico() {
        return numeroCivico;
    }

    /**
     * Permette di impostare il numero civico dell'indirizzo di residenza dello studente
     *
     * @param numeroCivico
     * @since 0.0.1
     */
    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    /**
     * Restituisce il cap della città dello studente
     *
     * @return cap
     * @since 0.0.1
     */
    public String getCap() {
        return cap;
    }

    /**
     * Permette di impostare il cap della città dello studente
     *
     * @param cap
     * @since 0.0.1
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     * Restituisce la città dove vive lo studente
     *
     * @return citta
     * @since 0.0.1
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Permette di impostare la città dove vive lo studente
     *
     * @param citta
     * @since 0.0.1
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * Restituisce il paese dove vive lo studente
     *
     * @return paese
     * @since 0.0.1
     */
    public String getPaese() {
        return paese;
    }

    /**
     * Permette di impostare il paese dove vive lo studente
     *
     * @param paese
     * @since 0.0.1
     */
    public void setPaese(String paese) {
        this.paese = paese;
    }

    /**
     * Restituisce la tipologia di laurea dello studente
     *
     * @return tipologiaDiLaurea
     * @since 0.0.1
     */
    public String getTipologiaDiLaurea() {
        return tipologiaDiLaurea;
    }

    /**
     * Permette di impostare la tipologia di laurea dello studente
     *
     * @param tipologiaDiLaurea
     * @since 0.0.1
     */
    public void setTipologiaDiLaurea(String tipologiaDiLaurea) {
        this.tipologiaDiLaurea = tipologiaDiLaurea;
    }

    /**
     * Restituisce il corso di laurea a cui lo studente è iscritto
     *
     * @return corsoDiLaurea
     * @since 0.0.1
     */
    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    /**
     * Permette di impostare il corso di laurea a cui lo studente è iscritto
     *
     * @param corsoDiLaurea
     * @since 0.0.1
     */
    public void setCorsoDiLaurea(String corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }

    /**
     * Restituisce l'anno di immatricolazione dello studente
     *
     * @return annoDiImmatricolazione
     * @since 0.0.1
     */
    public String getAnnoDiImmatricolazione() {
        return annoDiImmatricolazione;
    }

    /**
     * Permette di impostare l'anno di immatricolazione dello studente
     *
     * @param annoDiImmatricolazione
     * @since 0.0.1
     */
    public void setAnnoDiImmatricolazione(String annoDiImmatricolazione) {
        this.annoDiImmatricolazione = annoDiImmatricolazione;
    }
}
