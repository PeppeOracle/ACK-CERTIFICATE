package it.unisa.ackc.gestione_utenti.entity;

/**
 * Rappresenta il concetto di account
 *
 * @version 0.0.1
 */
public class Account {
    private String email;
    private String password;
    private String telefono;
    private String nome;
    private String cognome;
    private Ruolo ruolo;
    private Sesso sesso;

    /**
     * Permette di instanziare un oggetto di tipo <code>Account</code>
     *
     * @param email    dell'account studente
     * @param password dell'account studente
     * @param telefono numero di telefono relativo all'Account
     * @param nome     dello studente
     * @param cognome  dello studente
     * @param ruolo    il tipo di responsabilità associata all'Account all'interno del sistema
     * @param sesso    dello studente
     * @since 0.0.1
     */
    public Account(String email, String password, String telefono, String nome, String cognome, Ruolo ruolo, Sesso sesso) {
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.sesso = sesso;
    }

    /**
     * Restituisce l'email dell'Account
     *
     * @return email
     * @since 0.0.1
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permette di impostare l'email dell'Account
     *
     * @param email
     * @since 0.0.1
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce la password dell'Account
     *
     * @return password
     * @since 0.0.1
     */
    public String getPassword() {
        return password;
    }

    /**
     * Permette di impostare la password dell'Account
     *
     * @param password
     * @since 0.0.1
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce il telefono dell'Account
     *
     * @return telefono
     * @since 0.0.1
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permette di impostare il numero di telefono dell'Account
     *
     * @param telefono
     * @since 0.0.1
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Restituisce il nome dell'Account
     *
     * @return nome
     * @since 0.0.1
     */
    public String getNome() {
        return nome;
    }

    /**
     * Permette di impostare il nome dell'Account
     *
     * @param nome
     * @since 0.0.1
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome dell'Account
     *
     * @return cognome
     * @since 0.0.1
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Permette di impostare il cognome dell'Account
     *
     * @param cognome
     * @since 0.0.1
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce il ruolo dell'Account
     *
     * @return ruolo
     * @since 0.0.1
     */
    public Ruolo getRuolo() {
        return ruolo;
    }

    /**
     * Permette di impostare il ruolo dell'Account
     *
     * @param ruolo
     * @since 0.0.1
     */
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    /**
     * Restituisce il sesso dell'Account
     *
     * @return sesso
     * @since 0.0.1
     */
    public Sesso getSesso() {
        return sesso;
    }

    /**
     * Permette di impostare il sesso dell'Account
     *
     * @param sesso
     * @since 0.0.1
     */
    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    /**
     * Tipologie sesso:
     * <ul>
     * <li>{@link #MASCHIO} Sesso maschile</li>
     * <li>{@link #FEMMINA} Sesso femminile</li>
     * </ul>
     *
     * @version 0.0.1
     */
    public enum Sesso {
        MASCHIO,
        FEMMINA
    }

    /**
     * Possibili tipologie della pratica:
     * <ul>
     * <li>{@link #AMMINISTRATORE} Indica un account di un amministratore</li>
     * <li>{@link #STUDENTE} Indica un account di uno studente {@see it.unisa.ackc.gestione_utenti.entity.AccountStudente}</li>
     * <li>{@link #RESPONSABILE_UFFICIO} Indica un account di un responsabile ufficio {@see it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio}</li>
     * </ul>
     *
     * @version 0.0.1
     */
    public enum Ruolo {
        AMMINISTRATORE,
        STUDENTE,
        RESPONSABILE_UFFICIO
    }
}
