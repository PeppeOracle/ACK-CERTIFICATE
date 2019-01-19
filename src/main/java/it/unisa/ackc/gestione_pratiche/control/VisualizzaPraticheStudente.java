package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.util.List;

/**
 * Si occupa della visualizzazione delle pratiche per uno studente.
 *
 * @version 1.0.1
 */
public class VisualizzaPraticheStudente extends FormControl {
    /**
     * Macro della jsp della lista di pratiche.
     */
    private static final String PRATICHE_JSP = "gestionePratiche.jsp";
    /**
     * Macro del parametro pagina.
     */
    public static final String PAGINA_PARAMETRO = "pagina";
    /**
     * Macro del limite di pratiche in una pagina.
     */
    public static final int LIMITE_PAGINA = 10;
    /**
     * Istanza dello storage facade.
     */
    private ACKStorageFacade ackStorage;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.0.1
     */
    public VisualizzaPraticheStudente(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     * @param formDati dati sottomessi
     * @since 1.0.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        if (ackStorage == null) {
            ackStorage = getAckStorage();
        }
        AccountStudente account = (AccountStudente)
                getSessione().ottieni("account");
        formDati.aggiungiDato("temp_account", account);
        valida(formDati);
        int pagina = formDati.ottieniDatoIntero(PAGINA_PARAMETRO);
        List<Pratica> praticheStudente = ackStorage.findAllPraticheForStudente(
                account,
                LIMITE_PAGINA,
                (pagina - 1) * LIMITE_PAGINA);
        getRisposta().aggiungiAttributo(
                "pratiche",
                praticheStudente
        );
        getRisposta().inoltra(PRATICHE_JSP);
    }

    /**
     * {@inheritDoc}
     * @since 1.0.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control
                .convalida.VisualizzaPraticheStudente.class);
        super.valida(formDati);
    }
}
