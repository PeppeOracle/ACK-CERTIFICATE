package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RegistrazioneAccountResponsabileUfficioTest {
    @Rule
    public ExpectedException expect = ExpectedException.none();

    private RegistrazioneAccountResponsabileUfficio registrazioneAccount;

    private String longString;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    @Before
    public void setUp() {
        longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        registrazioneAccount = new RegistrazioneAccountResponsabileUfficio(sessioneStub, rispostaStub);
        ACKCStorageStub storage = new ACKCStorageStub();
        registrazioneAccount.setAckStorage(storage);

        formDati = new FormDati();
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.santoro21@unisa.it");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "ab123456");
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "3451372297");
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario");
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "Rossi");
        formDati.aggiungiDato(AccountConvalida.SESSO_PARAMETRO, "MASCHIO");
        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.CAMPUS_PARAMETRO, "Fisciano");
        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.EDIFICIO_PARAMETRO, "F");
        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.NUMERO_STANZA_PARAMETRO, "33");
        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.PIANO_PARAMETRO, "2");
        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.TIPOLOGIA_PRATICHE_PARAMETRO, new String[]{Pratica.Tipo.ATTIVITA_LAVORATIVA.name()});
    }

    @Test
    public void test01(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La mail non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, null);

        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test02(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La mail non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "");

        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test03(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza dell'email deve compresa tra 10 e 64");

        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.soro21@");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test04(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza dell'email deve compresa tra 10 e 64");

        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, longString);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test06(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza della password deve compresa tra 2 e 8");

        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "a");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test07(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza della password deve compresa tra 2 e 8");

        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "abyagvtacdtycd");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test08(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La password deve contenere almeno una lettera e un numero");

        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "12345678");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test09(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il telefono non è stato indicato");

        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test10(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del telefono deve compresa tra 9 e 10");

        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "12345678943510");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test11(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del telefono non è stato rispettato");

        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "abc123456");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test12() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il nome non è stato indicato");

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test13() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del nome deve essere compresa tra 1 e 64");

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, longString);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test14() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del nome non è stato rispettato");

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "123cc");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test15() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il cognome non è stato indicato");

        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test16() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del cognome deve essere compresa tra 1 e 64");

        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, longString);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test17() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del cognome non è stato rispettato");

        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "123cc");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test18() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il campus non è stato indicato");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.CAMPUS_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test19() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del campus deve essere compresa tra 1 e 64");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.CAMPUS_PARAMETRO, longString);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test20() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del campus non è stato rispettato");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.CAMPUS_PARAMETRO, "123cc");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test21() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'edificio non è stato indicato");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.EDIFICIO_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test22() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il nome dell'edificio non può superare i 64 caratteri");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.EDIFICIO_PARAMETRO, longString);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test24() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero del piano deve essere un intero");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.PIANO_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test25() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero del piano deve essere un intero");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.PIANO_PARAMETRO, "test");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test26() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero del piano deve essere un intero al più a due cifre");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.PIANO_PARAMETRO, "323");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test27() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero della stanza deve essere un positivo");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.NUMERO_STANZA_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test28() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero della stanza deve essere un positivo");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.NUMERO_STANZA_PARAMETRO, "test");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test29() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero della stanza deve essere maggiore di 0 e deve essere un numero al più a tre cifre");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.NUMERO_STANZA_PARAMETRO, "3422");
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test30() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Le tipologia delle pratiche pratica non è stata indicata");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.TIPOLOGIA_PRATICHE_PARAMETRO, null);
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test31() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo indicato non è corretto");

        formDati.aggiungiDato(RegistrazioneAccountResponsabileUfficio.TIPOLOGIA_PRATICHE_PARAMETRO, new String[]{"test"});
        registrazioneAccount.sottomettiForm(formDati);
    }

    @Test
    public void test50(){
        registrazioneAccount.sottomettiForm(formDati);
    }
}
