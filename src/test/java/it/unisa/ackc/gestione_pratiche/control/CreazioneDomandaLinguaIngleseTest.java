package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class CreazioneDomandaLinguaIngleseTest {

    private CreazioneDomandaLinguaInglese creazioneDomandaLinguaInglese;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        it.unisa.ackc.gestione_utenti.entity.AccountStudente accountStudente
                = new it.unisa.ackc.gestione_utenti.entity.AccountStudente();
        accountStudente.setTipologiaDiLaurea("Triennale");
        sessioneStub.setAccount(accountStudente);
        rispostaStub = new RispostaStub();

        formDati = new FormDati();
        formDati.aggiungiDato("grade", 4);
        formDati.aggiungiDato("numeroCfu", 9);
        formDati.aggiungiDato("enteCertificatore", "Trinity");
        formDati.aggiungiDato("cefr", "A2.2");

        creazioneDomandaLinguaInglese = new CreazioneDomandaLinguaInglese(sessioneStub, rispostaStub);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        formDati.aggiungiDato("grade", 0);
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        formDati.aggiungiDato("grade", 435);
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        formDati.aggiungiDato("grade", "grade");
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        formDati.aggiungiDato("numeroCfu", 0);
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        formDati.aggiungiDato("numeroCfu", 456);
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        formDati.aggiungiDato("numeroCfu", "numeroCfu");
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        formDati.aggiungiDato("enteCertificatore", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test8() {
        formDati.aggiungiDato("cefr", "abcdefghijk");
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @Test
    public void test9() {
        creazioneDomandaLinguaInglese.sottomettiForm(formDati);
    }

    @After
    public void tearDown() throws Exception {
    }

}