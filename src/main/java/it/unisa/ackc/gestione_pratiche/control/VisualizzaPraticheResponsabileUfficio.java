package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import javax.inject.Inject;
import java.util.List;

/**
 * Si occupa della visualizzazione e filtraggio delle
 * pratiche per un responsabile ufficio.
 *
 * @version 1.0.2
 */
public class VisualizzaPraticheResponsabileUfficio extends FormControl {
    /**
     * Macro del parametro filtro.
     */
    public static final String FILTRO_PARAMETRO = "filtro";
    /**
     * Macro del parametro pagina.
     */
    public static final String PAGINA_PARAMETRO = "pagina";
    /**
     * Macro della jsp della lista di pratiche.
     */
    private static final String PRATICHE_JSP = "gestionePratiche.jsp";
    /**
     * Macro del filtro nessun_filtro.
     */
    public static final int NESSUN_FILTRO = 0;
    /**
     * Macro del filtro pratiche_da_valutare.
     */
    public static final int PRATICHE_DA_VALUTARE = 1;
    /**
     * Macro del filtro pratiche_sospese.
     */
    public static final int PRATICHE_SOSPESE = 2;
    /**
     * Macro del filtro pratiche_chiuse.
     */
    public static final int PRATICHE_CHIUSE = 3;
    /**
     * Macro del limite di pratiche in una pagina.
     */
    public static final int LIMITE_PAGINA = 10;
    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacade ackStorage;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.0.2
     */
    public VisualizzaPraticheResponsabileUfficio(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     * @since 1.0.2
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        AccountResponsabileUfficio account = (AccountResponsabileUfficio)
                getSessione().ottieni("account");
        formDati.aggiungiDato("temp_account", account);
        valida(formDati);
        int filtro = formDati.ottieniDatoIntero(FILTRO_PARAMETRO);
        int pagina = formDati.ottieniDatoIntero(PAGINA_PARAMETRO);
        List<Pratica> praticheResponsabileUfficio;
        switch (filtro) {
            case PRATICHE_SOSPESE:
                praticheResponsabileUfficio =
                        ackStorage.findPraticheSospeseForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
                break;
            case PRATICHE_DA_VALUTARE:
                praticheResponsabileUfficio =
                        ackStorage.findPraticheDaValutareForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
                break;
            case PRATICHE_CHIUSE:
                praticheResponsabileUfficio =
                        ackStorage.findPraticheChiuseForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
                break;
            case NESSUN_FILTRO:
            default:
                praticheResponsabileUfficio =
                        ackStorage.findAllPraticheForResponsabileUfficio(
                                account,
                                LIMITE_PAGINA,
                                (pagina - 1) * LIMITE_PAGINA);
        }
        getRisposta().aggiungiAttributo(
                "pratiche",
                praticheResponsabileUfficio
        );
        getRisposta().inoltra(PRATICHE_JSP);
    }

    /**
     * {@inheritDoc}
     * @since 1.0.2
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida.VisualizzaPraticheResponsabileUfficio.class);
        super.valida(formDati);
    }
}
