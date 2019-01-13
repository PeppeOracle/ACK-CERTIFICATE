package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente;
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
    private String longString;

    @Before
    public void setUp() throws Exception {
        sessioneStub = new SessioneStub();
        rispostaStub = new RispostaStub();
        modificaProfiloStudente = new ModificaProfiloStudente(sessioneStub, rispostaStub);
        formDati = new FormDati();
        longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario");
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "Rossi");
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "Avellino");

        //modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test01() {
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "");
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test02(){
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, longString);
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test03(){
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario!");
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test04(){
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "");
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test05(){
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, longString);
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test06(){
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "Rossi?");
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test07(){
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "");
        modificaProfiloStudente.valida(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test08(){
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, longString);
        modificaProfiloStudente.valida(formDati);
    }
    
}