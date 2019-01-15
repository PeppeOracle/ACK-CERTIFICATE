package it.unisa.ackc.gestione_utenti.entity;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;

import java.util.List;
import javax.persistence.Entity;

/**
 * Rappresenta il concetto di account responsabile ufficio.
 *
 * @version 0.0.1
 */
@Entity
public class AccountResponsabileUfficio extends Account {
    /**
     *  Campus dove si trova l'ufficio del responsabile ufficio.
     */
    private String campus;
    /**
     *  Edificio dove si trova l'ufficio del responsabile ufficio.
     */
    private String edificio;
    /**
     *  Piano dove si trova l'ufficio del responsabile ufficio.
     */
    private int piano;
    /**
     *  Numero di stanza dove si trova l'ufficio del responsabile ufficio.
     */
    private int numeroStanza;

    /**
     * {@see it.unisa.ackc.gestione_pratiche.entity.Pratica.Tipo}.
     */
    private List<Pratica.Tipo> tipologiaPraticaDaGestire;

    /**
     * Permette di istanziare un oggetto di tipo
     * <code>AccountResponsabileUfficio</code>.
     *
     * @param aEmail dell'account del responsabile ufficio
     * @param aPassword dell'account del responsabile ufficio
     * @param aTelefono del responsabile ufficio
     * @param aNome del responsabile ufficio
     * @param aCognome del responsabile ufficio
     * @param aSesso del responsabile ufficio
     * @param aCampus dove si trova l'ufficio del responsabile ufficio
     * @param aEdificio dove si trova l'ufficio del responsabile ufficio
     * @param aPiano dove si trova l'ufficio del responsabile ufficio
     * @param aNumeroStanza dell'ufficio del responsabile ufficio
     * @param aTipologiaPraticaDaGestire da parte del responsabile ufficio
     * @version 0.0.1
     */
    public AccountResponsabileUfficio(final String aEmail,
                                      final String aPassword,
                                      final String aTelefono,
                                      final String aNome,
                                      final String aCognome,
                                      final Sesso aSesso,
                                      final String aCampus,
                                      final String aEdificio,
                                      final int aPiano,
                                      final int aNumeroStanza,
                                      final List<Pratica.Tipo>
                                              aTipologiaPraticaDaGestire) {
        super(aEmail,
                aPassword,
                aTelefono,
                aNome, aCognome,
                Ruolo.RESPONSABILE_UFFICIO,
                aSesso);
        this.campus = aCampus;
        this.edificio = aEdificio;
        this.piano = aPiano;
        this.numeroStanza = aNumeroStanza;
        this.tipologiaPraticaDaGestire = aTipologiaPraticaDaGestire;
    }
    /**
     * Costruttore di default.
     */
    public AccountResponsabileUfficio() { }

    /**
     * Restituisce
     * il campus dell'ufficio del responsabile ufficio.
     *
     * @return campus
     * @since 0.0.1
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Permette di impostare
     * il campus dell'ufficio del responsabile ufficio.
     *
     * @param aCampus nuovo campus
     * @since 0.0.1
     */
    public void setCampus(final String aCampus) {
        this.campus = aCampus;
    }

    /**
     * Restituisce
     * l'edificio dell'ufficio del responsabile ufficio.
     *
     * @return edificio
     * @since 0.0.1
     */
    public String getEdificio() {
        return edificio;
    }

    /**
     * Permette di impostare
     * l'edificio dell'ufficio del responsabile ufficio.
     *
     * @param aEdificio nuovo edificio
     * @since 0.0.1
     */
    public void setEdificio(final String aEdificio) {
        this.edificio = aEdificio;
    }

    /**
     * Restituisce
     * il piano dell'ufficio del responsabile ufficio.
     *
     * @return piano
     * @since 0.0.1
     */
    public int getPiano() {
        return piano;
    }

    /**
     * Permette di impostare
     * il piano dell'ufficio del responsabile ufficio.
     *
     * @param aPiano nuovo piano
     * @since 0.0.1
     */
    public void setPiano(final int aPiano) {
        this.piano = aPiano;
    }

    /**
     * Restituisce
     * il numero della stanza dell'ufficio del responsabile ufficio.
     *
     * @return numeroStanza
     * @since 0.0.1
     */
    public int getNumeroStanza() {
        return numeroStanza;
    }

    /**
     * Permette di impostare
     * il numero della stanza dell'ufficio del responsabile ufficio.
     *
     * @param aNumeroStanza nuovo numero di stanza
     * @since 0.0.1
     */
    public void setNumeroStanza(final int aNumeroStanza) {
        this.numeroStanza = aNumeroStanza;
    }

    /**
     * Restituisce
     * il tipo di pratica gestita dal responsabile ufficio.
     *
     * @return tipologiaPraticaDaGestire
     * @since 0.0.1
     */
    public List<Pratica.Tipo> getTipologiaPraticaDaGestire() {
        return tipologiaPraticaDaGestire;
    }

    /**
     * Permette di impostare
     * il campus del responsabile ufficio.
     *
     * @param aTipologiaPraticaDaGestire nuove tipologie di pratica da gestire
     * @since 0.0.1
     */
    public void setTipologiaPraticaDaGestire(
            final List<Pratica.Tipo> aTipologiaPraticaDaGestire) {
        this.tipologiaPraticaDaGestire = aTipologiaPraticaDaGestire;
    }
}
