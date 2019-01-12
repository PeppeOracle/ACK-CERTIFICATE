package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.gestione_utenti.control.ModificaProfiloStudente;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Test;

public class TestModificaProfilo {

    private ModificaProfiloStudente modificaProfiloStudente;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        modificaProfiloStudente = new ModificaProfiloStudente(sessioneStub, rispostaStub);
    }

    @Test
    public void test01(){

    }
}
