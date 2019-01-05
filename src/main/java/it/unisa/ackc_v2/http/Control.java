package it.unisa.ackc_v2.http;

/**
 * Astrazione di un control.
 */
public abstract class Control {
    /**
     * Sessione di riferimento.
     */
    private Sessione sessione;
    /**
     * Risposta di riferimento.
     */
    private Risposta risposta;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il
     *                  control
     */
    public Control(final Sessione aSessione, final Risposta aRisposta) {
        this.sessione = aSessione;
        this.risposta = aRisposta;
    }

    /**
     * Restituisce la sessione.
     *
     * @return sessione
     */
    public Sessione getSessione() {
        return sessione;
    }

    /**
     * Restituisce la risposta.
     *
     * @return risposta
     */
    public Risposta getRisposta() {
        return risposta;
    }
}
