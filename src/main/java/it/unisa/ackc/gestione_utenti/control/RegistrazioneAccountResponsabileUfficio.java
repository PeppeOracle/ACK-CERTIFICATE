package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.util.ArrayList;

/**
 * Si occupa della registrazione di un account responsabile.
 *
 * @version @version 1.1.1
 */
public final class RegistrazioneAccountResponsabileUfficio extends FormControl {
    /**
     * Macro del parametro campus.
     */
    public static final String CAMPUS_PARAMETRO = "campus";
    /**
     * Macro del parametro edificio.
     */
    public static final String EDIFICIO_PARAMETRO = "edificio";
    /**
     * Macro del parametro piano.
     */
    public static final String PIANO_PARAMETRO = "piano";
    /**
     * Macro del parametro numero stanza.
     */
    public static final String NUMERO_STANZA_PARAMETRO = "numeroStanza";
    /**
     * Macro del parametro tipologia pratiche.
     */
    public static final String TIPOLOGIA_PRATICHE_PARAMETRO =
            "tipologiaPratica";
    /**
     * Macro della jsp di successo della registrazione responsabile ufficio.
     */
    private static final String SUCCESSFUL_JSP = "";
    /**
     * Macro del messaggio di successo della registrazione responsabile ufficio.
     */
    private static final String SUCCESSFUL_MESSAGE = "";
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
    public RegistrazioneAccountResponsabileUfficio(
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
        String email = formDati.ottieniDato(AccountConvalida.EMAIL_PARAMETRO);
        String password = formDati.ottieniDato(
                AccountConvalida.PASSWORD_PARAMETRO
        );
        String telefono = formDati.ottieniDato(
                AccountConvalida.TELEFONO_PARAMETRO
        );
        String nome = formDati.ottieniDato(AccountConvalida.NOME_PARAMETRO);
        String cognome = formDati.ottieniDato(
                AccountConvalida.COGNOME_PARAMETRO
        );
        Account.Ruolo ruolo = Account.Ruolo.valueOf(
                formDati.ottieniDato(AccountConvalida.RUOLO_PARAMETRO)
        );
        Account.Sesso sesso = Account.Sesso.valueOf(
                formDati.ottieniDato(AccountConvalida.SESSO_PARAMETRO)
        );
        String campus = formDati.ottieniDato(CAMPUS_PARAMETRO);
        String edificio = formDati.ottieniDato(EDIFICIO_PARAMETRO);
        Integer piano = Integer.parseInt(
                formDati.ottieniDato(PIANO_PARAMETRO)
        );
        Integer numeroStanza = Integer.parseInt(
                formDati.ottieniDato(NUMERO_STANZA_PARAMETRO)
        );
        String[] tipologiaPraticaDaGestire = formDati.ottieniDati(
                TIPOLOGIA_PRATICHE_PARAMETRO
        );
        ArrayList<Pratica.Tipo> eTipologiaPraticaDaGestire = new ArrayList<>();
        for (String tipologia : tipologiaPraticaDaGestire) {
            eTipologiaPraticaDaGestire.add(
                    Pratica.Tipo.valueOf(tipologia)
            );
        }
        AccountResponsabileUfficio account = new AccountResponsabileUfficio(
                email,
                password,
                telefono,
                nome,
                cognome,
                sesso,
                campus,
                edificio,
                piano,
                numeroStanza,
                eTipologiaPraticaDaGestire
        );
        ackStorage.createAccount(account);
        getRisposta().aggiungiAttributo("successful", SUCCESSFUL_MESSAGE);
        getRisposta().inoltra(SUCCESSFUL_JSP);
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizione(
                AccountConvalida.VALIDA_EMAIL
        );
        aggiungiCondizione(
                AccountConvalida.VALIDA_COGNOME
        );
        aggiungiCondizione(
                AccountConvalida.VALIDA_NOME
        );
        aggiungiCondizione(
                AccountConvalida.VALIDA_PASSWORD
        );
        aggiungiCondizione(
                AccountConvalida.VALIDA_SESSO
        );
        aggiungiCondizione(
                AccountConvalida.VALIDA_TELEFONO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountResponsabileUfficio.VALIDA_CAMPUS
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountResponsabileUfficio.VALIDA_EDIFICIO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountResponsabileUfficio
                        .VALIDA_NUMERO_STANZA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountResponsabileUfficio.VALIDA_PIANO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountResponsabileUfficio
                        .VALIDA_TIPOLOGIA_PRATICHE
        );
        super.valida(formDati);
    }
}
