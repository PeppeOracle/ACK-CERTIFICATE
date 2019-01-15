package it.unisa.ackc.gestione_storage;

import it.unisa.ackc.gestione_storage.ejb.AccountEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.Account.Ruolo;
import it.unisa.ackc.gestione_utenti.entity.Account.Sesso;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Inserisce e rimuove gli elementi dal database durante
 * la sua creazione e la sua distruzione.
 * @version 0.0.1
 */
@Singleton
@Startup
public class DatabasePopulator {
    /**
     * EJB per le transazioni relative all'account.
     */
    @Inject
    private AccountEJB accountEJB;

    /**
     * Account dell'amministratore.
     */
    private Account adminAccount;

    /**
     * Inserisce gli elementi iniziali nel database.
     *
     * @version 0.0.1
     */
    @PostConstruct
    private void populateDB() {
        if (accountEJB.findByRuolo(Ruolo.AMMINISTRATORE).isEmpty()) {
            adminAccount = new Account("admin@unisa.it", "admin", "000000000",
                    "Admin", "Admin", Ruolo.AMMINISTRATORE, Sesso.MASCHIO);
            accountEJB.createAccount(adminAccount);
        }
    }
}
