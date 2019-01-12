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

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();

        formDati = new FormDati();
        //da compilare
        formDati.aggiungiDato("ente", "");
        formDati.aggiungiDato("indirizzoSede", "");
        formDati.aggiungiDato("profilo", "");
        formDati.aggiungiDato("tipoContratto", "");
        formDati.aggiungiDato("periodo", "");
        formDati.aggiungiDato("oreSvolte", "");

        creazioneDomandaAttivitaLavorativa = new CreazioneDomandaAttivitaLavorativa(sessioneStub, rispostaStub);
    }

    @Test()
    public void test1(){
        //primo test
    }
}