package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.io.File;
import java.util.List;

/**
 * Si occupa della creazione di una nuova pratica.
 *
 * @version 1.1.1
 */
public class CreazionePratica extends FormControl {
    /**
     * Macro del parametro messaggio.
     */
    public static final String MESSAGGIO_PARAMETRO =
            "messaggio";
    /**
     * Macro del parametro domanda.
     */
    public static final String DOMANDA_PARAMETRO =
            "fileDomanda";
    /**
     * Macro del parametro attestato.
     */
    public static final String ATTESTATO_PARAMETRO =
            "fileAttestato";
    /**
     * Macro del tipo della pratica.
     */
    public static final String TIPO_PARAMETRO =
            "tipo";
    /**
     * Macro della jsp di successo della creazione.
     */
    private static final String SUCCESSFUL_JSP =
            "/gestione-pratiche/mostra-pratica?tipo=2&pratica=";
    /**
     * Macro del path dei file degli studenti.
     */
    private static final String STUDENTI_PATH =
            "files-studenti";
    /**
     * Istanza dello storage facade.
     */
    private ACKStorageFacade ackStorage;
    /**
     * Account loggato.
     */
    private Account account;
    /**
     * Messaggio della pratica.
     */
    private String messaggio;
    /**
     * Tipo della pratica.
     */
    private String tipo;
    /**
     * Upload path per i documenti della pratica.
     */
    private String uploadPath;
    /**
     * Path della domanda.
     */
    private String domandaPath;
    /**
     * Path dell'attestato.
     */
    private String attestatoPath;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.1.1
     */
    public CreazionePratica(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
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
        account = (Account)
                getSessione().ottieni("account");
        messaggio = formDati.ottieniDato(MESSAGGIO_PARAMETRO);
        tipo = formDati.ottieniDato(TIPO_PARAMETRO);
        uploadPath = STUDENTI_PATH;
        upload();
        Pratica pratica = salvaPratica();
        getRisposta().redirect(SUCCESSFUL_JSP + pratica.getId());
    }

    /**
     * Salva la pratica.
     *
     * @since 1.1.1
     * @return pratica salvata
     */
    private Pratica salvaPratica() {
        Domanda domanda = (Domanda) getSessione().ottieni("domanda");
        getSessione().rimuovi("domanda");
        domanda.setPath(domandaPath);
        Attestato attestato = new Attestato(attestatoPath);
        Pratica pratica = new Pratica(
                domanda,
                attestato,
                messaggio,
                Pratica.Tipo.valueOf(tipo)
        );
        AccountStudente accountStudente = (AccountStudente)
                ackStorage.findAccountById(account.getId());
        accountStudente.addPratica(pratica);
        accountStudente = (AccountStudente)
                ackStorage.updateAccount(accountStudente);
        List<Pratica> listPratiche = accountStudente.getPratiche();
        return listPratiche.get(listPratiche.size() - 1);
    }

    /**
     * Salva i documenti da associare alla pratica.
     *
     * @since 1.1.1
     */
    private void upload() {
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        AccountStudente accountStudente = (AccountStudente)
                ackStorage.findAccountById(account.getId());
        domandaPath = uploadPath
                + File.separator
                + accountStudente.getMatricola()
                + "-" + accountStudente.getPratiche().size() + "domanda.pdf";
        getRisposta().scriviFile(DOMANDA_PARAMETRO, domandaPath);
        attestatoPath = uploadPath
                + File.separator
                + accountStudente.getMatricola()
                + "-" + accountStudente.getPratiche().size() + "attestato.pdf";
        getRisposta().scriviFile(ATTESTATO_PARAMETRO, attestatoPath);
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .CreazionePratica.class);
        super.valida(formDati);
    }
}
