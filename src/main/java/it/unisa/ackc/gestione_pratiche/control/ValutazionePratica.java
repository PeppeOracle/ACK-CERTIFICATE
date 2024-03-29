package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

/**
 * Si occupa della valutazione di una pratica.
 *
 * @version 1.1.1
 */
public class ValutazionePratica extends FormControl {
    /**
     * Macro del parametro stato della pratica.
     */
    public static final String STATO_PARAMETRO =
            "statoPratica";
    /**
     * Macro del parametro messaggio.
     */
    public static final String MESSAGGIO_PARAMETRO =
            "messaggio";
    /**
     * Macro della jsp di successo della valutazione.
     */
    private static final String SUCCESSFUL_JSP =
            "/gestione-pratiche/mostra-pratica?tipo=0&pratica=";
    /**
     * Macro del messaggio di successo della valutazione.
     */
    private static final String SUCCESSFUL_MESSAGE =
            "";
    /**
     * Istanza dello storage facade.
     */
    private ACKStorageFacade ackStorage;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il
     * @since 1.1.1
     */
    public ValutazionePratica(
            final Sessione aSessione,
            final Risposta aRisposta) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        if (ackStorage == null) {
            ackStorage = getAckStorage();
        }
        valida(formDati);
        Pratica.Stato stato = Pratica.Stato.valueOf(
                formDati.ottieniDato(STATO_PARAMETRO)
        );
        String messaggioPratica = formDati.ottieniDato(MESSAGGIO_PARAMETRO);
        Pratica pratica = ackStorage.findPraticaById(
                formDati.ottieniDatoLong(GestionePratiche.PRATICA_PARAMETRO)
        );
        pratica.setMessaggioResponsabileUfficio(messaggioPratica);
        pratica.setStato(stato);
        ackStorage.updatePratica(pratica);
        getRisposta().redirect(SUCCESSFUL_JSP + pratica.getId());
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .ValutazionePratica.class);
        aggiungiCondizione(GestionePratiche.VALIDA_PRATICA);
        super.valida(formDati);
    }
}
