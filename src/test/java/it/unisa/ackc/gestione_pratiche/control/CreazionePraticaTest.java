package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Test;

public class CreazionePraticaTest {

    private CreazionePratica creazionePratica;

    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    @Before
    public void setUp() {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();

        creazionePratica = new CreazionePratica(sessioneStub, rispostaStub);
        creazionePratica.setAckStorage(new ACKCStorageStub());

        formDati = new FormDati();
        formDati.aggiungiDato(CreazionePratica.MESSAGGIO_PARAMETRO, "Attestato non riconosciuto");
        formDati.aggiungiDato(CreazionePratica.TIPO_PARAMETRO, "LINGUA_INGLESE");
        formDati.aggiungiDato(CreazionePratica.DOMANDA_PARAMETRO, "domanda.pdf");
        formDati.aggiungiDato(CreazionePratica.ATTESTATO_PARAMETRO, "attestato.pdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        String actual = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam metus elit, pharetra a consectetur viverra, venenatis eu mauris. In hac habitasse platea dictumst. Praesent nibh elit, suscipit eget diam vitae, euismod tincidunt lectus. Sed ante ipsum, dictum a congue ac, laoreet in nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam metus elit, pharetra a consectetur viverra, venenatis eu mauris. In hac habitasse platea dictumst. Praesent nibh elit, suscipit eget diam vitae, euismod tincidunt lectus. Sed ante ipsum, dictum a congue ac, laoreet in nisi. Morbi dapibus sodales lacinia. Sed varius volutpat elit sed rhoncus. Vestibulum ut lectus in tortor eleifend vehicula. Fusce id risus molestie, pretium.";
        formDati.aggiungiDato(CreazionePratica.MESSAGGIO_PARAMETRO, actual);
        creazionePratica.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        formDati.aggiungiDato(CreazionePratica.DOMANDA_PARAMETRO, "domanda.docx");
        creazionePratica.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        formDati.aggiungiDato(CreazionePratica.DOMANDA_PARAMETRO, null);
        creazionePratica.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        formDati.aggiungiDato(CreazionePratica.ATTESTATO_PARAMETRO, "attestato.jpeg");
        creazionePratica.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        formDati.aggiungiDato(CreazionePratica.ATTESTATO_PARAMETRO, null);
        creazionePratica.sottomettiForm(formDati);
    }

    @Test
    public void test6() {
        creazionePratica.sottomettiForm(formDati);
    }
}
