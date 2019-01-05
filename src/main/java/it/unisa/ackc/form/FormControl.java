package it.unisa.ackc.form;

import it.unisa.ackc.http.Notifica;
import it.unisa.ackc.http.Control;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
     * @param aRisposta da restituire all'utente che ha innescato il control
     */
    public FormControl(final Sessione aSessione, final Risposta aRisposta) {
        super(aSessione, aRisposta);
        condizioniDiConvalida = new ArrayList<>();
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
    public void aggiungiCondizione(final CondizioneConvalida condizione) {
        condizioniDiConvalida.add(condizione);
    }

    /**
     * Permette di aggiungere le condizioni convalide contenute
     * all'interno di una classe.
     *
     * @param classeConvalida contenente le condizioni di convalida
     */
    public void aggiungiCondizioni(final Class classeConvalida) {
        Field[] campi = classeConvalida.getDeclaredFields();
        for (Field campo : campi) {
            Object valore;
            try {
                valore = campo.get(null);
                if (valore instanceof CondizioneConvalida) {
                    aggiungiCondizione((CondizioneConvalida) valore);
                }
            } catch (IllegalAccessException e) {
                // Ignora
            }
        }
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
            notifica.aggiungiErrori(condizione.validate(formDati));
        }
        if (notifica.contieneErrori()) {
            throw new IllegalArgumentException(notifica.erroreMessaggio());
        }
    }
}
