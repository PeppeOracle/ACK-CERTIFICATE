package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

/**
 * Permette il download di un file.
 *
 * @version 1.1.1
 */
public class DownloadFile extends FormControl {
    /**
     * Macro del parametro file_name.
     */
    public static final String FILE_PARAMETRO = "file_name";
    /**
     * Macro del parametro files-studenti.
     */
    private static final String STUDENTI_PATH = "files-studenti";
    /**
     * Macro della size del buffer.
     */
    private static final int BUFFER_SIZE = 4096;
    /**
     * Macro dell'estensione del file.
     */
    private static final String FILE_ESTENSIONE = ".pdf";

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.1.1
     */
    public DownloadFile(final Sessione aSessione, final Risposta aRisposta) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        valida(formDati);
        String fileName = formDati.ottieniDato(FILE_PARAMETRO);
        getRisposta().redirect(fileName);
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .DownloadFile.class);
        super.valida(formDati);
    }
}
