package it.unisa.ackc.test_suite;

import it.unisa.ackc.gestione_pratiche.control.CreazioneDomandaAttivitaLavorativaTest;
import it.unisa.ackc.gestione_pratiche.control.CreazioneDomandaLinguaIngleseTest;
import it.unisa.ackc.gestione_pratiche.control.CreazionePraticaTest;
import it.unisa.ackc.gestione_pratiche.control.ModificaPraticaSospesaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreazioneDomandaLinguaIngleseTest.class,
        CreazionePraticaTest.class,
        ModificaPraticaSospesaTest.class,
        CreazioneDomandaAttivitaLavorativaTest.class
})
public class GestionePraticheTestSuite {
}
