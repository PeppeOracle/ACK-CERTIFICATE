package it.unisa.ackc.gestione_storage.ejb;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Tipo;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Stato;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * EJB relativo alla pratica.
 * @version 0.1.1
 */
@Stateless
@LocalBean
public class PraticaEJB {

    /**
     * Entity manager che gestisce le transazioni nel database.
     */
    @Inject
    private EntityManager em;
    /**
     * Costruttore di default del bean.
     * @since 0.0.1
     */
    public PraticaEJB() {
    }
    /**
     * Memorizza la pratica nel database.
     * @param aPratica da memorizzare
     * @return aPratica
     * @since 0.0.1
     */
    public Pratica createPratica(final Pratica aPratica) {
        em.persist(aPratica);
        return aPratica;
    }
    /**
     * Aggiorna la pratica nel database.
     * @param aPratica da aggiornare
     * @return aPratica
     * @since 0.0.1
     */
    public Pratica updatePratica(final Pratica aPratica) {
        return em.merge(aPratica);
    }

    /**
     * Rimuove la pratica dal database.
     * @param aPratica da rimuovere
     * @since 0.0.1
     */
    public void deletePratica(final Pratica aPratica) {
        em.remove(aPratica);
    }
    /**
     * Trova una pratica nel database.
     * @param aId della pratica da trovare
     * @return pratica trovata
     * @since 0.0.1
     */
    public Pratica findById(final Long aId) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findPraticaById", Pratica.class);
        query.setParameter("id", aId);
        return query.getSingleResult();
    }
    /**
     * Trova tutte le pratica nel database di un tipo.
     * @param  aTipo delle pratiche da trovare
     * @return lista delle pratiche trovate
     * @since 0.0.1
     */
    public List<Pratica> findByTipo(final Tipo aTipo) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findPraticheByTipo", Pratica.class);
        query.setParameter("tipo", aTipo);
        return query.getResultList();
    }
    /**
     * Trova tutte le pratica nel database di un tipo.
     * @param  aStato delle pratiche da trovare
     * @return lista delle pratiche trovate
     * @since 0.1.1
     */
    public List<Pratica> findByStato(final Stato aStato) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findPraticheByStato", Pratica.class);
        query.setParameter("stato", aStato);
        return query.getResultList();
    }
    /**
     * Trova tutte le pratiche nel database.
     * @return lista di tutte le pratiche
     * @since 0.0.1
     */
    public List<Pratica> findAll() {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findAllPratiche", Pratica.class);
        return query.getResultList();
    }
}
