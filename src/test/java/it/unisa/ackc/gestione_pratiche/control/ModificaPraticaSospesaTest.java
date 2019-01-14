package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Test;

public class ModificaPraticaSospesaTest {

    private ModificaPraticaSospesa modificaPraticaSospesa;

    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    @Before
    public void setUp() throws Exception {

        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();

        modificaPraticaSospesa = new ModificaPraticaSospesa(sessioneStub, rispostaStub);

        formDati = new FormDati();
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
        formDati.aggiungiDato("fileDomanda", null);
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        formDati.aggiungiDato("fileAttestato", "attestato.jpeg");
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        formDati.aggiungiDato("fileAttestato", null);
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        formDati.aggiungiDato("stato", "APPROVATA");
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        formDati.aggiungiDato("tipo", "domanda");
        modificaPraticaSospesa.sottomettiForm(formDati);
    }

    @Test
    public void test8() {
        modificaPraticaSospesa.sottomettiForm(formDati);
    }
}