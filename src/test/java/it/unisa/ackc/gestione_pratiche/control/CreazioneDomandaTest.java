package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CreazioneDomandaTest {
    @Rule
    public ExpectedException expect = ExpectedException.none();

    private CreazioneDomanda creazioneDomanda;
    private FormDati formDati;

    @Before
    public void setUp() {
        SessioneStub sessioneStub = new SessioneStub();
        RispostaStub rispostaStub = new RispostaStub();

        formDati = new FormDati();
        formDati.aggiungiDato(CreazioneDomanda.TIPO_DI_DOMANDA_PARAMETRO, "LINGUA_INGLESE");

        creazioneDomanda = new CreazioneDomanda(sessioneStub, rispostaStub);
    }

    @Test
    public void test01(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di domanda non è stato indicato");

        formDati.aggiungiDato(CreazioneDomanda.TIPO_DI_DOMANDA_PARAMETRO, null);
        creazioneDomanda.sottomettiForm(formDati);
    }

    @Test
    public void test02(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di domanda non è stato indicato");

        formDati.aggiungiDato(CreazioneDomanda.TIPO_DI_DOMANDA_PARAMETRO, "");
        creazioneDomanda.sottomettiForm(formDati);
    }

    @Test
    public void test03(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di domanda indicato non è corretto");

        formDati.aggiungiDato(CreazioneDomanda.TIPO_DI_DOMANDA_PARAMETRO, "test");
        creazioneDomanda.sottomettiForm(formDati);
    }

    @Test
    public void test04(){
        creazioneDomanda.sottomettiForm(formDati);
    }
}
