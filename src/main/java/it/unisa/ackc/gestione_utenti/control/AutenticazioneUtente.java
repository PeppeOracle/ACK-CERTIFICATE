package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.storage.ejb.ACKStorageFacadeDefault;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

/**
 * Si occupa dell'autenticazione di un utente nel sistema.
 *
 * @version 1.0.1
 */
public class AutenticazioneUtente extends FormControl {
    /**
     * Macro della del messaggio di errore dell'autenticazione.
     */
    private static final String ERROR_MESSAGE = "Username o password errati";
    /**
     * Macro della jsp di errore dell'autenticazione.
     */
    private static final String ERROR_JSP = "";
    /**
     * Istanza dello storage facade.
     */
    private ACKStorageFacade ackStorage;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     */
    public AutenticazioneUtente(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
        super(aSessione, aRisposta);
        ackStorage = new ACKStorageFacadeDefault();
    }

    /**
     * {@inheritDoc}
     * @since 1.0.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        valida(formDati);
        String email =
                formDati.ottieniDato(AccountConvalida.EMAIL_PARAMETRO);
        String password =
                formDati.ottieniDato(AccountConvalida.PASSWORD_PARAMETRO);
        Account account = ackStorage.findAccountByEmail(email);
        if (account != null && account.getPassword().equals(password)) {
            getRisposta().aggiungiAttributo("account", account);
            switch (account.getRuolo()) {
                case AMMINISTRATORE:
                    getRisposta().inoltra(
                            "admin/registrazioneAccountResponsabileUfficio.jsp"
                    );
                    break;
                case RESPONSABILE_UFFICIO:
                    getRisposta().inoltra(
                            "responsabile-ufficio/gestionePratiche.jsp"
                    );
                    break;
                case STUDENTE:
                    getRisposta().inoltra(
                            "studente/gestionePratiche.jsp"
                    );
                    break;
                default:
                    getRisposta().aggiungiAttributo("message", ERROR_MESSAGE);
                    getRisposta().inoltra(ERROR_JSP);
            }
        } else {
            getRisposta().aggiungiAttributo("message", ERROR_MESSAGE);
            getRisposta().inoltra(ERROR_JSP);
        }
    }

    /**
     * {@inheritDoc}
     * @since 1.0.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizione(
                AccountConvalida.VALIDA_EMAIL
        );
        aggiungiCondizione(
                AccountConvalida.VALIDA_PASSWORD
        );
        super.valida(formDati);
    }
}
