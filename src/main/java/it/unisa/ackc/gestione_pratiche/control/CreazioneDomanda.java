package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.util.HashMap;
import java.util.Map;

/**
 * Si occupa della creazione di una domanda da allegare ad una pratica.
 *
 * @version 1.1.1
 */
public class CreazioneDomanda extends FormControl {
    /**
     * Macro del parametro azione.
     */
    public static final String AZIONE_PARAMETRO =
            "azione";
    /**
     * Macro del parametro tipo_di_domanda.
     */
    public static final String TIPO_DI_DOMANDA_PARAMETRO =
            "tipo_di_domanda";
    /**
     * Macro del valore della path di attività lavorativa.
     */
    private static final String ATTIVITA_LAVORATIVA_JSP =
            "/studente/creaDomandaAttivitaLavorativa.jsp";
    /**
     * Macro del valore della path di lingua inglese.
     */
    private static final String LINGUA_INGLESE_JSP =
            "/studente/creaDomandaLinguaInglese.jsp";
    /**
     * Mappa contenente i tipi di domanda e i path dei relativi control.
     */
    private Map<String, String> pathDomande;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.1.1
     */
    public CreazioneDomanda(final Sessione aSessione,
                            final Risposta aRisposta) {
        super(aSessione, aRisposta);
        pathDomande = new HashMap<>();
        pathDomande.put(
                "ATTIVITA_LAVORATIVA",
                ATTIVITA_LAVORATIVA_JSP
        );
        pathDomande.put(
                "LINGUA_INGLESE",
                LINGUA_INGLESE_JSP
        );
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        valida(formDati);
        String domanda = formDati.ottieniDato(TIPO_DI_DOMANDA_PARAMETRO);
        String path = pathDomande.get(domanda);
        getRisposta().aggiungiAttributo(
                AZIONE_PARAMETRO,
                formDati.ottieniDatoIntero(AZIONE_PARAMETRO)
        );
        if (path != null) {
            getRisposta().inoltra(path);
        } else {
            throw new IllegalArgumentException(
                    "Il tipo di domanda specificato non è supportato"
            );
        }
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .CreazioneDomanda.class);
        super.valida(formDati);
    }
}

