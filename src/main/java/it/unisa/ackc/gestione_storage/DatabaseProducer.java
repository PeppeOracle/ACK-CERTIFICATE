package it.unisa.ackc.gestione_storage;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *  Database producer dell'entity manager
 *  che gestisce le transazioni nel database.
 * @version 0.0.1
 */
public class DatabaseProducer {
    /**
     * Entity manager per le transazioni nel database.
     */
    @Produces
    @PersistenceContext(unitName = "EsamePU")
    private EntityManager em;
}
