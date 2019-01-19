package it.unisa.ackc.test_suite;

import it.unisa.ackc.servlet.gestione_pratiche.CreazioneDomandaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreazioneDomandaTest.class
})
public class ServletSuite {
}
