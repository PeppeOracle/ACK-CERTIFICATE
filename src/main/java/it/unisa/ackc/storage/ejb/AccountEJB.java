package it.unisa.ackc.storage.ejb;

import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.Account.Ruolo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * EJB relativo all'account.
 * @version 0.0.1
 */
@Stateless
@LocalBean
public class AccountEJB {

    /**
     * Entity manager che gestisce le transazioni nel database.
     */
    @PersistenceContext(unitName = "ACKPU")
    private EntityManager em;
    /**
     * Costruttore di default del bean.
     * @since 0.0.1
     */
    public AccountEJB() {
    }
    /**
     * Memorizza l'account nel database.
     * @param aAccount da memorizzare
     * @return aAccount
     * @since 0.0.1
     */
    public Account createAccount(final Account aAccount) {
        em.persist(aAccount);
        return aAccount;
    }
    /**
     * Aggiorna l'account nel database.
     * @param aAccount da aggiornare
     * @return aAccount
     * @since 0.0.1
     */
    public Account updateAccount(final Account aAccount) {
        return em.merge(aAccount);
    }

    /**
     * Rimuove l'account dal database.
     * @param aAccount da rimuovere
     * @since 0.0.1
     */
    public void deleteAccount(final Account aAccount) {
        em.remove(em.merge(aAccount));
    }
    /**
     * Trova un account nel database.
     * @param aId della Account da trovare
     * @return Account trovato
     * @since 0.0.1
     */
    public Account findById(final Long aId) {
        TypedQuery<Account> query =
                em.createNamedQuery("findAccountById", Account.class);
        query.setParameter("id", aId);
        return query.getSingleResult();
    }
    /**
     * Trova un account nel database.
     * @param aEmail della Account da trovare
     * @return Account trovato
     * @since 0.0.1
     */
    public Account findByEmail(final String aEmail) {
        TypedQuery<Account> query =
                em.createNamedQuery("findAccountByEmail", Account.class);
        query.setParameter("email", aEmail);
        return query.getSingleResult();
    }
    /**
     * Trova tutti gli account nel database di un tipo.
     * @param  aRuolo deglia ccount da trovare
     * @return lista degli account trovati
     * @since 0.0.1
     */
    public List<Account> findByRuolo(final Ruolo aRuolo) {
        TypedQuery<Account> query =
                em.createNamedQuery("findAccountByRuolo", Account.class);
        query.setParameter("ruolo", aRuolo);
        return query.getResultList();
    }
    /**
     * Trova tutti gli account nel database.
     * @return lista di tutti gli account
     * @since 0.0.1
     */
    public List<Account> findAll() {
        TypedQuery<Account> query =
                em.createNamedQuery("findAllAccount", Account.class);
        return query.getResultList();
    }
}

