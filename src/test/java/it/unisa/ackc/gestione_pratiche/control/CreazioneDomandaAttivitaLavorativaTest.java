package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreazioneDomandaAttivitaLavorativaTest {
    private CreazioneDomandaAttivitaLavorativa creazioneDomandaAttivitaLavorativa;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;
    private String longString;  //una stringa di 65 a

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        formDati = new FormDati();
        formDati.aggiungiDato("ente", "Bethesda");
        formDati.aggiungiDato("indirizzoSede", "Rockville, Maryland, Stati Uniti");
        formDati.aggiungiDato("profilo", "Videogiochi");
        formDati.aggiungiDato("tipoContratto", "Programmatore");
        formDati.aggiungiDato("periodo", "01-09-2018/12-01-2019");
        formDati.aggiungiDato("oreSvolte", "100");
        formDati.aggiungiDato("numeroCfu", 9);

        creazioneDomandaAttivitaLavorativa = new CreazioneDomandaAttivitaLavorativa(sessioneStub, rispostaStub);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test01(){
        formDati.aggiungiDato("ente", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test02(){
        formDati.aggiungiDato("ente", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test03(){
        formDati.aggiungiDato("indirizzoSede", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test04(){
        formDati.aggiungiDato("indirizzoSede", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test05(){
        formDati.aggiungiDato("profilo", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test06(){
        formDati.aggiungiDato("profilo", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test07(){
        formDati.aggiungiDato("tipoContratto", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test08(){
        formDati.aggiungiDato("tipoContratto", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test09(){
        formDati.aggiungiDato("periodo", "01-09-2018/12-01-201");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test10(){
        formDati.aggiungiDato("periodo", "01-09-2018/12-01-20019");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test11(){
        formDati.aggiungiDato("periodo", "01/09/2018-12/01/2019");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test12(){
        formDati.aggiungiDato("oreSvolte", "9");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test13(){
        formDati.aggiungiDato("oreSvolte", "1000");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test14(){
        formDati.aggiungiDato("oreSvolte", "aaa");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test15(){
        formDati.aggiungiDato("numeroCfu", 0);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test16(){
        formDati.aggiungiDato("numeroCfu", 100);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test17(){
        formDati.aggiungiDato("numeroCfu", "aa");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test
    public void test18(){ creazioneDomandaAttivitaLavorativa.valida(formDati); }
}