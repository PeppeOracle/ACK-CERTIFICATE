package it.unisa.ackc.test_suite;

import it.unisa.ackc.servlet.gestione_pratiche.*;
import it.unisa.ackc.servlet.gestione_utenti.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        CreazioneDomandaAttivitaLavorativaTest.class,
        CreazioneDomandaLinguaIngleseTest.class,
        CreazioneDomandaTest.class,
        CreazionePraticaTest.class,
        MostraPraticaTest.class,
        ValutazionePraticaTest.class,
        AutenticazioneUtenteTest.class,
        ModificaProfiloStudenteTest.class,
        RegistrazioneAccountResponsabileUfficioTest.class,
        RegistrazioneAccountStudenteTest.class

})
public class ServletSuite {
}
