package it.unisa.ackc.gestione_storage.ejb;

import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Stato;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Tipo;
import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * EJB per l'accesso al database ACK_Storage.
 * @version 0.0.1
 */
@Stateless
@LocalBean
public class ACKStorageFacadeEJB implements ACKStorageFacade {

    /**
     * EJB per le transazioni relative alla pratica.
     */
    @Inject
    private PraticaEJB praticaEJB;
    /**
     * EJB per le transazioni relative all'account.
     */
    @Inject
    private AccountEJB accountEJB;

    /**
     * Costruttore di default del bean.
     * @since 0.0.1
     */
    public ACKStorageFacadeEJB() {
    }

    /**
     * Aggiorna una pratica nell'ACK_STORAGE.
     *
     * @param pratica da aggiornare
     * @return pratica aggiornata
     * @since 0.0.1
     */
    @Override
    public Pratica updatePratica(final Pratica pratica) {
        return praticaEJB.updatePratica(pratica);
    }

    /**
     * Restituisce tutte le pratiche nell'ACK_STORAGE.
     *
     * @return lista di tutte le pratiche
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findAllPratiche() {
        return praticaEJB.findAll();
    }

    /**
     * Restituisce le pratiche sospese nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "SOSPESA"
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheSospese() {
        return praticaEJB.findByStato(Pratica.Stato.SOSPESA);
    }

    /**
     * Restituisce le pratiche da valutare (in attesa) nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "IN_ATTESA"
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheDaValutare() {
        return praticaEJB.findByStato(Stato.IN_ATTESA);
    }

    /**
     * Restituisce le pratiche chiuse (approvate o bocciate) nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "APPROVATA" o "BOCCIATA"
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheChiuse() {
        List<Pratica> praticheChiuse = praticaEJB.findByStato(Stato.APPROVATA);
        praticheChiuse.addAll(praticaEJB.findByStato(Stato.BOCCIATA));
        return praticheChiuse;
    }

    /**
     * Restituisce le pratiche di un'attestazione di attività lavorativa.
     *
     * @return lista delle pratiche di attività lavorativa
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheAttivitaLavorativa() {
        return praticaEJB.findByTipo(Tipo.ATTIVITA_LAVORATIVA);
    }

    /**
     * Restituisce le pratiche di un'attestazione di lingua inglese.
     *
     * @return lista delle pratiche di lingua inglese
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheLinguaInglese() {
        return praticaEJB.findByTipo(Tipo.LINGUA_INGLESE);
    }

    /**
     * Controlla la presenza di un account nell'ACK_STORAGE.
     *
     * @param email dell'account di cui voglio controllare la presenza
     * @return true se l'account è presente, false altrimenti
     * @since 0.0.1
     */
    @Override
    public boolean containsAccount(final String email) {
        return accountEJB.findByEmail(email)!=null;
    }

    /**
     * Restituisce l'account con una data email.
     *
     * @param email dell'account che voglio ottenere
     * @return account
     * @since 0.0.1
     */
    @Override
    public Account findAccountByEmail(final String email) {
        return accountEJB.findByEmail(email);
    }

    /**
     * Restituisce l'account con un  dato id.
     *
     * @param id dell'account che voglio ottenere
     * @return account
     * @since 0.0.1
     */
    @Override
    public Account findAccountById(final Long id) {
        return accountEJB.findById(id);
    }

    /**
     * Crea un account nell'ACK_STORAGE.
     *
     * @param account da creare
     * @return account creato
     * @since 0.0.1
     */
    @Override
    public Account createAccount(final Account account) {
        return accountEJB.createAccount(account);
    }

    /**
     * Aggiorna un account nell'ACK_Storage.
     *
     * @param account da aggiornare
     * @return account aggiornato
     * @since 0.0.1
     */
    @Override
    public Account updateAccount(final Account account) {
        return accountEJB.updateAccount(account);
    }

    /**
     * Elimina un account nell'ACK_STORAGE.
     *
     * @param account da eliminare
     * @since 0.0.1
     */
    @Override
    public void deleteAccount(final Account account) {
        accountEJB.deleteAccount(account);
    }
}
