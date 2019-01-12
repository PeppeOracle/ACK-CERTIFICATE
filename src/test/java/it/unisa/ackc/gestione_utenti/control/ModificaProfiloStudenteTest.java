package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.http.stub.RispostaStub;
import it.unisa.ackc.http.stub.SessioneStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModificaProfiloStudenteTest {

    private ModificaProfiloStudente modificaProfiloStudente;
    private SessioneStub sessioneStub;
    private RispostaStub rispostaStub;
    private FormDati formDati;

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        modificaProfiloStudente = new ModificaProfiloStudente(sessioneStub, rispostaStub);
        formDati = new FormDati();

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario");
        // TODO aggiungere gli altri parametri
    }

    @Test(expected = IllegalArgumentException.class)
    public void test01() {
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "");
        modificaProfiloStudente.valida(formDati);
    }
}