package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AutenticazioneUtenteTest {
    @Rule
    public ExpectedException expect = ExpectedException.none();

    private AutenticazioneUtente autenticazioneUtente;
    private Account account;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;
    private String longString;

    @Before
    public void setUp() {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        autenticazioneUtente = new AutenticazioneUtente(sessioneStub, rispostaStub);
        ACKCStorageStub storage = new ACKCStorageStub();
        account = new Account();
        account.setEmail("v.santoro21@personale.unisa.it");
        account.setPassword("Abc123");
        account.setRuolo(Account.Ruolo.STUDENTE);
        storage.setAccount(account);
        autenticazioneUtente.setAckStorage(storage);

        formDati = new FormDati();
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.santoro21@personale.unisa.it");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "Abc123");
    }

    @Test
    public void test01(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La mail non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, null);

        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test02(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La mail non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "");

        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test03(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza dell'email deve compresa tra 10 e 64");

        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.soro21@");
        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test04(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza dell'email deve compresa tra 10 e 64");

        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, longString);
        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test05(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza dell'email deve compresa tra 10 e 64");

        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, longString);
        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test06(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza della password deve compresa tra 2 e 8");

        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "a");
        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test07(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza della password deve compresa tra 2 e 8");

        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "ab123567");
        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test08(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La password deve contenere almeno una lettera e un numero");

        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "12345678");
        autenticazioneUtente.sottomettiForm(formDati);
    }

    @Test
    public void test09(){
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "abcd12");
        autenticazioneUtente.sottomettiForm(formDati);
        assertEquals(AutenticazioneUtente.ERROR_JSP, rispostaStub.getUrl());
    }

    @Test
    public void test10(){
        autenticazioneUtente.sottomettiForm(formDati);
        assertNotEquals(AutenticazioneUtente.ERROR_JSP, rispostaStub.getUrl());
    }

    @Test
        public void test11(){
        account.setRuolo(Account.Ruolo.RESPONSABILE_UFFICIO);
        autenticazioneUtente.sottomettiForm(formDati);
        assertNotEquals(AutenticazioneUtente.ERROR_JSP, rispostaStub.getUrl());
    }

    @Test
    public void test12(){
        account.setRuolo(Account.Ruolo.AMMINISTRATORE);
        autenticazioneUtente.sottomettiForm(formDati);
        assertNotEquals(AutenticazioneUtente.ERROR_JSP, rispostaStub.getUrl());
    }

    @Test
    public void test13(){
        autenticazioneUtente.sottomettiForm(formDati);
        assertNotEquals(AutenticazioneUtente.ERROR_JSP, rispostaStub.getUrl());
    }
}
