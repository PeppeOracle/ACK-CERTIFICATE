package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MostraPraticaTest {
    @Rule
    public ExpectedException expect = ExpectedException.none();

    private MostraPratica mostraPratica;
    private FormDati formDati;

    @Before
    public void setUp() {
        SessioneStub sessioneStub = new SessioneStub();
        RispostaStub rispostaStub = new RispostaStub();

        formDati = new FormDati();
        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, 1);
        formDati.aggiungiDato(MostraPratica.TIPO_PARAMETRO, MostraPratica.PRATICA_RESPONSABILE_UFFICIO);

        mostraPratica = new MostraPratica(sessioneStub, rispostaStub);
        ACKCStorageStub storage = new ACKCStorageStub();
        storage.setPratica(new Pratica());
        mostraPratica.setAckStorage(storage);
    }

    @Test
    public void test01(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di visualizzazione deve essere un numero");

        formDati.aggiungiDato(MostraPratica.TIPO_PARAMETRO, null);
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test02(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di visualizzazione deve essere un numero");

        formDati.aggiungiDato(MostraPratica.TIPO_PARAMETRO, "");
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test03(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di visualizzazione deve essere un numero");

        formDati.aggiungiDato(MostraPratica.TIPO_PARAMETRO, "test");
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test04(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il tipo di visualizzazione non è valido");

        formDati.aggiungiDato(MostraPratica.TIPO_PARAMETRO, -1);
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test05(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere un numero");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, null);
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test06(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere un numero");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, "");
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test07(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere un numero");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, "test");
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test08(){
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere maggiore di 0");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, 0);
        mostraPratica.sottomettiForm(formDati);
    }

    @Test
    public void test09(){
        mostraPratica.sottomettiForm(formDati);
    }
}
