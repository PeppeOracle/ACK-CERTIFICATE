package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RegistrazioneAccountStudenteTest {

    @Rule
    public ExpectedException expect = ExpectedException.none();

    private static final String longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private RegistrazioneAccountStudente registrazioneAccountStudente;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    @Before
    public void setUp() {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        registrazioneAccountStudente = new RegistrazioneAccountStudente(sessioneStub, rispostaStub);
        ACKCStorageStub storage = new ACKCStorageStub();
        storage.setAccount(new it.unisa.ackc.gestione_utenti.entity.AccountStudente());
        registrazioneAccountStudente.setAckStorage(storage);
        formDati = new FormDati();

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario");
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "Rossi");
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "Avellino");
        formDati.aggiungiDato(AccountStudente.DATA_DI_NASCITA_PARAMETRO, "07-04-1993");
        formDati.aggiungiDato(AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO, "Via Tuoro Cappuccini");
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "81");
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "83100");
        formDati.aggiungiDato(AccountStudente.CITTA_PARAMETRO, "Avellino");
        formDati.aggiungiDato(AccountStudente.PAESE_PARAMETRO, "Italia");
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "3451372297");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.santoro21@studenti.unisa.it");
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "0522500487");
        formDati.aggiungiDato(AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO, "Magistrale");
        formDati.aggiungiDato(AccountStudente.CORSO_DI_LAUREA_PARAMETRO, "Informatica");
        formDati.aggiungiDato(AccountConvalida.SESSO_PARAMETRO, "MASCHIO");
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "2017");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "ab123456");
    }

    @Test
    public void test01() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il nome non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test02() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del nome deve essere compresa tra 1 e 64");
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, longString);

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test03() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del nome non è stato rispettato");
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "M4r10");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test04() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il luogoNascita non è stato indicato");
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test05() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del luogoNascita deve essere compresa tra 1 e 64");
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, longString);

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test06() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del luogoNascita non è stato rispettato");
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "N4p0l1");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test07() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il periodo non è stato indicato");
        formDati.aggiungiDato(AccountStudente.DATA_DI_NASCITA_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test08() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del periodo non è stato rispettato");
        formDati.aggiungiDato(AccountStudente.DATA_DI_NASCITA_PARAMETRO, "22-ww-2015");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test09() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'indirizzo di residenza non può superare i 64 caratteri");
        formDati.aggiungiDato(AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO, longString);

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test10() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'indirizzo di residenza non è stato indicato");
        formDati.aggiungiDato(AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test11() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero civico deve essere un numero");
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "b");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test12() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il numero civico deve essere maggiore di 0 e deve essere un numero almeno a tre cifre");
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "4362");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test13() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il CAP non è stato indicato");
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test14() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il CAP deve essere di 5 caratteri");
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "123");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test15() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il CAP deve essere composto solo da cifre");
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "ab123");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test16() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il telefono non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test17() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza del telefono deve compresa tra 9 e 10");
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "3335675");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test18() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato del telefono non è stato rispettato");
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "+3335675129");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test19() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La mail non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test20() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza dell'email deve compresa tra 19 e 64");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, longString);

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test21() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato dell'email non è stato rispettato");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "adb");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test22() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La matricola non è stata indicata");
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test23() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La matricola deve essere di 10 caratteri");
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "1242356");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test24() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La matricola deve essere composta solo da cifre");
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "asd3454241");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test25() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il sesso non è stato indicato");
        formDati.aggiungiDato(AccountConvalida.SESSO_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test26() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il sesso indicato non è corretto");
        formDati.aggiungiDato(AccountConvalida.SESSO_PARAMETRO, "f");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test27() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La password non è stata indicata");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test28() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La lunghezza della password deve compresa tra 2 e 8");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "a");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test29() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il formato della password non è stato rispettato");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "ab1267");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test30() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("La password deve contenere almeno una lettera e un numero");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "pass");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test31() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'anno di immatricolazione non è stato indicato");
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test32() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'anno di immatricolazione deve essere di 4 caratteri");
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "12345");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

    @Test
    public void test33() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'anno di immatricolazione deve essere composto solo da cifre");
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "ab67");

        registrazioneAccountStudente.sottomettiForm(formDati);
    }

}