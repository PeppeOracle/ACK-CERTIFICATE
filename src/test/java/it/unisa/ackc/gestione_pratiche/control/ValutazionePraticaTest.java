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

public class ValutazionePraticaTest {
    @Rule
    public ExpectedException expect = ExpectedException.none();

    private ValutazionePratica valutazionePratica;
    
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    private String longString;
    
    @Before
    public void setUp() {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();

        valutazionePratica = new ValutazionePratica(sessioneStub, rispostaStub);

        ACKCStorageStub storage = new ACKCStorageStub();
        storage.setPratica(new Pratica());
        valutazionePratica.setAckStorage(storage);

        formDati = new FormDati();
        formDati.aggiungiDato(ValutazionePratica.STATO_PARAMETRO, Pratica.Stato.APPROVATA);
        formDati.aggiungiDato(ValutazionePratica.MESSAGGIO_PARAMETRO, "Complimenti!");
        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, 1);
    }

    @Test
    public void test01() {
        longString = new String(new char[513]).replace('\0', 'a');
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Il messaggio del responsabile ufficio non può superare i 512 caratteri");

        formDati.aggiungiDato(ValutazionePratica.MESSAGGIO_PARAMETRO, longString);
        valutazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test02() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Indicare il nuovo stato");

        formDati.aggiungiDato(ValutazionePratica.STATO_PARAMETRO, null);
        valutazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test03() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere un numero");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, null);
        valutazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test04() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere un numero");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, "approvata");
        valutazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test05() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("Lo stato indicato non è valido");

        formDati.aggiungiDato(ValutazionePratica.STATO_PARAMETRO, "approvata");
        valutazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test06() {
        expect.expect(IllegalArgumentException.class);
        expect.expectMessage("L'identificativo della pratica deve essere maggiore di 0");

        formDati.aggiungiDato(GestionePratiche.PRATICA_PARAMETRO, -1);
        valutazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test07() {
        valutazionePratica.sottomettiForm(formDati);
    }
}
