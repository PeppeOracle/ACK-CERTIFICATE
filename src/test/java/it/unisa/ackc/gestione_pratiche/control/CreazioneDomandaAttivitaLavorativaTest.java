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
    public void test1(){
        formDati.aggiungiDato("ente", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        formDati.aggiungiDato("ente", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3(){
        formDati.aggiungiDato("indirizzoSede", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4(){
        formDati.aggiungiDato("indirizzoSede", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5(){
        formDati.aggiungiDato("profilo", "");
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6(){
        formDati.aggiungiDato("profilo", longString);
        creazioneDomandaAttivitaLavorativa.valida(formDati);
    }

    @Test
    public void test7(){
        //da completare
    }

}