package it.unisa.ackc.gestione_utenti.entity;

/**
 * Rappresenta il concetto di account.
 *
 * @version 0.0.1
 */
public class Account {
    /**
     * Email dell'account.
     */
    private String email;
    /**
     * Password dell'account.
     */
    private String password;
    /**
     * Telefono della persona che possiede l'account.
     */
    private String telefono;
    /**
     * Nome della persona che possiede l'account.
     */
    private String nome;
    /**
     * Cognome della persona che possiede l'account.
     */
    private String cognome;
    /**
     * Ruolo dell'account.
     */
    private Ruolo ruolo;
    /**
     * Sesso della persona che possiede l'account.
     */
    private Sesso sesso;

    /**
     * Permette di instanziare un oggetto di tipo <code>Account</code>.
     *
     * @param pEmail    dell'account studente
     * @param pPassword dell'account studente
     * @param pTelefono numero di telefono relativo all'Account
     * @param pNome     dello studente
     * @param pCognome  dello studente
     * @param pRuolo    il tipo di responsabilità associata
     *                  all'Account all'interno del sistema
     * @param pSesso    dello studente
     * @since 0.0.1
     */
    public Account(final String pEmail,
                   final String pPassword,
                   final String pTelefono,
                   final String pNome,
                   final String pCognome,
                   final Ruolo pRuolo,
                   final Sesso pSesso) {
        this.email = pEmail;
        this.password = pPassword;
        this.telefono = pTelefono;
        this.nome = pNome;
        this.cognome = pCognome;
        this.ruolo = pRuolo;
        this.sesso = pSesso;
    }

    /**
     * Restituisce l'email dell'Account.
     *
     * @return email
     * @since 0.0.1
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permette di impostare l'email dell'Account.
     *
     * @param pEmail nuova email
     * @since 0.0.1
     */
    public void setEmail(final String pEmail) {
        this.email = pEmail;
    }

    /**
     * Restituisce la password dell'Account.
     *
     * @return password
     * @since 0.0.1
     */
    public String getPassword() {
        return password;
    }

    /**
     * Permette di impostare la password dell'Account.
     *
     * @param pPassword nuova password
     * @since 0.0.1
     */
    public void setPassword(final String pPassword) {
        this.password = pPassword;
    }

    /**
     * Restituisce il telefono dell'Account.
     *
     * @return telefono
     * @since 0.0.1
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permette di impostare il numero di telefono dell'Account.
     *
     * @param pTelefono nuovo telefono
     * @since 0.0.1
     */
    public void setTelefono(final String pTelefono) {
        this.telefono = pTelefono;
    }

    /**
     * Restituisce il nome dell'Account.
     *
     * @return nome
     * @since 0.0.1
     */
    public String getNome() {
        return nome;
    }

    /**
     * Permette di impostare il nome dell'Account.
     *
     * @param pNome nuovo nome
     * @since 0.0.1
     */
    public void setNome(final String pNome) {
        this.nome = pNome;
    }

    /**
     * Restituisce il cognome dell'Account.
     *
     * @return cognome
     * @since 0.0.1
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Permette di impostare il cognome dell'Account.
     *
     * @param pCognome nuovo cognome
     * @since 0.0.1
     */
    public void setCognome(final String pCognome) {
        this.cognome = pCognome;
    }

    /**
     * Restituisce il ruolo dell'Account.
     *
     * @return ruolo
     * @since 0.0.1
     */
    public Ruolo getRuolo() {
        return ruolo;
    }

    /**
     * Permette di impostare il ruolo dell'Account.
     *
     * @param pRuolo nuovo ruolo
     * @since 0.0.1
     */
    public void setRuolo(final Ruolo pRuolo) {
        this.ruolo = pRuolo;
    }

    /**
     * Restituisce il sesso dell'Account.
     *
     * @return sesso
     * @since 0.0.1
     */
    public Sesso getSesso() {
        return sesso;
    }

    /**
     * Permette di impostare il sesso dell'Account.
     *
     * @param pSesso sesso da impostare.
     * @since 0.0.1
     */
    public void setSesso(final Sesso pSesso) {
        this.sesso = pSesso;
    }

    /**
     * Tipologie sesso:
     * <ul>
     *  <li>{@link #MASCHIO}</li>
     *  <li>{@link #FEMMINA}</li>
     * </ul>.
     *
     * @version 0.0.1
     */
    public enum Sesso {
        /**
         * Sesso maschile.
         */
        MASCHIO,
        /**
         * Sesso femminile.
         */
        FEMMINA
    }

    /**
     * Possibili tipologie della pratica:
     * <ul>
     *  <li>{@link #AMMINISTRATORE}</li>
     *  <li>{@link #STUDENTE}</li>
     *  <li>{@link #RESPONSABILE_UFFICIO}</li>
     * </ul>.
     *
     * @version 0.0.1
     */
    public enum Ruolo {
        /**
         * Indica un account di un amministratore.
         */
        AMMINISTRATORE,
        /**
         * Indica un account di uno studente.
         */
        STUDENTE,
        /**
         * Indica un account di un responsabile ufficio.
         */
        RESPONSABILE_UFFICIO
    }
}
