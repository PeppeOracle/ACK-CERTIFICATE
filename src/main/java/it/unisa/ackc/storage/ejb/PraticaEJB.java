package it.unisa.ackc.storage.ejb;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Stato;
import it.unisa.ackc.gestione_pratiche.entity.Pratica.Tipo;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * EJB relativo alla pratica.
 * @version 0.2.1
 */
@Stateless
@LocalBean
public class PraticaEJB {

    /**
     * Entity manager che gestisce le transazioni nel database.
     */
    @PersistenceContext(unitName = "ACKPU")
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
        em.remove(em.merge(aPratica));
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
     * @param aTipo delle pratiche da trovare
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
     * Trova tutte le pratica nel database in uno stato.
     * @param aStato delle pratiche da trovare
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
     * Trova tutte le pratica nel database con dei tipi e in uno stato.
     * @param aStato delle pratiche da trovare
     * @param aTipi delle pratiche da trovare
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche trovate
     * @since 0.1.1
     */
    public List<Pratica> findByStatoByTipi(
            final Stato aStato,
            final List<Tipo> aTipi,
            final int aLimit,
            final int aOffset) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findPraticheByStatoByTipi", Pratica.class);
        query.setParameter("stato", aStato);
        query.setParameter("listaTipi", aTipi);
        query.setFirstResult(aOffset);
        query.setMaxResults(aLimit);
        return query.getResultList();
    }
    /**
     * Conta tutte le pratica nel database con dei tipi e in uno stato.
     * @param aStato delle pratiche da contare
     * @param aTipi delle pratiche da contare
     * @return lista di tutte le pratiche
     * @since 0.2.1
     */
    public Long countByStatoByTipi(
            final Stato aStato,
            final List<Tipo> aTipi) {
        TypedQuery<Long> query =
                em.createNamedQuery("countPraticheByStatoByTipi", Long.class);
        query.setParameter("stato", aStato);
        query.setParameter("listaTipi", aTipi);
        return query.getSingleResult();
    }
    /**
     * Trova tutte le pratica nel database con dei tipi e in degli stati.
     * @param aStati delle pratiche da trovare
     * @param aTipi delle pratiche da trovare
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista delle pratiche trovate
     * @since 0.1.1
     */
    public List<Pratica> findByStatiByTipi(
            final List<Stato> aStati,
            final List<Tipo> aTipi,
            final int aLimit,
            final int aOffset) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findPraticheByStatiByTipi", Pratica.class);
        query.setParameter("listaStati", aStati);
        query.setParameter("listaTipi", aTipi);
        query.setFirstResult(aOffset);
        query.setMaxResults(aLimit);
        return query.getResultList();
    }
    /**
     * Conta tutte le pratica nel database con dei tipi e in degli stati.
     * @param aStati delle pratiche da contare
     * @param aTipi delle pratiche da contare
     * @return lista di tutte le pratiche
     * @since 0.2.1
     */
    public Long countByStatiByTipi(
            final List<Stato> aStati,
            final List<Tipo> aTipi) {
        TypedQuery<Long> query =
                em.createNamedQuery("countPraticheByStatiByTipi", Long.class);
        query.setParameter("listaStati", aStati);
        query.setParameter("listaTipi", aTipi);
        return query.getSingleResult();
    }
    /**
     * Trova tutte le pratiche nel database con dei tipi.
     * @param aTipi delle pratiche da trovare
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista di tutte le pratiche
     * @since 0.1.1
     */
        public List<Pratica> findAllByTipi(
                final List<Tipo> aTipi,
                final int aLimit,
                final int aOffset) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findAllPraticheByTipi", Pratica.class);
        query.setParameter("listaTipi", aTipi);
        query.setFirstResult(aOffset);
        query.setMaxResults(aLimit);
        return query.getResultList();
    }
    /**
     * Conta tutte le pratiche nel database con dei tipi.
     * @param aTipi delle pratiche da contare
     * @return lista di tutte le pratiche
     * @since 0.2.1
     */
    public Long countAllByTipi(final List<Tipo> aTipi) {
        TypedQuery<Long> query =
                em.createNamedQuery("countAllPraticheByTipi", Long.class);
        query.setParameter("listaTipi", aTipi);
        return query.getSingleResult();
    }
    /**
     * Trova tutte le pratiche nel database di uno studente.
     * @param aAccount dello studente
     * @param aLimit limite elementi per la pagina restituita
     * @param aOffset offset di elementi della pagina restituita
     * @return lista di tutte le pratiche
     * @since 0.2.1
     */
    public List<Pratica> findAllForStudente(
            final AccountStudente aAccount,
            final int aLimit,
            final int aOffset) {
        TypedQuery<Pratica> query =
                em.createNamedQuery("findAllPraticheByStudente", Pratica.class);
        query.setParameter("account", aAccount);
        query.setFirstResult(aOffset);
        query.setMaxResults(aLimit);
        return query.getResultList();
    }
    /**
     * Conta tutte le pratiche nel database di uno studente.
     * @param aAccount dello studente
     * @return lista di tutte le pratiche
     * @since 0.2.1
     */
    public Long countAllForStudente(
            final AccountStudente aAccount) {
        TypedQuery<Long> query =
                em.createNamedQuery("countAllPraticheByStudente", Long.class);
        query.setParameter("account", aAccount);
        return query.getSingleResult();
    }
}
