package it.unisa.ackc_v2.form;

import it.unisa.ackc.validator.Notifica;
import it.unisa.ackc_v2.http.Control;
import it.unisa.ackc_v2.http.Risposta;
import it.unisa.ackc_v2.http.Sessione;

import java.util.List;

/**
 * <code>FormControl</code> rappresenta un'astrazione per i Control
 * che hanno come compito quello di gestire la sottomissione di una
 * Form, controllare la validità dei dati ed eseguire poi la logica
 * specifica.
 */
public abstract class FormControl extends Control {
    /**
     * Collezzione di condizioni di convalida per i dati
     * del form che il control dovrà gestire.
     */
    private List<CondizioneConvalida> condizioniDiConvalida;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il
     *                  control
     */
    public FormControl(final Sessione aSessione, final Risposta aRisposta) {
        super(aSessione, aRisposta);
    }

    /**
     * Questo metodo viene chiamato alla sottomissione della form.
     *
     * @param formDati dati sottomessi
     */
    public abstract void sottomettiForm(FormDati formDati);

    /**
     * Permette di aggiungere una condizione di convalida.
     *
     * @param condizione da aggiungere
     */
    public void addCondizione(final CondizioneConvalida condizione) {
        condizioniDiConvalida.add(condizione);
    }

    /**
     * Richiama tutte le condizioni di convalida aggiunte in
     * precedenza e restituisce una notifica che contiene tutti gli
     * errori individuati.
     *
     * @param formDati da validare
     */
    public void valida(final FormDati formDati) {
        Notifica notifica = new Notifica();
        for (CondizioneConvalida condizione : condizioniDiConvalida) {
            notifica.addErrors(condizione.validate(formDati));
        }
        if (notifica.hasErrors()) {
            throw new IllegalArgumentException(notifica.errorMessage());
        }
    }
}
