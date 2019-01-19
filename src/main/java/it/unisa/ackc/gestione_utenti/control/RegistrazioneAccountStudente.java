package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.text.ParseException;
import java.util.Date;

import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.MATRICOLA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.DATA_DI_NASCITA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.LUOGO_DI_NASCITA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.NUMERO_CIVICO_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.CAP_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.CITTA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.PAESE_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.CORSO_DI_LAUREA_PARAMETRO;
import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO;


/**
 * Si occupa della registrazione di un account studente.
 *
 * @version 1.1.1
 */
public class RegistrazioneAccountStudente extends FormControl {
    /**
     * Macro della jsp di successo della registrazione studente.
     */
    private static final String SUCCESSFUL_JSP = "";
    /**
     * Macro del messaggio di successo della registrazione studente.
     */
    private static final String SUCCESSFUL_MESSAGE = "";
    /**
     * Macro della lunghezza minima per email.
     */
    public static final int MIN_MAIL = 19;
    /**
     * Macro della lunghezza massima per email.
     */
    public static final int MAX_MAIL = 64;
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
    public RegistrazioneAccountStudente(
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
        String email = formDati.ottieniDato(
                AccountConvalida.EMAIL_PARAMETRO
        );
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
        Account.Sesso sesso = Account.Sesso.valueOf(formDati.ottieniDato(
                AccountConvalida.SESSO_PARAMETRO
        ));
        String matricola = formDati.ottieniDato(MATRICOLA_PARAMETRO);
        Date dataDiNascita = null;
        try {
            dataDiNascita = formDati.ottieniDatoData(DATA_DI_NASCITA_PARAMETRO);
        } catch (ParseException e) { }
        String luogoDiNascita = formDati.ottieniDato(
                LUOGO_DI_NASCITA_PARAMETRO
        );
        String indirizzoDiResidenza = formDati.ottieniDato(
                INDIRIZZO_DI_RESIDENZA_PARAMETRO
        );
        Integer numeroCivico = Integer.parseInt(
                formDati.ottieniDato(NUMERO_CIVICO_PARAMETRO)
        );
        String cap = formDati.ottieniDato(CAP_PARAMETRO);
        String citta = formDati.ottieniDato(CITTA_PARAMETRO);
        String paese = formDati.ottieniDato(PAESE_PARAMETRO);
        String tipologiaDiLaurea = formDati.ottieniDato(
                TIPOLOGIA_DI_LAUREA_PARAMETRO
        );
        String corsoDiLaurea = formDati.ottieniDato(CORSO_DI_LAUREA_PARAMETRO);
        String annoDiImmatricolazione = formDati.ottieniDato(
                ANNO_DI_IMMATRICOLAZIONE_PARAMETRO
        );
        AccountStudente account = new AccountStudente(
                email,
                password,
                telefono,
                nome,
                cognome,
                sesso,
                matricola,
                dataDiNascita,
                luogoDiNascita,
                indirizzoDiResidenza,
                numeroCivico,
                cap,
                citta,
                paese,
                tipologiaDiLaurea,
                corsoDiLaurea,
                annoDiImmatricolazione
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
                        convalida.AccountStudente
                        .VALIDA_EMAIL
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente.VALIDA_LUOGO_DI_NASCITA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente.VALIDA_DATA_DI_NASCITA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente
                        .VALIDA_INDIRIZZO_DI_RESIDENZA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente
                        .VALIDA_NUMERO_CIVICO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente
                        .VALIDA_CAP
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente.VALIDA_CITTA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente.VALIDA_PAESE
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente
                        .VALIDA_MATRICOLA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente.VALIDA_TIPOLOGIA_DI_LAUREA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente.VALIDA_CORSO_DI_LAUREA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.AccountStudente
                        .VALIDA_ANNO_DI_IMMATRICOLAZIONE
        );
        super.valida(formDati);
    }
}
