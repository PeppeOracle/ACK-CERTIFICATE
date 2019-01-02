package it.unisa.ackc.gestione_storage;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;

import javax.ejb.Local;
import java.util.List;

/**
 * Rappresenta un'interfaccia per l'accesso al database ACK_Storage.
 *
 * @version 0.1.1
 */
@Local
public interface ACKStorageFacade {

    /**
     * Aggiorna una pratica nell'ACK_STORAGE.
     *
     * @param pratica da aggiornare
     * @return pratica aggiornata
     * @since 0.0.1
     */
    Pratica updatePratica(Pratica pratica);

    /**
     * Restituisce la pratica con un dato id.
     *
     * @param id della pratica
     * @return pratica
     * @since 0.1.1
     */
    Pratica findPraticaById(Long id);
    /**
     * Restituisce tutte le pratiche nell'ACK_STORAGE.
     *
     * @return lista di tutte le pratiche
     * @since 0.0.1
     */
    List<Pratica> findAllPratiche();

    /**
     * Restituisce le pratiche sospese nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "SOSPESA"
     * @since 0.0.1
     */
    List<Pratica> findPraticheSospese();

    /**
     * Restituisce le pratiche da valutare (in attesa) nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "IN_ATTESA"
     * @since 0.0.1
     */
    List<Pratica> findPraticheDaValutare();

    /**
     * Restituisce le pratiche chiuse (approvate o bocciate) nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "APPROVATA" o "BOCCIATA"
     * @since 0.0.1
     */
    List<Pratica> findPraticheChiuse();

    /**
     * Restituisce le pratiche di un'attestazione di attività lavorativa.
     *
     * @return lista delle pratiche di attività lavorativa
     * @since 0.0.1
     */
    List<Pratica> findPraticheAttivitaLavorativa();

    /**
     * Restituisce le pratiche di un'attestazione di lingua inglese.
     *
     * @return lista delle pratiche di lingua inglese
     * @since 0.0.1
     */
    List<Pratica> findPraticheLinguaInglese();
    /**
     * Controlla la presenza di un account nell'ACK_STORAGE.
     *
     * @param email dell'account di cui voglio controllare la presenza
     * @return true se l'account è presente, false altrimenti
     * @since 0.0.1
     */
    boolean containsAccount(String email);

    /**
     * Restituisce l'account con una data email.
     *
     * @param email dell'account che voglio ottenere
     * @return account
     * @since 0.0.1
     */
    Account findAccountByEmail(String email);

    /**
     * Restituisce l'account con un  dato id.
     *
     * @param id dell'account che voglio ottenere
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
