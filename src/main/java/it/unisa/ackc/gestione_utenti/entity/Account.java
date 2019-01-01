package it.unisa.ackc.gestione_utenti.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * Rappresenta il concetto di account.
 *
 * @version 0.0.2
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllAccount",
                query = "SELECT a FROM Account a"),
        @NamedQuery(name = "findAccountById",
                query = "SELECT a FROM Account a WHERE a.id= :id"),
        @NamedQuery(name = "findAccountByEmail",
                query = "SELECT a FROM Account a WHERE a.email= :email"),
        @NamedQuery(name = "findAccountByRuolo",
                query = "SELECT a FROM Account a WHERE a.ruolo=:ruolo")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    /**
     * Id della pratica.
     */
    @Id
    @GeneratedValue
    private Long id;
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
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
    /**
     * Sesso della persona che possiede l'account.
     */
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    /**
     * Permette di instanziare un oggetto di tipo <code>Account</code>.
     *
     * @param aEmail dell'account studente
     * @param aPassword dell'account studente
     * @param aTelefono numero di telefono relativo all'Account
     * @param aNome dello studente
     * @param aCognome dello studente
     * @param aRuolo il tipo di responsabilità associata
     *               all'Account all'interno del sistema
     * @param aSesso dello studente
     * @since 0.0.1
     */
    public Account(final String aEmail,
                   final String aPassword,
                   final String aTelefono,
                   final String aNome,
                   final String aCognome,
                   final Ruolo aRuolo,
                   final Sesso aSesso) {
        this();
        this.email = aEmail;
        this.password = aPassword;
        this.telefono = aTelefono;
        this.nome = aNome;
        this.cognome = aCognome;
        this.ruolo = aRuolo;
        this.sesso = aSesso;
    }

    /**
     * Costruttore di default.
     */
    public Account() {
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
     * l'email dell'Account.
     *
     * @return email
     * @since 0.0.1
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permette di impostare
     * l'email dell'Account.
     *
     * @param aEmail nuova email
     * @since 0.0.1
     */
    public void setEmail(final String aEmail) {
        this.email = aEmail;
    }

    /**
     * Restituisce
     * la password dell'Account.
     *
     * @return password
     * @since 0.0.1
     */
    public String getPassword() {
        return password;
    }

    /**
     * Permette di impostare
     * la password dell'Account.
     *
     * @param aPassword nuova password
     * @since 0.0.1
     */
    public void setPassword(final String aPassword) {
        this.password = aPassword;
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
     * @param aTelefono nuovo telefono
     * @since 0.0.1
     */
    public void setTelefono(final String aTelefono) {
        this.telefono = aTelefono;
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
     * @param aNome nuovo nome
     * @since 0.0.1
     */
    public void setNome(final String aNome) {
        this.nome = aNome;
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
     * @param aCognome nuovo cognome
     * @since 0.0.1
     */
    public void setCognome(final String aCognome) {
        this.cognome = aCognome;
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
     * @param aRuolo nuovo ruolo
     * @since 0.0.1
     */
    public void setRuolo(final Ruolo aRuolo) {
        this.ruolo = aRuolo;
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
     * @param aSesso sesso da impostare.
     * @since 0.0.1
     */
    public void setSesso(final Sesso aSesso) {
        this.sesso = aSesso;
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
