package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.storage.ejb.ACKStorageFacadeDefault;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;


/**
 * Si occupa di reperire le informazioni relative ad una pratica
 * per un responsabile ufficio.
 *
 * @version 1.1.1
 */
public class MostraPratica extends FormControl {
    /**
     * Macro del parametro tipo di visualizzione richiesta.
     */
    public static final String
            TIPO_PARAMETRO = "tipo";
    /**
     * Macro della jsp per il responsabile ufficio (visualizzazione).
     */
    private static final String
            PRATICA_RESPONSABILE_UFFICIO_JSP = "visualizzaPratica.jsp";
    /**
     * Tipo jsp per responsabile ufficio (visualizzazione).
     */
    public static final int
            PRATICA_RESPONSABILE_UFFICIO = 0;
    /**
     * Macro della jsp per il responsabile ufficio (valutazione).
     */
    private static final String
            PRATICA_RESPONSABILE_UFFICIO_VALUTA_JSP = "valutaPratica.jsp";
    /**
     * Tipo jsp per responsabile ufficio (valutazione).
     */
    public static final int
            PRATICA_RESPONSABILE_UFFICIO_VALUTA = 1;
    /**
     * Macro della jsp per lo studente (visualizzazione).
     */
    private static final String
            PRATICA_STUDENTE_JSP = "visualizzaPratica.jsp";
    /**
     * Tipo jsp per lo studente  (visualizzazione).
     */
    public static final int
            PRATICA_STUDENTE = 2;
    /**
     * Macro della jsp per lo studente (modifica).
     */
    private static final String
            PRATICA_STUDENTE_MODIFICA_JSP = "visualizzaPratica.jsp";
    /**
     * Tipo jsp per lo studente  (modifica).
     */
    public static final int
            PRATICA_STUDENTE_MODIFICA = 3;
    /**
     * Istanza dello storage facade.
     */
    private ACKStorageFacade ackStorage;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.1.1
     */
    public MostraPratica(final Sessione aSessione, final Risposta aRisposta) {
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
        Pratica pratica = ackStorage.findPraticaById(
                formDati.ottieniDatoLong(GestionePratiche.PRATICA_PARAMETRO)
        );
        getRisposta().aggiungiAttributo("pratica", pratica);
        int tipo = formDati.ottieniDatoIntero(TIPO_PARAMETRO);
        getRisposta().inoltra(getJSP(tipo));
    }

    /**
     * Restituisce la jsp corrispondente al tipo.
     *
     * @param tipo di visualizzazione richiesta
     * @return jsp corrispondente al tipo indicato
     * @since 1.1.1
     */
    private String getJSP(final int tipo) {
        switch (tipo) {
            case PRATICA_RESPONSABILE_UFFICIO:
                return PRATICA_RESPONSABILE_UFFICIO_JSP;
            case PRATICA_RESPONSABILE_UFFICIO_VALUTA:
                return PRATICA_RESPONSABILE_UFFICIO_VALUTA_JSP;
            case PRATICA_STUDENTE:
                return PRATICA_STUDENTE_JSP;
            case PRATICA_STUDENTE_MODIFICA:
                return PRATICA_STUDENTE_MODIFICA_JSP;
            default:
                return null;
        }
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .MostraPratica.class);
        super.valida(formDati);
    }
}
