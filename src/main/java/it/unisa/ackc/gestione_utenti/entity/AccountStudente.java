package it.unisa.ackc.gestione_utenti.entity;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Rappresenta il concetto di account studente.
 *
 * @version 0.1.1
 */
@Entity
public class AccountStudente extends Account {

    /**
     * Matricola dello studente.
     */
    private String matricola;
    /**
     * Data di nascita dello studente.
     */
    private Date dataDiNascita;
    /**
     * Luogo di nascita dello studente.
     */
    private String luogoDiNascita;
    /**
     * Indirizzo di residenza dello studente.
     */
    private String indirizzoDiResidenza;
    /**
     * Numero civido dell'indirizzo di residenza dello studente.
     */
    private int numeroCivico;
    /**
     * Cap della città dello studente.
     */
    private String cap;
    /**
     * Città di residenza dello studente.
     */
    private String citta;
    /**
     * Paese di residenza dello studente.
     */
    private String paese;
    /**
     * Tipologia di laurea dello studente.
     */
    private String tipologiaDiLaurea;
    /**
     * Corso di laurea dello studente.
     */
    private String corsoDiLaurea;
    /**
     * Anno di immatricolazione dello studente.
     */
    private String annoDiImmatricolazione;
    /**
     * Pratiche create.
     */
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "accountStudente")
    private List<Pratica> pratiche;

    /**
     * Permette di istanziare un oggetto di tipo <code>AccountStudente</code>.
     *
     * @param aEmail                  dell'account dello studente
     * @param aPassword               dell'account dello studente
     * @param aTelefono               dello studente
     * @param aNome                   dello studente
     * @param aCognome                dello studente
     * @param aSesso                  dello studente
     * @param aMatricola              dello studente
     * @param aDataDiNascita          dello studente
     * @param aLuogoDiNascita         dello studente
     * @param aIndirizzoDiResidenza   dello studente
     * @param aNumeroCivico           dell'indirizzo di residenza dello studente
     * @param aCap                    della città dello studente
     * @param aCitta                  dove vive lo studente
     * @param aPaese                  dove vive lo studente
     * @param aTipologiaDiLaurea      dello studente
     * @param aCorsoDiLaurea          a cui lo studente è iscritto
     * @param aAnnoDiImmatricolazione dello studente
     */
    public AccountStudente(final String aEmail,
                           final String aPassword,
                           final String aTelefono,
                           final String aNome,
                           final String aCognome,
                           final Sesso aSesso,
                           final String aMatricola,
                           final Date aDataDiNascita,
                           final String aLuogoDiNascita,
                           final String aIndirizzoDiResidenza,
                           final int aNumeroCivico,
                           final String aCap,
                           final String aCitta,
                           final String aPaese,
                           final String aTipologiaDiLaurea,
                           final String aCorsoDiLaurea,
                           final String aAnnoDiImmatricolazione) {
        super(aEmail,
                aPassword,
                aTelefono,
                aNome,
                aCognome,
                Ruolo.STUDENTE,
                aSesso);
        this.pratiche = new ArrayList<>();
        this.matricola = aMatricola;
        this.dataDiNascita = aDataDiNascita;
        this.luogoDiNascita = aLuogoDiNascita;
        this.indirizzoDiResidenza = aIndirizzoDiResidenza;
        this.numeroCivico = aNumeroCivico;
        this.cap = aCap;
        this.citta = aCitta;
        this.paese = aPaese;
        this.tipologiaDiLaurea = aTipologiaDiLaurea;
        this.corsoDiLaurea = aCorsoDiLaurea;
        this.annoDiImmatricolazione = aAnnoDiImmatricolazione;
    }
    /**
     * Costruttore di default.
     */
    public AccountStudente() {
        this.pratiche = new ArrayList<>();
    }
    /**
     * Restituisce
     * la matricola dello studente.
     *
     * @return matricola
     * @since 0.0.1
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * Permette di impostare
     * la matricola dello studente.
     *
     * @param aMatricola nuova matricola
     * @since 0.0.1
     */
    public void setMatricola(final String aMatricola) {
        this.matricola = aMatricola;
    }

    /**
     * Restituisce
     * la data di nascita dello studente.
     *
     * @return dataDiNascita
     * @since 0.0.1
     */
    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * Permette di impostare
     * la data di nascita dello studente.
     *
     * @param aDataDiNascita nuova data di nascita
     * @since 0.0.1
     */
    public void setDataDiNascita(final Date aDataDiNascita) {
        this.dataDiNascita = aDataDiNascita;
    }

    /**
     * Restituisce
     * il luogo di nascita dello studente.
     *
     * @return luogoDiNascita
     * @since 0.0.1
     */
    public String getLuogoDiNascita() {
        return luogoDiNascita;
    }

    /**
     * Permette di impostare
     * il luogo di nascita dello studente.
     *
     * @param aLuogoDiNascita nuovo luogo di nascita
     * @since 0.0.1
     */
    public void setLuogoDiNascita(final String aLuogoDiNascita) {
        this.luogoDiNascita = aLuogoDiNascita;
    }

    /**
     * Restituisce
     * l'indirizzo di residenza dello studente.
     *
     * @return indirizzoDiResidenza
     * @since 0.0.1
     */
    public String getIndirizzoDiResidenza() {
        return indirizzoDiResidenza;
    }

    /**
     * Permette di impostare
     * l'indirizzo di residenza dello studente.
     *
     * @param aIndirizzoDiResidenza nuovo indirizzo di residenza
     * @since 0.0.1
     */
    public void setIndirizzoDiResidenza(final String aIndirizzoDiResidenza) {
        this.indirizzoDiResidenza = aIndirizzoDiResidenza;
    }

    /**
     * Restituisce il numero civico dell'indirizzo di residenza dello studente.
     *
     * @return numeroCivico
     * @since 0.0.1
     */
    public int getNumeroCivico() {
        return numeroCivico;
    }

    /**
     * Permette di impostare
     * il numero civico dell'indirizzo di residenza dello studente.
     *
     * @param aNumeroCivico nuovo numero civico
     * @since 0.0.1
     */
    public void setNumeroCivico(final int aNumeroCivico) {
        this.numeroCivico = aNumeroCivico;
    }

    /**
     * Restituisce
     * il cap della città dello studente.
     *
     * @return cap
     * @since 0.0.1
     */
    public String getCap() {
        return cap;
    }

    /**
     * Permette di impostare
     * il cap della città dello studente.
     *
     * @param aCap nuovo cap
     * @since 0.0.1
     */
    public void setCap(final String aCap) {
        this.cap = aCap;
    }

    /**
     * Restituisce
     * la città dove vive lo studente.
     *
     * @return citta
     * @since 0.0.1
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Permette di impostare
     * la città dove vive lo studente.
     *
     * @param aCitta nuova città
     * @since 0.0.1
     */
    public void setCitta(final String aCitta) {
        this.citta = aCitta;
    }

    /**
     * Restituisce
     * il paese dove vive lo studente.
     *
     * @return paese
     * @since 0.0.1
     */
    public String getPaese() {
        return paese;
    }

    /**
     * Permette di impostare
     * il paese dove vive lo studente.
     *
     * @param aPaese nuovo parametro
     * @since 0.0.1
     */
    public void setPaese(final String aPaese) {
        this.paese = aPaese;
    }

    /**
     * Restituisce
     * la tipologia di laurea dello studente.
     *
     * @return tipologiaDiLaurea
     * @since 0.0.1
     */
    public String getTipologiaDiLaurea() {
        return tipologiaDiLaurea;
    }

    /**
     * Permette di impostare
     * la tipologia di laurea dello studente.
     *
     * @param aTipologiaDiLaurea nuova tipologia di laurea
     * @since 0.0.1
     */
    public void setTipologiaDiLaurea(final String aTipologiaDiLaurea) {
        this.tipologiaDiLaurea = aTipologiaDiLaurea;
    }

    /**
     * Restituisce
     * il corso di laurea a cui lo studente è iscritto.
     *
     * @return corsoDiLaurea
     * @since 0.0.1
     */
    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    /**
     * Permette di impostare
     * il corso di laurea a cui lo studente è iscritto.
     *
     * @param aCorsoDiLaurea nuovo corso di laurea
     * @since 0.0.1
     */
    public void setCorsoDiLaurea(final String aCorsoDiLaurea) {
        this.corsoDiLaurea = aCorsoDiLaurea;
    }

    /**
     * Restituisce
     * l'anno di immatricolazione dello studente.
     *
     * @return annoDiImmatricolazione
     * @since 0.0.1
     */
    public String getAnnoDiImmatricolazione() {
        return annoDiImmatricolazione;
    }

    /**
     * Permette di impostare
     * l'anno di immatricolazione dello studente.
     *
     * @param aAnnoDiImmatricolazione nuovo anno di immatricolazione
     * @since 0.0.1
     */
    public void setAnnoDiImmatricolazione(
            final String aAnnoDiImmatricolazione) {
        this.annoDiImmatricolazione = aAnnoDiImmatricolazione;
    }
    /**
     * Restituisce
     * l'anno di immatricolazione dello studente.
     *
     * @return pratiche
     * @since 0.1.1
     */
    public List<Pratica> getPratiche() {
        return pratiche;
    }
    /**
     * Permette di aggiungere
     * una pratica all'account studente.
     *
     * @param pratica da aggiungere
     * @since 0.1.1
     */
    public void addPratica(final Pratica pratica) {
        pratiche.add(pratica);
        pratica.setAccountStudente(this);
    }
    /**
     * Permette di rimuovere
     * una pratica dall'account studente.
     *
     * @param pratica da aggiungere
     * @since 0.1.1
     */
    public void removePratica(final Pratica pratica) {
        pratiche.remove(pratica);
        pratica.setAccountStudente(null);
    }
}
