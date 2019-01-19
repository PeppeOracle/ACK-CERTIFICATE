package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.control.CreazionePratica;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.http.stub.ACKCStorageStub;
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
        ACKCStorageStub storage = new ACKCStorageStub();
        storage.setAccount(new it.unisa.ackc.gestione_utenti.entity.AccountStudente());
        modificaProfiloStudente.setAckStorage(storage);
        formDati = new FormDati();
        longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario");
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "Rossi");
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "Avellino");
        formDati.aggiungiDato(AccountStudente.DATA_DI_NASCITA_PARAMETRO, "07-04-1993");
        formDati.aggiungiDato(AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO, "Via Tuoro Cappuccini");
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "81");
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "83100");
        formDati.aggiungiDato(AccountStudente.CITTA_PARAMETRO, "Avellino");
        formDati.aggiungiDato(AccountStudente.PAESE_PARAMETRO, "Italia");
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "3451372297");
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.santoro21@studenti.unisa.it");
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "0522500487");
        formDati.aggiungiDato(AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO, "Magistrale");
        formDati.aggiungiDato(AccountStudente.CORSO_DI_LAUREA_PARAMETRO, "Informatica");
        formDati.aggiungiDato(AccountConvalida.SESSO_PARAMETRO, "MASCHIO");
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "2017");
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "ab123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test01() {
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test02(){
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test03(){
        formDati.aggiungiDato(AccountConvalida.NOME_PARAMETRO, "Mario!");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test04(){
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test05(){
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test06(){
        formDati.aggiungiDato(AccountConvalida.COGNOME_PARAMETRO, "Rossi?");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test07(){
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test08(){
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test09(){
        formDati.aggiungiDato(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, "Avellino?!");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test10(){
        formDati.aggiungiDato(AccountStudente.DATA_DI_NASCITA_PARAMETRO, "07/04/1993");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test11(){
        formDati.aggiungiDato(AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test12(){
        formDati.aggiungiDato(AccountStudente.INDIRIZZO_DI_RESIDENZA_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test13(){
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test14(){
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "8181");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test15(){
        formDati.aggiungiDato(AccountStudente.NUMERO_CIVICO_PARAMETRO, "aa");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test16(){
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "8310");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test17(){
        formDati.aggiungiDato(AccountStudente.CAP_PARAMETRO, "aaaaa");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test18(){
        formDati.aggiungiDato(AccountStudente.CITTA_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test19(){
        formDati.aggiungiDato(AccountStudente.CITTA_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test20(){
        formDati.aggiungiDato(AccountStudente.CITTA_PARAMETRO, "Avell!no?");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test21(){
        formDati.aggiungiDato(AccountStudente.PAESE_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test22(){
        formDati.aggiungiDato(AccountStudente.PAESE_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test23(){
        formDati.aggiungiDato(AccountStudente.PAESE_PARAMETRO, "1tal!a");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test24(){
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "51372297");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test25(){
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "393451372297");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test26(){
        formDati.aggiungiDato(AccountConvalida.TELEFONO_PARAMETRO, "ea5iel229l");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test27(){
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.soro21@");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test28(){
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test29(){
        formDati.aggiungiDato(AccountConvalida.EMAIL_PARAMETRO, "v.santoro21@personale.unisa.it");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test30(){
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "052250048");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test31(){
        formDati.aggiungiDato(AccountStudente.MATRICOLA_PARAMETRO, "052250048a");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test32(){
        formDati.aggiungiDato(AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test33(){
        formDati.aggiungiDato(AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test34(){
        formDati.aggiungiDato(AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO, "Mag1stral3");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test35(){
        formDati.aggiungiDato(AccountStudente.CORSO_DI_LAUREA_PARAMETRO, "");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test36(){
        formDati.aggiungiDato(AccountStudente.CORSO_DI_LAUREA_PARAMETRO, longString);
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test37(){
        formDati.aggiungiDato(AccountStudente.CORSO_DI_LAUREA_PARAMETRO, "1nf0rmat1ca");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test38(){
        formDati.aggiungiDato(AccountConvalida.SESSO_PARAMETRO, "0");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test39(){
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "217");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test40(){
        formDati.aggiungiDato(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, "20i7");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test41(){
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "a");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test42(){
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "ab1234567");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test43(){
        formDati.aggiungiDato(AccountConvalida.PASSWORD_PARAMETRO, "12345678");
        modificaProfiloStudente.sottomettiForm(formDati);
    }

    @Test
    public void test44(){ modificaProfiloStudente.sottomettiForm(formDati); }

}