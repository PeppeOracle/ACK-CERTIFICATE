package it.unisa.ackc.gestione_storage;

import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.Account.Ruolo;
import it.unisa.ackc.gestione_utenti.entity.Account.Sesso;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
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
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/EsameDS",
        user = "APP",
        password = "APP",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    /**
     * EJB per le transazioni relative all'account.
     */
    @Inject
    private ACKStorageFacadeEJB storageEJB;

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
        adminAccount = new Account("admin@unisa.it", "admin", "000000000", "Admin", "Admin",Ruolo.AMMINISTRATORE, Sesso.MASCHIO);
        storageEJB.createAccount(adminAccount);
    }

    /**
     * Rimuove gli elementi nel database.
     *
     * @version 0.0.1
     */
    @PreDestroy
    private void clearDB() {
        adminAccount = storageEJB.updateAccount(adminAccount);
        storageEJB.deleteAccount(adminAccount);
    }
}
