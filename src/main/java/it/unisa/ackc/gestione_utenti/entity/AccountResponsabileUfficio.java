package it.unisa.ackc.gestione_utenti.entity;


import it.unisa.ackc.gestione_pratiche.entity.Pratica;

import java.util.ArrayList;

/**
 * Rappresenta il concetto di account responsabile ufficio
 *
 * @version 0.0.1
 */
public class AccountResponsabileUfficio extends Account {
    private String campus;
    private String edificio;
    private int piano;
    private int numeroStanza;

    /**
     * {@see it.unisa.ackc.gestione_pratiche.entity.Pratica.Tipo}
     */
    private ArrayList<Pratica.Tipo> tipologiaPraticaDaGestire;

    /**
     * Permette di istanziare un oggetto di tipo <code>AccountResponsabileUfficio</code>
     *
     * @param email                     dell'account del responsabile ufficio
     * @param password                  dell'account del responsabile ufficio
     * @param telefono                  del responsabile ufficio
     * @param nome                      del responsabile ufficio
     * @param cognome                   del responsabile ufficio
     * @param sesso                     del responsabile ufficio
     * @param campus                    dove si trova l'ufficio del responsabile ufficio
     * @param edificio                  dove si trova l'ufficio del responsabile ufficio
     * @param piano                     dove si trova l'ufficio del responsabile ufficio
     * @param numeroStanza              dell'ufficio del responsabile ufficio
     * @param tipologiaPraticaDaGestire da parte del responsabile ufficio
     * @version 0.0.1
     */
    public AccountResponsabileUfficio(String email, String password, String telefono, String nome, String cognome, Sesso sesso, String campus, String edificio, int piano, int numeroStanza, ArrayList<Pratica.Tipo> tipologiaPraticaDaGestire) {
        super(email, password, telefono, nome, cognome, Ruolo.RESPONSABILE_UFFICIO, sesso);
        this.campus = campus;
        this.edificio = edificio;
        this.piano = piano;
        this.numeroStanza = numeroStanza;
        this.tipologiaPraticaDaGestire = tipologiaPraticaDaGestire;
    }

    /**
     * Restituisce il campus dell'ufficio del responsabile ufficio
     *
     * @return campus
     * @since 0.0.1
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Permette di impostare il campus dell'ufficio del responsabile ufficio
     *
     * @param campus
     * @since 0.0.1
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * Restituisce l'edificio dell'ufficio del responsabile ufficio
     *
     * @return edificio
     * @since 0.0.1
     */
    public String getEdificio() {
        return edificio;
    }

    /**
     * Permette di impostare l'edificio dell'ufficio del responsabile ufficio
     *
     * @param edificio
     * @since 0.0.1
     */
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    /**
     * Restituisce il piano dell'ufficio del responsabile ufficio
     *
     * @return piano
     * @since 0.0.1
     */
    public int getPiano() {
        return piano;
    }

    /**
     * Permette di impostare il piano dell'ufficio del responsabile ufficio
     *
     * @param piano
     * @since 0.0.1
     */
    public void setPiano(int piano) {
        this.piano = piano;
    }

    /**
     * Restituisce il numero della stanza dell'ufficio del responsabile ufficio
     *
     * @return numeroStanza
     * @since 0.0.1
     */
    public int getNumeroStanza() {
        return numeroStanza;
    }

    /**
     * Permette di impostare il numero della stanza dell'ufficio del responsabile ufficio
     *
     * @param numeroStanza
     * @since 0.0.1
     */
    public void setNumeroStanza(int numeroStanza) {
        this.numeroStanza = numeroStanza;
    }

    /**
     * Restituisce il tipo di pratica gestita dal responsabile ufficio
     *
     * @return tipologiaPraticaDaGestire
     * @since 0.0.1
     */
    public ArrayList<Pratica.Tipo> getTipologiaPraticaDaGestire() {
        return tipologiaPraticaDaGestire;
    }

    /**
     * Permette di impostare il campus del responsabile ufficio
     *
     * @param tipologiaPraticaDaGestire
     * @since 0.0.1
     */
    public void setTipologiaPraticaDaGestire(ArrayList<Pratica.Tipo> tipologiaPraticaDaGestire) {
        this.tipologiaPraticaDaGestire = tipologiaPraticaDaGestire;
    }
}
