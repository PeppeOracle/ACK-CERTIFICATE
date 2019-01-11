package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import javax.inject.Inject;
import java.io.File;
import java.util.Date;

/**
 * Si occupa della modifica di una pratica.
 *
 * @version 1.1.1
 */
public class ModificaPraticaSospesa extends FormControl {
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
     * Macro della jsp di successo della modifica.
     */
    private static final String SUCCESSFUL_JSP =
            "";
    /**
     * Macro del messaggio di successo della modifica.
     */
    private static final String SUCCESSFUL_MESSAGE =
            "";
    /**
     * Macro del path dei file degli studenti.
     */
    private static final String STUDENTI_PATH =
            "files-studenti";
    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacade ackStorage;
    /**
     * Pratica da aggiornare.
     */
    private Pratica pratica;
    /**
     * Nuovo messaggio della pratica.
     */
    private String messaggio;
    /**
     * Upload path per i documenti della pratica.
     */
    private String uploadPath;
    /**
     * Nome del file della domanda.
     */
    private String nomeDomanda;
    /**
     * Nome del file dell'attestato.
     */
    private String nomeAttestato;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.1.1
     */
    public ModificaPraticaSospesa(
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
        valida(formDati);
        messaggio = formDati.ottieniDato(MESSAGGIO_PARAMETRO);
        pratica = ackStorage.findPraticaById(
                formDati.ottieniDatoLong(GestionePratiche.PRATICA_PARAMETRO)
        );
        uploadPath = getRisposta().ottieniUploadPath() + STUDENTI_PATH;
        nomeDomanda = formDati.ottieniDato(DOMANDA_PARAMETRO);
        nomeAttestato = formDati.ottieniDato(ATTESTATO_PARAMETRO);
        upload();
        salvaPratica();
        getRisposta().aggiungiAttributo("successful", SUCCESSFUL_MESSAGE);
        getRisposta().inoltra(SUCCESSFUL_JSP);
    }

    /**
     * Salva la pratica.
     *
     * @since 1.1.1
     */
    private void salvaPratica() {
        if (messaggio != null && messaggio.length() > 0) {
            pratica.setMessaggioStudente(messaggio);
        }
        pratica.setDataAggiornamento(new Date());
        pratica.setStato(Pratica.Stato.IN_ATTESA);
        ackStorage.updatePratica(pratica);
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
        if (nomeDomanda != null) {
            Domanda domanda = pratica.getDomanda();
            domanda.setDataAggiornamento(new Date());
            Domanda aDomanda = (Domanda) getSessione()
                    .ottieni("domanda");
            if (aDomanda != null) {
                domanda.replace(aDomanda);
            }
            String domandaPath = uploadPath
                    + File.separator
                    + pratica.getId()
                    + "-" + "domanda.pdf";
            new File(domandaPath).delete();
            getRisposta().scriviFile(DOMANDA_PARAMETRO, domandaPath);
        }
        if (nomeAttestato != null) {
            Attestato attestato = pratica.getAttestato();
            attestato.setDataAggiornamento(new Date());
            String attestatoPath = uploadPath
                    + File.separator
                    + pratica.getId()
                    + "-" + "attestato.pdf";
            new File(attestatoPath).delete();
            getRisposta().scriviFile(ATTESTATO_PARAMETRO, attestatoPath);
        }
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .ModificaPraticaSospesa.class);
        super.valida(formDati);
    }
}
