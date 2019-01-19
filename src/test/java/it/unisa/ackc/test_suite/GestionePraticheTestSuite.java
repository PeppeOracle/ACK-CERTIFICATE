package it.unisa.ackc.test_suite;

import it.unisa.ackc.gestione_pratiche.control.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreazioneDomandaLinguaIngleseTest.class,
        CreazionePraticaTest.class,
        ModificaPraticaSospesaTest.class,
        CreazioneDomandaAttivitaLavorativaTest.class,
        CreazioneDomandaTest.class,
        MostraPraticaTest.class,
        ValutazionePraticaTest.class
})
public class GestionePraticheTestSuite {
}
