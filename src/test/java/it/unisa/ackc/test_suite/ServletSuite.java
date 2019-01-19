package it.unisa.ackc.test_suite;

import it.unisa.ackc.servlet.gestione_pratiche.*;
import it.unisa.ackc.servlet.gestione_utenti.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreazioneDomandaTest.class,
        CreazioneDomandaAttivitaLavorativaTest.class,
        CreazioneDomandaLinguaIngleseTest.class,
        CreazionePraticaTest.class,
        AutenticazioneUtenteTest.class,
        RegistrazioneAccountResponsabileUfficio.class
})
public class ServletSuite {
}
