package it.unisa.ackc;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;

import java.util.List;

/**
 * Rappresenta un'interfaccia per l'accesso al database ACK_Storage.
 *
 * @version 0.0.1
 */
public interface ACKStorageFacade {

    /**
     * Crea una pratica nell'ACK_STORAGE.
     *
     * @param pratica da creare
     * @return pratica creata
     * @since 0.0.1
     */
    Pratica createPratica(Pratica pratica);

    /**
     * Aggiorna una pratica nell'ACK_STORAGE.
     *
     * @param pratica da aggiornare
     * @return pratica aggiornata
     * @since 0.0.1
     */
    Pratica updatePratica(Pratica pratica);

    /**
     * Elimina una pratica nell'ACK_STORAGE.
     *
     * @param pratica da rimuovere
     * @since 0.0.1
     */
    void deletePratica(Pratica pratica);

    /**
     * Controlla la presenza di un account nell'ACK_STORAGE.
     *
     * @param pratica di cui voglio controllare la presenza
     * @return true se la pratica è presente, false altrimenti
     * @since 0.0.1
     */
    boolean containsPratica(Pratica pratica);

    /**
     * Trova tutte le pratiche nell'ACK_STORAGE.
     *
     * @return lista di tutte le pratiche
     * @since 0.0.1
     */
    List<Pratica> findAllPratiche();

    /**
     * Trova le pratiche sospese nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "SOSPESA"
     * @since 0.0.1
     */
    List<Pratica> findPraticheSospese();

    /**
     * Trova le pratiche da valutare (in attesa) nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "IN_ATTESA"
     * @since 0.0.1
     */
    List<Pratica> findPraticheDaValutare();

    /**
     * Trova le pratiche chiuse (approvate o bocciate) nell'ACK_STORAGE.
     *
     * @return lista delle pratiche con lo stato "APPROVATA" o "BOCCIATA"
     * @since 0.0.1
     */
    List<Pratica> findPraticheChiuse();

    /**
     * Controlla la presenza di un account nell'ACK_STORAGE.
     *
     * @param account di cui voglio controllare la presenza
     * @return true se l'account è presente, false altrimenti
     * @since 0.0.1
     */
    boolean containsAccount(Account account);

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
