package it.unisa.ackc.gestione_storage.ejb;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Stato;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Tipo;
import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.Account.Ruolo;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Facade per l'accesso al database ACK_Storage.
 * @version 0.3.1
 */
public class ACKStorageFacadeDefault implements ACKStorageFacade {

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
     * Costruttore di default del facade.
     * @since 0.0.1
     */
    public ACKStorageFacadeDefault() {
    }

    /**
     * Aggiorna una pratica nel database.
     *
     * @param aPratica da aggiornare
     * @return pratica aggiornata
     * @since 0.0.1
     */
    @Override
    public Pratica updatePratica(final Pratica aPratica) {
        return praticaEJB.updatePratica(aPratica);
    }

    /**
     * Restituisce la pratica con un  dato id.
     *
     * @param id della pratica da ottenere
     * @return account
     * @since 0.0.1
     */
    @Override
    public Pratica findPraticaById(final Long id) {
        return praticaEJB.findById(id);
    }

    /**
     * Restituisce tutte le pratiche
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche
     * @since 0.1.2
     */
    @Override
    public List<Pratica> findAllPraticheForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount,
            final int aLimit,
            final int aOffset) {
        return praticaEJB.findAllByTipi(
                aAccount.getTipologiaPraticaDaGestire(),
                aLimit,
                aOffset);
    }

    /**
     * Conta tutte le pratiche
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    @Override
    public Long countAllPraticheForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount) {
        return praticaEJB.countAllByTipi(
                aAccount.getTipologiaPraticaDaGestire());
    }

    /**
     * Restituisce le pratiche sospese
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche
     * @since 0.1.2
     */
    @Override
    public List<Pratica> findPraticheSospeseForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount,
            final int aLimit,
            final int aOffset) {
        return praticaEJB.findByStatoByTipi(
                Stato.SOSPESA,
                aAccount.getTipologiaPraticaDaGestire(),
                aLimit,
                aOffset);
    }

    /**
     * Conta le pratiche sospese
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    @Override
    public Long countPraticheSospeseForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount) {
        return praticaEJB.countByStatoByTipi(
                Pratica.Stato.SOSPESA,
                aAccount.getTipologiaPraticaDaGestire());
    }

    /**
     * Restituisce le pratiche da valutare (in attesa)
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche
     * @since 0.1.2
     */
    @Override
    public List<Pratica> findPraticheDaValutareForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount,
            final int aLimit,
            final int aOffset) {
        return praticaEJB.findByStatoByTipi(
                Stato.IN_ATTESA,
                aAccount.getTipologiaPraticaDaGestire(),
                aLimit,
                aOffset);
    }

    /**
     * Conta le pratiche da valutare (in attesa)
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    @Override
    public Long countPraticheDaValutareForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount) {
        return praticaEJB.countByStatoByTipi(
                Stato.IN_ATTESA,
                aAccount.getTipologiaPraticaDaGestire());
    }

    /**
     * Restituisce le pratiche chiuse (approvate o bocciate)
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche
     * @since 0.1.2
     */
    @Override
    public List<Pratica> findPraticheChiuseForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount,
            final int aLimit,
            final int aOffset) {
        ArrayList<Stato> stati = new ArrayList<>();
        stati.add(Stato.BOCCIATA);
        stati.add(Stato.APPROVATA);
        return praticaEJB.findByStatiByTipi(
                stati,
                aAccount.getTipologiaPraticaDaGestire(),
                aLimit,
                aOffset);
    }

    /**
     * Conta le pratiche chiuse (approvate o bocciate)
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    @Override
    public Long countPraticheChiuseForResponsabileUfficio(
            final AccountResponsabileUfficio aAccount) {
        ArrayList<Stato> stati = new ArrayList<>();
        stati.add(Stato.BOCCIATA);
        stati.add(Stato.APPROVATA);
        return praticaEJB.countByStatiByTipi(
                stati,
                aAccount.getTipologiaPraticaDaGestire());
    }

    /**
     * Restituisce tutte le pratiche nel database di uno studente.
     *
     * @param aAccount dello studente
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche
     * @since 0.2.1
     */
    @Override
    public List<Pratica> findAllPraticheForStudente(
            final AccountStudente aAccount,
            final int aLimit,
            final int aOffset) {
        return praticaEJB.findAllForStudente(
                aAccount,
                aLimit,
                aOffset);
    }
    /**
     * Conta tutte le pratiche nel database di uno studente.
     *
     * @param aAccount dello studente
     * @return numero delle pratiche
     * @since 0.2.1
     */
    @Override
    public Long countAllPraticheForStudente(
            final AccountStudente aAccount) {
        return praticaEJB.countAllForStudente(
                aAccount);
    }

    /**
     * Restituisce le pratiche di un'attestazione di attività lavorativa.
     *
     * @return lista delle pratiche
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheAttivitaLavorativa() {
        return praticaEJB.findByTipo(Tipo.ATTIVITA_LAVORATIVA);
    }

    /**
     * Restituisce le pratiche di un'attestazione di lingua inglese.
     *
     * @return lista delle pratiche
     * @since 0.0.1
     */
    @Override
    public List<Pratica> findPraticheLinguaInglese() {
        return praticaEJB.findByTipo(Tipo.LINGUA_INGLESE);
    }

    /**
     * Controlla la presenza di un account nell'ACK_STORAGE.
     *
     * @param aEmail dell'account di cui voglio controllare la presenza
     * @return true se l'account è presente, false altrimenti
     * @since 0.0.1
     */
    @Override
    public boolean containsAccount(final String aEmail) {
        return accountEJB.findByEmail(aEmail) != null;
    }

    /**
     * Restituisce l'account con una data email.
     *
     * @param aEmail dell'account da ottenere
     * @return account
     * @since 0.0.1
     */
    @Override
    public Account findAccountByEmail(final String aEmail) {
        return accountEJB.findByEmail(aEmail);
    }

    /**
     * Restituisce l'account con un  dato id.
     *
     * @param aId dell'account da ottenere
     * @return account
     * @since 0.0.1
     */
    @Override
    public Account findAccountById(final Long aId) {
        return accountEJB.findById(aId);
    }

    /**
     * Controlla la presenza di un account admin nell'ACK_STORAGE.
     *
     * @return true se l'account è presente, false altrimenti
     * @since 0.3.1
     */
    @Override
    public boolean containsAdminAccount() {
        return accountEJB.findByRuolo(Ruolo.AMMINISTRATORE).isEmpty();
    }
    /**
     * Crea un account nell'ACK_STORAGE.
     *
     * @param aAccount da creare
     * @return account creato
     * @since 0.0.1
     */
    @Override
    public Account createAccount(final Account aAccount) {
        return accountEJB.createAccount(aAccount);
    }

    /**
     * Aggiorna un account nell'ACK_Storage.
     *
     * @param aAccount da aggiornare
     * @return account aggiornato
     * @since 0.0.1
     */
    @Override
    public Account updateAccount(final Account aAccount) {
        return accountEJB.updateAccount(aAccount);
    }

    /**
     * Elimina un account nell'ACK_STORAGE.
     *
     * @param aAccount da eliminare
     * @since 0.0.1
     */
    @Override
    public void deleteAccount(final Account aAccount) {
        accountEJB.deleteAccount(aAccount);
    }
}
