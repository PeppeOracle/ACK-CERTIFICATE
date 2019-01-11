package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import javax.inject.Inject;
import java.text.ParseException;
import java.util.Date;

import static it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente.*;

/**
 * Si occupa della modifica del profilo di uno studente.
 *
 * @version 1.0.1
 */
public class ModificaProfiloStudente extends FormControl {
    /**
     * Macro della jsp della modifica del profilo.
     */
    private static final String MODIFICA_JSP = "gestioneProfiloStudente.jsp";
    /**
     * Macro della jsp di successo della valutazione.
     */
    private static final String SUCCESSFUL_JSP = "";
    /**
     * Macro del messaggio di successo della valutazione.
     */
    private static final String SUCCESSFUL_MESSAGE = "";
    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.0.1
     */
    public ModificaProfiloStudente(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     * @since 1.0.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        valida(formDati);
        Account account = (Account)
                getSessione().ottieni("account");
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
        String matricola = formDati.ottieniDato(MATRICOLA_PARAMETRO);
        Date dataDiNascita = null;
        try {
            dataDiNascita = formDati
                    .ottieniDatoData(DATA_DI_NASCITA_PARAMETRO);
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
        AccountStudente studente = (AccountStudente) ackStorage.findAccountById(
                account.getId()
        );
        if (email != null) {
            studente.setEmail(email);
        }
        if (password != null) {
            studente.setPassword(password);
        }
        if (telefono != null) {
            studente.setTelefono(telefono);
        }
        if (nome != null) {
            studente.setNome(nome);
        }
        if (cognome != null) {
            studente.setCognome(cognome);
        }
        if (ruolo != null) {
            studente.setRuolo(ruolo);
        }
        if (sesso != null) {
            studente.setSesso(sesso);
        }
        if (matricola != null) {
            studente.setMatricola(matricola);
        }
        if (dataDiNascita != null) {
            studente.setDataDiNascita(dataDiNascita);
        }
        if (luogoDiNascita != null) {
            studente.setLuogoDiNascita(luogoDiNascita);
        }
        if (indirizzoDiResidenza != null) {
            studente.setIndirizzoDiResidenza(indirizzoDiResidenza);
        }
        if (numeroCivico != null) {
            studente.setNumeroCivico(numeroCivico);
        }
        if (citta != null) {
            studente.setCitta(citta);
        }
        if (cap != null) {
            studente.setCap(cap);
        }
        if (paese != null) {
            studente.setPaese(paese);
        }
        if (tipologiaDiLaurea != null) {
            studente.setTipologiaDiLaurea(tipologiaDiLaurea);
        }
        if (corsoDiLaurea != null) {
            studente.setCorsoDiLaurea(corsoDiLaurea);
        }
        if (annoDiImmatricolazione != null) {
            studente.setAnnoDiImmatricolazione(annoDiImmatricolazione);
        }
        ackStorage.updateAccount(studente);
        getRisposta().aggiungiAttributo("successful", SUCCESSFUL_MESSAGE);
        getRisposta().inoltra(SUCCESSFUL_JSP);
    }

    /**
     * {@inheritDoc}
     * @since 1.0.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_EMAIL
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_COGNOME
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_NOME
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_PASSWORD
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_SESSO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_TELEFONO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente
                        .VALIDA_LUOGO_DI_NASCITA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_DATA_DI_NASCITA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente
                        .VALIDA_INDIRIZZO_DI_RESIDENZA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_NUMERO_CIVICO
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_CAP
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_CITTA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_PAESE
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_MATRICOLA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente
                        .VALIDA_TIPOLOGIA_DI_LAUREA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente.VALIDA_CORSO_DI_LAUREA
        );
        aggiungiCondizione(
                it.unisa.ackc.gestione_utenti.control.
                        convalida.ModificaProfiloStudente
                        .VALIDA_ANNO_DI_IMMATRICOLAZIONE
        );
        super.valida(formDati);
    }
}
