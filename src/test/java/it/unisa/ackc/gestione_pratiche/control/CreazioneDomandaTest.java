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
        formDati.aggiungiDato(CreazioneDomanda.AZIONE_PARAMETRO, 0);

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
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il parametro azione deve essere un numero");

        formDati.aggiungiDato(CreazioneDomanda.AZIONE_PARAMETRO, null);
        creazioneDomanda.sottomettiForm(formDati);
    }

    @Test
    public void test05(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Azione non supportata");

        formDati.aggiungiDato(CreazioneDomanda.AZIONE_PARAMETRO, 3);
        creazioneDomanda.sottomettiForm(formDati);
    }

    @Test
    public void test06(){
        creazioneDomanda.sottomettiForm(formDati);
    }
}
