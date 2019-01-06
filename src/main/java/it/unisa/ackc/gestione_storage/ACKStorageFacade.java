package it.unisa.ackc.gestione_storage;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.ejb.Local;
import java.util.List;

/**
 * Rappresenta un'interfaccia per l'accesso al database ACK_Storage.
 *
 * @version 0.2.1
 */
@Local
public interface ACKStorageFacade {
    /**
     * Stringa di lookup per lo storage.
     */
    String LOOKUP =
            "java:global/ACK-CERTIFICATE/"
                    + "ACKStorageFacadeEJB!it.unisa.ackc."
                    + "gestione_storage.ACKStorageFacade";

    /**
     * Aggiorna una pratica nel database.
     *
     * @param aPratica da aggiornare
     * @return pratica aggiornata
     * @since 0.0.1
     */
    Pratica updatePratica(Pratica aPratica);

    /**
     * Restituisce la pratica con un  dato id.
     *
     * @param aId della pratica da ottenere
     * @return account
     * @since 0.0.1
     */
    Pratica findPraticaById(Long aId);
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
    List<Pratica> findAllPraticheForResponsabileUfficio(
            AccountResponsabileUfficio aAccount,
            int aLimit,
            int aOffset);

    /**
     * Conta tutte le pratiche
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    Long countAllPraticheForResponsabileUfficio(
            AccountResponsabileUfficio aAccount);
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
    List<Pratica> findPraticheSospeseForResponsabileUfficio(
            AccountResponsabileUfficio aAccount,
            int aLimit,
            int aOffset);

    /**
     * Conta le pratiche sospese
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    Long countPraticheSospeseForResponsabileUfficio(
            AccountResponsabileUfficio aAccount);
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
    List<Pratica> findPraticheDaValutareForResponsabileUfficio(
            AccountResponsabileUfficio aAccount,
            int aLimit,
            int aOffset);

    /**
     * Conta le pratiche da valutare (in attesa)
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    Long countPraticheDaValutareForResponsabileUfficio(
            AccountResponsabileUfficio aAccount);
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
    List<Pratica> findPraticheChiuseForResponsabileUfficio(
            AccountResponsabileUfficio aAccount,
            int aLimit,
            int aOffset);

    /**
     * Restituisce le pratiche chiuse (approvate o bocciate)
     * per un responsabile ufficio.
     *
     * @param aAccount del responsabile ufficio
     * @return numero delle pratiche
     * @since 0.2.1
     */
    Long countPraticheChiuseForResponsabileUfficio(
            AccountResponsabileUfficio aAccount);

    /**
     * Restituisce tutte le pratiche nel database di uno studente.
     *
     * @param aAccount dello studente
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche
     * @since 0.2.1
     */
    List<Pratica> findAllPraticheForStudente(
            AccountStudente aAccount,
            int aLimit,
            int aOffset);
    /**
     * Conta tutte le pratiche nel database di uno studente.
     *
     * @param aAccount dello studente
     * @return numero delle pratiche
     * @since 0.2.1
     */
    Long countAllPraticheForStudente(
            AccountStudente aAccount);
    /**
     * Restituisce le pratiche di un'attestazione di attività lavorativa.
     *
     * @return lista delle pratiche
     * @since 0.0.1
     */
    List<Pratica> findPraticheAttivitaLavorativa();

    /**
     * Restituisce le pratiche di un'attestazione di lingua inglese.
     *
     * @return lista delle pratiche
     * @since 0.0.1
     */
    List<Pratica> findPraticheLinguaInglese();
    /**
     * Controlla la presenza di un account nell'ACK_STORAGE.
     *
     * @param aEmail dell'account di cui voglio controllare la presenza
     * @return true se l'account è presente, false altrimenti
     * @since 0.0.1
     */
    boolean containsAccount(String aEmail);

    /**
     * Restituisce l'account con una data email.
     *
     * @param aEmail dell'account da ottenere
     * @return account
     * @since 0.0.1
     */
    Account findAccountByEmail(String aEmail);

    /**
     * Restituisce l'account con un  dato id.
     *
     * @param id dell'account da ottenere
     * @return account
     * @since 0.0.1
     */
    Account findAccountById(Long id);

    /**
     * Crea un account nell'ACK_STORAGE.
     *
     * @param account da creare
     * @return account creato
     * @since 0.0.1
     */
    Account createAccount(Account account);

    /**
     * Aggiorna un account nell'ACK_Storage.
     *
     * @param account da aggiornare
     * @return account aggiornato
     * @since 0.0.1
     */
    Account updateAccount(Account account);

    /**
     * Elimina un account nell'ACK_STORAGE.
     *
     * @param account da eliminare
     * @since 0.0.1
     */
    void deleteAccount(Account account);
}
