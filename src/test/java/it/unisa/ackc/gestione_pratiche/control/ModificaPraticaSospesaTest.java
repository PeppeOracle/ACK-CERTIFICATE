package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import it.unisa.ackc.storage.ACKStorageFacade;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ModificaPraticaSospesaTest {
    private ModificaPraticaSospesa modificaPraticaSospesa;

    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;
    private ACKCStorageStub storage;

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();

        modificaPraticaSospesa = new ModificaPraticaSospesa(sessioneStub, rispostaStub);
        modificaPraticaSospesa.setAckStorage(storage = new ACKCStorageStub());

        formDati = new FormDati();
        formDati.aggiungiDato("pratica", "1");
        formDati.aggiungiDato("messaggio", "In allegato i file");
        formDati.aggiungiDato("tipo", "LINGUA_INGLESE");
        formDati.aggiungiDato("fileDomanda", "domanda.pdf");
        formDati.aggiungiDato("fileAttestato", "attestato.pdf");
        formDati.aggiungiDato("stato", "SOSPESA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        String actual = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam metus elit, pharetra a consectetur viverra, venenatis eu mauris. In hac habitasse platea dictumst. Praesent nibh elit, suscipit eget diam vitae, euismod tincidunt lectus. Sed ante ipsum, dictum a congue ac, laoreet in nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam metus elit, pharetra a consectetur viverra, venenatis eu mauris. In hac habitasse platea dictumst. Praesent nibh elit, suscipit eget diam vitae, euismod tincidunt lectus. Sed ante ipsum, dictum a congue ac, laoreet in nisi. Morbi dapibus sodales lacinia. Sed varius volutpat elit sed rhoncus. Vestibulum ut lectus in tortor eleifend vehicula. Fusce id risus molestie, pretium.";
        formDati.aggiungiDato("messaggio", actual);
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        formDati.aggiungiDato("fileDomanda", "domanda.docx");
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        formDati.aggiungiDato("fileAttestato", "attestato.jpeg");
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        Pratica pratica = new Pratica();
        pratica.setStato(Pratica.Stato.APPROVATA);
        storage.setPratica(pratica);
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        Pratica pratica = new Pratica();
        pratica.setTipo("caiao");
        storage.setPratica(pratica);
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test
    public void test6() {
        Pratica pratica = new Pratica();
        pratica.setStato(Pratica.Stato.SOSPESA);
        pratica.setDomanda(new Domanda());
        pratica.setAttestato(new Attestato());
        storage.setPratica(pratica);
        modificaPraticaSospesa.sottomettiForm(formDati);
    }
}